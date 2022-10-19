/**
 * @Author Ls
 * @Date 2022/10/19 23:29
 * @Description FileConfig
 * @Version 1.0
 */
package com.example.wxclassserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FileConfig implements WebMvcConfigurer {

    /**上传地址*/
    @Value("${file.upload.path}")
    private String filePath;

    /**显示相对地址*/
    @Value("${file.upload.relative}")
    private String fileRelativePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(fileRelativePath).addResourceLocations("file:/" + filePath);
    }
}

