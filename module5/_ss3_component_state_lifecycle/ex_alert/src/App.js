import logo from './logo.svg';
import './App.css';
import React from "react";
import Alert from "./components/Alert";

function App() {
    const text = "This is alert";
    return (
        <Alert text={text}/>

    );
}

export default App;
