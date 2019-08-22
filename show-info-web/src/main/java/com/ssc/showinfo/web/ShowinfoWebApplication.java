package com.ssc.showinfo.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: show-info
 * @description: 项目的入口类
 * @author: ssc
 * @create: 2019/8/22 10:41
 **/
@SpringBootApplication(scanBasePackages = "com.ssc.showinfo")
@MapperScan("com.ssc.showinfo.dao.mapper")
public class ShowinfoWebApplication {

    public static void main(String[] args){
        SpringApplication.run(ShowinfoWebApplication.class);
    }
}
