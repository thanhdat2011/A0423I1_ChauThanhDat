import React, {Component} from "react";

class TodoApp extends Component{
    constructor(props) {
        super(props);
        this.state = {
            taskList : [],
            item : ''
        }
    }

    handleChange(evt) {
        const value = evt.target.value.trim()
        this.setState({
            item : value
        })
    }

    handleAddItem(){
        if (this.state.item) {
            this.setState({
                taskList : [...this.state.taskList, this.state.item],
                item : ''
            })
        }

    }

    render() {
        return (
            <>
                <div className="App">
                    <h1>To Do List</h1>
                    <input type="text" value={this.state.item} onChange={(evt) => this.handleChange(evt)}/>
                    <button type="submit" onClick={() => this.handleAddItem()} >Add</button>

                    <hr
                        style={{
                            height : '1px', backgroundColor: 'black'
                        }}
                    />

                    <table
                           style={{
                               textAlign: "center",
                               margin: "auto",
                               width : '30%'
                           }}>
                        <thead>
                        <tr>
                            <th>STT</th>
                            <th>Task</th>
                        </tr>
                        </thead>
                        <tbody>
                        {this.state.taskList.map((task, index)=> (
                            <tr key={index}>
                                <td>{index+1}</td>
                                <td>{task}</td>
                            </tr>
                        ))}
                        </tbody>
                    </table>
                </div>
            </>
        )
    }
}

export default TodoApp