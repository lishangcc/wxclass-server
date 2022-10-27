package com.example.wxclassserver.mapper;

import com.example.wxclassserver.model.Student;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentMapper {
    //查询所有学生
    @Select("select sno, sname, sage, gender, grade, sphone, intro, status, smail from student")
    List<Student> selectAllStudent();
    //学号查找学生
    @Select("select sno, sname, sage, gender, grade, sphone, intro, status, smail from student where sno = #{sno}")
    Student selectStudentBySno(int sno);
    //修改学生信息 修改name，age，gender，grade，sphone，intro，smail
    @Update("update student\n" +
            "        set student.sname = #{student.sname},\n" +
            "            student.sage = #{student.sage},\n" +
            "            student.gender = #{student.gender},\n" +
            "            student.sphone = #{student.sphone},\n" +
            "            student.intro = #{student.intro},\n" +
            "            student.smail = #{student.smail}\n" +
            "        where student.sno = #{student.sno};")
    int modStudentBySno(Student student);
    //删除学生
    @Delete("delete from student where sno = #{sno}")
    int deleteStudentBySno(int sno);
}
