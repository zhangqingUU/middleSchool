package com.school.result.service;

import com.school.result.pojo.Class2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-19
 * @Description:
 */
public interface ClassService {
    List<Class2> getClaByGradeId(int gradeId);
}
