package com.school.result.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.school.result.mapper.Student2Mapper;
import com.school.result.pojo.Student;
import com.school.result.vo.StudentVO;

import java.util.List;

/**
 * @Author: 张晴
 * @CreateTime: 2021-01-18
 * @Description: 学生Service
 */
public interface StudentService {

    //添加学生信息
    int addStu(Student student);

    //根据id得到单个学生对象
    Student getStudentById(String studentNo);

    //分页查询学生信息
    List<StudentVO> selStu(int currentPage, int pageSize, String studentNo, String studentName, String idCard, String gradationId, String gradeId, String classId);

    //得到学生总人数
    int getCount(String studentNo, String studentName, String idCard, String gradationId, String gradeId,String classId);

    //根据学号删除学生信息
    int delStu(int studentNo);

    //根据学号查询学生的信息
    StudentVO selStuByNo(int studentNo);
}
