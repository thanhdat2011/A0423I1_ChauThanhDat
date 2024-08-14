import {Field, Form, Formik, ErrorMessage} from "formik";
import {useNavigate} from "react-router-dom";
import * as customerService from "../../services/CustomerService";
import * as Yup from "yup";
import "../../css/customer/create.css";
import {toast} from "react-toastify";
import * as authService from '../../services/Authenticate/AuthService.js'
import React from "react";

const CreateCustomer = () => {
    const navigate = useNavigate();

    const handleCreate = async (customer) => {
        try {
            console.log(customer);
            const token = authService.getToken();
            await customerService.createCustomer(customer, token);
            navigate("/customer");
            toast.success("Thêm mới khách hàng thành công", {
                position: "top-right",
                autoClose: 2000,
            });
        } catch (e) {
            console.log(e);
        }
    };

    const customerInit = {
        name: "",
        address: "",
        dob: "",
        phone: "",
        email: "",
        idCard: "",
        companyName: "",
        website: "",
        gender: ""

    };

    const validate = {
        name: Yup.string()
            .required("Tên khách hàng không được rỗng")
            .max(100, "Tên khách hàng không dài quá 100 kí tự")
            .min(3, "Tên khách hàng phải có ít nhất 3 kí tự")
            .matches(/^[A-ZÀ-Ỹ][a-zà-ỹ]+(\s[A-ZÀ-Ỹ][a-zà-ỹ]*)+$/, "Tên khách hàng chỉ được chứa chữ cái và khoảng trắng , Chữ đầu viết hoa"),
        dob: Yup.date()
            .required("Vui lòng chọn ngày sinh")
            .max(new Date(), `Ngày không được lớn hơn hiện tại`),
        gender: Yup.string().required("Vui lòng chọn giới tính"),
        address: Yup.string()
            .required("Địa chỉ không được rỗng")
            .max(100, "Địa chỉ không dài quá 100 kí tự")
            .min(5, "Địa chỉ phải có ít nhất 5 kí tự"),
        email: Yup.string()
            .required("Email không được rỗng")
            .max(100, "Email không dài quá 100 kí tự")
            .min(5, "Email phải có ít nhất 5 kí tự")
            .matches(/^[\S]+@[\w]+\.[\w]+$/, "Email không đúng định dạng"),
        phone: Yup.string()
            .required("Số điện thoại không được rỗng")
            .max(20, "Số điện thoại không dài quá 20 số")
            .min(10, "Số điện thoại phải có ít nhất 10 số")
            .matches(/^(\+\d{1,2}[- ]?)?\(?\d{3}\)?[- ]?\d{3}[- ]?\d{4,}$/, "Số điện thoại không hợp lệ"),
        website: Yup.string()
            .required("Website không được rỗng")
            .max(100, "Website không dài quá 100 kí tự")
            .matches(/^[a-zA-Z0-9-]+(\.[a-zA-Z0-9-]+)*\.[a-zA-Z0-9-]+$/, "Sai định dạng website"),
        companyName: Yup.string()
            .required("Tên công ty không được rỗng")
            .max(100, "Tên công ty không dài quá 100 kí tự")
            .min(5, "Tên công ty dài hơn 5 kí tự")
            .matches(/^[A-ZÀ-Ỹ]?[a-zà-ỹ0-9]+(\s[A-ZÀ-Ỹ]?[a-zà-ỹ0-9]*)*$/, "Tên công ty không chứa kí đặc biệt"),
    idCard: Yup.string()
        .required("Căn cước công dân không được rỗng")
        .max(20, "Căn cước công dân không dài quá 20 kí tự")
        .min(5, "Tên khách phi hàng lớn hơn 5 kí tự"),
}
    ;

    return (
        <>

            <div id="create-tt" className="boss max-w-[1000px] max-h-[900px]  mx-auto ">
                <h1 className="text-center text-4xl font-bold py-3 shadow-2xl">Thêm Mới Khách Hàng</h1>
                <div class="flex items-center justify-center p-12 ">
                    <div class="mx-auto w-full max-w-[800px]">
                        <Formik
                            validationSchema={Yup.object(validate)}
                            initialValues={customerInit}
                            onSubmit={handleCreate}
                        >
                            <Form>
                                <div class="-mx-3 flex flex-wrap">
                                    <div class="w-full px-3 sm:w-1/2 ">
                                        <div class="mb-5">
                                            <label
                                                for="fName"
                                                class="mb-3 block text-base font-medium text-[#07074D]"
                                            >
                                                Tên khách hàng <span style={{color: "red"}}>(*)</span>
                                            </label>
                                            <Field
                                                type="text"
                                                name="name"
                                                id="fName"
                                                placeholder="Mời nhập vào..."
                                                class="w-full rounded-md border border-[#000x] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                                            />
                                            <ErrorMessage
                                                name="name"
                                                component="span"
                                                style={{color: "red", fontStyle: "italic"}}
                                            ></ErrorMessage>
                                        </div>
                                    </div>
                                    <div class="w-full px-3 sm:w-1/2">
                                        <div class="mb-5">
                                            <label
                                                for="lName"
                                                class="mb-3 block text-base font-medium text-[#07074D]"
                                            >
                                                Địa chỉ <span style={{color: "red"}}>(*)</span>
                                            </label>
                                            <Field
                                                type="text"
                                                name="address"
                                                id="lName"
                                                placeholder="Mời nhập vào"
                                                class="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                                            />
                                            <ErrorMessage
                                                name="address"
                                                component="span"
                                                style={{color: "red", fontStyle: "italic"}}
                                            ></ErrorMessage>
                                        </div>
                                    </div>
                                </div>

                                <div className="-mx-3 flex flex-wrap">
                                    <div className="w-full px-3 sm:w-1/2">
                                        <div className="mb-5">
                                            <label
                                                htmlFor="date"
                                                className="mb-3 block text-base font-medium text-[#07074D]"
                                            >
                                                Ngày sinh <span style={{color: "red"}}>(*)</span>
                                            </label>
                                            <Field
                                                type="date"
                                                name="dob"
                                                id="date"
                                                validate={(value) => {
                                                    let currentYear = new Date().getFullYear();
                                                    let minAllowedYear = currentYear - 18;
                                                    let minAllowedMonth = 5; // tháng 6 - 1 = tháng 5
                                                    let dob = new Date(value);
                                                    if (
                                                        dob.getFullYear() > minAllowedYear ||
                                                        (dob.getFullYear() === minAllowedYear &&
                                                            dob.getMonth() >= minAllowedMonth)
                                                    ) {
                                                        return "Bạn chưa đủ 18 tuổi.";
                                                    }
                                                }}
                                                className="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                                            />
                                            <ErrorMessage
                                                name="dob"
                                                component="span"
                                                style={{color: "red", fontStyle: "italic"}}
                                            ></ErrorMessage>
                                        </div>
                                    </div>
                                    <div className="w-full px-3 sm:w-1/2">
                                        <div className="mb-5">
                                            <label
                                                htmlFor="lName"
                                                className="mb-3 block text-base font-medium text-[#07074D]"
                                            >
                                                Số điện thoại <span style={{color: "red"}}>(*)</span>
                                            </label>
                                            <Field
                                                type="text"
                                                name="phone"
                                                id="lName"
                                                placeholder="Mời nhập vào"
                                                className="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                                            />
                                            <ErrorMessage
                                                name="phone"
                                                component="span"
                                                style={{color: "red", fontStyle: "italic"}}
                                            ></ErrorMessage>
                                        </div>
                                    </div>
                                </div>

                                <div className="-mx-3 flex flex-wrap">
                                    <div className="w-full px-3 sm:w-1/2">
                                        <div className="mb-5">
                                            <label
                                                htmlFor="lName"
                                                className="mb-3 block text-base font-medium text-[#07074D]"
                                            >
                                                Email <span style={{color: "red"}}>(*)</span>
                                            </label>
                                            <Field
                                                type="text"
                                                name="email"
                                                id="lName"
                                                placeholder="Mời nhập vào"
                                                className="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                                            />
                                            <ErrorMessage
                                                name="email"
                                                component="span"
                                                style={{color: "red", fontStyle: "italic"}}
                                            ></ErrorMessage>
                                        </div>
                                    </div>
                                    <div className="w-full px-3 sm:w-1/2">
                                        <div className="mb-5">
                                            <label
                                                htmlFor="lName"
                                                className="mb-3 block text-base font-medium text-[#07074D]"
                                            >
                                                Căn cước công dân{" "}
                                                <span style={{color: "red"}}>(*)</span>
                                            </label>
                                            <Field
                                                type="text"
                                                name="idCard"
                                                id="lName"
                                                placeholder="Mời nhập vào"
                                                className="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                                            />
                                            <ErrorMessage
                                                name="idCard"
                                                component="span"
                                                style={{color: "red", fontStyle: "italic"}}
                                            ></ErrorMessage>
                                        </div>
                                    </div>
                                </div>

                                <div className="-mx-3 flex flex-wrap">
                                    <div className="w-full px-3 sm:w-1/2">
                                        <div className="mb-5">
                                            <label
                                                htmlFor="lName"
                                                className="mb-3 block text-base font-medium text-[#07074D]"
                                            >
                                                Tên công ty <span style={{color: "red"}}>(*)</span>
                                            </label>
                                            <Field
                                                type="text"
                                                name="companyName"
                                                id="lName"
                                                placeholder="Mời nhập vào"
                                                className="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                                            />
                                            <ErrorMessage
                                                name="companyName"
                                                component="span"
                                                style={{color: "red", fontStyle: "italic"}}
                                            ></ErrorMessage>
                                        </div>
                                    </div>
                                    <div className="w-full px-3 sm:w-1/2">
                                        <div className="mb-5">
                                            <label
                                                htmlFor="lName"
                                                className="mb-3 block text-base font-medium text-[#07074D]"
                                            >
                                                Website <span style={{color: "red"}}>(*)</span>
                                            </label>
                                            <Field
                                                type="text"
                                                name="website"
                                                id="lName"
                                                placeholder="Mời nhập vào"
                                                className="w-full rounded-md border border-[#e0e0e0] bg-white py-3 px-6 text-base font-medium text-[#6B7280] outline-none focus:border-[#6A64F1] focus:shadow-md"
                                            />
                                            <ErrorMessage
                                                name="website"
                                                component="span"
                                                style={{color: "red", fontStyle: "italic"}}
                                            ></ErrorMessage>
                                        </div>
                                    </div>
                                </div>

                                <div className="mb-5">
                                    <label className="mb-3 block text-base font-medium text-[#07074D]">
                                        Vui lòng chọn giới tính của bạn{" "}
                                        <span style={{color: "red"}}>(*)</span>
                                    </label>
                                    <div className="flex items-center space-x-6">
                                        <div className="flex flex-col w-full">
                                            <Field
                                                as="select"
                                                name="gender"
                                                className="w-48 px-4 py-2 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
                                            >
                                                <option value="">Chọn giới tính</option>
                                                <option className="font-bold" value="Nam">
                                                    Nam
                                                </option>
                                                <option className="font-bold" value="Nữ">
                                                    Nữ
                                                </option>
                                                <option className="font-bold" value="Khác">
                                                    Khác
                                                </option>
                                            </Field>
                                            <ErrorMessage
                                                name="gender"
                                                component="div"
                                                className="w-full mt-2"
                                                style={{color: "red", fontStyle: "italic"}}
                                            ></ErrorMessage>
                                        </div>
                                    </div>
                                </div>
                                <div>
                                    <button
                                        className="text-white bg-blue-700 hover:bg-blue-800  focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800 inline-flex items-center"
                                        style={{backgroundColor: "#4CAF50"}}
                                        type={"submit"}>
                                        <span><i className="fi fi-rs-disk"/></span>
                                        Lưu
                                    </button>
                                    <button type={"reset"}
                                            className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center me-2 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800 inline-flex items-center">
                                        <span><i className="fi fi-rr-eraser"/></span>
                                        Làm mới
                                    </button>
                                </div>
                            </Form>
                        </Formik>
                    </div>
                </div>
            </div>
        </>
    );
};
export default CreateCustomer;
