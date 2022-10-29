package com.example.wxclassserver.controller;


import com.example.wxclassserver.model.Chapter;
import com.example.wxclassserver.model.Course;
import com.example.wxclassserver.model.Pages;
import com.example.wxclassserver.model.Response;
import com.example.wxclassserver.service.ChapterService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description: ChapterController <br>
 * date: 2022-10-13 15:00 <br>
 * author: DaTao <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping("/chapter")
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    //物理路径
    @Value("${file.upload.path}")
    private String filePath;

    /**显示虚拟地址*/
    @Value("${file.upload.relative}")
    private String fileRelativePath;

    @GetMapping("/list")
    public List<Chapter> list(Integer courseId){

        List<Chapter> list = chapterService.list(courseId);
        return list;
    }

    @GetMapping("/getPage")
    public Pages<Chapter> getPage(Integer pageIndex, Integer pageSize, Integer courseId, String chapterName){

        Pages<Chapter> pagers = chapterService.getPagers(pageIndex, pageSize,courseId,chapterName);
        return pagers;
    }


    @RequestMapping("/add")
    public Response add(Chapter chapter){
        chapterService.add(chapter);

        return new Response(200,"success");
    }

    @GetMapping("/delete")
    public void delete(Integer id){

        chapterService.delete(id);
    }

    @GetMapping("/update")
    public void update(Chapter chapter){

        chapterService.update(chapter);
    }


    /**
     * 上传课程封面
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value="/upload",method = RequestMethod.POST)
    public Response upload(MultipartFile file) throws IOException {

        //获取文件原名
        String fileName = file.getOriginalFilename();
        //创建要上传的文件对象
        File newFile = new File(filePath,fileName);
        //将文件copy到目标地址
        file.transferTo(newFile);

        String filePath = fileRelativePath.replace("*","")+fileName;

        return new Response(200,"success",filePath);
    }

}
