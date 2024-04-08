import React, {useEffect, useState} from "react";
import * as bookService from "../service/BookService"
import Modal from "react-modal"
import {toast} from "react-toastify";
import {Link} from "react-router-dom";

function ListBook() {
    const [books, setBooks] = useState([])
    const [modalIsOpen, setIsOpen] = useState(false)
    const [bookDelete, setBookDelete] = useState({})

    useEffect(() => {
        if (books.length === 0) {
            getAll();
            console.log(books)
        }
    }, [])

    const getAll= async () => {
        const temp = await bookService.getAllBook()
        setBooks(temp)
    }

    //========  FOR DELETE MODAL ============
    const customStyles = {
        content: {
            top: '10%',
            left: '50%',
            right: 'auto',
            bottom: 'auto',
            marginRight: '-50%',
            transform: 'translate(-50%, -50%)',
        },
    };
    const openModal = (book) => {
        setBookDelete(book)
        setIsOpen(true);
    }

    const removeBook = async () => {
        const isSuccess = await bookService.removeBook(bookDelete.id)
        console.log(isSuccess)
        if (isSuccess) {
            toast.success("Delete successfully !!!")
        }
        setIsOpen(false)
        await getAll()
    }


    return (
        <>
            <h1>Book Library</h1>
            <Link to="/books/add">Add New Book</Link>
            <table className="table table-hover">
                <thead>
                <tr>
                    <td>ID</td>
                    <td>Title</td>
                    <td>Author</td>
                    <td>Publish Date</td>
                    <td>Quantity</td>
                    <td>Actions</td>
                </tr>
                </thead>
                <tbody>
                {books.map((book) => (
                    <tr key={book.id}>
                        <td>{book.id}</td>
                        <td>{book.title}</td>
                        <td>{book.author}</td>
                        <td>{book.date}</td>
                        <td>{book.quantity}</td>
                        <td>
                            <button className="btn btn-danger" onClick={() => openModal(book)}>Delete</button>
                            <Link className="btn btn-primary" to={`/books/edit/${book.id}`}>Edit</Link>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>

            <Modal
                isOpen={modalIsOpen}
                onRequestClose={() => setIsOpen(false)}
                style={customStyles}
            >
                <div>Do you want to delete book named {bookDelete.title}</div>
                <button className="btn btn-danger" onClick={removeBook}>Delete</button>
            </Modal>
        </>
    )


}

export default ListBook
