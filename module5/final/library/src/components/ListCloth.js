import React, {useEffect, useState} from "react";
import * as clothingService from "../service/ClothingService"
import {Link} from "react-router-dom";
import moment from "moment";


function ListCloth() {
    const [clothes, setClothes] = useState([])
    const [categories, setCategories] = useState([])

    const [nameSearch, setNameSearch] = useState("")
    const [categorySearch, setCategorySearch] = useState("")


    useEffect(() => {
        getAllCategory()
    }, [])

    useEffect(() => {
            getAll()
    }, [nameSearch, categorySearch])

    //====================================================================
    const getAll= async () => {
        const temp = await clothingService.getAllBook();
        console.log(temp)

        const res = temp.filter((cloth) => cloth.title.toLowerCase().includes(nameSearch.toLowerCase())
                                            && cloth.category.type.toLowerCase().includes(categorySearch.toLowerCase())
        )

        setClothes(res)
    }

    const getAllCategory = async () => {
        const res = await clothingService.getAllCategory();
        setCategories(res)
    }

    return (
        <div className="container-fluid">
            <h1 style={{textAlign : "center", marginTop : "20px"}}>CLOTHING SHOP</h1>

            <div className="navbar nav-item">
                <div>
                    <input placeholder="Search By Name" type="text" onChange={(evt) => setNameSearch(evt.target.value)}/>
                    <select className="form-control" id="inputCategory" name="category" onChange={(evt) => setCategorySearch(evt.target.value)}>
                    <option value="">Select category</option>
                    {categories.map(category => (
                        <option key={category.id}
                                value={category.type}
                        >
                            {category.type}
                        </option>
                    ))}
                    </select>
                </div>
            </div>

            <table className="table table-hover">
                <thead>
                <tr>
                    <td>ID</td>
                    <td>Title</td>
                    <td>Immigrate Date</td>
                    <td>Category</td>
                    <td>Quantity</td>
                    <td className="action-btn">Actions</td>
                </tr>
                </thead>
                <tbody>
                {clothes.map((cloth, index) => (
                    <tr key={cloth.id}>
                        <td>{index+1}</td>
                        <td>{cloth.title}</td>
                        <td>{moment(cloth.date).format('DD/MM/YYYY')}</td>
                        <td>{cloth.category.type}</td>
                        <td>{cloth.quantity}</td>
                        <td className="action-btn">
                            <Link className="btn btn-primary" to={`/clothes/edit/${cloth.id}`}>Edit</Link>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>

        </div>
    )


}

export default ListCloth
