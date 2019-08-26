package com.ssc.showinfo.biz.service;

import com.ssc.showinfo.dao.entity.NBAPlayerInfo;
import com.ssc.showinfo.dao.mapper.NBAPlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * @program: show-info
 * @description: 获取NBA球员的数据相关服务类
 * @author: ssc
 * @create: 2019/8/26 16:59
 **/
@Service
public class NBAPlayerService extends BaseService<NBAPlayerInfo>{

    @Autowired
    private NBAPlayerMapper nbaPlayerMapper;


    @Override
    public Mapper getMapper() {
        return nbaPlayerMapper;
    }
}
