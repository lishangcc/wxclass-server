package com.example.wxclassserver.mapper;

import com.example.wxclassserver.model.Grade;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GradeMapper {
    //查询所有班级
    @Select("select id, name, number, intro, charge, hot from grade")
    List<Grade> selectAllGrade();
    //查询热门班级
    @Select("select id, name, number, intro, charge, hot from grade where hot = 1")
    List<Grade> selectHotGrade();
}
