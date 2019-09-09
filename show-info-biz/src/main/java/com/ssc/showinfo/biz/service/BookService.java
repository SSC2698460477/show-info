package com.ssc.showinfo.biz.service;

import com.ssc.showinfo.common.redis.CacheTime;
import com.ssc.showinfo.common.redis.RedisClient;
import com.ssc.showinfo.dao.entity.BookInfo;
import com.ssc.showinfo.dao.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

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

    @Autowired
    private RedisClient redisClient;

    public String test(){
        String key = "showinfo:book:test";
        if(redisClient.get(key) == null){
            String testStr = bookMapper.selectByPrimaryKey(1).toString();
            redisClient.set(key,testStr, CacheTime.CACHE_EXP_MIUNTE);
            return testStr;
        }else{
            return redisClient.get(key);
        }
    }

    public List<BookInfo> queryPageListByRecord(BookInfo record, Integer page, Integer rows) {
        return bookMapper.queryPageListByRecord(record,page,rows);
    }

    public Integer queryBookCount() {
        return bookMapper.queryBookCount();
    }

    @Override
    public Mapper<BookInfo> getMapper() {
        return bookMapper;
    }


}
