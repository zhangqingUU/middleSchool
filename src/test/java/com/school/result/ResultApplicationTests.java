package com.school.result;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.school.result.controller.Student2Controller;
import com.school.result.mapper.*;
import com.school.result.pojo.*;
import com.school.result.service.TeacherService;
import com.school.result.vo.ResultVO;
import com.school.result.vo.StudentVO;
import org.apache.ibatis.mapping.ResultMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResultApplicationTests {
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private Student2Controller student2Controller;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private Student2Mapper student2Mapper;

    @Autowired
    private ExamTypeMapper examTypeMapper;

    @Autowired
    private CourseMapper courceMapper;

    @Autowired
    private ResultMapper resultMapper;

    @Test
    public void contextLoads() {
        Teacher teacher = teacherService.loginIn("15101174223", "123456");
        if (teacher != null) {
            System.out.println("登录成功！");
        } else {
            System.out.println("登录失败！");
        }
    }

    @Test
    public void test1() {
        Student stu = studentMapper.selectById("1");
        System.out.println(stu);
    }

    @Test
    public void test2() {
        //查询全部
        //List<StudentVO> studentVOList = student2Mapper.selStu();
        //studentVOList.forEach(System.out::println);
    }

    @Test
    public void test3() {
        //模糊条件
        QueryWrapper<StudentVO> wrapper = new QueryWrapper<>();
        wrapper.like("studentNo", "");
        wrapper.like("studentName", "");
        wrapper.like("idCard", "");
        wrapper.like("s.gradationId", "");
        wrapper.like("s.gradeId", "");
        wrapper.like("s.classId", "");

        //分页测试
        Page<StudentVO> studentVOPage = new Page<>(0, 3);
        Page<StudentVO> result = student2Mapper.selectPage(studentVOPage, wrapper);

        List<StudentVO> studentVOList = result.getRecords();
        studentVOList.forEach(System.out::println);
    }

    @Test
    public void test4() {
        //总人数
        System.out.println(student2Mapper.selectCount(null));
    }

    @Test
    public void test5() {
        //查询所有的考试类型
        List<ExamType> examTypeList = examTypeMapper.selectList(null);

        examTypeList.forEach(System.out::println);

    }

    @Test
    public void test6() {
        //查询指定gradeId年级下面的课程
        List<Course> courseList = courceMapper.selCourseByGradeId(1, 1);
        courseList.forEach(System.out::println);
    }

    @Test
    public  void test7(){
        //添加成绩前，先把本班的学生查询出来
        List<Student> studentList= studentMapper.selClassStu(2,1,1);
        studentList.forEach(System.out::println);
    }

    @Test
    public void test8(){
        //添加学生的成绩
        Result result=new Result();
        result.setStudentNo(123321);
        result.setCourseId(1);
        result.setStudentResult(99);
        result.setGradationId(2);
        result.setGradeId(3);
        result.setClassId(4);
        result.setExamTypeId(1);
        result.setBeiZhu("xxx");
        result.setTotalScore(120);

        int r=resultMapper.addResult(result);
        if(r>0) {
            System.out.println("成绩添加成功！");
        }else{
            System.out.println("成绩添加失败！");
        }
    }

    @Test
    public void test9(){
        //查询班级的成绩
        List<ResultVO> resultList=resultMapper.selClassResult(2,1,3,1);
        resultList.forEach(System.out::println);
    }

    @Test
    public void test10(){
        //添加学生的成绩
        Result result=new Result();
        result.setStudentNo(10083);
        result.setCourseId(1);
        result.setStudentResult(12);
        result.setGradationId(2);
        result.setGradeId(1);
        result.setClassId(3);
        result.setExamTypeId(1);

        int r=resultMapper.updResult(result);
        if(r>0) {
            System.out.println("成绩修改成功！");
        }else{
            System.out.println("成绩修改失败！");
        }
    }

    @Test
    public void test11(){
        //计算每个人单科的最高成绩(要求显示字段: 学号，姓名，课程ID，课程名称，最高成绩)
        List<ResultVO> resultVOList= resultMapper.selResult1(2,1,3,1);
        resultVOList.forEach(System.out::println);
    }

    @Test
    public void test12(){
        //列出各门课程成绩最好的学生(要求显示字段: 学号，姓名,科目ID，科目名称，成绩)
        List<ResultVO> resultVOList= resultMapper.selResult2(2,1,3,1);
        resultVOList.forEach(System.out::println);
    }

    @Test
    public void test13(){
        //列出各门课程的平均(要求显示字段: 学号，姓名,科目ID，科目名称，平均成绩)
        List<ResultVO> resultVOList= resultMapper.selResult3(2,1,3,1);
        resultVOList.forEach(System.out::println);
    }
}
