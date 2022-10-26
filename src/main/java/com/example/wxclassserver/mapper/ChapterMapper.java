package com.example.wxclassserver.mapper;

import com.example.wxclassserver.model.Chapter;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * description: ChapterMapper <br>
 * date: 2022-10-13 15:05 <br>
 * author: DaTao <br>
 * version: 1.0 <br>
 */
@Mapper
public interface ChapterMapper {


    @Select({"<script> SELECT c1.id,c1.course_id,c2.name courseName,c1.name,c1.info,c1.video,c1.status" +
            " FROM chapter c1 JOIN course c2 ON c1.course_id=c2.id where c1.course_id = #{courseId}"+
            "<where>" +
            "<if test='chapterName != null'> and c1.name like '%${chapterName}%' </if> " +
            "</where>" +
            "LIMIT #{recordStart},#{pageSize} "+
            "</script>"})
    List<Chapter> queryCourse(@Param("recordStart") Integer recordStart,
                              @Param("pageSize") Integer pageSize,
                              @Param("courseId") Integer courseId,
                              @Param("chapterName") String chapterName);


    @Select({"<script> SELECT count(*) " +
            " FROM chapter c1 JOIN course c2 ON c1.course_id=c2.id where c1.course_id = #{courseId}"+
            "<where>" +
            "<if test='chapterName != null'> and c1.name like '%${chapterName}%' </if> " +
            "</where>" +
            "</script>"})
    int getRecordCount(@Param("chapterName") String chapterName,@Param("courseId") Integer courseId);


    @Insert("insert into chapter(name,course_id,info,video) value(#{chapter.name},#{chapter.name},#{chapter.course_id},#{chapter.info},#{chapter.video})")
    void add(@Param("chapter") Chapter chapter);


    //
    void update(Chapter chapter);

    void delete(Integer id);
}
