/* 一级联动---显示--二级联动 */
function btnNext1() {
  $(".btn1").attr("disabled", "disabled");
  $(".chooseSubject-table,.generate").slideDown();
}
/* 二级联动---显示--三级联动 */
function btnNext2() {
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
