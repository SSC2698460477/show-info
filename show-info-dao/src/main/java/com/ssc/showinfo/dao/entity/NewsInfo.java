package com.ssc.showinfo.dao.entity;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @program: show-info
 * @description: 新闻信息实体类
 * @author: ssc
 * @create: 2019/9/17 15:34
 **/
@Table(name = "tb_news")
public class NewsInfo extends BaseEntity {

    @Column(name = "UUID")
    private String uuid;

    @Column(name = "CLASSID")
    private String classId; //分类id

    @Column(name = "MYOTHER")
    private String myother; // 转载或者原创 0 原创 1 转载

    @Column(name = "TITLE")
    private String title;

    @Column(name = "INTRO")
    private String intro;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "URL")
    private String url;

    @Column(name = "PUBTIME")
    private String pubtime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getMyother() {
        return myother;
    }

    public void setMyother(String myother) {
        this.myother = myother;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPubtime() {
        return pubtime;
    }

    public void setPubtime(String pubtime) {
        this.pubtime = pubtime;
    }
}
