package com.school.result.mapper;

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
public interface ClassMapper {
    List<Class2> getClaByGradeId(@Param("gradeId") int gradeId);
}
