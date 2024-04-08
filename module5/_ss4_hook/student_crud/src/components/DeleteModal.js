import React, {useState} from "react";

function DeleteModal(props)  {
    const [showModal, setShowModal] = useState(false)

    const handleDelete = () => {
        props.onDelete()
        setShowModal(false);
    }

    return (
        <div>
            <button className="btn btn-danger" onClick={() => setShowModal(true)}>Delete</button>

            {showModal && (
                <div className="modal" style={{ display: 'block' }}>
                    <div className="modal-dialog">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title">Confirm Delete</h5>
                                <button type="button" className="btn-close" onClick={() => setShowModal(false)}/>
                            </div>
                            <div className="modal-body">
                                <p>Are you sure you want to delete {props.student.name}?</p>
                            </div>
                            <div className="modal-footer">
                                <button onClick={() => setShowModal(false)} type="button" className="btn btn-secondary" data-bs-dismiss="modal" >Close</button>
                                <button onClick={() => handleDelete()} type="button" className="btn btn-primary">Delete</button>
                            </div>
                        </div>
                    </div>
                </div>
            )}
        </div>
    );
}

export default DeleteModal