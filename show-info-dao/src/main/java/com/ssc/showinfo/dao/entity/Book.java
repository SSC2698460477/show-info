package com.ssc.showinfo.dao.entity;

import java.util.List;

/**
 * @program: show-info
 * @description: book详细信息，包括短评信息
 * @author: ssc
 * @create: 2019/9/2 16:16
 **/
public class Book {

    private BookInfo bookInfo; // 书籍的信息

    private List<BookShortComment> bookShortComments; // 短评的集合

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public List<BookShortComment> getBookShortComments() {
        return bookShortComments;
    }

    public void setBookShortComments(List<BookShortComment> bookShortComments) {
        this.bookShortComments = bookShortComments;
    }
}
