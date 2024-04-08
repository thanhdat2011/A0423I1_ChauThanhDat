import React, {Component} from "react";

class Calculator extends Component{
    constructor(props) {
        super(props);
        this.state = {
            num1 : '',
            num2 : '',
            result : ''
        }
    }

    calculating(operation) {
        switch (operation) {
            case '+':
                this.setState({
                    result : parseInt(this.state.num1) + parseInt(this.state.num2)
                })
                break;
            case '-':
                this.setState({
                    result : parseInt(this.state.num1) - parseInt(this.state.num2)
                })
                break;
            case '*':
                this.setState({
                    result : parseInt(this.state.num1) * parseInt(this.state.num2)
                })
                break;
            case '/':
                this.setState({
                    result : parseInt(this.state.num1) / parseInt(this.state.num2)
                })
                break;
        }
    }

    updateValue(inputName, value) {
        // const val = num.target.value;
        this.setState({
            [inputName] : value
        })
    }

    render() {
        return (
            <>
                <input id="num1" onChange={(number) => this.updateValue('num1', number.target.value)} type="text"/><br/>
                <input id="num2" onChange={(number) => this.updateValue('num2', number.target.value)} type="text"/><br/>
                <br/>
                <input type="submit" id="+" onClick={() => this.calculating('+')} value="+"/>
                <input type="submit" id="-" onClick={() => this.calculating('-')} value="-"/>
                <input type="submit" id="*" onClick={() => this.calculating('*')} value="*"/>
                <input type="submit" id="/" onClick={() => this.calculating('/')} value="/"/>
                <br/>

                Result: {this.state.result}
            </>
        )
    }
}
export default Calculator