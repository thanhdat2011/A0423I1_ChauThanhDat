import axios from "axios";

//======================== getCategoryById ============================
export async function getCategoryById(id) {
    try {
        const res = await axios.get(`http://localhost:8080/category/${id}`)
        console.log(res.data)
        return res.data
    }catch (e) {
        console.log(e)
    }
}

//===================== getAllCategory ================================
export async function getAllCategory() {
    try {
        const res = await axios.get("http://localhost:8080/category")
        return res.data
    } catch (e) {
        console.log(e)
    }
}

//================== return back book (same delete) ===================
export const returnBook = async (id) => {
    try {
        await axios.delete(`http://localhost:8080/rentBook/${id}`)
        return true
    } catch (e) {
        console.log(e)
    }
}

//========================= getAllRentBook (có sort) ===================
export const getAllRentBook = async () => {
    try {
        const res = await axios.get("http://localhost:8080/rentBook?_sort=title")
        return res.data
    }catch (e) {
        console.log(e)
    }
}

//=============================== getAllBook ===========================
export const getAllBook = async () => {
    try {
        // ?_sort=title : sort by
        const res = await axios.get(`http://localhost:8080/book`)
        // console.log(res.data)
        return res.data
    } catch (e) {
        console.log(e)
    }
}

//=============================== removeBook ===========================
export const removeBook = async (id) => {
    try {
        await axios.delete(`http://localhost:8080/book/${id}`)
        return true
    } catch (e) {
        console.log(e)
    }
}

//=============================== addNewBook ===========================
export const addNewBook = async (book) => {
    try {
        await axios.post("http://localhost:8080/book", book)
        return true;
    } catch (e) {
        console.log(e)
        return false
    }
}

//=============================== editBook =============================
export const editBook = async (book) => {
    try {
        await axios.put(`http://localhost:8080/book/${book.id}`, book)
        return true
    } catch (e) {
        return false
    }
}

//=============================== getBookById ===========================
export const getBookById = async (id) => {
    try {
        const res = await axios.get(`http://localhost:8080/book/${id}`)
        return res.data
    }catch (e) {
        console.log(e)
    }
}

//=============================== rentBook ===========================
export const rentBook = async (book) => {
    try {
        await axios.post("http://localhost:8080/rentBook", book)
        return true
    } catch (e) {
        console.log(e)
        return false
    }
}

//=========================== updateBookQuantityAfterRent ===========================
export const updateBookQuantityAfterRent = async (book) => {
    try {
        const response = await axios.get(`http://localhost:8080/book/${book.bookId}`) //tra ve doi tuong axios
        const quantityOfThatBook = response.data.quantity
        const updateQuantity = parseInt(quantityOfThatBook) - parseInt(book.quantity)

        await axios.patch(`http://localhost:8080/book/${book.bookId}`, {quantity : updateQuantity})
        return true;
    } catch (e) {
        console.log(e)
    }
}

export const updateBookQuantityAfterGiveBack = async (book) => {
    try {
        const response = await axios.get(`http://localhost:8080/book/${book.bookId}`) //tra ve doi tuong axios
        const quantityOfThatBook = response.data.quantity
        const updateQuantity = parseInt(quantityOfThatBook) + parseInt(book.quantity)

        await axios.patch(`http://localhost:8080/book/${book.bookId}`, {quantity : updateQuantity})
        return true;
    } catch (e) {
        console.log(e)
    }
}
