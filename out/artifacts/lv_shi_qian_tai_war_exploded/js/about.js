$(function () {
    findAbout();
});
function findAbout() {
    $.ajax({
        url: '/about',
        data: {},
        type: 'get',
        dataType: 'json',
        success: function (res) {
            console.log(res);
            setAboutData(res.aboutModel)

        }
    })
}
function setAboutData(data) {
    let html = '';
    html += '<div>\n' +
        '            <div>'+data.title+'</div>\n' +
        '            <div>'+data.titles+'</div>\n' +
        '            <div></div>\n' +
        '        </div>\n' +
        '        <div>\n' +
        '            <div><img src="'+data.img_href+'" height="315" width="418"/></div>\n' +
        '\n' +
        '            <div>\n' +
        '                <div>'+data.content+'\n' +
        '                </div>\n' +
        '            </div>\n' +
        '        </div>'
    $("#about").html(html);


}