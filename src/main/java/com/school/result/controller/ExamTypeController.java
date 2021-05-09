package com.school.result.controller;

import com.school.result.pojo.ExamType;
import com.school.result.service.ExamTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/examType")
public class ExamTypeController {
    @Autowired
    private ExamTypeService examTypeService;

    @RequestMapping(value = "/selExamType", method = RequestMethod.POST)
    @ResponseBody
    public List<ExamType> selExamType(){
        return examTypeService.selExamType();
    }

}
