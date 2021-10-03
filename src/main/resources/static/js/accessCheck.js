
function checkUserLogin{
    $.ajax({
        type: "POST",
        dataType: "json",
        url: 'checkUserLogin',
        contentType: "application/json",
        success: function (result) {
            if (email.length > 0) {
            } else {
                window.location.href = "userLogin.html";
            }
        }
    });
}