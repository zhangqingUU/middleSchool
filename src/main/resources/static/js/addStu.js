var bo=false;//验证表单元素是否正确！关键
/**
 * 检验学生姓名
 */
function checkStuName(here){
    var stuName=$(here).val();
    if(stuName==""){
        alert("学生姓名不能为空！");
        $(here).siblings(".boolean").text("✘").css("color","red");
        bo=false;
    }else{
        $(here).siblings(".boolean").text("✔").css("color","green");
        bo=true;//验证通过！
    }
}

//验证身份证号码
function checkIdCard(here){
    var idCard=$(here).val();
    bo=com_checkIdCard(idCard);//调用已经封装好的验证身份证号码的方法
}

//验证手机号码
function checkPhone(here){
    var reg = /^1[34578]\d{9}$/;
    var phone=$(here).val();
    if(reg.test(phone)==true){
        alert("成功！");
    }else{
        alert("失败！");
    }
}

//验证邮箱
function checkEmail(here){
    var reg=/^[0-9a-zA-Z]+@[0-9a-zA-Z]+.[a-zA-Z]{3}$/;
    var email=$(here).val();
    alert(email);
    if(reg.test(email)){
        alert("成功！");
    }else{
        alert("失败！");
    }
}