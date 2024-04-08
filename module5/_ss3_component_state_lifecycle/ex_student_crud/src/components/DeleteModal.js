import React, {Component} from "react";

class DeleteModal extends Component{
    constructor(props) {
        super(props);
        this.state = {
            showModal : false
        }
    }

    handleDelete(){
        this.props.onDelete()
        this.setState({ showModal: false });
    }

    render() {
        return (
            <div>
                <button className="btn btn-danger" onClick={() => this.setState({showModal : true})}>Delete</button>

                {this.state.showModal && (
                    <div className="modal" style={{ display: 'block' }}>
                        <div className="modal-dialog">
                            <div className="modal-content">
                                <div className="modal-header">
                                    <h5 className="modal-title">Confirm Delete</h5>
                                    <button type="button" className="btn-close" onClick={() => this.setState({showModal: false})}/>
                                </div>
                                <div className="modal-body">
                                    <p>Are you sure you want to delete {this.props.student.name}?</p>
                                </div>
                                <div className="modal-footer">
                                    <button onClick={() => this.setState({showModal:false})} type="button" className="btn btn-secondary" data-bs-dismiss="modal" >Close</button>
                                    <button onClick={() => this.handleDelete()} type="button" className="btn btn-primary">Delete</button>
                                </div>
                            </div>
                        </div>
                    </div>
                )}
            </div>
        );
    }

}

export default DeleteModal