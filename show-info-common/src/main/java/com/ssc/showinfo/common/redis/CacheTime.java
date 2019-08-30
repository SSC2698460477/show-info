package com.ssc.showinfo.common.redis;

/**
 * @program: show-info
 * @description: redis缓存时间常量类
 * @author: ssc
 * @create: 2019/8/29 13:53
 **/
public class CacheTime {

    public static int CACHE_EXP_FIVE_SECONDS = 5; // 缓存时效 5秒钟

    public static int CACHE_EXP_MIUNTE = 60; // 缓存时效 1分钟

    public static int CACHE_EXP_FIVE_MINUTE = 5 * 60  ; // 缓存时效 5分钟

    public static int CACHE_EXP_TEN_MINUTE = 10 * 60  ; // 缓存时效 10分钟

    public static int CACHE_EXP_QUARTER_MINUTE = 15 * 60  ; //  缓存时效 15分钟

    public static int CACHE_EXP_HOUR = 60 * 60; // 缓存时效 1小时

    public static int CACHE_EXP_HALF_DAY = 12 * 3600; // 缓存时效 12小时

    public static int CACHE_EXP_DAY = 24 * 3600; // 缓存时效 1天

    public static int CACHE_EXP_WEEK = 7 * 24 * 3600; // 缓存时效 1周

    public static int CACHE_EXP_MONTH = 30 * 24 * 3600; // 缓存时效 1月

    public static int CACHE_EXP_FOREVER = 0; // 缓存时效 永久

}
