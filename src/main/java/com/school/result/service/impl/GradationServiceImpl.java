package com.school.result.service.impl;

import com.school.result.mapper.GradationMapper;
import com.school.result.pojo.Gradation;
import com.school.result.service.GradationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-19
 * @Description:
 */
@Service
public class GradationServiceImpl implements GradationService {

    @Autowired
    private GradationMapper gradationMapper;

    @Override
    public List<Gradation> selGraList() {
        return gradationMapper.selGraList();
    }
}
