package com.school.result.controller;

import com.school.result.pojo.Teacher;
import com.school.result.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-16
 * @Description:
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    //调用业务逻辑层
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    @ResponseBody
    public Teacher loginIn(String phone, String loginPwd) {

        return teacherService.loginIn(phone, loginPwd);
    }


}
