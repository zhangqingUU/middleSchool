package com.school.result.mapper;

import com.school.result.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-16
 * @Description: 教师DAO
 */
@Component
public interface TeacherMapper {
    /**
    * @Description:登录
    * @Param:手机号和密码
    * @Return:
    */
    Teacher getInfo(@Param("phone") String phone, @Param("loginPwd") String pwd);
}
