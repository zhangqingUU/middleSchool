package com.school.result.service.impl;

import com.school.result.mapper.GradeMapper;
import com.school.result.pojo.Grade;
import com.school.result.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-19
 * @Description:
 */
@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public List<Grade> selGraListByGId(int gradationId,int teacherId) {
        return gradeMapper.selGraListByGId(gradationId,teacherId);
    }
}
