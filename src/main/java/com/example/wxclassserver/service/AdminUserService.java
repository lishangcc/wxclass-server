/**
 * @Author Ls
 * @Date 2022/10/27 22:55
 * @Description AdminUserService
 * @Version 1.0
 */
package com.example.wxclassserver.service;

import com.example.wxclassserver.mapper.AdminUserMapper;
import com.example.wxclassserver.model.AdminUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminUserService {

    @Autowired
    AdminUserMapper adminUserMapper;

    public List<AdminUser> queryUser(String username,String password){
        List<AdminUser> users = adminUserMapper.queryUser(username, password);
        return users;
    }
}
