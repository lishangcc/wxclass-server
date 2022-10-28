/**
 * @Author Ls
 * @Date 2022/10/27 10:01
 * @Description UserToken
 * @Version 1.0
 */
package com.example.wxclassserver.model;

import java.util.Date;

public class UserToken {
    private Long userId;

    private String token;

    private Date updateTime;

    private Date expireTime;
}
