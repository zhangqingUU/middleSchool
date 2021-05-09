package com.school.result.controller;

import com.school.result.pojo.Course;
import com.school.result.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/selCourseByGradeId", method = RequestMethod.POST)
    @ResponseBody
    public List<Course> selCourseByGradeId(int gradeId, int teacherId) {
        return courseService.selCourseByGradeId(gradeId,teacherId);
    }
}
