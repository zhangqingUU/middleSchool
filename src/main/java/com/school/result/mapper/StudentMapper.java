package com.school.result.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.school.result.pojo.Student;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-18
 * @Description: StudentDao
 */
public interface StudentMapper extends BaseMapper<Student> {
    /**
     * @Description: 添加学生信息
     * @Param:
     * @Return:
     */
    int addStu(@Param("student") Student student);

}
