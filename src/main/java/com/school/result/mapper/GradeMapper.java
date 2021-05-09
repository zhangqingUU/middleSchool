package com.school.result.mapper;

import com.school.result.pojo.Grade;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-19
 * @Description:
 */
public interface GradeMapper {
    /**
     * 二级联动，根据层次id得到所有年级信息
     * @param gradationId
     * @return
     */
    List<Grade> selGraListByGId(@Param("gradationId") int gradationId,@Param("teacherId") int teacherId);
}
