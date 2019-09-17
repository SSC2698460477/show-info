package com.ssc.showinfo.web.controller;

import com.ssc.showinfo.biz.service.NewsService;
import com.ssc.showinfo.dao.entity.NewsInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: show-info
 * @description: 财经新闻信息controller类
 * @author: ssc
 * @create: 2019/9/17 16:19
 **/
@RestController
@RequestMapping("api/news")
public class NewsController {

    private final static Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    private NewsService newsService;

    @GetMapping("queryAll")
    public ResponseEntity queryAll(){
        if(logger.isInfoEnabled()){
            logger.info("进入queryAll接口方法中...");
        }
        try{
            List<NewsInfo> newsInfos = newsService.queryAll();
            return ResponseEntity.ok(newsInfos);
        }catch (Exception e){
            logger.error("访问接口出现错误！",e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
