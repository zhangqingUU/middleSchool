package com.school.result.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.school.result.pojo.Student;
import com.school.result.service.StudentService;
import com.school.result.vo.Message;
import com.school.result.vo.StudentVO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/student")
@RestController
@Api(tags = "学生Controller")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //    @ApiOperation(value = "这里输入用户的id就能查看用户信息", notes = "输入id就可以了")
//    @ApiImplicitParams(
//            {
//                    @ApiImplicitParam(name = "studentNo", value = "这是学号", dataType = "int", example = "1000")
//            }
//    )
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数缺失"),
            @ApiResponse(code = 401, message = "参数不正确"),
            @ApiResponse(code = 200, message = "成功")
    })

    @PostMapping("/selStu")
    public Message selStu(HttpServletRequest request) {
        //分页查询
        //System.out.println("进来了");
        String studentNo = request.getParameter("studentNo");
        String studentName = request.getParameter("studentName");
        String idCard = request.getParameter("idCard");
        String gradationId = request.getParameter("gradationId");
        String gradeId = request.getParameter("gradeId");
        String classId = request.getParameter("classId");
        int currentPage = Integer.valueOf(request.getParameter("currentPage"));
        int pageSize = Integer.valueOf(request.getParameter("pageSize"));

//        System.out.println("currentPage："+currentPage);
//        System.out.println("pageSize："+pageSize);

        List<StudentVO> studentVOList = studentService.selStu(currentPage, pageSize, studentNo, studentName, idCard, gradationId, gradeId, classId);
        studentVOList.forEach(System.out::println);
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("stu", studentVOList);
        Message message = new Message();
        message.setCode("200");
        message.setMsg("成功");
        message.setData(hashMap);
        return message;
    }


    @ResponseBody
    @RequestMapping(value = "/getCount", method = RequestMethod.POST)
    public int getCount(HttpServletRequest request){
        //模糊查询总条数
        String studentNo = request.getParameter("studentNo");
        String studentName = request.getParameter("studentName");
        String idCard = request.getParameter("idCard");
        String gradationId = request.getParameter("gradationId");
        String gradeId = request.getParameter("gradeId");
        String classId = request.getParameter("classId");
        return studentService.getCount(studentNo, studentName, idCard, gradationId, gradeId, classId);
    }

    @ResponseBody
    @RequestMapping(value = "/addStu", method = RequestMethod.POST)
    public boolean addStu(Student student) {
        //添加学生
        if (studentService.addStu(student) > 0) {
            return true;
        } else {
            return false;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/delStu", method = RequestMethod.POST)
    public boolean delStu(int studentNo) {
        //删除学生
        if (studentService.delStu(studentNo) > 0) {
            return true;
        } else {
            return false;
        }
    }
}
