package com.school.result.controller;

import com.school.result.pojo.Student;
import com.school.result.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping(value = "/addStu", method = RequestMethod.POST)
    public boolean addStu(Student student){
        if(studentService.addStu(student)>0){
            return true;
        }else{
            return false;
        }
    }

}
