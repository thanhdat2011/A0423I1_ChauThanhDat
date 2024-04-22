import logo from './logo.svg';
import './App.css';
import React from "react";
import ListBook from "./components/ListBook";
import {BrowserRouter,Routes,Route} from "react-router-dom";
import AddBook from "./components/AddBook";
import {ToastContainer} from "react-toastify";
import EditBook from "./components/EditBook";
import ListRentBook from "./components/ListRentBook";


function App() {
    return (
        <>
        <BrowserRouter>
            <Routes>
                <Route path="/books" element={<ListBook/>}/>
                <Route path="/books/rent" element={<ListRentBook/>}/>
                <Route path="/books/add" element={<AddBook/>}/>
                <Route path="/books/edit/:id" element={<EditBook/>}/>
            </Routes>
        </BrowserRouter>
        <ToastContainer />
        </>
    );
}

export default App;
