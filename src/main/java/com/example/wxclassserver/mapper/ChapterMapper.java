package com.example.wxclassserver.mapper;

import com.example.wxclassserver.model.Chapter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ChapterMapper {


    @Select({"<script> SELECT c1.id,c1.course_id,c2.name courseName,c1.name,c1.info,c1.video,c1.status" +
            " FROM chapter c1 JOIN course c2 ON c1.course_id=c2.id where c1.course_id = #{id}"+
            "<where>" +
            "<if test='chapterName != null'> and c1.name like '%${chapterName}%' </if> " +
            "</where>" +
            "LIMIT #{recordStart},#{pageSize} "+
            "</script>"})
    List<Chapter> queryCourse(Integer recordStart, Integer pageSize, Integer courseId, String chapterName);


    @Select({"<script> SELECT count(*) " +
            " FROM chapter c1 JOIN course c2 ON c1.course_id=c2.id where c1.course_id = #{id}"+
            "<where>" +
            "<if test='chapterName != null'> and c1.name like '%${chapterName}%' </if> " +
            "</where>" +
            "</script>"})
    int getRecordCount(String chapterName);


    //@Insert("insert into chapter() value()")
    void add(Chapter chapter);


    //
    void update(Chapter chapter);

    void delete(Integer id);
}
