package com.school.result.service;

import com.school.result.pojo.Grade;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-19
 * @Description:
 */
@Component
public interface GradeService {
    List<Grade> selGraListByGId(int gradationId,int teacherId);
}
