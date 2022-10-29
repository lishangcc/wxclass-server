package com.example.wxclassserver.mapper;

import com.example.wxclassserver.model.Grade;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface GradeMapper {
    //查询所有班级
    @Select("select id, name, number, intro, charge, hot from grade")
    List<Grade> selectAllGrade();
    //查询热门班级
    @Select("select id, name, number, intro, charge, hot from grade where hot = 1")
    List<Grade> selectHotGrade();
    //删除班级
    @Delete("delete from grade where id = #{id}")
    int deleteGrade(int id);
    //修改班级信息
    @Update("update grade set grade.name = #{grade.name}, grade.number = #{grade.number}, grade.intro = #{grade.intro}, grade.charge = #{grade.charge}, grade.hot = #{grade.hot}")
    int modGradeInfo(Grade grade);
}
