package com.ssc.showinfo.biz.service;

import com.ssc.showinfo.dao.entity.UserInfo;
import com.ssc.showinfo.dao.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * @program: show-info
 * @description: 登录的service层的逻辑处理
 * @author: ssc
 * @create: 2019/9/10 16:24
 **/
@Service
public class LoginService extends BaseService<UserInfo> {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Mapper<UserInfo> getMapper() {
        return loginMapper;
    }
}
