$(document).ready(function () {

});

var currentPage = 1;//当前页码
var pageSize = 10;//每页显示的数量
var totalPage = 1;//总页数

//加载总页码
function loadPage() {
    currentPage=1;
    //获取模糊查询的内容
    var json = {
        studentNo: $(".likeStuNo").val(),
        studentName: $(".likeStuName").val(),
        idCard: $(".likeStuIdCard").val(),
        gradationId: $(".stuGradation").val(),
        gradeId: $(".stuGrade").val(),
        classId: $(".stuClass").val()
    };
    $.post("/student/getCount", json, function (data) {
        totalPage = Math.ceil(data / 10);
        if(totalPage!=0){
            $(".showPage").text(1+"/"+totalPage);
        }else{
            $(".showPage").text(1+"/"+1);
            alert("没有此学员信息！");
        }
    })
}

//加载分页信息
function loadInfo() {
    //改变当前页码
    $(".showPage").text(currentPage+"/"+totalPage);
    //清空
    $(".stu-sel-table tr").find("td").text("");
    //获取模糊查询的内容
    var json = {
        currentPage: currentPage,
        pageSize: pageSize,
        studentNo: $(".likeStuNo").val(),
        studentName: $(".likeStuName").val(),
        idCard: $(".likeStuIdCard").val(),
        gradationId: $(".stuGradation").val(),
        gradeId: $(".stuGrade").val(),
        classId: $(".stuClass").val()
    };

    //console.log(json);

    $.post("/student/selStu", json, function (data) {
        var stu = data.data.stu;//获取里面的学生信息
        //console.log(data.data.stu);
        var no = 1;
        $(stu).each(function (i, v) {
            $(".stu-sel-table").find("tr:eq(" + (i + 1) + ")").find("td:eq(0)").text((currentPage - 1) * pageSize + no);
            $(".stu-sel-table").find("tr:eq(" + (i + 1) + ")").find("td:eq(1)").text(this.studentNo);
            $(".stu-sel-table").find("tr:eq(" + (i + 1) + ")").find("td:eq(2)").text(this.studentName);
            $(".stu-sel-table").find("tr:eq(" + (i + 1) + ")").find("td:eq(3)").text(this.gradationName);
            $(".stu-sel-table").find("tr:eq(" + (i + 1) + ")").find("td:eq(4)").text(this.gradeName);
            $(".stu-sel-table").find("tr:eq(" + (i + 1) + ")").find("td:eq(5)").text(this.className);
            $(".stu-sel-table").find("tr:eq(" + (i + 1) + ")").find("td:eq(6)").text(this.sex);
            $(".stu-sel-table").find("tr:eq(" + (i + 1) + ")").find("td:eq(7)").text(this.phone);
            $(".stu-sel-table").find("tr:eq(" + (i + 1) + ")").find("td:eq(8)").text(this.bornDate);
            $(".stu-sel-table").find("tr:eq(" + (i + 1) + ")").find("td:eq(9)").text(this.idCard);
            //$(".stu-sel-table").find("tr:eq(" + (i + 1) + ")").find("td:eq(10)").html($(".divSpan").html());
            $(".stu-sel-table").find("tr:eq(" + (i + 1) + ")").find("td:eq(10)").html('<a href="javascript:void(0)" onclick="details(this)">详情</a>&nbsp;&nbsp;&nbsp;<a href="updStu">修改</a>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)">删除</a>');
            no++;//行号
        })
    })
}

//查看学生的详情
function details($this){
    console.log($this);
}

//下一页
function nextPage() {
    currentPage++;
    if (checkPage() == true) {
        loadInfo();
    }
}
//上一页
function prevPage() {
    currentPage--;
    if (checkPage() == true) {
        loadInfo();
    }
}
//首页
function startPage() {
    currentPage=1;
    if (checkPage() == true) {
        loadInfo();
    }
}
//尾页
function endPage() {
    currentPage=totalPage;
    if (checkPage() == true) {
        loadInfo();
    }
}

//判断分页情况
function checkPage() {
    if(totalPage==0){
        return;
    }
    if (currentPage < 1) {
        $(".pageTitle").text("已经是第一页了！");
        currentPage=1;
        return false;//溢出就停止
    } else if (currentPage > totalPage) {
        $(".pageTitle").text("已经是最后一页了！");
        currentPage=totalPage;
        return false;//溢出就停止
    } else {
        $(".pageTitle").text("");
        return true;//正常情况
    }
}