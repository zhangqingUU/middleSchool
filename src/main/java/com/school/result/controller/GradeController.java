package com.school.result.controller;

import com.school.result.pojo.Gradation;
import com.school.result.pojo.Grade;
import com.school.result.service.GradationService;
import com.school.result.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @RequestMapping(value = "/selGraListByGId", method = RequestMethod.POST)
    @ResponseBody
    public List<Grade> selGraListByGId(int gradationId,int teacherId){
        return gradeService.selGraListByGId(gradationId, teacherId);
    }
}
