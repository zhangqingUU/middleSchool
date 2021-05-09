package com.school.result.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "student s inner join gradation gra inner join grade g inner join class c  on s.`gradationId`=gra.gradationid and s.`gradeId`=g.`gradeId` and s.`classId`=c.`classId`")
public class StudentVO implements Serializable {
    @TableId(value = "studentNo")
    private int studentNo;//学号
    @TableField(value = "studentName")
    private String studentName;//学生姓名
    @TableField(value = "loginPwd")
    private String loginPwd;//密码
    private String sex;//性别
    private String phone;//手机号
    private String address;//地址
    @TableField(value = "bornDate")
    private String bornDate;//出生日期
    private String email;//邮箱
    @TableField(value = "idCard")
    private String idCard;//身份证号
    @TableField(value = "s.gradationId")
    private int gradationId;//层次，第几届
    @TableField(value = "s.gradeId")
    private int gradeId;//年级编号
    @TableField(value = "s.classId")
    private int classId;//班级编号
    @TableField(value = "stuStatus")
    private String stuStatus;//学习状态：在读（默认）、已毕业
    @TableField(value = "beiZhu")
    private String beiZhu;//备注
    //////
    @TableField(value = "gra.gradationName")
    private String gradationName;
    @TableField(value = "g.gradeName")
    private String gradeName;
    @TableField(value = "c.className")
    private String className;

    public String getBornDate() {
        return bornDate.substring(0,10);
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }
}
