import React, { Component } from 'react';
import Hello from "./Hello";


// Thông báo trước khi ẩn component
class Delete extends Component {
    constructor(props) {
        super(props);
        this.state = {
            display: true
        };
    }

    delete = () => {
        this.setState({ display: false });
    };

    render() {
        // let message;
        // if (this.state.display) {
        //     message = <Hello />;
        //
        // }
        // return (
        //     <div style={{ textAlign: 'center' }}>
        //         {message}
        //         <button onClick={this.delete}>
        //             Delete the component
        //         </button>
        //     </div>
        // );
        if (this.state.display) {
            return (
                <div style={{ textAlign: 'center' }}>
                    <Hello />
                    <button onClick={this.delete}>
                        Delete the component
                    </button>
                </div>
            )
        }
    }
}

export default Delete;