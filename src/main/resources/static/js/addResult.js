/* 一级联动---显示--二级联动 */
function btnNext1() {
    var stuGradation = $(".stuGradation").val();
    var stuGrade = $(".stuGrade").val();
    var stuClass = $(".stuClass").val();
    var stuExamType = $(".stuExamType").val();

    console.log(stuGradation);
    console.log(stuGrade);
    console.log(stuClass);
    console.log(stuExamType);

    if (stuGradation != "0" && stuGrade != "0" && stuClass != "0" && stuExamType != "0") {
        $(".chooseSubject-table").slideDown();
        loadCourseByGradeId();
        $(".btn1").attr("disabled", "disabled");
    } else {
        alert("信息不完善，无法进行下一步！");
    }
}

/* 二级联动---显示--三级联动 */
function btnNext2() {
    var totalScore = $(".totalScore").val().trim();
    var toggle2 = $(".toggle").is(':checked');
    if (totalScore != "" && toggle2 != false && isNaN(totalScore) == false) {
        $(".generate").slideDown();
        $(".btn2").attr("disabled", "disabled");
        //禁用选择框和文本框
        $(".toggle").attr("readonly", "readonly");
        $(".totalScore").attr("readonly", "readonly");
    } else {
        alert("请完善信息！");
    }

}

/* 超链接提示生成 */
function btnNext3() {
    var bo = confirm("您确定要生成吗？");
    if (bo == false) {
        return;
    }
    //生成导航栏的标题，举例"语文"
    var $th='<th width="150">'+$(".toggle").val()+'</th>';
    $(".result-add-table").find("tr:eq(0)").find("th:eq(2)").after($th);
    //生成填写成绩的框
    var $td='<td width="150"></td>';
    $(".result-add-table").find("tr:gt(0)").find("td:eq(2)").after($td);
    $(".generate").slideUp();
    $(".result-add-table").fadeIn(1000);
    /* 规定表格可以编辑的部分 */
    var $trs = $(".result-add-table tr");
    $trs.each(function (i) {
        //i指的是下标
        $(this).find("td:gt(2)").attr("contenteditable", "true");
    });
}

//加载第几届，层次的全部信息
function selGrasList() {
    $.post("/gradation/selGraList", "teacherId=1", function (data) {
        $.each(data, function (i, v) {
            var $option = "<option value='" + v.gradationId + "'>" + v.gradationName + "</option>"
            $(".stuGradation").append($option);
        })
    }, "json");
}

//加载考试类型
function loadExamType() {
    $.post("/examType/selExamType", "", function (data) {
        $.each(data, function (i, v) {
            var $option = "<option value='" + v.examTypeId + "'>" + v.examTypeName + "</option>"
            $(".stuExamType").append($option);
        })
    }, "json");
}

//加载所属年级下面的科目
function loadCourseByGradeId() {

    var gradeId = $(".stuGrade").val();
    var json = {
        gradeId: gradeId,
        teacherId: 1
    };
    console.log(json);
    $.post("/course/selCourseByGradeId", json, function (data) {
        $.each(data, function (i, v) {
            var $td = '<td>' + v.courseName + ' <input type="radio" value="' + v.courseName + '" class="toggle">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" placeholder="总分" class="textBox textBox-totalScore totalScore"></td>';
            $(".btn-course").before($td);
        })
    }, "json");
}

//层次改变事件
function changeGraListByGId(here) {
    $(".stuGrade").find("option:gt(0)").remove();
    $(".stuGrade").prop('selectedIndex', 0);
    $(".stuClass").prop('selectedIndex', 0);
    var id = $(here).val();

    var json = {
        teacherId: 1,
        gradationId: id
    };
    $.post("/grade/selGraListByGId", json, function (data) {
        $.each(data, function (i, v) {
            var $option = "<option value='" + v.gradeId + "'>" + v.gradeName + "</option>"
            $(".stuGrade").append($option);
        })
    }, "json");
}


//年级改变事件
function changeGradeByGId(here) {
    $(".stuClass").find("option:gt(0)").remove();
    $(".stuClass").prop('selectedIndex', 0);
    var gradeId = $(here).val();
    var gradationId = $(".stuGradation").val();

    //alert(gradeId+"---"+gradationId);

    var json = {
        gradeId: gradeId,
        gradationId: gradationId,
        teacherId: 1
    };

    $.post("/class2/selClaListByGId", json, function (data) {
        //console.log(data);
        $.each(data, function (i, v) {
            var $option = "<option value='" + v.classId + "'>" + v.className + "</option>";
            $(".stuClass").append($option);
        })
    }, "json")
}

