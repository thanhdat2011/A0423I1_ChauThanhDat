import React, {useEffect, useState} from "react";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as bookService from "../service/BookService"
import {useNavigate} from "react-router-dom";
import * as Yup from "yup"
import {toast} from "react-toastify";


function AddBook() {
    const [book, setBook] = useState({})
    const [categories, setCategories] = useState([])
    const navigate = useNavigate()

    //================================= VALIDATE =============================
    const validateBook = {
        id : Yup.number().required("Must be not empty !!!").min(1).max(100000),
        title : Yup.string().required("Must be not empty !!!").min(5).max(10000),
        author : Yup.string().required("Must be not empty !!!").min(5).max(10000),
        date: Yup.date().max(new Date(), "Date in future !!!"),
        category : Yup.string().required("Please choose !!!"),
        quantity : Yup.number().required("Must be not empty !!!").min(1).max(1000).typeError("Must be a number")
    }

    // ======================= get all category for choice ===================
    useEffect(() => {
        getAllCategory()
    }, [])

    //================================== ADD NEW BOOK =========================
    const addNewBook = async (book) => {
        const id = book.category

        book.category = await getCategoryById(id)
        console.log(book.category)

        const isSuccess = await bookService.addNewBook(book)
        if (isSuccess) {
            toast.success("Add successfully !!!")
        }
        navigate("/books")
    }

    //====================== HANDLE SELECT CATEGORY =======================
    // getAll
    const getAllCategory = async () => {
        const res = await bookService.getAllCategory()
        setCategories(res)
    }

    // getByID
    const getCategoryById = async (id) => {
        return await bookService.getCategoryById(id);
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
                        <label htmlFor="inputDate" className="col-sm-2 col-form-label">Publish Date</label>
                        <div className="col-sm-10">
                            <Field type="date" className="form-control" id="inputDate" placeholder="Author" name="date"/>
                            <ErrorMessage name="date" component="div"/>
                        </div>
                    </div>

                    <div className="form-group row">
                        <label htmlFor="inputCategory" className="col-sm-2 col-form-label">Category</label>
                        <div className="col-sm-10">
                            <Field as="select" className="form-control" id="inputCategory" name="category">
                                <option value="" hidden>Select category</option>
                                {categories.map(category => (
                                    <option key={category.id}
                                            value={category.id}
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

                    <button className="btn btn-primary" type="submit">Add</button>
                </Form>
            </Formik>
        </>
    )
}

export default AddBook