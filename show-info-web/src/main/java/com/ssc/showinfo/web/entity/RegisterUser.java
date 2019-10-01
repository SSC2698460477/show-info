package com.ssc.showinfo.web.entity;

/**
 * @program: show-info
 * @description: 注册用户的实体参数类
 * @author: ssc
 * @create: 2019/10/1 14:47
 **/
public class RegisterUser {

    /**
     * 登录名
     */
    private String name;
    /**
     *注册邮箱
     */
    private String email;
    /**
     * 注册密码
     */
    private String password;
    /**
     * 注册身份
     */
    private String identity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
