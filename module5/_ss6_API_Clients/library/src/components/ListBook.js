import React, {useEffect, useState} from "react";
import * as bookService from "../service/BookService"
import Modal from "react-modal"
import {toast} from "react-toastify";
import {Link} from "react-router-dom";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as Yup from "yup";
import moment from "moment";


function ListBook() {
    const [books, setBooks] = useState([])
    const [deleteModalIsOpen, setDeleteModalIsOpen] = useState(false)
    const [rentModalIsOpen, setRentModalIsOpen] = useState(false)
    const [bookDelete, setBookDelete] = useState({})
    const [bookRent, setBookRent] = useState({})
    const [selectDeleteBooks, setSelectDeleteBooks] = useState([])
    const [categories, setCategories] = useState([])

    const [nameSearch, setNameSearch] = useState("")
    const [authorSearch, setAuthorSearch] = useState("")

    //=========================== FOR LIST ============================
    useEffect(() => {
        getAllCategory()
    }, [])

    useEffect(() => {
        // if (books.length === 0) {
            getAll()
            // console.log(books)
        // }
    }, [nameSearch, authorSearch])


    const getAll= async () => {
        const temp = await bookService.getAllBook();
        // console.log(temp)

        const res = temp.filter((book) => book.title.toLowerCase().includes(nameSearch.toLowerCase())
                                        && book.author.toLowerCase().includes(authorSearch.toLowerCase()))

        setBooks(res)
    }

    const getAllCategory = async () => {
        const res = await bookService.getAllCategory();
        setCategories(res)
    }

    //================================ FOR RENT =============================
    const validateRentBook = {
        quantity : Yup.number().min(1).max(bookRent.quantity).typeError("Must be a number")
    }

    //=============================  FOR MODAL =======================
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

    const openDeleteModal = (book) => {
        setBookDelete(book)
        setDeleteModalIsOpen(true);
    }

    const openRentModal = (book) => {
        setBookRent({
            "bookId": book.id,
            "title": book.title,
            "author": book.author,
            "date": book.date,
            "quantity": book.quantity
        })
        setRentModalIsOpen(true);
    }

    //========================== DELETE SINGLE ==================================
    const removeBook = async () => {
        const isSuccess = await bookService.removeBook(bookDelete.id)
        if (isSuccess) {
            toast.success("Delete successfully !!!")
        }
        setDeleteModalIsOpen(false)
        await getAll()
    }

    //========================= HANDLE SELECT MULTIPLE TO DELETE =========================
    const toggleSelect = (bookId) => {
        if (selectDeleteBooks.includes(bookId)) {
            setSelectDeleteBooks(selectDeleteBooks.filter(id => id !== bookId));
        } else {
            setSelectDeleteBooks([...selectDeleteBooks, bookId]);
        }
    };

    //============================= DELETE MULTIPLE =============================
    const deleteSelected = async() => {
        if (selectDeleteBooks.length === 0) {
            setDeleteModalIsOpen(false)
            toast.warn("Choose first !!!")
            return ;
        }

        let isSuccess = true;
        for (const bookId of selectDeleteBooks) {
            try {
                await bookService.removeBook(bookId)
            } catch (e) {
                isSuccess = false
            }
        }

        if (isSuccess) {
            toast.success("Delete successfully !!!")
        }

        setSelectDeleteBooks([])
        setDeleteModalIsOpen(false)
        await getAll()
    };


    //=========================== RENT BOOK ===========================
    const rentBook = async (book) => {

        // handle rent book (add more attribute on rented book)
        const rentedBook = {
            ... bookRent,
            rentDate : new Date().toLocaleDateString(),
            quantity: book.quantity
        }

        const isSuccess = await bookService.rentBook(rentedBook)
        if (isSuccess) {
            toast.success("Rent successfully !!!")
            await bookService.updateBookQuantityAfterRent(book)
        }
        setRentModalIsOpen(false)
        await getAll()
    }
    //=================================================================

    return (
        <div className="container-fluid">
            <h1 style={{textAlign : "center", marginTop : "20px"}}>Book Library</h1>

            <div className="navbar nav-item">
                <div>
                    <Link className="icon-link" to="/books/rent">Your Rent Books</Link>
                </div>

                <div>
                    <Link className="btn btn-outline-dark" to="/books/add">Add New Book</Link>
                </div>

                <div>
                    <input placeholder="Search By Name" type="text" onChange={(evt) => setNameSearch(evt.target.value)}/>
                    <input placeholder="Search By Author" type="text" onChange={(evt) => setAuthorSearch(evt.target.value)}/>
                </div>
            </div>

            <table className="table table-hover">
                <thead>
                <tr>
                    <td>ID</td>
                    <td>Title</td>
                    <td>Author</td>
                    <td>Publish Date</td>
                    <td>Category</td>
                    <td>Quantity</td>
                    <td className="action-btn">Actions</td>
                </tr>
                </thead>
                <tbody>
                {books.map((book) => (
                    <tr key={book.id}>
                        <td>{book.id}</td>
                        <td>{book.title}</td>
                        <td>{book.author}</td>
                        <td>{moment(book.date).format('DD/MM/YYYY')}</td>
                        <td>{book.category.type}</td>
                        <td>{book.quantity}</td>
                        <td className="action-btn">
                            <input className="form-check-input" type="checkbox" checked={selectDeleteBooks.includes(book.id)} onChange={() => toggleSelect(book.id)} />
                            <button className="btn btn-danger" onClick={() => openDeleteModal(book)}>Delete</button>
                            <Link className="btn btn-primary" to={`/books/edit/${book.id}`}>Edit</Link>
                            <button className="btn btn-secondary" onClick={() => openRentModal(book)}>Rent</button>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>

            <button className="btn btn-danger" onClick={() => openDeleteModal()}>delete choose</button>

            {/*DELETE MULTIPLE*/}
            <Modal
                isOpen={deleteModalIsOpen}
                onRequestClose={() => setDeleteModalIsOpen(false)}
                style={customStyles}
            >
                <div>Do you want to delete</div>
                <button className="btn btn-danger" onClick={deleteSelected}>Delete</button>
            </Modal>

            {/*DELETE SINGLE MODAL*/}
            {/*<Modal*/}
            {/*    isOpen={deleteModalIsOpen}*/}
            {/*    onRequestClose={() => setDeleteModalIsOpen(false)}*/}
            {/*    style={customStyles}*/}
            {/*>*/}
            {/*    <div>Do you want to delete book named {bookDelete.title}</div>*/}
            {/*    <button className="btn btn-danger" onClick={removeBook}>Delete</button>*/}
            {/*</Modal>*/}

            {/*RENT MODAL (IF quantity > 0*/}
            {bookRent.quantity > 0 &&  (<Modal
                isOpen={rentModalIsOpen}
                onRequestClose={() => setRentModalIsOpen(false)}
                style={customStyles}
            >
                <div>Do you want to rent book named {bookRent.title}</div>
                <Formik initialValues={bookRent} onSubmit={rentBook}
                        validationSchema={Yup.object(validateRentBook)}>
                    <Form style={{margin : "auto", width:"100%", border:"none"}}>

                        <Field type="hidden" name="bookID"/>

                        <Field placeholder="Quantity" name="quantity"/>
                        <ErrorMessage name="quantity" component="div"/>
                        <div>
                            <button type="submit" className="btn btn-primary">Rent</button>
                        </div>
                    </Form>
                </Formik>
            </Modal>)}

            {/* IF QUANTITY < 0 */}
            {bookRent.quantity === 0 &&  (<Modal
                isOpen={rentModalIsOpen}
                onRequestClose={() => setRentModalIsOpen(false)}
                style={customStyles}
            >
                <div>Book named {bookRent.title} was sold out !!!</div>
            </Modal>)}

        </div>
    )


}

export default ListBook
