let page;
let limit=10;
let service_id=1;
let data;
//myAjax("/back/productId/count", data拿不到值
// $(function () {
// //     // let data = {page: 1, limit: 8, cuisineId: 0};
//     findTypeId(sessionStorage.getItem("service_id"));

// });

layui.use(['laypage', 'layer','jquery','table'], function () {
    var laypage = layui.laypage;
    laypage.render({
        elem: 'page'
        , count: myAjax("/back/productId/count", data, 'get').count
        , layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
        ,limit:3
        , jump: function (obj) {
            console.log(obj);
            page = obj.curr;
            limit = 20;
            console.log(limit);

            // id = sessionStorage.getItem("service_id");
            findTypeId(sessionStorage.getItem("service_id"));
        }
    });
});
// function page(data) {
//
// }
//home页面给了菜系id，上面菜系id转换成当前表的菜系id，而如果你要查询商品id则需要拿到当前点击商品的id,通过当前商品在findall内查询
function findTypeId(service_id) {

    sessionStorage.setItem("service_id", service_id);
    let data = {page: page, limit: limit, service_id: service_id};
    $.ajax({
        url: '/findById',
        data: data,
        type: 'get',
        dataType: 'json',
        success: function (res) {
            console.log(res);
            setProductData(res.data);
        }
    })
    // page(data);
}
function setProductData(data) {
    let html ='';
    data.forEach(function (elem) {
        html += '<div>\n' +
            '                <div onclick="goToProductPage('+elem.id+')"><img src="'+elem.img_href+'" height="350" width="350" alt=""/></div>\n' +
            '                <div>'+elem.name+'</div>\n' +
            '            </div>';
    });
    $("#productList").html(html);
}
function goToProductPage(id) {
    sessionStorage.setItem("id", id);
    window.location.href = '/html/product-index.html';
}