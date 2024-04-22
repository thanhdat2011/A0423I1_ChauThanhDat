import React, {useEffect, useState} from "react";
import * as bookService from "../service/BookService"
import Modal from "react-modal";
import {toast} from "react-toastify";
import {updateBookQuantityAfterGiveBack, updateBookQuantityAfterRent} from "../service/BookService";

function ListRentBook() {
    const [books, setBooks] = useState([]);
    const [returnBookModalIsOpen, setReturnBookModalIsOpen] = useState(false)
    const [bookReturn, setBookReturn] = useState({})

    useEffect(() => {
        if (books.length === 0 ) {
            getAll()
        }
    }, [])

    // =========================== GET ALL RENT BOOK ===========================
    const getAll = async () => {
        const res = await bookService.getAllRentBook()
        setBooks(res)
    }

    // ========================== FOR MODAL ====================================
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

    const openReturnBookModal = (book) => {
        setBookReturn(book)
        setReturnBookModalIsOpen(true)
    }

    // =========================== FOR RETURN BOOK =============================
    const returnBook = async () => {
        const isSuccess = await bookService.returnBook(bookReturn.id)
        if (isSuccess) {
            toast.success("Return Book Successfully !!!")
            await updateBookQuantityAfterGiveBack(bookReturn)
        }
        setReturnBookModalIsOpen(false)
        await getAll()
    }

    return(
        <>
            <h1>Book You Rent</h1>
            <table className="table table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Book</th>
                    <th>Quantity</th>
                    <th>Rent Date</th>
                </tr>
                </thead>
                <tbody>
                {books.map((book) => (
                    <tr key={book.id}>
                        <td>{book.id}</td>
                        <td>{book.title}</td>
                        <td>{book.quantity}</td>
                        <td>{book.rentDate}</td>
                        <td><button className="btn btn-primary" onClick={() => openReturnBookModal(book)}>Return</button></td>
                    </tr>
                ))}
                </tbody>
            </table>

            {/*RETURN BOOK MODAL*/}
            <Modal
                isOpen={returnBookModalIsOpen}
                onRequestClose={() => setReturnBookModalIsOpen(false)}
                style={customStyles}
            >
                <div>Do you want to return book named {bookReturn.title}</div>
                <button className="btn btn-danger" onClick={returnBook}>Confirm</button>
            </Modal>
        </>
    )
}

export default ListRentBook