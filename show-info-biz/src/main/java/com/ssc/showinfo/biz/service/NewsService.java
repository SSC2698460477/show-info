package com.ssc.showinfo.biz.service;

import com.ssc.showinfo.dao.entity.NewsInfo;
import com.ssc.showinfo.dao.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * @program: show-info
 * @description: 新闻信息操作的service类
 * @author: ssc
 * @create: 2019/9/17 16:16
 **/
@Service
public class NewsService extends BaseService<NewsInfo>{

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public Mapper<NewsInfo> getMapper() {
        return newsMapper;
    }
}
