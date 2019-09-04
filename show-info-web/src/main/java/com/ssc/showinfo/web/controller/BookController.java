package com.ssc.showinfo.web.controller;

import com.github.pagehelper.PageInfo;
import com.ssc.showinfo.biz.service.BookService;
import com.ssc.showinfo.biz.service.BookShortCommentService;
import com.ssc.showinfo.dao.entity.Book;
import com.ssc.showinfo.dao.entity.BookInfo;
import com.ssc.showinfo.dao.entity.BookShortComment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @Autowired
    private BookShortCommentService bookShortCommentService;

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
    public ResponseEntity<Book> queryBookInfoById(@PathVariable(value = "id") Integer id) {
        if (logger.isInfoEnabled()) {
            logger.info("开始调用queryBookInfoById接口，id={}", id);
        }
        try {
            BookInfo record = new BookInfo();
            record.setId(id);
            BookInfo bookInfo = bookService.queryOne(record);
            BookShortComment bookShortComment = new BookShortComment();
            bookShortComment.setId(0);
            bookShortComment.setBookId(id);
            List<BookShortComment> list = bookShortCommentService.queryListByRecord(bookShortComment);
            Book book = new Book();
            book.setBookInfo(bookInfo);
            book.setBookShortComments(list);
            return ResponseEntity.ok(book);
        } catch (Exception e) {
            logger.error("调用queryBookInfoById接口失败！", e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 增加短评
     *
     * @param shortComment
     * @return
     */
    @PostMapping(value = "addShortComment",consumes = "application/json;charset=utf-8")
    public ResponseEntity addShortComment(@RequestBody BookShortComment shortComment){
        if(logger.isInfoEnabled()){
            logger.info("开始调用addShortComment接口，bookId={} comment={}", shortComment.getBookId(), shortComment.getShortComment());
        }
        try{
            Integer result = bookShortCommentService.save(shortComment);
            if(result <= 0){
                if(logger.isInfoEnabled()){
                    logger.info("新增短评失败！");
                }
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
            if(logger.isInfoEnabled()){
                logger.info("新增短评成功！");
            }
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            logger.error("调用addShortComment接口出错", e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
