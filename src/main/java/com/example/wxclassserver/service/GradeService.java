package com.example.wxclassserver.service;

import com.example.wxclassserver.mapper.GradeMapper;
import com.example.wxclassserver.model.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    private GradeMapper gradeMapper;

    public List<Grade> selectAllGrade(){
        return gradeMapper.selectAllGrade();
    }

    public List<Grade> selectHotGrade(){
        return  gradeMapper.selectHotGrade();
    }
}
