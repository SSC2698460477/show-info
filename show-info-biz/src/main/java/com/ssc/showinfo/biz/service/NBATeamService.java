package com.ssc.showinfo.biz.service;

import com.ssc.showinfo.dao.entity.NBATeamInfo;
import com.ssc.showinfo.dao.mapper.NBATeamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * @program: show-info
 * @description: 获取NBA球队，球员数据服务类
 * @author: ssc
 * @create: 2019/8/26 16:57
 **/
@Service
public class NBATeamService extends BaseService<NBATeamInfo>{

    @Autowired
    private NBATeamMapper nbaTeamMapper;


    @Override
    public Mapper getMapper() {
        return nbaTeamMapper;
    }
}
