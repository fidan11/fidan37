function fillSelectedItemForUpdate(id, name, surname, age, scholarship) {
    document.getElementById("idUpdate").value = id;
    document.getElementById("nameUpdate").value = name;
    document.getElementById("surnameUpdate").value = surname;
    document.getElementById("ageUpdate").value = age;
    document.getElementById("scholarshipUpdate").value = scholarship;
}

function fillSelectedItemForDelete(id) {
    document.getElementById("idDelete").value = id;
    $("#idDelete").val(id);
}

// function $(id) {
//     document.getElementById(id);
// }
//
// foo({
//     id: 1,
//     name: "Sarkhan",
//     surname: "Rasullu"
// })