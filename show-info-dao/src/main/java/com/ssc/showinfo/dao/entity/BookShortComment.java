package com.ssc.showinfo.dao.entity;

import javax.persistence.*;

/**
 * @program: show-info
 * @description: 书籍的短评信息
 * @author: ssc
 * @create: 2019/9/2 15:03
 **/
@Table(name = "tb_book_short_comment")
public class BookShortComment extends BaseEntity{

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "book_id")
    private Integer bookId; // 书籍id

    @Column(name = "short_comment")
    private String shortComment; // 书籍的短评

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getShortComment() {
        return shortComment;
    }

    public void setShortComment(String shortComment) {
        this.shortComment = shortComment;
    }
}
