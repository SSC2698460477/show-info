package com.ssc.showinfo.dao.mapper;

import com.ssc.showinfo.dao.BaseMapper;
import com.ssc.showinfo.dao.entity.BookInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: show-info
 * @description: 书籍相关的mapper
 * @author: ssc
 * @create: 2019/8/22 14:20
 **/
public interface BookMapper extends BaseMapper<BookInfo>{

    List<BookInfo> queryPageListByRecord(@Param("bookInfo") BookInfo bookInfo, @Param("start") Integer start, @Param("rows") Integer rows);

    Integer queryBookCount();
}
