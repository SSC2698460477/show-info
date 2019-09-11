package com.ssc.showinfo.web.controller;

import com.ssc.showinfo.biz.service.LoginService;
import com.ssc.showinfo.dao.entity.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @program: show-info
 * @description: 登录controller类
 * @author: ssc
 * @create: 2019/9/10 15:37
 **/
@RequestMapping("api/login")
@RestController
public class LoginController {

    private final static Logger logger = LoggerFactory.getLogger(LoggerFactory.class);

    @Autowired
    private LoginService loginService;

    /**
     * 登录信息的验证接口
     *
     * @param userInfo
     * @return
     */
    @PostMapping
    @CrossOrigin
    public ResponseEntity login(@RequestBody UserInfo userInfo){
        if(logger.isInfoEnabled()){
            logger.info("调用login接口，userName={}，password={}",userInfo.getUsername(),userInfo.getPassword());
        }
        try{
            UserInfo record = new UserInfo();
            record.setUsername(userInfo.getUsername());
            record.setPassword(userInfo.getPassword());
            UserInfo result = loginService.queryOne(record);
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            logger.error("调用login接口出错",e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

}
