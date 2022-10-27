package com.example.wxclassserver.service;


import com.example.wxclassserver.mapper.ChapterMapper;
import com.example.wxclassserver.model.Chapter;
import com.example.wxclassserver.model.Pages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: ChapterService <br>
 * date: 2022-10-13 15:04 <br>
 * author: DaTao <br>
 * version: 1.0 <br>
 */
@Service
public class ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

    /**
     * 分页
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public Pages<Chapter> getPagers(Integer pageIndex, Integer pageSize, Integer courseId, String chapterName) {

        //起始条数
        Integer recordStart = (pageIndex-1)*pageSize;

        //获取data
        List<Chapter> data = chapterMapper.queryCourse(recordStart,pageSize,courseId,chapterName);

        String[] statusInfos = {"未学习","学习中","已学完"};

        for(Chapter chapter : data){
            chapter.setStatusInfo(statusInfos[chapter.getStatus()]);
        }

        int totalRecord = chapterMapper.getRecordCount(chapterName,courseId);

        //计算总页数
        Integer totalPage = totalRecord%pageSize == 0 ? totalRecord/pageSize : totalRecord/pageSize + 1;

        //组装page对象
        Pages<Chapter> pages = new Pages(pageSize,totalPage,totalRecord,pageIndex,data);


        return pages;

    }


    public void add(Chapter chapter) {
        chapterMapper.add(chapter);
    }

    public void update(Chapter chapter) {
        chapterMapper.update(chapter);
    }
}
