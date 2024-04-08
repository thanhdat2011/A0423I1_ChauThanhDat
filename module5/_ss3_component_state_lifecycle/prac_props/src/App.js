import logo from './logo.svg';
import './App.css';
import React from "react";
import Welcome from "./component/Welcome";
import Hello from "./component/Hello";
import Sum from "./component/Sum";
import AppComponent from "./component/AppComponent";


function App() {

    return (
        <>
            {/*prop in component*/}
            <div className="App">
                <Welcome name="Admin" />
            </div>

            {/*function component*/}
            <Hello />
            <Sum first = {1} second = {2}/>

            {/*class component*/}
            <AppComponent/>
        </>
    );
}

export default App;
