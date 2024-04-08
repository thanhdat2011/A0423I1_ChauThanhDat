import axios from "axios";

export const getAllBook = async () => {
    try {
        const res = await axios.get("http://localhost:8080/book")
        console.log(res)
        return res.data
    } catch (e) {
        console.log(e)
    }
}

export const removeBook = async (id) => {
    try {
        await axios.delete(`http://localhost:8080/book/${id}`)
        return true
    } catch (e) {
        console.log(e)
    }
}

export const addNewBook = async (book) => {
    try {
        await axios.post("http://localhost:8080/book", book)
        return true;
    } catch (e) {
        console.log(e)
        return false
    }
}

export const editBook = async (book) => {
    try {
        await axios.put(`http://localhost:8080/book/${book.id}`, book)
        return true
    } catch (e) {
        return false
    }
}

export const getBookById = async (id) => {
    try {
        const res = await axios.get(`http://localhost:8080/book/${id}`)
        return res.data
    }catch (e) {
        console.log(e)
    }
}


