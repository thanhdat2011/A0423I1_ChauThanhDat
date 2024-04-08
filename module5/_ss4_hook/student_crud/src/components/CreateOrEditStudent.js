import React, {useEffect, useState} from "react";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";
import {useNavigate, useParams} from "react-router";

function CreateOrEditStudent(props) {

    const [student,setStudent] = useState()
    const navigate = useNavigate()
    const {id} = useParams()

    useEffect(()=>{
        if (id) {
            const temp = props.studentList.find((student) => student.id === id)
            setStudent(temp)
            console.log(temp)
        } else {
            setStudent(
                {
                    id : '',
                    name: '',
                    age: '',
                    address: '',
                    phone: '',
                    email: ''
                }
            );
        }
    }, [id])

    const addNewStudent = (student) => {
        setStudent(student);
        props.onCreate(student);
        navigate("/students")
    }


    const validateStudent = {
        id : Yup.string().required("Please input id !!!")
            .matches(/^ST[0-9]{2}$/, "ID must start with ST following by 2 digits"),
        name : Yup.string().required("Please input name !!!")
            .max(100),
        age : Yup.number().required("Please input age !!!")
            .min(18)
            .max(100),
        address : Yup.string().max(100),
        phone : Yup.string().required("Please input phone !!!")
            .max(20),
        email : Yup.string().matches(/^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/)
    }

    if(!student) {
        return null;
    }

    return (
        <>
            <Formik initialValues={student} onSubmit={addNewStudent}
                    validationSchema={Yup.object(validateStudent)}
            >
                <Form>
                    <h3 style={{textAlign : "center"}}>Create Student</h3>
                    <div className="form-group row">
                        <label htmlFor="inputID" className="col-sm-2 col-form-label">ID</label>
                        <div className="col-sm-10">
                            <Field className="form-control" id="inputID" placeholder="ID" name="id"/>
                            <ErrorMessage name="id" component="div"/>
                        </div>
                    </div>

                    <div className="form-group row">
                        <label htmlFor="inputName" className="col-sm-2 col-form-label">Name</label>
                        <div className="col-sm-10">
                            <Field className="form-control" id="inputName" placeholder="Name" name="name" component="p"/>
                            <ErrorMessage name="name" component="div"/>
                        </div>
                    </div>

                    <div className="form-group row">
                        <label htmlFor="inputAge" className="col-sm-2 col-form-label">Age</label>
                        <div className="col-sm-10">
                            <Field type="number"  className="form-control" id="inputAge" placeholder="age" name="age"/>
                            <ErrorMessage name="age" component="div"/>
                        </div>
                    </div>

                    <div className="form-group row">
                        <label htmlFor="inputAdd" className="col-sm-2 col-form-label">Address</label>
                        <div className="col-sm-10">
                            <Field className="form-control" id="inputAdd" placeholder="address" name="address"/>
                            <ErrorMessage name="address" component="div"/>
                        </div>
                    </div>

                    <div className="form-group row">
                        <label htmlFor="inputPhone" className="col-sm-2 col-form-label">Phone</label>
                        <div className="col-sm-10">
                            <Field className="form-control" id="inputPhone" placeholder="phone" name="phone"/>
                            <ErrorMessage name="phone" component="div"/>
                        </div>
                    </div>

                    <div className="form-group row">
                        <label htmlFor="inputEmail" className="col-sm-2 col-form-label">Email</label>
                        <div className="col-sm-10">
                            <Field className="form-control" id="inputEmail" placeholder="email" name="email"/>
                            <ErrorMessage name="email" component="div"/>
                        </div>
                    </div>

                    <button className="btn btn-primary" type="submit">Create</button>
                </Form>
            </Formik>

        </>
    )
}

export default CreateOrEditStudent