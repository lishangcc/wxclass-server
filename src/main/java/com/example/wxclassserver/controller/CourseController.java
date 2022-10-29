/**
 * @Author Ls
 * @Date 2022/10/19 23:32
 * @Description CourseController
 * @Version 1.0
 */
package com.example.wxclassserver.controller;

import com.example.wxclassserver.model.Course;
import com.example.wxclassserver.model.Pages;
import com.example.wxclassserver.model.Response;
import com.example.wxclassserver.service.CourseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    /**
     * 添加
     * 修改
     * 删除
     *
     * 列表
     * 查询
     */
    @Resource
    private CourseService courseService;

    //物理路径
    @Value("${file.upload.path}")
    private String filePath;

    /**显示虚拟地址*/
    @Value("${file.upload.relative}")
    private String fileRelativePath;


    @GetMapping("/list")
    public List<Course> list(){

        List<Course> list = courseService.list();
        return list;
    }


    @GetMapping("/getPage")
    public Pages<Course> getPage(Integer pageIndex, Integer pageSize, String courseName, String teacherName){

        Pages<Course> pagers = courseService.getPagers(pageIndex, pageSize,courseName,teacherName);
        return pagers;
    }

    /**
     * 保存课程
     * @param course
     */
    @RequestMapping("/add")
    public String add(Course course){

        courseService.add(course);

        return "success";
    }

    /**
     * 上传课程封面
     * @param faceImg
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/upload",method = RequestMethod.POST)
    public Response upload(MultipartFile faceImg) throws IOException {

        //获取文件原名
        String fileName = faceImg.getOriginalFilename();
        //创建要上传的文件对象
        File newFile = new File(filePath,fileName);
        //将文件copy到目标地址
        faceImg.transferTo(newFile);

        String filePath = fileRelativePath.replace("*","")+fileName;

        return new Response(200,"success",filePath);
    }



    @GetMapping("/delete")
    public void delete(Integer id){

        courseService.delete(id);
    }


    @GetMapping("/update")
    public void update(Course course){

        courseService.update(course);
    }

}
