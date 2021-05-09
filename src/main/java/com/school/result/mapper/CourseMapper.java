package com.school.result.mapper;

import com.school.result.pojo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    List<Course> selCourseByGradeId(@Param("gradeId") int gradeId, @Param("teacherId") int teacherId);
}
