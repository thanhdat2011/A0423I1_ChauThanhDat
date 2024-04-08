import React, {Component} from "react";
import DeleteModal from "./DeleteModal";

class StudentList extends Component{
    constructor(props) {
        super(props);
        this.state = {
            students: [
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
            ]
        }
    }

    handleDelete(id){
        this.setState({
            students : this.state.students.filter((student) => student.id !== id)
            // students : this.state.students.splice(index, 1)
        })
    }

    render() {
        return (
            <>
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
                    {this.state.students.map((student, index)=>(
                        <tr key={student.id}>
                            <td>{index + 1}</td>
                            <td>{student.name}</td>
                            <td>{student.age}</td>
                            <td>{student.address}</td>
                            <td>{student.phone}</td>
                            <td>{student.email}</td>
                            {/*<td><button className="btn btn-danger" onClick={()=> this.remove(id)}>Delete</button></td>*/}
                            <td><DeleteModal student = {student} onDelete={() => this.handleDelete(student.id)}/></td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            </>
        )
    }
}

export default StudentList