import React from "react";

class AppComponent extends React.Component{
    greeting = "Hello Class Component";
    render() {
        return <Headline message = {this.greeting}/>
    }
}

class Headline  extends React.Component {
    render() {
        return <h1>{this.props.message}</h1>
    }
}

export default AppComponent