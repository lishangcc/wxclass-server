package com.example.wxclassserver.controller;

import com.example.wxclassserver.model.Grade;
import com.example.wxclassserver.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller("/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @RequestMapping("/getAll")
    public List<Grade> getAllGrade(){
        return gradeService.selectAllGrade();
    }

    @RequestMapping("/getHot")
    public List<Grade> getHotGrade(){
        return gradeService.selectHotGrade();
    }
}
