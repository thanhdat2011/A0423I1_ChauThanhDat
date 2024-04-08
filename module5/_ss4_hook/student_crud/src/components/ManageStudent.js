import React, {useEffect, useState} from "react";
import CreateOrEditStudent from "./CreateOrEditStudent";
import StudentList from "./StudentList";
import {BrowserRouter, Routes, Route} from "react-router-dom";

function ManageStudents() {
    const [studentList, setStudentList] = useState([]);

    useEffect(() => {
        setStudentList([
            {
                id : 'ST01',
                name: 'Dat',
                age: 24,
                address: 'Da Nang',
                phone: '0293029420',
                email: 'ctd@gmail.com'
            },
            {
                id : 'ST02',
                name: 'Truong',
                age: 20,
                address: 'Quang Nam',
                phone: '9283982230',
                email: 'ltn@gmail.com'
            },
            {
                id : 'ST03',
                name: 'Quoc',
                age: 21,
                address: 'Hoi An',
                phone: '0913091314',
                email: 'ctd@gmail.com'
            }
        ])
    }, [])

    const handleDelete = (studentID) => {
        /* Xoa theo index
            const updateList = [...studentList]
            updateList.splice(index, 1)
            setStudentList(updateList)
        */
        setStudentList(studentList.filter((student) => student.id !== studentID))
    }

    // Function to add or edit a student
    const addOrEditStudent = (updatedStudent) => {
        const existingStudentIndex = studentList.findIndex(
            (student) => student.id === updatedStudent.id
        );
        if (existingStudentIndex !== -1) {
            // Edit existing student
            const updatedList = [...studentList];
            updatedList[existingStudentIndex] = updatedStudent;
            setStudentList(updatedList);
        } else {
            // Add new student
            setStudentList([...studentList, updatedStudent]);
        }
    };

    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path="/students" element={<StudentList studentList={studentList} onDelete={handleDelete}/>}/>
                    <Route path="/students/create" element={<CreateOrEditStudent student={{}} onCreate={addOrEditStudent}/>}/>
                    <Route path="/students/edit/:id" element={<CreateOrEditStudent studentList={studentList} onCreate={addOrEditStudent}/> }/>
                    <Route path="/students/search/:key"/>
                </Routes>
            </BrowserRouter>
        </>
    );
}

export default ManageStudents