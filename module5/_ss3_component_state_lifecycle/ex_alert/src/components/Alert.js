import React, {Component} from "react";

class Alert extends Component{
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <>
                <div className="alert alert-primary" role="alert">
                    <a href="https://www.facebook.com/" className="alert-link">{this.props.text}</a>
                </div>
            </>
        )
    }
}

export default Alert