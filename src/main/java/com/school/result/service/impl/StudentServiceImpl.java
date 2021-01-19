package com.school.result.service.impl;

import com.school.result.mapper.StudentMapper;
import com.school.result.pojo.Student;
import com.school.result.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-18
 * @Description: 学生DAO实现类
 */
@Service
public class StudentServiceImpl implements StudentService {

    //调用mapper
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int addStu(Student student) {
        return studentMapper.addStu(student);
    }
}
