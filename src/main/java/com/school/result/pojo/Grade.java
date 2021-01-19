package com.school.result.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-19
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    private int gradeId;
    private String gradeName;
    private int gradationId;
}
