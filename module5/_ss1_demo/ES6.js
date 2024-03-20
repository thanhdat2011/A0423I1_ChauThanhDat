// 1. Tạo một mảng mới chứa các số lớn hơn 5 từ mảng ban đầu.
let arr = [2,-7,9,-4,6,0,1,8];
let res1 = arr.filter((num) => num > 5)
console.log("1. " + res1)

// 2. Sử dụng arrow function và reduce để tính tổng các phần tử trong mảng.
let sum = arr.reduce((previousValue, currentValue) => previousValue + currentValue);
console.log("2. " + sum)

// 3. Kiểm tra 1 mảng có chứa số V hay không nếu có trả về V không thì trả về "không tìm thấy".
let res3 = (arr, V) => arr.includes(V) ? V: "Không tìm thấy"
console.log("3. " + res3(arr, 3))

// 4. Kiểm tra 1 mảng tất cả các phần tử trong mảng đó có lớn hơn 0 hay không?.
let res4 = (arr) => arr.every(element => element > 0);
console.log("4. " + res4(arr))

// 5. Tìm phần tử đầu tiên trong mảng lớn hơn 3.
let res5 = arr.find(element => element > 3)
console.log("5. " + res5)

// 6. Sử dụng destructuring với rest parameter để trích xuất phần tử đầu tiên vào biến "first"
// và các phần tử còn lại vào một mảng mới "rest".
let [first,...rest] = arr
console.log("6. ")
console.log("First : " + first)
console.log("Rest : " + rest)

// 7. Sử dụng destructuring để trích xuất các giá trị "name" và "age"
// từ một mảng chứa các đối tượng "person".
let persons = [
    { name: "Dat", age: 23, address: "Da nang" },
    { name: "Truong", age: 20, address: "Quang Nam" },
    { name: "Quoc", age: 21, address: "Hoi An" }
];

// Trích xuất giá trị "name" và "age" từ mỗi đối tượng trong mảng
let extractedData = persons.map(({ name, age }) => ({ name, age}));
console.log("7. " + extractedData);


// 8. Sử dụng Rest parameter và Spread operator để tạo một hàm nhận
// vào danh sách các số và trả về tổng của chúng.
let sumArray = (...numbers) => {
    return numbers.reduce((previous, current) => previous + current, 0);
};

// Sử dụng hàm tinhTong
let res8 = sumArray(1, 2, 3, 4, 5);
console.log("8. ", res8);


// 9. Sử dụng Rest parameter để nhận vào một danh sách tên và
// trả về chuỗi định dạng "Welcome, [tên1], [tên2], [tên3], ..." cho tất cả các tên.
let welcomeMessage = (...names) => {
    if (names.length === 0) {
        return "Welcome!";
    } else {
        let formattedNames = names.join(', ');
        return `Welcome, ${formattedNames}!`;
    }
};

console.log("9. ")
console.log(welcomeMessage("Dat", "Quoc", "Truong")); // Output: Welcome, Alice, Bob, Charlie!
console.log(welcomeMessage("Dat")); // Output: Welcome, David!
console.log(welcomeMessage()); // Output: Welcome!


// 10. Tạo một đối tượng "book" với thuộc tính "title", "author" và "pages"
// bằng cách sử dụng Enhanced object literals.
// Đối tượng "book" cũng có phương thức "displayInfo" để in ra thông tin về sách.
const book = {
    title: "Hoc lap trinh nhanh giau lam.",
    author: "Thanh Dat",
    pages: 100,
    displayInfo() {
        console.log(`Title: ${this.title}\nAuthor: ${this.author}\nPages: ${this.pages}`);
    }
};

console.log("10 .")
book.displayInfo();



