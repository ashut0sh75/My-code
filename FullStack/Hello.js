// function printAll(...args) {
//     console.log(args );
//     console.log(typeof(args));
// }

// printAll(1, 2, 3, 4, 5, 6);

let Student = {
    rollNo: 10,
    Name: "Ashutosh",
    year: 4,
};

function printData({Name, rollNo}) {
    console.log("Name " + Name+" "+rollNo);
}

printData(Student);
alert("Hii");