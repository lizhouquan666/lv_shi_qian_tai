//根据当前id取查询三条数据，
$(function () {
    let id = sessionStorage.getItem("id");
    findById(id);
});

function findById(id) {

    $.ajax({
        url: '/findById',
        data: {id: id},
        type: 'get',
        dataType: 'json',
        success: function (res) {
            console.log(res);
            if (res.data.length == 1) {
                setProductData(data[0]);
                setLastData(null);
                setNextData(null);
            }
            if (res.data.length == 3) {
                setLastData(data[0]);
                setProductData(data[1]);
                setNextData(data[2]);
            }
            if (res.data.length == 2) {
                if (res.data[0].id == id) {
                    setLastData(null);
                    setProductData(data[1]);
                    setNextData(data[2]);
                } else {
                    setLastData(data[0]);
                    setProductData(data[1]);
                    setNextData(null);
                }
            }
        }
    })
}

function setProductData(data) {
    let html = '<div>' + data.name + '</div>';
    $("#middle").html(html);
}

function setLastData(data) {
    let html = '<div onclick="findById(' + data.id + ')"><img src=""/> 上一个' + data == null ? "无" : data.name + '</div>';
    $("#last").html(html);
}

function setNextData(data) {
    let html = '<div onclick="findById(' + data.id + ')"><img src=""/> 下一个' + data == null ? "无" : data.name + '</div>';
    $("#next").html(html);
}