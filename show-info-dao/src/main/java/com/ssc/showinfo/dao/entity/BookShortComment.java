package com.ssc.showinfo.dao.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @program: show-info
 * @description: 书籍的短评信息
 * @author: ssc
 * @create: 2019/9/2 15:03
 **/
@Table(name = "tb_book_short_comment")
public class BookShortComment extends BaseEntity{

    @Id
    private int id;

    @Column(name = "book_id")
    private int bookId; // 书籍id

    @Column(name = "short_comment")
    private String shortComment; // 书籍的短评

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getShortComment() {
        return shortComment;
    }

    public void setShortComment(String shortComment) {
        this.shortComment = shortComment;
    }
}
