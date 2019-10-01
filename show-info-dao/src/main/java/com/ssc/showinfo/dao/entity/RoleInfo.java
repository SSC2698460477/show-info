package com.ssc.showinfo.dao.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: show-info
 * @description: 用户角色表对应的实体类
 * @author: ssc
 * @create: 2019/9/29 17:47
 **/
@Table(name = "tb_sys_role")
public class RoleInfo extends BaseEntity{

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "roleName")
    private String name;

    @Column(name = "roleDesc")
    private String desc;

    @Column(name = "roleType")
    private String type; // 0 超级管理员 1 普通管理员 2 员工

    @Column(name = "roleRemark")
    private String remark;

    @Column(name = "state")
    private String state; // 用户状态 1 有效 0 失效

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String type) {
        if(type == "1"){
            this.name="管理员";
        }else{
            this.name="员工";
        }
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if(type == "manager"){
            this.type = "1";
        }else{
            this.type = "2";
        }
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
