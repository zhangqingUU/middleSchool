package com.school.result.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @Author: 张晴
 * @CreateTime: 2021-01-18
 * @Description: 学生实体类，14个字段
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements  Serializable{
    @TableId(value = "studentNo")
    private int studentNo;//学号
    @TableField(value = "studentName")
    private String studentName;//学生姓名
    @TableField(value = "loginPwd")
    private String loginPwd;//密码
    @TableField(value = "sex")
    private String sex;//性别
    private String phone;//手机号
    private String address;//地址
    @TableField(value = "bornDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String bornDate;//出生日期
    private String email;//邮箱
    @TableField(value = "idCard")
    private String idCard;//身份证号
    @TableField(value = "gradationId")
    private int gradationId;//层次，第几届
    @TableField(value = "gradeId")
    private int gradeId;//年级编号
    @TableField(value = "classId")
    private int classId;//班级编号
    @TableField(value = "stuStatus")
    private String stuStatus;//学习状态：在读（默认）、已毕业
    @TableField(value = "beiZhu")
    private String beiZhu;//备注
}
