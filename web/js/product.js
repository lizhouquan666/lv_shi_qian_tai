let page = 1;
let limit = 3;
let data;
let id = 1;
layui.use(['laypage', 'layer'], function () {
    var laypage = layui.laypage
        , layer = layui.layer;
    laypage.render({
        elem: 'page'
        , count: myAjax("/product", data, 'get').count
        , layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
        , jump: function (obj) {
            console.log(obj);
            page = obj.curr;
            limit = obj.limit;
            id = sessionStorage.getItem("id");
            findProductTypeId(id);
        }
    });
});
function findProductTypeId(id) {
    sessionStorage.setItem("id", id);
    data = {page: page, limit: limit, id: id};
    $.ajax({
        url: '/findProductById',
        data: data,
        type: 'get',
        dataType: 'json',
        success: function (res) {
            console.log(res);
            setProductsData(res.data);
        }
    })
}
function setProductsData(data) {
    let html ='';
    data.forEach(function (elem) {
        html += '<div>\n' +
            '            <div><img src="'+elem.img_href+'" height="350" width="350" alt=""/></div>\n' +
            '            <div>\n' +
            '                <div><h2>'+elem.name+'</h2></div>\n' +
            '                <div></div>\n' +
            '                <div>市场价：'+elem.price+'</div>\n' +
            '                <div>优惠价 '+elem.normal_price+'</div>\n' +
            '            </div>\n' +
            '        </div>\n' +
            '        <div>'+elem.content+'</div>\n' +
            '        <div id="page"></div>';
    });
    $("#products").html(html);
}