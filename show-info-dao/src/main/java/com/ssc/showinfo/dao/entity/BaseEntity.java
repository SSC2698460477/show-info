package com.ssc.showinfo.dao.entity;

import java.util.Date;

/**
 * @program: show-info
 * @description: 基础的实体类，表中的通用属性抽取出来
 * @author: ssc
 * @create: 2019/8/22 14:11
 **/
public abstract class BaseEntity {

    private Date created; // 创建时间
    private Date updated; // 修改时间

    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }
    public Date getUpdated() {
        return updated;
    }
    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
