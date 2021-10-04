
function checkUserLogin(){
    $.ajax({
        type: "POST",
        dataType: "json",
        url: '/checkUserLogin',
        contentType: "application/json",
        success: function (result) {
            if (result==="") {
                alert("Testing booking services require Login First!");
                window.location.href = "userLogin.html";
            }
        }
    });
}

function  checkManagerLogin(){
    $.ajax({
        type: "POST",
        dataType: "json",
        url: '/checkManagerLogin',
        contentType: "application/json",
        success: function (result) {
            if (result==="") {
                window.location.href = "403.html";
            }
        }
    });
}