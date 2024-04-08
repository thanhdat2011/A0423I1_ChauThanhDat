import React from "react";

class Car extends React.Component{
    constructor(props) {
        super(props);
        this.state = {
            brand : "Ferrari",
            model : "modern",
            color:"red",
            year: 1999,
            speed : 50}
    }

    changeColor (){
        const colors = ["red", "blue", "green", "yellow", "orange", "purple"];
        const randomColor = colors[Math.floor(Math.random() * colors.length)];
        this.setState({ color: randomColor });
    }
    upSpeed(){
        this.setState({speed : this.state.speed + 1})
    }
    downSpeed(){
        this.setState({speed : this.state.speed - 1})
    }

    // lop co san
    componentDidMount() {
        setTimeout(() => {
            this.setState({ color: 'pink' });
        }, 5000);
    }

    // xu li su kien
     actionLink() {
        function handleClick(e) {
            e.preventDefault();
            alert('You had clicked a Link.');
        }
        return (
            <a href="https://www.facebook.com/" onClick={handleClick}>
                Click_Me
            </a>
        );
    }


    render() {
        return (
            <>
                {/*LIFE CYCLE*/}
                <div
                    style={{
                        backgroundColor: this.state.color,
                        paddingTop: 20,
                        width: 400,
                        height: 80,
                        margin: 'auto'
                    }}
                />

                {/*STATE EVENT*/}
                <h1>My {this.state.brand}</h1>
                <p> It is a {this.state.color}, {this.state.model} from {this.state.year}.</p>
                <p>Speed is {this.state.speed} now</p>
                <button type="button" onClick={() => this.changeColor()}>Change Color</button>
                <button type="button" onClick={() => this.upSpeed()}>Speed UP</button>
                <button type="button" onClick={() => this.downSpeed()}>Speed DOWN</button>

                {/*Xu li su kien nay*/}
                <p>{this.actionLink()}</p>

            </>
        )
    }
}

export default Car;