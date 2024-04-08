import React, {useEffect, useState} from "react";

function CarSelection() {

    const [brandList, setBrandList] = useState([])
    const [colorList, setColorList] = useState([])
    const [car, setCar] = useState({brand : "", color : ""})

    useEffect(() => {
        setBrandList(["Mercedes S600", "Lamborghini", "Ferrari 1000", "BMW C500"])
        setColorList(["Black", "White", "Red", "Blue"])
    }, [])

    const selectBrand = (value) => (
        setCar({brand: value, color: car.color})
    )

    const selectColor = (value) => (
        setCar({brand: car.brand, color: value})
    )

    return (
        <>
            <h1>Select your car</h1>

            <div>
                <span>Select brand</span>
                <select onChange={(evt) => selectBrand(evt.target.value)}>
                    {brandList.map((brand, index) => (
                        <option key={brand} value={brand}>{brand}</option>
                    ))}
                </select>
            </div>

            <div>
                <span>Select color</span>
                <select onChange={(evt) => selectColor(evt.target.value)}>
                    {colorList.map((color) => (
                        <option key={color} value={color}>{color}</option>
                    ))}
                </select>
            </div>

            {car.brand && car.color && (
                <div>
                    <p>You selected - {car.brand} - {car.color}</p>
                </div>
            )}
        </>
    )
}

export default CarSelection