/**
 * @Author Ls
 * @Date 2022/10/21 11:05
 * @Description Customer
 * @Version 1.0
 */
package com.example.wxclassserver.model;

public class Customer {

    private Integer id;
    private String openid;
    private String sessionKey;
    private String nickname;
    private String avatarUrl;
    private String addTime;
    private String account;
    private String phone;

    public Customer() {
    }

    public Customer( String openid, String sessionKey, String nickname, String avatarUrl) {
        this.openid = openid;
        this.sessionKey = sessionKey;
        this.nickname = nickname;
        this.avatarUrl = avatarUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

