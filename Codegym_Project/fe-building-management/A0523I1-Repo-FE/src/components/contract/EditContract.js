import React, {useEffect, useState} from 'react';
import '../../configs/routes'
import {ErrorMessage, Field, Form, Formik,} from 'formik'
import '../../css/form.css'
import {Link, useParams} from 'react-router-dom'
import {getContractById,updateContract} from '../../services/ContractService'
import Moment from "moment";
import {storage} from "../../configs/firebase";
import {ref,uploadBytesResumable,getDownloadURL,uploadBytes,deleteObject} from 'firebase/storage'
import {v4} from 'uuid';
import {contractSchema} from '../../schema/ContractSchema'
import PopupUpdate from "./PopupUpdate";
import Loading from "./Loading";
import ErrorNotFound from "./ErrorNotFound";
import * as authService from '../../services/Authenticate/AuthService.js'



const EditContract = () => {
    const {id}= useParams();
    const [contract,setContract] = useState({});
    const [isUpdate,setIsUpdate] = useState(false)
    const [showErrorPopup, setShowErrorPopup] = useState(false);
    const [error, setError] = useState(null);
    const [previewUrl, setPreviewUrl] = useState(null);
    const [showLoading, setShowLoading] = useState(false);


    const calculateEndDate = (e,values,setFieldValue) => {
        const {name,value} = e.target;
        switch (name) {
            case 'term':
                values.term = value;
                break;
            case'startDate':
                values.startDate = value;
                    break;
            default:
                break;
        }
        const {term,startDate} = values
            const start = Moment(startDate)
            const end = start.add(parseInt(term) ,'month');
            setFieldValue('endDate', end.format('YYYY-MM-DD'))
    }
    const totalContractAmount = (e,values,setFieldValue) =>{
        const {name,value} = e.target;
        switch (name) {
            case 'currentFee':
                values.currentFee = value;
                break;
            case 'term':
                values.term = value;
                break;
            default:
                break;
        }
        const {currentFee,term} = values;
        const currentValue = currentFee.replace(/\D/g, '')
        const total = currentValue * parseInt(term);
        setFieldValue('total',numberFormatter.format(total))
    }
    const numberFormatter = new Intl.NumberFormat('vi-VN', {
        style: 'decimal',
        useGrouping: true,
        minimumFractionDigits: 0,
        maximumFractionDigits: 2
    });
    const formatNumber = (input) => {
        let value = input.value.replace(/\D/g, ''); // Remove non-numeric characters
        input.value = numberFormatter.format(value);
    };
    useEffect(() => {
        fetchContractById(id);
    },[id])

    const fetchContractById = async (id) => {
        try{
            const token = authService.getToken();
            const response = await getContractById(id,token);
                setContract(response.result);
        }catch (e) {
            console.log(e);
            setError(e.message);
            setShowErrorPopup(true)
        }
    }
    const initialValue = {
        id : contract.id,
        employee:contract.employeeName ? contract.employeeName : '',
        customer : contract.customerName ? contract.customerName : '',
        term: contract.term ? numberFormatter.format(contract.term) : '',
        startDate: contract.startDate ? Moment(contract.startDate).format("yyyy-MM-DD") : '',
        endDate: contract.endDate ? Moment(contract.endDate).format("yyyy-MM-DD") : '',
        currentFee:contract.feePerMouth ? numberFormatter.format(contract.feePerMouth) : '',
        landing : contract.code ? contract.code : '',
        deposit: contract.deposit ? numberFormatter.format(contract.deposit) : '',
        taxCode: contract.taxCode ? contract.taxCode : '',
        content: contract.content ? contract.content : '',
        fireBaseUrl: contract.fireBaseUrl ? contract.fireBaseUrl : '',
        img: null,
        total :numberFormatter.format(contract.term * contract.feePerMouth)
    }


    function getUploadedFileFromCache(file) {
        const cachedFile = localStorage.getItem('uploaded-file');
        return cachedFile ? JSON.parse(cachedFile) : null;
    }
    function cacheUploadedFile(file) {
        localStorage.setItem('uploaded-file', JSON.stringify(file));
    }
    const UploadFile = async (file) => {
        setShowLoading(true);
        try {
            const cachedFile = getUploadedFileFromCache(file);
            if (cachedFile) {

                return cachedFile.downloadURL;
            }else{

                const storageRef = ref(storage,`imagesContracts/${file.name + v4()}`);
                // const uploadTask = uploadBytesResumable(storageRef,file);
                // uploadTask.on('state_changed',(snapshot) => {
                //     const progress = (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
                //     setProgress(progress);
                // })
                // await uploadTask;
                const uploadTask = await uploadBytes(storageRef, file);
                const downloadURL = await getDownloadURL(uploadTask.ref);
                setShowLoading(false);
                cacheUploadedFile({
                    name: file.name,
                    downloadURL: downloadURL,
                });
                return downloadURL;
            }
        }catch (e) {
            console.log(e)
            // deleteObject(storageRef)
            setShowLoading(false);
        }

    }

    const onSubmit =  async (values,formikProps) => {
        console.time('calculateEndDate');
        try{
            let valueMerge = {...values}
            if(valueMerge.img){
                console.time('uploadFile');
                const img  = await UploadFile(valueMerge.img)
                console.timeEnd('uploadFile');
                valueMerge = {...valueMerge, fireBaseUrl: img}
            }else{
                valueMerge = {...valueMerge, fireBaseUrl:contract.fireBaseUrl}
            }
            const token = authService.getToken();
            await updateContract(id,valueMerge,token);
            setIsUpdate(true)
            localStorage.removeItem("uploaded-file");

        }
        catch (e) {
            console.log('Error updating contract ',e);
            if (e.status === 404){
                setError(e.message)
                setShowErrorPopup(true)
            }else if(e.status === 400){
                if(e.result && typeof e.result === 'object' && Object.keys(e.result).length > 0){
                    Object.keys(e.result).forEach( (field) => {
                        formikProps.setFieldError(field, e.result[field])
                    });
                }else{
                    setError(e.message);
                    setShowErrorPopup(true);
                }
            }
            else{
                setError('Đã xảy ra lỗi, vui lòng thử lại sau.');
                setShowErrorPopup(true);
            }
        }
        console.timeEnd('calculateEndDate');
    }

    const handleClosePopup = () => {
        setIsUpdate(false)
    }
    const handleClosePopupErrorNotFound = () => {
        setShowErrorPopup(false)
    }
    if (!initialValue) return <div>Loading...</div>
    return (
        <div style={{width: '100%'}} class="w-full h-[630px] mt-[20px] " id="update-ct">
            <div className="h-full mx-16  flex gap-3" style={{position : 'relative'}}>
                {showLoading && (
                    <div className="loading-overlay" style={{
                        position : 'absolute',
                        height : '100%',
                        width : '100%',
                        background : "rgba(0, 0, 0,0.1)",
                        opacity : "1",
                        pointerEvents : "auto"
                    }}>
                       <Loading/>
                    </div>
                )}
                <div className="w-full h-full box__shadow ">
                    <div className="w-full h-[80px] bg-[#fafafa] border-b-[1px] flex items-center ">
                   <span className="ml-5">
                      <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth="1.5"
                           stroke="currentColor" className="w-6 h-6">
                      <path strokeLinecap="round" strokeLinejoin="round"
                            d="M19.5 14.25v-2.625a3.375 3.375 0 0 0-3.375-3.375h-1.5A1.125 1.125 0 0 1 13.5 7.125v-1.5a3.375 3.375 0 0 0-3.375-3.375H8.25m3.75 9v6m3-3H9m1.5-12H5.625c-.621 0-1.125.504-1.125 1.125v17.25c0 .621.504 1.125 1.125 1.125h12.75c.621 0 1.125-.504 1.125-1.125V11.25a9 9 0 0 0-9-9Z"/>
                     </svg>
                    </span>
                        <p className="font-semibold text-[#333] ml-2  " style={{fontSize: "17px"}}>Hợp đồng</p>
                    </div>

                    <Formik
                        enableReinitialize
                        initialValues={initialValue}
                        onSubmit={(values,formikProps) => onSubmit(values,formikProps)}
                        validationSchema={contractSchema} >
                        {({values,handleChange,setFieldValue}) =>(
                            <Form>
                                <div className="w-full h-full  flex flex-col">
                                    <div className="w-full h-4/6  flex">
                                        <div className="w-1/2 h-5/6 flex flex-col gap-8 wrap ">
                                            <div className=" h-1/5 mx-5  mt-5 flex gap-3 ">
                                                <p className="w-4/12 h-full text-sm">Nhân Viên
                                                    <span className="text-lg text-red-500">*</span></p>
                                                <div className="w-8/12 h-full  flex">
                         <span
                             className="flex items-center bg-[#fafafa] py-3 px-4 border rounded-tl-[3px] rounded-tb-[3px] text-[#888] ">
                           <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth="1.5"
                                stroke="currentColor" className="w-4 h-4">
                          <path strokeLinecap="round" strokeLinejoin="round"
                                d="M15.75 6a3.75 3.75 0 1 1-7.5 0 3.75 3.75 0 0 1 7.5 0ZM4.501 20.118a7.5 7.5 0 0 1 14.998 0A17.933 17.933 0 0 1 12 21.75c-2.676 0-5.216-.584-7.499-1.632Z"/>
                         </svg>
                         </span>
                                                    <Field
                                                        style={{fontFamily: 'Arial, sans-serif', fontSize: '13.4px', color: '#888'}}
                                                        type="text" className="w-full  border-[#8887] px-3"
                                                        placeholder="Nhập để tìm"
                                                        name='employee'
                                                        disabled/>
                                                    <ErrorMessage name='employee' component="span" style={{color: "red"}}/>
                                                </div>
                                            </div>
                                            <div className=" h-1/5 mx-5 flex gap-3 ">
                                                <p className="w-4/12 h-full text-sm">Khách Hàng <span
                                                    className="text-sm text-red-500">*</span></p>
                                                <div className="w-8/12 h-full  flex">
                         <span
                             className="flex items-center bg-[#fafafa] py-3 px-4 border rounded-tl-[3px] rounded-tb-[3px] text-[#888] ">
                           <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth="1.5"
                                stroke="currentColor" className="w-4 h-4">
                          <path strokeLinecap="round" strokeLinejoin="round"
                                d="M15.75 6a3.75 3.75 0 1 1-7.5 0 3.75 3.75 0 0 1 7.5 0ZM4.501 20.118a7.5 7.5 0 0 1 14.998 0A17.933 17.933 0 0 1 12 21.75c-2.676 0-5.216-.584-7.499-1.632Z"/>
                         </svg>
                         </span>

                                                    <Field type="text"
                                                           style={{
                                                               fontFamily: 'Arial, sans-serif',
                                                               fontSize: '13.4px',
                                                               color: '#888'
                                                           }}
                                                           className="w-full  border-[#8887] px-3" placeholder="Nhập Để Tìm"
                                                           name="customer"
                                                           disabled
                                                    />


                                                    <ErrorMessage name='customer' component="span" style={{color: "red"}}/>
                                                </div>
                                            </div>

                                            <div className=" h-[40px] mx-5 flex gap-3 ">
                                                <p className="w-4/12 h-full text-sm">Kì Hạn <span
                                                    className="text-lg text-red-500">*</span> <span
                                                    className="text-sm text-red-500">(tháng)</span></p>
                                                <div className="w-8/12 h-full">
                                                    <div className="flex">
                                                 <span
                                                     className="flex items-center bg-[#fafafa] py-3 px-4 border rounded-tl-[3px] rounded-tb-[3px] text-[#888] ">
                                               <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth="1.5"
                                                    stroke="currentColor" className="w-4 h-4">
                                                  <path strokeLinecap="round" strokeLinejoin="round"
                                                        d="M16.5 6v.75m0 3v.75m0 3v.75m0 3V18m-9-5.25h5.25M7.5 15h3M3.375 5.25c-.621 0-1.125.504-1.125 1.125v3.026a2.999 2.999 0 0 1 0 5.198v3.026c0 .621.504 1.125 1.125 1.125h17.25c.621 0 1.125-.504 1.125-1.125v-3.026a2.999 2.999 0 0 1 0-5.198V6.375c0-.621-.504-1.125-1.125-1.125H3.375Z"/>
                                               </svg>
                                             </span>
                                                        <Field
                                                            style={{fontFamily: 'Arial, sans-serif', fontSize: '13.4px',  color: '#222'}}
                                                            type="number" className="w-full  border-[#8887] px-3"
                                                            name="term"
                                                            onChange = {(e) =>{
                                                                handleChange(e)
                                                                calculateEndDate(e,values,setFieldValue)
                                                                totalContractAmount(e,values,setFieldValue)
                                                            }}
                                                            placeholder="Nhập Kì hạn"/>
                                                    </div>

                                                    <ErrorMessage name="term" className={'p-2'} component="span" style={{color: "red",fontSize:'13px'}}/>
                                                </div>
                                            </div>
                                            <div className=" h-[40px] mx-5  flex gap-3 ">
                                                <p className="w-4/12 h-full text-sm">Ngày Bắt Đầu <span
                                                    className="text-lg text-red-500">*</span></p>
                                                <div className="w-8/12 h-full">
                                                    <div className="flex">
                                                     <span
                                                         className="flex items-center bg-[#fafafa] py-3 px-4 border rounded-tl-[3px] rounded-tb-[3px] text-[#888] ">
                                                         <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth="1.5"
                                                        stroke="currentColor" className="w-4 h-4">
                                                        <path strokeLinecap="round" strokeLinejoin="round"
                                                    d="M6.75 3v2.25M17.25 3v2.25M3 18.75V7.5a2.25 2.25 0 0 1 2.25-2.25h13.5A2.25 2.25 0 0 1 21 7.5v11.25m-18 0A2.25 2.25 0 0 0 5.25 21h13.5A2.25 2.25 0 0 0 21 18.75m-18 0v-7.5A2.25 2.25 0 0 1 5.25 9h13.5A2.25 2.25 0 0 1 21 11.25v7.5m-9-6h.008v.008H12v-.008ZM12 15h.008v.008H12V15Zm0 2.25h.008v.008H12v-.008ZM9.75 15h.008v.008H9.75V15Zm0 2.25h.008v.008H9.75v-.008ZM7.5 15h.008v.008H7.5V15Zm0 2.25h.008v.008H7.5v-.008Zm6.75-4.5h.008v.008h-.008v-.008Zm0 2.25h.008v.008h-.008V15Zm0 2.25h.008v.008h-.008v-.008Zm2.25-4.5h.008v.008H16.5v-.008Zm0 2.25h.008v.008H16.5V15Z"/>
                                                        </svg>
                                                    </span>
                                                        <Field
                                                            style={{fontFamily: 'Arial, sans-serif', fontSize: '13.4px', color: '#222'}}
                                                            type="date"
                                                            className="w-full  border-[#8887] px-3"
                                                            placeholder="Chọn Ngày Bắt Đầu"

                                                            onChange = {(e) =>{
                                                                calculateEndDate(e,values,setFieldValue)
                                                                handleChange(e)
                                                            }}
                                                            name="startDate"
                                                        />
                                                    </div>
                                                    <ErrorMessage name="startDate" class={'p-2'} component="span" style={{color: "red",fontSize:'13px'}}/>
                                                </div>
                                            </div>

                                            <div className=" h-[40px] mx-5  flex gap-3 ">
                                                <p className="w-4/12 h-full text-sm">Ngày Kết Thúc <span
                                                    className="text-lg text-red-500">*</span></p>
                                                <div className="w-8/12 h-full  ">
                                                    <div className='flex'>
                           <span
                               className="flex items-center bg-[#fafafa] py-3 px-4 border rounded-tl-[3px] rounded-tb-[3px] text-[#888] ">
                               <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth="1.5"
                                    stroke="currentColor" className="w-4 h-4">
                                  <path strokeLinecap="round" strokeLinejoin="round"
                                        d="M6.75 3v2.25M17.25 3v2.25M3 18.75V7.5a2.25 2.25 0 0 1 2.25-2.25h13.5A2.25 2.25 0 0 1 21 7.5v11.25m-18 0A2.25 2.25 0 0 0 5.25 21h13.5A2.25 2.25 0 0 0 21 18.75m-18 0v-7.5A2.25 2.25 0 0 1 5.25 9h13.5A2.25 2.25 0 0 1 21 11.25v7.5m-9-6h.008v.008H12v-.008ZM12 15h.008v.008H12V15Zm0 2.25h.008v.008H12v-.008ZM9.75 15h.008v.008H9.75V15Zm0 2.25h.008v.008H9.75v-.008ZM7.5 15h.008v.008H7.5V15Zm0 2.25h.008v.008H7.5v-.008Zm6.75-4.5h.008v.008h-.008v-.008Zm0 2.25h.008v.008h-.008V15Zm0 2.25h.008v.008h-.008v-.008Zm2.25-4.5h.008v.008H16.5v-.008Zm0 2.25h.008v.008H16.5V15Z"/>
                                </svg>
                                </span>
                                                    <Field
                                                        type="date"
                                                        style={{fontFamily: 'Arial, sans-serif', fontSize: '13.4px', color: '#888'}}
                                                        className="w-full  border-[#8887] px-3"
                                                        placeholder="Chưa Xác Định"
                                                        name="endDate"
                                                        disabled/>
                                                    </div>
                                                    <ErrorMessage name="endDate" class={'p-2'} component="span" style={{color: "red",fontSize:'13px'}}/>
                                                </div>
                                            </div>

                                            <div className=" h-1/5 mx-5  mb-5 flex gap-3 " >
                                                <p className="w-4/12 h-full text-sm">H/A Hợp Đồng <span
                                                    className="text-lg text-red-500">*</span></p>
                                                <div className="w-8/12 h-full  relative ">
                                                    <label
                                                        htmlFor="upload_avt"
                                                        className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800 inline-flex items-center"
                                                    >
                                                        Chọn <div className="max-sm:hidden px-1"> ảnh</div>
                                                    </label>
                                                    <input
                                                        type="file"
                                                        name="firebaseUrl"
                                                        hidden
                                                        required="true"
                                                        id="upload_avt"
                                                        onChange={(e) => {
                                                            setFieldValue("img", e.target.files[0]);
                                                            setPreviewUrl(URL.createObjectURL(e.target.files[0]));
                                                        }}/>
                                                    <ErrorMessage name="img" className={'p-2'} component="span"
                                                                  style={{color: "red", fontSize: '12px'}}/>
                                                    <img src={previewUrl ? previewUrl : contract.fireBaseUrl}
                                                         className="w-2/12 h-[100px]  absolute right-0 top-0 rounded-lg border-solid border-[1px]"
                                                    />
                                                    {/*<div className='flex' style={{alignItems: 'center', gap: '10px'}}>*/}
                                                    {/*    <img src={previewUrl ? previewUrl : contract.fireBaseUrl}*/}
                                                    {/*         name='img' style={{*/}
                                                    {/*        height: '100px',*/}
                                                    {/*        width: '100px',*/}
                                                    {/*        borderRadius: "50%",*/}
                                                    {/*        objectFit: 'cover'*/}
                                                    {/*    }}/>*/}
                                                    {/*    <input type="file"*/}
                                                    {/*           className="border-none pt-1 h-full"*/}
                                                    {/*           onChange={(e) => {*/}
                                                    {/*               setFieldValue("img", e.target.files[0]);*/}
                                                    {/*               setPreviewUrl(URL.createObjectURL(e.target.files[0]));*/}
                                                    {/*           }}*/}
                                                    {/*    />*/}
                                                    {/*</div>*/}


                                                </div>
                                            </div>

                                        </div>
                                        <div className="w-1/2 h-5/6 flex flex-col gap-8  ">
                                            <div className=" h-1/5 mx-5  mt-5 flex gap-3 ">
                                                <p className="w-4/12 h-full text-sm">Mặt Bằng <span
                                                    className="text-lg text-red-500">*</span></p>
                                                <div className="w-8/12 h-full flex">
                                             <span
                                                 className="flex items-center bg-[#fafafa] py-3 px-4 border rounded-tl-[3px] rounded-tb-[3px] text-[#888] ">
                                               <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                                                    strokeWidth="1.5"
                                                    stroke="currentColor" className="w-4 h-4">
                                                      <path strokeLinecap="round" strokeLinejoin="round"
                                                            d="M15.75 5.25a3 3 0 0 1 3 3m3 0a6 6 0 0 1-7.029 5.912c-.563-.097-1.159.026-1.563.43L10.5 17.25H8.25v2.25H6v2.25H2.25v-2.818c0-.597.237-1.17.659-1.591l6.499-6.499c.404-.404.527-1 .43-1.563A6 6 0 1 1 21.75 8.25Z"/>
                                               </svg>
                                             </span>
                                                    <Field type="text"
                                                           className="w-full  border-[#8887] px-3"
                                                           style={{
                                                               fontFamily: 'Arial, sans-serif',
                                                               fontSize: '13.4px',
                                                               color: '#888'
                                                           }}
                                                           placeholder="Chưa Xác Định"
                                                           name="landing"
                                                           disabled/>
                                                    <ErrorMessage name="landing" component="span" style={{color: "red"}}/>
                                                </div>
                                            </div>
                                            <div className=" h-[40px] mx-5 flex gap-3 ">
                                                <p className="w-4/12 h-full text-sm">Phí Hiện Tại <span
                                                    className="text-lg text-red-500">*</span> <span
                                                    className="text-sm text-red-500">(VND)</span></p>
                                                <div className="w-8/12 h-full">
                                                    <div className="flex">
                                                    <span
                                                        className="flex items-center bg-[#fafafa] py-3 px-4 border rounded-tl-[3px] rounded-tb-[3px] text-[#888] ">
                                                   <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth="1.5"
                                                        stroke="currentColor" className="w-4 h-4">
                                                       <path strokeLinecap="round" strokeLinejoin="round"
                                                             d="M2.25 18.75a60.07 60.07 0 0 1 15.797 2.101c.727.198 1.453-.342 1.453-1.096V18.75M3.75 4.5v.75A.75.75 0 0 1 3 6h-.75m0 0v-.375c0-.621.504-1.125 1.125-1.125H20.25M2.25 6v9m18-10.5v.75c0 .414.336.75.75.75h.75m-1.5-1.5h.375c.621 0 1.125.504 1.125 1.125v9.75c0 .621-.504 1.125-1.125 1.125h-.375m1.5-1.5H21a.75.75 0 0 0-.75.75v.75m0 0H3.75m0 0h-.375a1.125 1.125 0 0 1-1.125-1.125V15m1.5 1.5v-.75A.75.75 0 0 0 3 15h-.75M15 10.5a3 3 0 1 1-6 0 3 3 0 0 1 6 0Zm3 0h.008v.008H18V10.5Zm-12 0h.008v.008H6V10.5Z"/>
                                                   </svg>
                                                </span>
                                                        <Field type="text"
                                                               className="w-full  border-[#8887] px-3"
                                                               style={{
                                                                   fontFamily: 'Arial, sans-serif',
                                                                   fontSize: '13.4px',
                                                                   color: '#222'
                                                               }}
                                                               onChange={(e) => {
                                                                   formatNumber(e.target)
                                                                   totalContractAmount(e,values,setFieldValue)
                                                                   handleChange(e)
                                                               }}
                                                               name="currentFee"
                                                               placeholder="Chưa Xác Định"
                                                        />
                                                    </div>
                                                    <ErrorMessage name="currentFee" className={"p-2"} component="span" style={{color: "red",fontSize:'12px'}}/>
                                                </div>
                                            </div>
                                            <div className=" h-[40px] mx-5 flex gap-3 ">
                                                <p className="w-4/12 h-full text-sm">Tiền Đặt Cọc
                                                    <span className="text-lg text-red-500">*</span>
                                                    <span className="text-sm text-red-500"> (VND)</span></p>
                                                <div className=" w-8/12 h-full">
                                                    <div className="flex">
                                                        <span
                                                            className="flex items-center bg-[#fafafa] py-3 px-4 border rounded-tl-[3px] rounded-tb-[3px] text-[#888] ">
                                                           <svg xmlns="http://www.w3.org/2000/svg" fill="none"
                                                                viewBox="0 0 24 24" strokeWidth="1.5"
                                                                stroke="currentColor" className="w-4 h-4">
                                                               <path strokeLinecap="round" strokeLinejoin="round"
                                                                     d="M2.25 18.75a60.07 60.07 0 0 1 15.797 2.101c.727.198 1.453-.342 1.453-1.096V18.75M3.75 4.5v.75A.75.75 0 0 1 3 6h-.75m0 0v-.375c0-.621.504-1.125 1.125-1.125H20.25M2.25 6v9m18-10.5v.75c0 .414.336.75.75.75h.75m-1.5-1.5h.375c.621 0 1.125.504 1.125 1.125v9.75c0 .621-.504 1.125-1.125 1.125h-.375m1.5-1.5H21a.75.75 0 0 0-.75.75v.75m0 0H3.75m0 0h-.375a1.125 1.125 0 0 1-1.125-1.125V15m1.5 1.5v-.75A.75.75 0 0 0 3 15h-.75M15 10.5a3 3 0 1 1-6 0 3 3 0 0 1 6 0Zm3 0h.008v.008H18V10.5Zm-12 0h.008v.008H6V10.5Z"/>
                                                           </svg>
                                                        </span>
                                                        <Field type="text"
                                                               className="w-full  border-[#8887] px-3"
                                                               style={{
                                                                   fontFamily: 'Arial, sans-serif',
                                                                   fontSize: '13.4px',
                                                                   color: '#222'
                                                               }}
                                                               name="deposit"
                                                               onChange={(e) => {
                                                                   formatNumber(e.target)
                                                                   handleChange(e)
                                                               }}
                                                               placeholder="Nhập Tiền Đặt Cọc"
                                                        />
                                                    </div>
                                                    <ErrorMessage name="deposit" className={'p-2'} component="span" style={{color: "red",fontSize : '13px'}}/>
                                                </div>

                                            </div>

                                            <div className=" h-1/5 mx-5  flex gap-3 ">
                                                <p className="w-4/12 h-full text-sm">Tổng Tiền </p>
                                                <div className="w-8/12 h-full  flex">
                        <span
                            className="flex items-center bg-[#fafafa] py-3 px-4 border rounded-tl-[3px] rounded-tb-[3px] text-[#888] ">
                           <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth="1.5"
                                stroke="currentColor" className="w-4 h-4">
                               <path strokeLinecap="round" strokeLinejoin="round"
                                     d="M2.25 18.75a60.07 60.07 0 0 1 15.797 2.101c.727.198 1.453-.342 1.453-1.096V18.75M3.75 4.5v.75A.75.75 0 0 1 3 6h-.75m0 0v-.375c0-.621.504-1.125 1.125-1.125H20.25M2.25 6v9m18-10.5v.75c0 .414.336.75.75.75h.75m-1.5-1.5h.375c.621 0 1.125.504 1.125 1.125v9.75c0 .621-.504 1.125-1.125 1.125h-.375m1.5-1.5H21a.75.75 0 0 0-.75.75v.75m0 0H3.75m0 0h-.375a1.125 1.125 0 0 1-1.125-1.125V15m1.5 1.5v-.75A.75.75 0 0 0 3 15h-.75M15 10.5a3 3 0 1 1-6 0 3 3 0 0 1 6 0Zm3 0h.008v.008H18V10.5Zm-12 0h.008v.008H6V10.5Z"/>
                           </svg>
                        </span>
                                                    <Field type="text"
                                                           className="w-full  border-[#8887] px-3"
                                                           style={{
                                                               fontFamily: 'Arial, sans-serif',
                                                               fontSize: '13.4px',
                                                               color: '#222'
                                                           }}
                                                           placeholder="Chưa Xác Định"
                                                           name="total"
                                                           disabled/>
                                                </div>
                                            </div>

                                            <div className=" h-[40px] mx-5  flex gap-3 ">
                                                <p className="w-4/12 h-full text-sm">Mã Số Thuế <span
                                                    className="text-lg text-red-500">*</span></p>
                                                <div className="w-8/12 h-full">
                                                    <div className="flex ">
                                                    <span
                                                        className="flex items-center bg-[#fafafa] py-3 px-4 border rounded-tl-[3px] rounded-tb-[3px] text-[#888] ">
                                                         <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                                                              strokeWidth="1.5" stroke="currentColor" className="w-4 h-4">
                                                      <path strokeLinecap="round" strokeLinejoin="round"
                                                            d="M3.75 4.875c0-.621.504-1.125 1.125-1.125h4.5c.621 0 1.125.504 1.125 1.125v4.5c0 .621-.504 1.125-1.125 1.125h-4.5A1.125 1.125 0 0 1 3.75 9.375v-4.5ZM3.75 14.625c0-.621.504-1.125 1.125-1.125h4.5c.621 0 1.125.504 1.125 1.125v4.5c0 .621-.504 1.125-1.125 1.125h-4.5a1.125 1.125 0 0 1-1.125-1.125v-4.5ZM13.5 4.875c0-.621.504-1.125 1.125-1.125h4.5c.621 0 1.125.504 1.125 1.125v4.5c0 .621-.504 1.125-1.125 1.125h-4.5A1.125 1.125 0 0 1 13.5 9.375v-4.5Z"/>
                                                      <path strokeLinecap="round" strokeLinejoin="round"
                                                            d="M6.75 6.75h.75v.75h-.75v-.75ZM6.75 16.5h.75v.75h-.75v-.75ZM16.5 6.75h.75v.75h-.75v-.75ZM13.5 13.5h.75v.75h-.75v-.75ZM13.5 19.5h.75v.75h-.75v-.75ZM19.5 13.5h.75v.75h-.75v-.75ZM19.5 19.5h.75v.75h-.75v-.75ZM16.5 16.5h.75v.75h-.75v-.75Z"/>
                                                    </svg>
                                                    </span>
                                                        <Field type="text"
                                                               style={{
                                                                   fontFamily: 'Arial, sans-serif',
                                                                   fontSize: '13.4px',
                                                                   color: '#222'
                                                               }}
                                                               className="w-full  border-[#8887] px-3"
                                                               name="taxCode"
                                                               placeholder="Nhập Mã Số"

                                                        />
                                                    </div>
                                                    <ErrorMessage name="taxCode" className={'p-2'} component="span" style={{color : 'red',fontSize:'12px'}}/>

                                                </div>
                                            </div>
                                            <div className=" h-[40px] mx-5  flex gap-3 ">
                                                <p className="w-4/12 h-full text-sm">Nội Dung H/Đ <span
                                                    className="text-lg text-red-500">*</span></p>
                                                <div className="w-8/12 h-full  ">
                                                    <Field
                                                        as="textarea"
                                                        type="text"
                                                        className="w-full h-full border-[#8887] px-3" style={{
                                                        fontFamily: 'Arial, sans-serif',
                                                        fontSize: '13.4px',
                                                        color: '#222',
                                                        height: '10vh'
                                                    }}
                                                        placeholder="Nhập Nội Dung"
                                                        name='content'
                                                    />
                                                    <ErrorMessage name='content' className={'p-2'} component='span' style={{color:"red",fontSize:'12px'}}/>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="w-full h-1/6">
                                        <div className="w-full ml-3  h-10 ">
                                            <button
                                                className="text-white bg-blue-700 hover:bg-blue-800  focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800 inline-flex items-center"
                                                type="submit"
                                                style={{backgroundColor: "#4CAF50"}}
                                            >
                                              <span className="pr-1">
                                                <i className="fi fi-rs-disk"/>
                                              </span>
                                                Cập nhật
                                            </button>
                                            <Link to="/contract">

                                            <button
                                                className="text-white bg-blue-700 hover:bg-blue-800 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800 inline-flex items-center"
                                                type="reset">
                                                    <span className="pr-1">
                                                      <i className="fi fi-rr-eraser"/>
                                                    </span>
                                                Làm mới
                                            </button>
                                            </Link>
                                        </div>
                                    </div>
                                </div>
                            </Form>
                        )}
                    </Formik>

                </div>

            </div>

            {isUpdate && <PopupUpdate handleClosePopup={handleClosePopup}/>}
            {showErrorPopup && <ErrorNotFound message={error} handleClosePopup={handleClosePopupErrorNotFound}/>}
        </div>
    )

}

export default EditContract;
