package com.ssc.showinfo.dao.mapper;

import com.ssc.showinfo.dao.BaseMapper;
import com.ssc.showinfo.dao.entity.UserInfo;

/**
 * @program: show-info
 * @description: 用户的mapper接口处理方法
 * @author: ssc
 * @create: 2019/9/10 16:26
 **/
public interface UserMapper extends BaseMapper<UserInfo>{

    UserInfo checkLoginUser(UserInfo record);
}
