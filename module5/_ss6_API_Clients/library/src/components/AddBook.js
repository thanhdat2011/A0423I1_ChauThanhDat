import React, {useEffect, useState} from "react";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as bookService from "../service/BookService"
import {useNavigate} from "react-router-dom";
import * as Yup from "yup"
import {toast} from "react-toastify";
import {number} from "yup";

function AddBook() {
    const [book, setBook] = useState({})


    const navigate = useNavigate()
    const validateBook = {
        id : Yup.number().required("Must be not empty !!!").min(1).max(100000),
        title : Yup.string().required("Must be not empty !!!").min(5).max(10000),
        author : Yup.string().required("Must be not empty !!!").min(5).max(10000),
        quantity : Yup.number().required("Must be not empty !!!").min(1).max(1000)
    }
    const addNewBook = async (book) => {
        const isSuccess = await bookService.addNewBook(book)
        if (isSuccess) {
            toast.success("Add successfully !!!")
        }
        navigate("/books")
    }

    return (
        <>
            <Formik initialValues={book} onSubmit={addNewBook}
                validationSchema={Yup.object(validateBook)}
            >
                <Form>
                    <h3 style={{textAlign : "center"}}>Add New Book</h3>
                    <div className="form-group row">
                        <label htmlFor="inputID" className="col-sm-2 col-form-label">ID</label>
                        <div className="col-sm-10">
                            <Field className="form-control" id="inputID" placeholder="ID" name="id"/>
                            <ErrorMessage name="id" component="div"/>
                        </div>
                    </div>

                    <div className="form-group row">
                        <label htmlFor="inputTitle" className="col-sm-2 col-form-label">Title</label>
                        <div className="col-sm-10">
                            <Field className="form-control" id="inputTitle" placeholder="Title" name="title"/>
                            <ErrorMessage name="title" component="div"/>
                        </div>
                    </div>

                    <div className="form-group row">
                        <label htmlFor="inputAuthor" className="col-sm-2 col-form-label">Author</label>
                        <div className="col-sm-10">
                            <Field className="form-control" id="inputAuthor" placeholder="Author" name="author"/>
                            <ErrorMessage name="author" component="div"/>
                        </div>
                    </div>

                    <div className="form-group row">
                        <label htmlFor="inputDate" className="col-sm-2 col-form-label">Author</label>
                        <div className="col-sm-10">
                            <Field type="date" className="form-control" id="inputDate" placeholder="Author" name="date"/>
                            <ErrorMessage name="date" component="div"/>
                        </div>
                    </div>

                    <div className="form-group row">
                        <label htmlFor="inputQuantity" className="col-sm-2 col-form-label">Quantity</label>
                        <div className="col-sm-10">
                            <Field type="number" className="form-control" id="inputQuantity" placeholder="quantity" name="quantity"/>
                            <ErrorMessage name="quantity" component="div"/>
                        </div>
                    </div>

                    <button className="btn btn-primary" type="submit">Add</button>
                </Form>
            </Formik>
        </>
    )
}

export default AddBook