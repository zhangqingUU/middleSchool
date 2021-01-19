package com.school.result.service.impl;

import com.school.result.mapper.ClassMapper;
import com.school.result.pojo.Class2;
import com.school.result.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-19
 * @Description:
 */
@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;

    @Override
    public List<Class2> getClaByGradeId(int gradeId) {
        return classMapper.getClaByGradeId(gradeId);
    }
}
