/**
 * @Author Ls
 * @Date 2022/10/27 10:26
 * @Description AdminUser
 * @Version 1.0
 */
package com.example.wxclassserver.model;

public class AdminUser {
    private Integer id;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
