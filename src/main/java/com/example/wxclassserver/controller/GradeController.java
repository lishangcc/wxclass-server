package com.example.wxclassserver.controller;

import com.example.wxclassserver.model.Grade;
import com.example.wxclassserver.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/grade")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @GetMapping("/getAllGrade")
    public List<Grade> getAllGrade(){
        return gradeService.selectAllGrade();
    }

    @GetMapping("/getHotGrade")
    public List<Grade> getHotGrade(){
        return gradeService.selectHotGrade();
    }

    @DeleteMapping("/deleteGrade")
    public Map<String,Object> deleteGrade(int id){
        int i = gradeService.deleteGrade(id);
        HashMap<String, Object> map = new HashMap<>();
        if(i==1){
            map.put("successMsg","删除该班级成功");
        }else {
            map.put("failureMsg","删除该班级失败");
        }
        return map;
    }

    @PostMapping("/modGradeInfo")
    public Map<String,Object> modGradeInfo(Grade grade){
        int i = gradeService.modGradeInfo(grade);
        HashMap<String, Object> map = new HashMap<>();
        if(i==1){
            map.put("successMsg","修改班级信息成功");
        }else {
            map.put("failureMsg","修改班级信息失败");
        }
        return map;
    }
}
