package com.school.result.service;

import com.school.result.pojo.Class2;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-19
 * @Description:
 */
@Component
public interface ClassService {
    List<Class2> setClaByGradeId(int gradationId,int gradeId,int classId);
}
