var i = 1;
function lunBo() {
    i++;
    if (i > 3) {
        i = 1;
    }
    $("body").css({
        "transition-duration": "3s",
        "background-size": "cover",
        "background-repeat": "no-repeat",
        "background-image": "url(/img/login_bg" + i + ".jpg)"
    });
}

setInterval("lunBo()", 5000);

//以上是背景轮播图代码的结束

/**
 * 登录按钮
 */
function btnLogin() {
    var phone = $("#inputPhone").val();
    var pwd = $("#inputPassword").val();

    if (phone == "") {
        alert("手机号不能为空！");
        return;
    }
    if (pwd == "") {
        alert("密码不能为空！");
        return;
    }

    var json = {
        phone: phone,
        loginPwd: pwd
    };

    $.post("/teacher/loginIn", json,function(data){
        console.log(data);
        //alert("成功！");
       /* console.log(data);
        console.log(data.teacherName);
        if(data.teacherName==""||data.teacherName=="null"){
            alert("登录失败！");
        }else{
            alert("登录成功！");
        }*/
    },"json");

}

/**
 * 注册按钮
 */
function btnRegister() {
    location.href = "/index";
}