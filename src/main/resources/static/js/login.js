//以下是背景轮播图代码的开始
var i = 1;

function lunBo() {
    i++;
    if (i > 3) {
        i = 1;
    }
    $("body").css({
        "background-image": "url(img/login_bg" + i + ".jpg)",
        "transition": "5s"
    });
}

setInterval("lunBo()", 10000);

//以上是背景轮播图代码的结束

/**
 * 登录按钮
 */
function btnLogin() {
    var phone = $("#inputPhone").val();
    var pwd = $("#inputPassword").val();
    //alert(phone+","+pwd);

    var json = {
        phone: phone,
        loginPwd: pwd
    };

    $.post("/teacher/loginIn", json, function (data) {
        console.log(data);
        if (data !=="") {
            location.href="/index";
        } else {
            alert("登录失败！");
        }
    })

}