import logo from './logo.svg';
import './App.css';
import React from "react";
import StudentList from "./components/StudentList";
import Header from "./components/Header";

function App() {
    return (
        <>
            <Header/>
            <StudentList/>
        </>
    );
}

export default App;
