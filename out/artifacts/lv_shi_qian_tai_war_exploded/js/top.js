// $(function () {
//     findTop();
// });
// function findTop() {
//     $.ajax({
//         url: '/home',
//         data: {},
//         type: 'get',
//         dataType: 'json',
//         success: function (res) {
//             console.log(res);
//             setTopData(res.serviceModelList);
//         }
//     })
// }
// function setTopData(data) {
//     let html = '';
//     for (let i = 0; i < data.length; i++) {
//         html += ' <div><img src="'+data[i].img_href+'" height="100" width="100" alt=""/>'+data[i].titles+'</div>';
//     }
//     $("#serviceModelList").html(html);
//
// }