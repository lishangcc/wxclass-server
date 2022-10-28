package com.example.wxclassserver.mapper;

import com.example.wxclassserver.model.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface AdminUserMapper {

    @Select("select username,password from adminuser where username=#{username} and password=#{password}")
//    void queryUser(@Param("username") String username, @Param("password") String password);
    List<AdminUser> queryUser(@Param("username") String username, @Param("password") String password);
}
