package com.school.result.service;

import com.school.result.pojo.Gradation;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-19
 * @Description:
 */
@Component
public interface GradationService {
    /**
     * 查询所有的层次信息
     * @return
     */
    List<Gradation> selGraList();
}
