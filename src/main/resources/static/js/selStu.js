$(document).ready(function () {
    //html动态改变之后点击事件失效
    $(document).on("click", ".trDetails", function () {
        //获取当前行的stu详细信息对象
        var stu = $.parseJSON($(this).prev().text());
        console.log(stu);
        //显示详情弹框
        details();
        $(".detailTitle span").text(stu.studentName);
        $(".stu-details-table").find("tr:eq(0)").find("td:eq(1)").text(stu.studentNo);
        $(".stu-details-table").find("tr:eq(0)").find("td:eq(3)").text(stu.gradationName);
        $(".stu-details-table").find("tr:eq(1)").find("td:eq(1)").text(stu.gradeName);
        $(".stu-details-table").find("tr:eq(1)").find("td:eq(3)").text(stu.className);
        $(".stu-details-table").find("tr:eq(2)").find("td:eq(1)").text(stu.sex);
        $(".stu-details-table").find("tr:eq(2)").find("td:eq(3)").text(stu.phone);
        $(".stu-details-table").find("tr:eq(3)").find("td:eq(1)").text(stu.bornDate);
        $(".stu-details-table").find("tr:eq(3)").find("td:eq(3)").text(stu.idCard);
        $(".stu-details-table").find("tr:eq(4)").find("td:eq(1)").text(stu.email);
        $(".stu-details-table").find("tr:eq(4)").find("td:eq(3)").text(stu.loginPwd);
        $(".stu-details-table").find("tr:eq(5)").find("td:eq(1)").text(stu.stuStatus);
        $(".stu-details-table").find("tr:eq(5)").find("td:eq(3)").text(stu.address);
        $(".stu-details-table").find("tr:eq(6)").find("td:eq(1)").text(stu.beiZhu);
    });
    //删除
    $(document).on("click", ".trDel", function () {
        var bo = confirm("确定要删除吗？");
        if (bo == false) {
            return;
        }
        var stuNo = $(this).parents("tr").find("td:eq(1)").text();
        var boData=false;
        $.post("/student/delStu", "studentNo=" + stuNo, function (data) {
            if (data == true) {
                alert("删除成功！");
                loadPage();
                loadInfo();
            } else {
                alert("删除失败！");
            }
        })
    })
});

var currentPage = 1;//当前页码
var pageSize = 10;//每页显示的数量
var totalPage = 1;//总页数
var totalCount=0;

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
        totalCount=data;//总条数
        //alert("68行：totalCount="+totalCount+"，data="+data);
        totalPage = Math.ceil(data / 10);
        if (totalPage != 0) {
            $(".showPage").text(1 + "/" + totalPage);
        } else {
            $(".showPage").text(1 + "/" + 1);
            alert("没有此学员信息！");
        }
    })
}

//加载分页信息
function loadInfo() {
    //改变当前页码
    $(".showPage").text(currentPage + "/" + totalPage);
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
            $(".stu-sel-table").find("tr:eq(" + (i + 1) + ")").find("td:eq(10)").html('<div style="display: none;">' + JSON.stringify(this) + '</div><a href="javascript:void(0)" class="trDetails">详情</a>&nbsp;&nbsp;&nbsp;<a href="/student/chuanZhi/'+this.studentNo+'">修改</a>&nbsp;&nbsp;&nbsp;<a href="javascript:void(0)" class="trDel">删除</a>');
            no++;//行号
        })
    })
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
    currentPage = 1;
    if (checkPage() == true) {
        loadInfo();
    }
}

//尾页
function endPage() {
    currentPage = totalPage;
    if (checkPage() == true) {
        loadInfo();
    }
}

//判断分页情况
function checkPage() {
    if (totalPage == 0) {
        return;
    }
    if (currentPage < 1) {
        $(".pageTitle").text("已经是第一页了！");
        currentPage = 1;
        return false;//溢出就停止
    } else if (currentPage > totalPage) {
        $(".pageTitle").text("已经是最后一页了！");
        currentPage = totalPage;
        return false;//溢出就停止
    } else {
        $(".pageTitle").text("");
        return true;//正常情况
    }
}