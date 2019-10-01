package com.ssc.showinfo.web.entity;

/**
 * @program: show-info
 * @description: 登录请求的参数
 * @author: ssc
 * @create: 2019/10/1 14:35
 **/
public class LoginUser {

    /**
     * email邮箱
     */
    private String email;

    /**
     * 登录密码
     */
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
