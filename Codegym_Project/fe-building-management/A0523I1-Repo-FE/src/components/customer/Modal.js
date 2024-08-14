import React from 'react';
import {Formik, Form, Field, ErrorMessage} from 'formik';
import '../../css/customer/detail.css';
import {format, parseISO} from "date-fns";


const Modal = ({customer, onClose}) => {

    const formatDate = (Field) => {
        return format(parseISO(Field), "yyyy-MM-dd");
    }

    const initialValues = {
        name: customer.name || '',
        address: customer.address || '',
        dob: customer.dob ? formatDate(customer.dob) : '',
        phone: customer.phone || '',
        email: customer.email || '',
        idCard: customer.idCard || '',
        companyName: customer.companyName || '',
        website: customer.website || '',
        gender: customer.gender || '',
    };
    return (
        <div id="detail-tt"
             className="w-[750px] h-[600px] fixed  mx-auto mt-12 top-0 left-0 right-0 bottom-0 m flex items-center justify-center">
            <div className="mod rounded-lg p-8 mx-auto h-full w-full">
                <div className="w-full h-auto relative">
                    <h1 className=" text-3xl font-medium mt-1 py-3 left-0 ">
                        Thông tin khách hàng
                    </h1>
                    <button
                        className="absolute right-0 top-2.5 text-3xl "
                        onClick={onClose}
                    >
                        &times;
                    </button>
                </div>

                <Formik
                    initialValues={initialValues}
                    onSubmit={() => {
                    }}
                    enableReinitialize
                >
                    <Form className="relative">
                        <div className="-mx-3 flex flex-wrap">
                            <div className="w-full px-3 py-0 sm:w-1/2">

                                <div className="mb-5">
                                    <label htmlFor="name" className="mb-3 block text-base font-medium">
                                        Tên khách hàng
                                    </label>
                                    <Field
                                        type="text"
                                        name="name"
                                        id="name"
                                        placeholder="Mời nhập vào..."
                                        className="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                                        readOnly/>
                                </div>
                            </div>
                            <div className="w-full px-3 sm:w-1/2">
                                <div className="mb-5">
                                    <label htmlFor="address"
                                           className="mb-3 block text-base font-medium">
                                        Địa chỉ
                                    </label>
                                    <Field
                                        type="text"
                                        name="address"
                                        id="address"
                                        placeholder="Mời nhập vào"
                                        className="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                                        readOnly/>
                                </div>
                            </div>
                        </div>
                        <div className="-mx-3 flex flex-wrap">
                            <div className="w-full px-3 sm:w-1/2">
                                <div className="mb-5">
                                    <label htmlFor="dob"
                                           className="mb-3 block text-base font-medium">
                                        Ngày sinh
                                    </label>
                                    <Field
                                        type="date"
                                        name="dob"
                                        id="dob"
                                        className="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                                        readOnly/>
                                </div>
                            </div>
                            <div className="w-full px-3 sm:w-1/2">
                                <div className="mb-5">
                                    <label htmlFor="phone"
                                           className="mb-3 block text-base font-medium">
                                        Số điện thoại
                                    </label>
                                    <Field
                                        type="text"
                                        name="phone"
                                        id="phone"
                                        placeholder="Mời nhập vào"
                                        className="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                                        readOnly/>
                                </div>
                            </div>
                        </div>
                        <div className="-mx-3 flex flex-wrap">
                            <div className="w-full px-3 sm:w-1/2">
                                <div className="mb-5">
                                    <label htmlFor="email"
                                           className="mb-3 block text-base font-medium">
                                        Email
                                    </label>
                                    <Field
                                        type="text"
                                        name="email"
                                        id="email"
                                        placeholder="Mời nhập vào"
                                        className="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                                        readOnly/>
                                </div>
                            </div>
                            <div className="w-full px-3 sm:w-1/2">
                                <div className="mb-5">
                                    <label htmlFor="idCard"
                                           className="mb-3 block text-base font-medium">
                                        Căn cước công dân
                                    </label>
                                    <Field
                                        type="text"
                                        name="idCard"
                                        id="idCard"
                                        placeholder="Mời nhập vào"
                                        className="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                                        readOnly/>
                                </div>
                            </div>
                        </div>
                        <div className="-mx-3 flex flex-wrap">
                            <div className="w-full px-3 sm:w-1/2">
                                <div className="mb-5">
                                    <label htmlFor="companyName"
                                           className="mb-3 block text-base font-medium">
                                        Tên công ty
                                    </label>
                                    <Field
                                        type="text"
                                        name="companyName"
                                        id="companyName"
                                        placeholder="Mời nhập vào"
                                        className="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                                        readOnly/>
                                </div>
                            </div>
                            <div className="w-full px-3 sm:w-1/2">
                                <div className="mb-5">
                                    <label htmlFor="website"
                                           className="mb-3 block text-base font-medium">
                                        Website
                                    </label>
                                    <Field
                                        type="text"
                                        name="website"
                                        id="website"
                                        placeholder="Mời nhập vào"
                                        className="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                                        readOnly/>
                                </div>
                            </div>
                        </div>
                        <div className="mb-5">
                            <label className="mb-3 block text-base font-medium">
                                Giới tính

                            </label>
                            <div className="flex items-center space-x-6">
                                <div className="flex items-center">
                                    <Field
                                        as="select"
                                        name="gender"
                                        className="w-32 px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
                                    >
                                        <option value="Nam">Nam</option>
                                        <option value="Nữ">Nữ</option>
                                        <option value="Khác">Khác</option>
                                    </Field>
                                </div>
                            </div>
                            {/* Add more fields as needed */}
                        </div>
                    </Form>
                </Formik>
            </div>
        </div>
    );
};

export default Modal;