package com.school.result.service.impl;

import com.school.result.mapper.CourseMapper;
import com.school.result.pojo.Course;
import com.school.result.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> selCourseByGradeId(int gradeId, int teacherId) {
        return courseMapper.selCourseByGradeId(gradeId,teacherId);
    }
}
