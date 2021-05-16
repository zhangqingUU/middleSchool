package com.school.result.controller;

import com.school.result.pojo.Class2;
import com.school.result.pojo.Gradation;
import com.school.result.pojo.Grade;
import com.school.result.service.*;
import com.school.result.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-17
 * @Description:
 */
@Controller
public class HelloController {

    //调用service
    @Autowired
    private GradationService gradationService;
    @Autowired
    private GradeService gradeService;
    @Autowired
    private ClassService classService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        //后缀为.html的文件名
        return "login";
    }

    @GetMapping("/addResult")
    public String addResult() {
        return "addResult";
    }

    @GetMapping("/addStu")
    public String addStu(Model model) {
//        List<Gradation> list1 = gradationService.selGraList();//查询
//        model.addAttribute("grasList", list1);
//        List<Grade> list2 = gradeService.selGraListByGId(2);
//        model.addAttribute("gradeList", list2);
//        List<Class2> list3 = classService.getClaByGradeId(1);
//        model.addAttribute("classList", list3);
        return "addStu";
    }

    @GetMapping("/selResult")
    public String selResult() {
        return "selResult";
    }

    @GetMapping("/selStu")
    public String selStu(HttpServletRequest request) {
//        List<StudentVO> studentVOList=studentService.selStu();
//        request.setAttribute("stuList",studentVOList);
        /*mmap.put("listmap", lists);*/
        return "selStu";
    }

    @GetMapping("/updStu")
    public String updStu() {
        return "updStu";
    }

    @GetMapping("/updResult")
    public String updResult() {
        return "updResult";
    }

}
