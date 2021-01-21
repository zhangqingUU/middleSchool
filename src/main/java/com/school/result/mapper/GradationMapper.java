package com.school.result.mapper;

import com.school.result.pojo.Gradation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-19
 * @Description:
 */
@Component
@RequestMapping("gradation")
public interface GradationMapper {
    /**
     * @Description:查询所有的层次信息
     * @Param:
     * @Return:
     */
    List<Gradation> selGraList(@Param("teacherId") int teacherId);
}
