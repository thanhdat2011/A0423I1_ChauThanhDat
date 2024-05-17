import logo from './logo.svg';
import './App.css';
import React from "react";
import ListCloth from "./components/ListCloth";
import {BrowserRouter,Routes,Route} from "react-router-dom";
import {ToastContainer} from "react-toastify";
import EditCloth from "./components/EditCloth";


function App() {
    return (
        <>
        <BrowserRouter>
            <Routes>
                <Route path="/clothes" element={<ListCloth/>}/>
                <Route path="/clothes/edit/:id" element={<EditCloth/>}/>
            </Routes>
        </BrowserRouter>
        <ToastContainer/>
        </>
    );
}

export default App;
