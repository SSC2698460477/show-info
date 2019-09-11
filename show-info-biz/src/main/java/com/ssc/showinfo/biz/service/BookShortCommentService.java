package com.ssc.showinfo.biz.service;

import com.ssc.showinfo.dao.entity.BookShortCommentInfo;
import com.ssc.showinfo.dao.mapper.BookShortCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @program: show-info
 * @description: 书籍短评的service
 * @author: ssc
 * @create: 2019/9/2 15:41
 **/
@Service
public class BookShortCommentService extends BaseService<BookShortCommentInfo>{

    @Autowired
    private BookShortCommentMapper bookShortCommentMapper;

    /**
     * 根据书籍id查询评论的信息列表
     *
     * @param bookShortCommentInfo
     * @return
     */
    public List<BookShortCommentInfo> queryListByRecord(BookShortCommentInfo bookShortCommentInfo){
        return bookShortCommentMapper.queryListByRecoed(bookShortCommentInfo);
    }

    @Override
    public Mapper<BookShortCommentInfo> getMapper() {
        return bookShortCommentMapper;
    }
}
