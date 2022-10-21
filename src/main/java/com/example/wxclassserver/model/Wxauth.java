/**
 * @Author Ls
 * @Date 2022/10/21 11:06
 * @Description Wxauth
 * @Version 1.0
 */
package com.example.wxclassserver.model;

public class Wxauth {

    private String session_key;
    private Integer expires_in;
    private String openid;

    public String getSession_key() {
        return session_key;
    }

    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    @Override
    public String toString() {
        return "Wxauth{" +
                "session_key='" + session_key + '\'' +
                ", expires_in=" + expires_in +
                ", openid='" + openid + '\'' +
                '}';
    }
}
