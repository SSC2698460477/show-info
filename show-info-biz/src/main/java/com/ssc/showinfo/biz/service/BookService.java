package com.ssc.showinfo.biz.service;

import com.ssc.showinfo.dao.entity.BookInfo;
import com.ssc.showinfo.dao.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * @program: show-info
 * @description: 操作书籍信息的service类
 * @author: ssc
 * @create: 2019/8/22 11:12
 **/
@Service
public class BookService extends BaseService<BookInfo>{

    @Autowired
    private BookMapper bookMapper;

    public String test(){
        return bookMapper.selectByPrimaryKey(1).toString();
    }

    @Override
    public Mapper<BookInfo> getMapper() {
        return bookMapper;
    }
}
