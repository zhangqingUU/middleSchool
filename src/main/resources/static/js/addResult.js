/* 一级联动---显示--二级联动 */
function btnNext1() {
    $(".btn1").attr("disabled", "disabled");
    $(".chooseSubject-table").slideDown();
}
/* 二级联动---显示--三级联动 */
function btnNext2() {
    $(".generate").slideDown();
}

/* 超链接提示生成 */
function btnNext3() {
    var bo = confirm("您确定要生成吗？");
    if (bo == false) {
        return;
    }
    $(".generate").slideUp();
    $(".result-add-table").fadeIn(1000);
    $(".btn2").attr("disabled", "disabled");
    /* 规定表格可以编辑的部分 */
    var $trs = $(".result-add-table tr");
    $trs.each(function (i) {
        //i指的是下标
        $(this).find("td:gt(2)").attr("contenteditable", "true");
    });
}
