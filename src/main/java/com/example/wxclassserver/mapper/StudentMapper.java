package com.example.wxclassserver.mapper;

import com.example.wxclassserver.model.Student;
import com.sun.tools.javac.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    //查询所有学生
    List<Student> selectAllStudent();
    //学号查找学生
    Student selectStudentBySno(int sno);
    //修改学生信息 修改name，age，gender，grade，sphone，intro，smail
    int modStudentNameBySno(Student student);
    //删除学生
    int deleteStudentBySno(int sno);
}
