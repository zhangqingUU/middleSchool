package com.school.result.controller;

import com.school.result.pojo.Gradation;
import com.school.result.service.GradationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-19
 * @Description:
 */
@Controller
@RequestMapping("/gradation")
public class GradationController {

    @Autowired
    private GradationService gradationService;

    @RequestMapping(value = "/selGraList", method = RequestMethod.POST)
    @ResponseBody
    public List<Gradation> selGraList(int teacherId){
        return gradationService.selGraList(teacherId);
    }


}
