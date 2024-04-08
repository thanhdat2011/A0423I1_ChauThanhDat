import React from "react";
import Home from "./Home";

class AddLoginComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            isLoggedIn : false
        }
    }
    handleLogin() {
        this.setState({
            isLoggedIn : true
        });
    }
    handleLogOut() {
        this.setState({
            isLoggedIn : false
        })
    }


    render() {
        if (this.state.isLoggedIn) {
            return (
                <Home onLogOut={() => this.handleLogOut()}/>
            )
        }
        return (
            <>
                <div style={{textAlign : "center"}}>
                    <h1>Please Login</h1>
                    <button type="button" onClick={() =>this.handleLogin()}>Login</button>
                </div>
            </>
        )
    }
}

export default AddLoginComponent