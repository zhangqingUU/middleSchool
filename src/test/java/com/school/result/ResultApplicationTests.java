//package com.school.result;
//
//import com.school.result.pojo.Teacher;
//import com.school.result.service.TeacherService;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ResultApplicationTests {
//    @Autowired
//    private TeacherService teacherService;
//    @Test
//    public void contextLoads() {
//        Teacher teacher = teacherService.loginIn("15101174223", "123456");
//        if (teacher != null) {
//            System.out.println("登录成功！");
//        } else {
//            System.out.println("登录失败！");
//        }
//    }
//
//}
