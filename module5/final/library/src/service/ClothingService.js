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

//=============================== getAllBook ===========================
export const getAllBook = async () => {
    try {
        // ?_sort=title : sort by
        const res = await axios.get(`http://localhost:8080/clothes?_sort=quantity`)
        return res.data
    } catch (e) {
        console.log(e)
    }
}



//=============================== editBook =============================
export const editCloth = async (book) => {
    try {
        await axios.put(`http://localhost:8080/clothes/${book.id}`, book)
        return true
    } catch (e) {
        return false
    }
}

//=============================== getBookById ===========================
export const getClothById = async (id) => {
    try {
        const res = await axios.get(`http://localhost:8080/clothes/${id}`)
        return res.data
    }catch (e) {
        console.log(e)
    }
}

