$(function () {
    findTop();
});
function findTop() {
    $.ajax({
        url: '/home',
        data: {},
        type: 'get',
        dataType: 'json',
        success: function (res) {
            console.log(res);
            setTopData(res.navModels);
            setLog(res.logModels);
            setTopTitleData(res.topModel);
            setHomeServiceData(res.serviceModelList);
            setPowerData(res.powerModels);
            setCustomerData(res.customerModels);
            setTeamData(res.teamModels);
            setNewData(res.newModels);
            setFootData(res.footModels);


        }
    })
}

function setHomeServiceData(data) {
        let html = '';
    for (let i = 0; i < data.length; i++) {
        html += ' <div onclick="goToService('+data[i].id+')"><img src="'+data[i].img_href+'" height="100" width="100" alt=""/>'+data[i].titles+'</div>';
    }
    $("#serviceModelList").html(html);
    // findTypeId(0);

}
function goToService(service_id) {
    sessionStorage.setItem("service_id", service_id);

    window.location.href = '/html/service-index.html';
}
// function findTypeId(service_id) {
//     sessionStorage.setItem("service_id", service_id);
//     data = {page: page, limit: limit, service_id: service_id};
//     $.ajax({
//         url: '/findById',
//         data: data,
//         type: 'get',
//         dataType: 'json',
//         success: function (res) {
//             console.log(res);
//             setProductData(res.data);
//         }
//     })
// }
function setTopData(data) {
    let htmlL = '';
    let htmlR = '';
    for (let i = 0; i < data.length - 3; i++) {
        // htmlL += ' <div onclick="goto('+data[i].href+')">'+data[i].titles+'</div>';
        htmlL += ' <div onclick="window.location.href=\''+data[i].img_href+'\'">'+data[i].titles+'</div>';
    }
    for (let i = 3; i < data.length; i++) {
        htmlR += ' <div onclick="window.location.href=\''+data[i].img_href+'\'">'+data[i].titles+'</div>';
    }

    $("#navModelsR").html(htmlR);
    $("#navModelsL").html(htmlL);


}
function setLog(data) {
    let htmlLog = '';
    htmlLog +='<div><img src="'+data.img_href+'"/></div>\n' +
        '            <div>\n' +
        '                <div>'+data.name+'</div>\n' +
        '                <div>'+data.title+'</div>\n' +
        '            </div>'
    $("#log").html(htmlLog);
}
//设置home页面的标题与副标题
function setTopTitleData(data) {
    let htmlTitle= '';
    htmlTitle +='<div>'+data.title+'</div>\n' +
        '<div>'+data.title1+'</div>'
    $("#topModel").html(htmlTitle);

}
//实力
function setPowerData(data) {
    let htmlPower='';
    for (let i = 0; i <data.length ; i++) {
        htmlPower +='<div>\n' +
            '                    <div>'+data[i].numb+'</div>\n' +
            '                    <div>'+data[i].title+'</div>\n' +
            '                </div>'
    }
   $("#powerModels").html(htmlPower);

}
//客户
function setCustomerData(data) {
    let htmlCust = '';
    for (let i = 0; i <data.length ; i++) {
        htmlCust += '<div><img src="'+data[i].img_href+'" height="100" width="100" alt=""/></div>'
    }
    $("#customerModels").html(htmlCust);
}
//团队
function setTeamData(data) {
    let htmlTeam = '';
    for (let i = 0; i < data.length; i++) {
        htmlTeam += '<div>\n' +
            '                    <div><img src="'+data[i].img_href+'" height="180" width="180" alt=""/></div>\n' +
            '                    <div>'+data[i].name+'</div>\n' +
            '                    <div>'+data[i].peo+'</div>\n' +
            '                    <div>'+data[i].content+'</div>\n' +
            '                </div>'

    }
    $("#teamModels").html(htmlTeam);

}
//新闻
function setNewData(data) {
    let htmlNew ='';
    for (let i = 0; i < data.length; i++) {
        htmlNew +='<div>\n' +
            '                    <div><img src="'+data[i].img_href+'" height="200" width="340" alt=""/></div>\n' +
            '                    <div>'+data[i].title+' </div>\n' +
            '                    <div>'+data[i].date+'</div>\n' +
            '                    <div>'+data[i].content+'</div>\n' +
            '                </div>'
    }
    $("#newModels").html(htmlNew);
}
//foot
function setFootData(data) {
    let htmlFoot='';
    htmlFoot +='<div>\n' +
        '            <div>'+data.title+'</div>\n' +
        '            <div>\n' +
        '                <div>'+data.phone+'</div>\n' +
        '                <div>'+data.chuanzhen+'</div>\n' +
        '                <div>'+data.sj+'</div>\n' +
        '                <div>'+data.numb+'</div>\n' +
        '                <div>'+data.email+'</div>\n' +
        '                <div>'+data.address+'</div>\n' +
        '            </div>\n' +
        '        </div>'
    $("#footModels").html(htmlFoot);
}