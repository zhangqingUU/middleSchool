package com.school.result.controller;

import com.school.result.pojo.Student;
import com.school.result.service.StudentService;
import com.school.result.vo.Message;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(tags = "这是最牛团队编写的用户部分功能")
public class Student2Controller {
    @Autowired
    private StudentService studentService;


    @ApiOperation(value = "这里输入用户的id就能查看用户信息", notes = "输入id就可以了")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "studentNo", value = "这是学号", dataType = "int", example = "1000")
            }
    )
    @ApiResponses({
            @ApiResponse(code = 400, message = "请求参数缺失"),
            @ApiResponse(code = 401, message = "参数不正确"),
            @ApiResponse(code = 200, message = "成功")
    })
    @GetMapping("getStudentById/{studentNo}")
    public Message getStudentById(@PathVariable String studentNo) {
        System.out.println("studentNo=" + studentNo);
        Student stu = studentService.getStudentById(studentNo);
        System.out.println("stu=" + stu);
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("stu", stu);
        Message message = new Message();
        message.setCode("200");
        message.setMsg("成功");
        message.setData(hashMap);
        return message;
    }


}
