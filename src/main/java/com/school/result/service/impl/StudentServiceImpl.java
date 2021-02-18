package com.school.result.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.school.result.mapper.Student2Mapper;
import com.school.result.mapper.StudentMapper;
import com.school.result.pojo.Student;
import com.school.result.service.StudentService;
import com.school.result.vo.StudentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-18
 * @Description: 学生DAO实现类
 */
@Service
public class StudentServiceImpl implements StudentService {

    //调用mapper
    @Autowired
    private StudentMapper studentMapper;
    //调用mapper
    @Autowired
    private Student2Mapper student2Mapper;

    @Override
    public int addStu(Student student) {
        return studentMapper.addStu(student);
    }

    @Override
    public Student getStudentById(String studentNo) {
        return studentMapper.selectById(studentNo);
    }

    @Override
    public List<StudentVO> selStu(int currentPage, int pageSize, String studentNo, String studentName, String idCard, String gradationId, String gradeId, String classId) {
        //模糊条件
        QueryWrapper<StudentVO> wrapper = new QueryWrapper<>();
        wrapper.like("studentNo", studentNo);
        wrapper.like("studentName", studentName);
        wrapper.like("idCard", idCard);
        wrapper.like("s.gradationId", gradationId);
        wrapper.like("s.gradeId", gradeId);
        wrapper.like("s.classId", classId);

        //分页测试
        Page<StudentVO> studentVOPage = new Page<>(currentPage, pageSize);
        Page<StudentVO> result = student2Mapper.selectPage(studentVOPage, wrapper);

        return result.getRecords();
    }

    @Override
    public int getCount(String studentNo, String studentName, String idCard, String gradationId, String gradeId,String classId) {
        //模糊条件
        QueryWrapper<StudentVO> wrapper = new QueryWrapper<>();
        wrapper.like("studentNo", studentNo);
        wrapper.like("studentName", studentName);
        wrapper.like("idCard", idCard);
        wrapper.like("s.gradationId", gradationId);
        wrapper.like("s.gradeId", gradeId);
        wrapper.like("s.classId", classId);
        //获取总条数
        return student2Mapper.selectCount(wrapper);
    }

}
