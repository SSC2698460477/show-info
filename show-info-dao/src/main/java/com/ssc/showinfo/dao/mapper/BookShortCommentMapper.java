package com.ssc.showinfo.dao.mapper;

import com.ssc.showinfo.dao.BaseMapper;
import com.ssc.showinfo.dao.entity.BookShortCommentInfo;

import java.util.List;

/**
 * @program: show-info
 * @description: 书籍短评相关的mapper
 * @author: ssc
 * @create: 2019/9/2 15:36
 **/
public interface BookShortCommentMapper extends BaseMapper<BookShortCommentInfo>{

    public List<BookShortCommentInfo> queryListByRecoed(BookShortCommentInfo bookShortCommentInfo);

}
