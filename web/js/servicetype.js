$(function () {
    findProduct();
});
function findProduct() {
    $.ajax({
        url: '/product',
        data: {},
        type: 'get',
        dataType: 'json',
        success: function (res) {
            console.log(res);
            setSboxData(res.sboxModels);
            //
        }
    })
}
function setSboxData(data) {
    let html='';
    for (let i = 0; i < data.length; i++) {
        html +='<div onclick="findTypeId('+data[i].service_id+')">'+data[i].name+'</div>'
    }
    $("#sboxModels").html(html);
}