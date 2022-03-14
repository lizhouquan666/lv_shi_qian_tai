// // let URL = "http://127.0.1:8080/";
// $(function () {
//     let loginName = sessionStorage.getItem("loginName");
//     if (loginName == null) {
//         window.location.href = "/html/login.html";
//     }
// });

function myAjax(url, data, type) {
    //判断当前用户是否已经登录

    let res = {};
    $.ajax({
        url: url,
        type: type == null ? 'post' : 'get',
        data: data,
        async: false,
        dataType: 'json',
        success: function (data) {
            console.log(data);
            res = data;
        }
    });
    return res;
}