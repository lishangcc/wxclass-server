package com.example.wxclassserver.mapper;

import com.example.wxclassserver.model.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeMapper {
    //查询所有班级
    List<Grade> selectAllGrade();
    //查询热门班级
    List<Grade> selectHotGrade();
}
