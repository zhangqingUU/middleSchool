package com.school.result.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-18
 * @Description: 学生实体类，14个字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int studentNo;//学号
    private String studentName;//学生姓名
    private String loginPwd;//密码
    private String sex;//行呗
    private String phone;//手机号
    private String address;//地址
    private Timestamp bornDate;//出生日期
    private String email;//邮箱
    private String idCard;//身份证号
    private int gradationId;//层次，第几届
    private int gradeId;//年级编号
    private int classId;//班级编号
    private String studyStatus;//学习状态：在读（默认）、已毕业
    private String beiZhu;//备注
}
