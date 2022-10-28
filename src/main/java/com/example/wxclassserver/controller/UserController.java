/**
 * @Author Ls
 * @Date 2022/10/26 12:06
 * @Description UserController
 * @Version 1.0
 */
package com.example.wxclassserver.controller;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.wxclassserver.model.AdminUser;
import com.example.wxclassserver.model.Response;
import com.example.wxclassserver.service.AdminUserService;
import com.example.wxclassserver.utils.JWTUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    AdminUserService adminUserService;

    @GetMapping("/login")
    public Map<String,Object> login(AdminUser adminUser) {



        /**
         * 登陆逻辑
         *
         *  验证用户密码，如果验证成功。
         *
         *  创建一个随机字符串（UUId） 将  uuid作为ikey 和 用户信息以及 token 存储到redis中  （servletContext）
         *
         *  将 key 返回给客户端。
         *
         */
//        AdminUser users = adminUserService.queryUser(adminUser.getUsername(),adminUser.getPassword());
        List<AdminUser> users = adminUserService.queryUser(adminUser.getUsername(), adminUser.getPassword());
        System.out.println(users);

        Map<String, Object> map = new HashMap<>();
        if (users.size()!=0) {
            try {

//                AdminUser users = adminUserService.queryUser(adminUser.getUsername(),adminUser.getPassword());
                JWTUtils JWT = new JWTUtils();
                Map<String, String> payload = new HashMap<>();
                payload.put("account", adminUser.getUsername());
                payload.put("password", adminUser.getPassword());
                String token = JWT.getToken(payload);
                System.out.println(token);
                map.put("state", true);
                map.put("msg", "认证成功");
                map.put("token", token);


//                DecodedJWT decode = JWT.decode(token);

            } catch (Exception e) {
                map.put("state", false);
                map.put("msg", "登录失败");
            }

        }
        else {
            map.put("state", false);
            map.put("msg", "登录失败");
        }
        return map;
    }
}
