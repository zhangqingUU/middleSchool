var bo = false;//验证表单元素是否正确！关键
/**
 * 检验学生姓名
 */
function checkStuName(here) {
    var stuName = $(here).val();
    if (stuName == "") {
        //alert("学生姓名不能为空！");
        titleFalse(here);
    } else {
        titleTrue(here);
    }
}

/**
 * 正确提示
 * @param here
 */
function titleTrue(here) {
    $(here).siblings(".boolean").text("✔").css("color", "green");
    bo = true;//验证通过！
}

/**
 * 提示错误
 * @param here
 */
function titleFalse(here) {
    $(here).siblings(".boolean").text("✘").css("color", "red");
    bo = false;
}

//验证身份证号码
function checkIdCard(here) {
    var idCard = $(here).val();
    bo = com_checkIdCard(idCard);//调用已经封装好的验证身份证号码的方法
    if (bo == false) {
        titleFalse(here);
    } else {
        titleTrue(here);
    }
}

//验证手机号码
function checkPhone(here) {
    var reg = /^1[34578]\d{9}$/;
    var phone = $(here).val();
    if (reg.test(phone) == false) {
        titleFalse(here);
    } else {
        titleTrue(here);
    }
}

//验证邮箱
function checkEmail(here) {
    var reg = /^[0-9a-zA-Z]+@[0-9a-zA-Z]+.[a-zA-Z]{3}$/;
    var email = $(here).val();
    if (reg.test(email) == false) {
        //alert("失败！");
        titleFalse(here);
    } else {
        //alert("成功！");
        titleTrue(here);
    }
}

//验证出生日期
function checkBornDate(here) {
    var bornDate = $(here).val();
    if (bornDate == "") {
        titleFalse(here);
    } else {
        titleTrue(here);
    }
}

//检查详细地址
function checkDetailAddress(here) {
    var province1 = $("#province1").find("option:selected").val();
    var city1 = $("#city1").find("option:selected").val();
    var district1 = $("#district1").find("option:selected").val();
    var address = $(here).val();

    if (province1 != "" && city1 != "" && district1 != "" && address != "") {
        titleTrue(here);
    }else{
        titleFalse(here);
    }
}

//检查班级信息
function checkClass(here) {
    var stuGradation = $(".stuGradation").find("option:selected").val();
    var stuGrade = $(".stuGrade").find("option:selected").val();
    var stuClass = $(".stuClass").find("option:selected").val();
    //alert(stuGradation+"---"+stuGrade+"---"+stuClass);
    if (stuGradation != "0" && stuGrade != "0" && stuClass != "0") {
        titleTrue(here);
    }else{
        titleFalse(here);
    }
}

//清空
function clearAll(){
    $(".stu-add").find("input[type='text']").val("");//普通文本框
    $(".stuBeiZhu").val("");//多行文本域
    $('.stu-add select').prop('selectedIndex', 0);//下拉框默认选中第一个
}


function selGrasList(){
    $.post("/gradation/selGraList","",function(data){
        $.each(data,function(i,v){
            var $option="<option value='"+v.gradationId+"'>"+v.gradationName+"</option>"
            $(".stuGradation").append($option);
        })
    },"json");
}

//加载第几届，层次的全部信息
function selGrasList(){
    $.post("/gradation/selGraList","",function(data){
        $.each(data,function(i,v){
            var $option="<option value='"+v.gradationId+"'>"+v.gradationName+"</option>"
            $(".stuGradation").append($option);
        })
    },"json");
}

//层次改变事件
function changeGraListByGId(here){
    $(".stuGrade").find("option:gt(0)").remove();
    $(".stuGrade").prop('selectedIndex', 0);
    $(".stuClass").prop('selectedIndex', 0);

    var id=$(here).val();
    $.post("/grade/selGraListByGId","gradationId="+id,function(data){
        $.each(data,function(i,v){
            var $option="<option value='"+v.gradeId+"'>"+v.gradeName+"</option>"
            $(".stuGrade").append($option);
        })
    },"json");
}


//年级改变事件
function changeGradeByGId(here){
    var gradeId=$(here).val();
    alert(gradeId);
    $("/class2/selClaListByGId","gradeId="+gradeId,function () {
        $.each(data,function(i,v){
            var $option="<option value='"+v.classId+"'>"+v.className+"</option>"
            $(".stuClass").append($option);
        })
    },"json")
}
