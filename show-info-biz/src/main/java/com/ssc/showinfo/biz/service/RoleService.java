package com.ssc.showinfo.biz.service;

import com.ssc.showinfo.dao.entity.RoleInfo;
import com.ssc.showinfo.dao.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * @program: show-info
 * @description: 用户角色管理的service类
 * @author: ssc
 * @create: 2019/9/29 18:23
 **/
@Service
public class RoleService extends BaseService<RoleInfo>{

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public Mapper<RoleInfo> getMapper() {
        return roleMapper;
    }
}
