package com.example.wxclassserver.controller;

import com.example.wxclassserver.model.Student;
import com.example.wxclassserver.service.StudentService;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;
    //查询所有学生
    @RequestMapping("/getAllStudent")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }
    //根据学号查询学生信息
    @RequestMapping("/getStudentInfo")
    public Map<String,Object> getStudentInfo(int sno, ModelAndView modelAndView){
        Student student = studentService.getStudentBySno(sno);
        HashMap<String, Object> map = new HashMap<>();
        map.put("student",student);
        return map;
    }
    //修改学生信息
    @RequestMapping("/modStudentInfo")
    public Map<String, Object> modStudentBySno(Student student){
        int i = studentService.modStudentNameBySno(student);
        Map<String,Object> map = new HashMap<>();
        if(i==1){
            map.put("modSuccessMsg","修改学生信息成功");
        }else {
            map.put("modErrMsg","修改学生信息失败");
        }
        return map;
    }
    //删除学生
    @RequestMapping("/deleteStudent")
    public Map<String,Object> deleteStudentBySno(Student student){
        HashMap<String, Object> map = new HashMap<>();
        int i = studentService.deleteStudentBySno(student.getSno());
        if (i==1){
            map.put("successMsg","删除该学生成功");
        }else {
            map.put("failureMsg","删除该学生失败");
        }
        return map;
    }
    //禁用学生
    @RequestMapping("/disableStudent")
    public Map<String,Object> modStudentToDisable(int sno){
        int i = studentService.modStudentToDisable(sno);
        HashMap<String, Object> map = new HashMap<>();
        if (i==1){
            map.put("successMsg","禁用该学生成功");
        }else {
            map.put("failureMsg","禁用该学生失败");
        }
        return map;
    }
}
