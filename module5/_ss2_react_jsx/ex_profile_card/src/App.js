import logo from './logo.svg';
import './App.css';
import React from "react";

function App() {
    return (
        <>
            <div className="container">
                <div className="card">
                    <div className="card--header" />
                    <img
                        className="avatar"
                        src="Shiba_Inu_coin_logo.png"
                        alt="avatar"
                    />
                    <div className="card--body">
                        <div>
                            <p className="text-header">My Dog</p>
                            <p className="text-sub">
                                Love me love my dog
                            </p>
                            <button className="btn third">FOLLOW</button>
                        </div>
                    </div>
                </div>
            </div>


            {/*<div className="card" style={{width: "18rem"}}>*/}
            {/*    <img src="Shiba_Inu_coin_logo.png" className="card-img-top" alt="..."/>*/}
            {/*        <div className="card-body">*/}
            {/*            <h5 className="card-title">My Dog</h5>*/}
            {/*            <p className="card-text">*/}
            {/*                His name is Shiba. My gf love him much.*/}
            {/*            </p>*/}
            {/*        </div>*/}
            {/*</div>*/}
        </>
    );
}

export default App;
