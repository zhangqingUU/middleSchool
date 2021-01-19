package com.school.result.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private int teacherId;//教师编号
    private String teacherName;//教师姓名
    private String loginPwd;//登录密码
    private String sex;//教师姓名
    private String phone;//手机号
    private String email;//邮箱
    private int courseId;//课程编号，一个老师只能教授一门课程
    private int posterId;//岗位编号


}
