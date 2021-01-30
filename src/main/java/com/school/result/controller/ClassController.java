package com.school.result.controller;

import com.school.result.pojo.Class2;
import com.school.result.pojo.Gradation;
import com.school.result.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/class2")
public class ClassController {
    @Autowired
    private ClassService classService;

    @RequestMapping(value = "/selClaListByGId", method = RequestMethod.POST)
    @ResponseBody
    public List<Class2> setClaByGradeId(int gradationId,int gradeId,int teacherId){
        return classService.setClaByGradeId(gradationId,gradeId,teacherId);
    }
}
