import React from "react";

// Function component

const names = ['Batman', 'Iron Man', 'Ant Man', 'Captain America'];
const Hello = () => (names.map(helloFunction))

const helloFunction = (name) => (<p>Hello, {name}</p>)

export default Hello
