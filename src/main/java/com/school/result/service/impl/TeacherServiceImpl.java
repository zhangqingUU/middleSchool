package com.school.result.service.impl;

import com.school.result.mapper.TeacherMapper;
import com.school.result.pojo.Teacher;
import com.school.result.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-16
 * @Description: 教师DAO
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher loginIn(String phone, String pwd) {
        return teacherMapper.getInfo(phone, pwd);
    }
}
