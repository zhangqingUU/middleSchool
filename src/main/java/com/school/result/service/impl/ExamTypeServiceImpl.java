package com.school.result.service.impl;

import com.school.result.mapper.ExamTypeMapper;
import com.school.result.pojo.ExamType;
import com.school.result.service.ExamTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExamTypeServiceImpl implements ExamTypeService {

    @Autowired
    private ExamTypeMapper examTypeMapper;

    @Override
    public List<ExamType> selExamType() {
        return examTypeMapper.selectList(null);
    }
}
