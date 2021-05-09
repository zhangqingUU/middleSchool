package com.school.result.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 考试类型表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "examtype")
public class ExamType implements Serializable {
    @TableId(value = "examTypeId")
    private int examTypeId;
    @TableField(value = "examTypeName")
    private String examTypeName;
    @TableField(value = "beiZhu")
    private String beiZhu;
}
