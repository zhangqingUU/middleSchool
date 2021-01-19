package com.school.result.service;

import com.school.result.mapper.TeacherMapper;
import com.school.result.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @Description:教师业务逻辑层
* @Param:
* @Return:
*/
public interface TeacherService {
    Teacher loginIn(String phone,String loginPwd);
}
