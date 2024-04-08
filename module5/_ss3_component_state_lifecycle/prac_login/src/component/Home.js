import React, {Component} from "react";

class Home extends Component{
    render() {
        return (
            <>
                <div style={{textAlign : "center"}}>
                    <h1>Welcome</h1>
                    <button type="button" onClick={this.props.onLogOut}>Log out</button>
                </div>
            </>
        )
    }
}

export default Home