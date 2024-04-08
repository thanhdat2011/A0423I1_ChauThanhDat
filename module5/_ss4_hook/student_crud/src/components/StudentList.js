import React, {useEffect, useState} from "react";
import DeleteModal from "./DeleteModal";
import {Link} from "react-router-dom";


function StudentList(props) {

    const [studentList, setStudentList] = useState([])
    const [nameSearch, setNameSearch] = useState('')

    useEffect(()=> {
        setStudentList(props.studentList)
        console.log(studentList)
        const temp = [...props.studentList];
        const res = temp.filter((student)=> student.name.includes(nameSearch))
        setStudentList(res)
    }, [nameSearch])

    const handleDelete = (studentID) => {
        props.onDelete(studentID)
    }

    return (
        <>
            <h1>Student Management</h1>
            <Link className="btn btn-light btn-outline-dark" to="/students/create">Add New Student</Link>
            <div>
                <input type="text" onChange={(evt) => setNameSearch(evt.target.value)}/>
            </div>
            <table className="table table-hover">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>age</th>
                    <th>address</th>
                    <th>phone</th>
                    <th>email</th>
                </tr>
                </thead>
                <tbody>
                {studentList.map((student, index)=>(
                    <tr key={student.id}>
                        <td>{index + 1}</td>
                        <td>{student.id}</td>
                        <td>{student.name}</td>
                        <td>{student.age}</td>
                        <td>{student.address}</td>
                        <td>{student.phone}</td>
                        <td>{student.email}</td>
                        <td><DeleteModal student={student} onDelete={() => handleDelete(student.id)}/></td>
                        <td><Link className="btn btn-primary" to={`/students/edit/${student.id}`}>Edit</Link></td>
                    </tr>
                ))}
                </tbody>
            </table>
        </>
    )
}

export default StudentList