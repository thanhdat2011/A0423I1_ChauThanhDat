import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";
import React, {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import * as bookService from "../service/BookService"
import {toast} from "react-toastify";

function EditBook() {
    const [book, setBook] = useState()
    const [categories, setCategories] = useState([])
    const {id} = useParams()

    useEffect(() => {
        getAllCategory()
        getEditBook()
    }, [])


    const navigate = useNavigate()

    //========================= VALIDATE ==========================
    // REGEX : .matches(/^[a-zA-Z0-9]+$/, 'Invalid format')
    const validateBook = {
        id : Yup.number().required("Must be not empty !!!").min(1).max(100000),
        title : Yup.string().required("Must be not empty !!!").min(5).max(10000),
        author : Yup.string().required("Must be not empty !!!").matches(/^[a-zA-Z ]+$/, "do not have digit").min(5).max(10000),
        date: Yup.date().max(new Date(), "Date in future !!!"),
        // category : Yup.string().required("Please choose !!!"),
        category : Yup.string().required("Please choose !!!").typeError("Please choose !!!"),
        quantity : Yup.number().required("Must be not empty !!!").min(1).max(1000).typeError("Must be a number")
    }

    //==================== GET BOOK WANT EDIT ====================
    const getEditBook = async () => {
        const temp = await bookService.getBookById(id)
        setBook(temp)
    }

    //==================== UPDATE BOOK ===========================
    const updateBook = async (updateBook) => {
        // để ý book.category ở đây là id => mình muốn gắn lại cho book.category là đối tượng với id đó
        // gán lại đối tượng category
        const id = updateBook.category
        updateBook.category = await getCategoryById(id)

        const isSuccess = await bookService.editBook(updateBook)
        if (isSuccess) {
            toast.success("Edit success !!!")
        } else {
            toast.success("FAIL !!!")
        }
        navigate("/books")
    }

    //=================== HANDLE SELECT CATEGORY ==================
    const getAllCategory = async () => {
        const res = await bookService.getAllCategory()
        setCategories(res)
    }

    const getCategoryById = async (id) => {
        return await bookService.getCategoryById(id);
    }
    // ============================================================

    if (!book) {
        return null
    }

    return (
        <>
            <Formik initialValues={book} onSubmit={updateBook}
                    validationSchema={Yup.object(validateBook)}
            >
                <Form>
                    <h3 style={{textAlign : "center"}}>Edit Book</h3>
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
                        <label htmlFor="inputDate" className="col-sm-2 col-form-label">Publish Date</label>
                        <div className="col-sm-10">
                            <Field type="date" className="form-control" id="inputDate" name="date"/>
                            <ErrorMessage name="date" component="div"/>
                        </div>
                    </div>

                    <div className="form-group row">
                        <label htmlFor="inputCategory" className="col-sm-2 col-form-label">Category</label>
                        <div className="col-sm-10">
                            <Field as="select" className="form-control" id="inputCategory" placeholder="category" name="category">
                                <option value={book.category.id} hidden>{book.category.type}</option>
                                {categories.map(category => (
                                    <option key={category.id}
                                            value={category.id}
                                            // defaultValue={book.category.id}
                                    >
                                        {category.type}
                                    </option>
                                ))}
                            </Field>
                            <ErrorMessage name="category" component="div"/>
                        </div>
                    </div>

                    <div className="form-group row">
                        <label htmlFor="inputQuantity" className="col-sm-2 col-form-label">Quantity</label>
                        <div className="col-sm-10">
                            <Field className="form-control" id="inputQuantity" placeholder="quantity" name="quantity"/>
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