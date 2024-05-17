import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";
import React, {useEffect, useState} from "react";
import {useNavigate, useParams} from "react-router-dom";
import * as clothingService from "../service/ClothingService"
import {toast} from "react-toastify";

function EditCloth() {
    const [cloth, setCloth] = useState()
    const [categories, setCategories] = useState([])
    const {id} = useParams()

    useEffect(() => {
        getAllCategory()
        getEditCloth()
    }, [])

    const navigate = useNavigate()

    const validateCloth = {
        title : Yup.string().required("Must be not empty !!!").max(100),
        date: Yup.date().max(new Date(), "Date in future !!!"),
        quantity : Yup.number().required("Must be not empty !!!").integer("Must be a integer !!!").positive("Must be > 0").typeError("Must be a number")
    }

    const getEditCloth = async () => {
        const temp = await clothingService.getClothById(id)
        temp.category = temp.category.id
        setCloth(temp)
    }

    //==================== UPDATE CLOTH ===========================
    const updateCloth = async (updateCloth) => {

        const id = updateCloth.category
        updateCloth.category = await getCategoryById(id)

        const isSuccess = await clothingService.editCloth(updateCloth)
        if (isSuccess) {
            toast.success("Edit success !!!")
        } else {
            toast.success("FAIL !!!")
        }
        navigate("/clothes")
    }

    const getAllCategory = async () => {
        const res = await clothingService.getAllCategory()
        setCategories(res)
    }

    const getCategoryById = async (id) => {
        return await clothingService.getCategoryById(id);
    }

    if (!cloth) {
        return null
    }

    return (
        <>
            <Formik initialValues={cloth} onSubmit={updateCloth}
                    validationSchema={Yup.object(validateCloth)}
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
                        <label htmlFor="inputDate" className="col-sm-2 col-form-label">Immigrate Date</label>
                        <div className="col-sm-10">
                            <Field type="date" className="form-control" id="inputDate" name="date"/>
                            <ErrorMessage name="date" component="div"/>
                        </div>
                    </div>

                    <div className="form-group row">
                        <label htmlFor="inputCategory" className="col-sm-2 col-form-label">Category</label>
                        <div className="col-sm-10">
                            <Field as="select" className="form-control" id="inputCategory" placeholder="category" name="category">
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

                    <button className="btn btn-primary" type="submit">Edit</button>
                </Form>
            </Formik>
        </>
    )
}

export default EditCloth