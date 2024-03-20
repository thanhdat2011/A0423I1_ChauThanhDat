import logo from './logo.svg';
import './App.css';
import React from "react";

function App() {
    const fruits = [
        {id: 1, name: "Banana",origin: "Viet Nam" },
        {id: 2, name: "Apple",origin: "US" },
        {id: 3, name: "Mango",origin: "Thai" },
        {id: 4, name: "Grapes",origin: "australia" }
    ]

    const h1Style = {
        color : "red",
        textAlign: "center"
    }

    return (
        <>
            <h1 style={h1Style}>Store</h1>
            <h3 style={{color : "blue"}}>
                Today is {new Date().toLocaleDateString()}
            </h3>
            <table className="table table-hover">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Origin</th>
                </tr>
                </thead>
                <tbody>
                {fruits.map((fruit) => (
                    <tr key={fruit.id}>
                        <td>{fruit.name}</td>
                        <td>{fruit.origin}</td>
                    </tr>
                ))}
                </tbody>
            </table>

            <p>Browser's detail {navigator.userAgent}</p>
        </>
    );
}

export default App;
