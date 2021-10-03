const email = document.getElementById('email');
const name1 = document.getElementById('name1');
const phone = document.getElementById('phone');
const password = document.getElementById('password');
const form = document.getElementById('form');

form.addEventListener('submit', (e) => {

    //prevent page from submitting
    e.preventDefault();

    checkInputs();

})

function checkInputs() {
    //get values from inputs
    const emailValue = email.value.trim();
    const name1Value = name1.value.trim();
    const phoneValue = phone.value.trim();
    const passwordValue = password.value.trim();
    let i = 0;

    if(emailValue === '') {
        //add error class
        setErrorFor(email, 'Email cannot be blank');
    } else if(!isEmail(emailValue)) {
        setErrorFor(email, 'Email is not vaild');
    } else {
        //add success class
        setSuccessFor(email);
        i++;
    }

    if(name1Value === '') {
        //add error class
        setErrorFor(name1, 'User name cannot be blank');
    } else {
        //add success class
        setSuccessFor(name1);
        i++;
    }
    if(phoneValue === '') {
        setErrorFor(phone, "Phone number cannot be blank");
    } else if (!isPhone(phoneValue)) {
        setErrorFor(phone, "Incorrect phone number format");
    } else {
        setSuccessFor(phone);
        i++;
    }
    if(passwordValue === '') {
        setErrorFor(password, "Password cannot be blank");
    } else if(!isPassword(passwordValue)) {
        setErrorFor(password, "At least one letter and number (6~8 Charas)");
    } else {
        setSuccessFor(password);
        i++;
    }

    if(i===4) {
        window.location.href = "index-page-1.html";
    } else {
        console.log(i);
    }

}

function setErrorFor(input, message) {
    const inputBox = input.parentElement;
    const small = inputBox.querySelector('small');

    //add error message into the small
    small.innerText = message;

    //add error class
    inputBox.className = 'input-box error';
}

function setSuccessFor(input) {
    const inputBox = input.parentElement;
    inputBox.className = 'input-box success';
}

function isEmail(email) {
    return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}

function isPassword(password) {
    return /^(?![^a-zA-Z]+$)(?!\D+$).{6,8}$/.test(password);
}

function isPhone(phone) {
    return /^(([0-9\ \+\_\-\\(\)])|(ext|x)){6,20}$/.test(phone);
}

