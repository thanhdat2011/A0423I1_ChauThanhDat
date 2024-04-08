import React, {Component} from "react";

class StudentList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            students : [
                {
                    id : 1,
                    name : ' Nguyen Van A',
                    age  : 30,
                    address : 'Ha Noi'
                },
                {
                    id : 2,
                    name : ' Nguyen Van C',
                    age  : 20,
                    address : 'Sai Gon'
                }
            ]
        }
    }

        render ()
        {
            return (
                <>
                    <table>
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Address</th>
                        </tr>
                        </thead>
                        <tbody>
                        {this.state.students.map((student) => (
                            <tr>
                                <td>{student.id}</td>
                                <td>{student.name}</td>
                                <td>{student.age}</td>
                                <td>{student.address}</td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </>
            )
        }
}

export default StudentList