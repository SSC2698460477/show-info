package com.ssc.showinfo.web.controller;

import com.ssc.showinfo.biz.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: show-info
 * @description: 获取书籍信息的controller类
 * @author: ssc
 * @create: 2019/8/22 10:49
 **/
@RestController
@RequestMapping("api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("test")
    public String test(){
        return bookService.test();
    }

}
