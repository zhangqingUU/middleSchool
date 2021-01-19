package com.school.result.mapper;

import com.school.result.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-18
 * @Description: StudentDao
 */
@Component
public interface StudentMapper {
    /**
     * @Description: 添加学生成绩
     * @Param:
     * @Return:
     */
    int addStu(@Param("student") Student student);
}
