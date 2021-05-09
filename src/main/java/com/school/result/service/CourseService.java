package com.school.result.service;

import com.school.result.pojo.Course;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CourseService {

    List<Course> selCourseByGradeId(int gradeId, int teacherId);
}
