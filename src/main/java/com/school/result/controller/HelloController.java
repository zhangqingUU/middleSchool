package com.school.result.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-17
 * @Description:
 */
@Controller
public class HelloController {
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
    public String addStu() {
        return "addStu";
    }

    @GetMapping("/selResult")
    public String selResult() {
        return "selResult";
    }

    @GetMapping("/selStu")
    public String selStu() {
        return "selStu";
    }

     @GetMapping("/updStu")
    public String updStu() {
        return "updStu";
    }
}
