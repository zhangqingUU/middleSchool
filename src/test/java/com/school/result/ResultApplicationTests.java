package com.school.result;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.school.result.controller.Student2Controller;
import com.school.result.mapper.CourseMapper;
import com.school.result.mapper.ExamTypeMapper;
import com.school.result.mapper.Student2Mapper;
import com.school.result.mapper.StudentMapper;
import com.school.result.pojo.Course;
import com.school.result.pojo.ExamType;
import com.school.result.pojo.Student;
import com.school.result.pojo.Teacher;
import com.school.result.service.TeacherService;
import com.school.result.vo.StudentVO;
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

}
