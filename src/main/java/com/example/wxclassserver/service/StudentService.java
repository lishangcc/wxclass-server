package com.example.wxclassserver.service;

import com.example.wxclassserver.model.Student;
import com.example.wxclassserver.mapper.StudentMapper;
import com.sun.tools.javac.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    public List<Student> getAllStudent() {
        List<Student> students = studentMapper.selectAllStudent();
        return students;
    }

    public Student getStudentBySno(int sno){
        return studentMapper.selectStudentBySno(sno);
    }

    public int modStudentNameBySno(Student student) {
        return studentMapper.modStudentNameBySno(student);
    }

    public int deleteStudentBySno(int sno){
        return studentMapper.deleteStudentBySno(sno);
    }
}
