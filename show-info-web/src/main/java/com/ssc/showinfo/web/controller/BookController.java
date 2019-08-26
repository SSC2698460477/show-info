package com.ssc.showinfo.web.controller;

import com.github.pagehelper.PageInfo;
import com.ssc.showinfo.biz.service.BookService;
import com.ssc.showinfo.dao.entity.BookInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @program: show-info
 * @description: 获取书籍信息的controller类
 * @author: ssc
 * @create: 2019/8/22 10:49
 **/
@RestController
@RequestMapping("api/book")
public class BookController {

    private final static Logger logger = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private BookService bookService;

    @GetMapping("test")
    public String test() {
        return bookService.test();
    }

    /**
     * 分页查询书籍信息接口
     *
     * @param page 当前页码数
     * @param rows 每页的条数
     * @return
     */
    @GetMapping("queryBookList")
    public ResponseEntity<PageInfo> queryBookList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                  @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        if (logger.isInfoEnabled()) {
            logger.info("开始调用queryBookList接口，page= {}，rows={}", page, rows);
        }
        try {
            PageInfo<BookInfo> pageInfo = bookService.queryPageListByWhere(null, page, rows);
            return ResponseEntity.ok(pageInfo);
        } catch (Exception e) {
            logger.error("调用queryBookList接口失败！", e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 根据id 获取书籍的信息
     *
     * @param id 书籍id
     * @return
     */
    @GetMapping("queryBookInfoById/{id}")
    public ResponseEntity<BookInfo> queryBookInfoById(@PathVariable(value = "id") Integer id) {
        if (logger.isInfoEnabled()) {
            logger.info("开始调用queryBookInfoById接口，id={}", id);
        }
        try {
            BookInfo bookInfo = bookService.queryById(id);
            return ResponseEntity.ok(bookInfo);
        } catch (Exception e) {
            logger.error("调用queryBookInfoById接口失败！", e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

}
