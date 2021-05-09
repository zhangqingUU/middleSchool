package com.school.result.service;

import com.school.result.pojo.ExamType;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *考试类型
 */
@Component
public interface ExamTypeService {
    //查询所有的考试类型
    List<ExamType> selExamType();
}
