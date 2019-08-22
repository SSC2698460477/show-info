package com.ssc.showinfo.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @program: show-info
 * @description: 基础的mapper
 * @author: ssc
 * @create: 2019/8/22 14:18
 **/
public interface BaseMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
