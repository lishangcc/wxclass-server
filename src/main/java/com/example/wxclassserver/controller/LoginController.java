/**
 * @Author Ls
 * @Date 2022/10/26 0:02
 * @Description LoginController
 * @Version 1.0
 */
package com.example.wxclassserver.controller;

import com.example.wxclassserver.model.Customer;
import com.example.wxclassserver.model.Wxauth;
import com.example.wxclassserver.service.CustomerService;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
public class LoginController {

    @Resource
    private CustomerService customerService;

    @GetMapping("/createOpenKey")
    public String createOpenKey(String code,String nickname,String avatarUrl, HttpSession session) throws IOException {
        System.out.println(code);

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wx986fe21d2bd17158&secret=8dadb2406609762a7ca1101fe417b9ed&js_code="+code+"&grant_type=authorization_code";
        //okhttp3 库 用来发送请求
        OkHttpClient client = new OkHttpClient();
        //构建请求对象
        Request request = new Request.Builder().url(url).build();
        //执行请求获取响应
        Response response = client.newCall(request).execute();
        //从响应对象中取出 json字符串
        String result = response.body().string();

        //用Gson将json转换为对象
        Wxauth wxauth = new Gson().fromJson(result, Wxauth.class);
        System.out.println(wxauth);
        //创建uuid和openid及session_key关联
        String token = UUID.randomUUID().toString();

        //servletContext的作用域对应 整个应用。
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute(token,wxauth);

        //持久化用户数据
        Customer customer = new Customer(wxauth.getOpenid(),wxauth.getSession_key(),nickname,avatarUrl);
        customerService.add(customer);

        return token;
    }

    @RequestMapping("/customerList")
    public List<Customer> list(){
        return customerService.list();
    }
}
