package com.ssc.showinfo.common.annotation;

import java.lang.annotation.*;

/**
 * @program: show-info
 * @description: JWT 验证忽略注解
 * @author: ssc
 * @create: 2019/9/29 17:34
 **/
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JwtIgnore {
    boolean required() default true;
}
