import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";
import React, {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import * as bookService from "../service/BookService"
import {toast} from "react-toastify";

function EditBook() {
    const [book, setBook] = useState()
    const {id} = useParams()

    useEffect(() => {
        getEditBook()
    }, [])


    const navigate = useNavigate()
    const validateBook = {
        id : Yup.number().required("Must be not empty !!!").min(1).max(100000),
        title : Yup.string().required("Must be not empty !!!").min(5).max(10000),
        author : Yup.string().required("Must be not empty !!!").min(5).max(10000),
        quantity : Yup.number().required("Must be not empty !!!").min(1).max(1000)
    }

    const getEditBook = async () => {
        const temp = await bookService.getBookById(id)
        setBook(temp)
    }

    const updateBook = async (book) => {
        const isSuccess = await bookService.editBook(book)
        if (isSuccess) {
            toast.success("Edit success !!!")
        } else {
            toast.success("FAIL !!!")
        }
        navigate("/books")
    }

    if (!book) {
        return null
    }

    return (
        <>
            <Formik initialValues={book} onSubmit={updateBook}
                    validationSchema={Yup.object(validateBook)}
            >
                <Form>
                    <h3 style={{textAlign : "center"}}>Add New Book</h3>
                    <div className="form-group row">
                        <label htmlFor="inputID" className="col-sm-2 col-form-label">ID</label>
                        <div className="col-sm-10">
                            <Field readOnly className="form-control" id="inputID" placeholder="ID" name="id"/>
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
                        <label htmlFor="inputQuantity" className="col-sm-2 col-form-label">Quantity</label>
                        <div className="col-sm-10">
                            <Field type="number" className="form-control" id="inputQuantity" placeholder="quantity" name="quantity"/>
                            <ErrorMessage name="quantity" component="div"/>
                        </div>
                    </div>

                    <button className="btn btn-primary" type="submit">Edit</button>
                </Form>
            </Formik>
        </>
    )
}
export default EditBook