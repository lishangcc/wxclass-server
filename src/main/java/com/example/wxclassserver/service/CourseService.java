/**
 * @Author Ls
 * @Date 2022/10/19 14:12
 * @Description CourseService
 * @Version 1.0
 */
package com.example.wxclassserver.service;


import com.example.wxclassserver.mapper.CourseMapper;
import com.example.wxclassserver.model.Course;
import com.example.wxclassserver.model.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;


    /**
     * 分页
     * @param pageIndex
     * @param pageSize
     * @return
     */



    public Pages<Course> getPagers(Integer pageIndex,Integer pageSize,String courseName,String teacherName) {


        //起始条数
        Integer recordStart = (pageIndex-1)*pageSize;

        //获取data
        List<Course> data = courseMapper.queryCourse(recordStart,pageSize,courseName,teacherName);

        for(Course course : data){
            if(course.getAttribute().equals("1")){
                course.setAttribute("公开课");
            }else if(course.getAttribute().equals("2")){
                course.setAttribute("标准课");
            }
        }

        int totalRecord = courseMapper.getRecordCount(courseName,teacherName);

        //计算总页数
        Integer totalPage = totalRecord%pageSize == 0 ? totalRecord/pageSize : totalRecord/pageSize + 1;

        //组装page对象
        Pages<Course> pages = new Pages(pageSize,totalPage,totalRecord,pageIndex,data);


        return pages;
    }


    public void add(Course course) {

        courseMapper.add(course);
    }

    public void delete(Integer id) {
        courseMapper.delete(id);
    }

    public void update(Course course) {

        courseMapper.update(course);
    }

    public List<Course> list() {
        List<Course>  list = courseMapper.list();
        for(Course course : list){
            if(course.getAttribute().equals("1")){
                course.setAttribute("公开课");
            }else if(course.getAttribute().equals("2")){
                course.setAttribute("标准课");
            }
        }

        return list;
    }
}
