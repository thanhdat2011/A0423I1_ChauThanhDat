import React from "react";

// FUNCTION COMPONENT

// const numbers = [1,2,3,4,5];
// const Sum = () => (<p>{sumFunction()}</p>);
// const sumFunction = () => (numbers.reduce((previous, current) => previous + current));

const Sum = (props) => (<p>Sum : {props.first+ props.second}</p>);


export default Sum