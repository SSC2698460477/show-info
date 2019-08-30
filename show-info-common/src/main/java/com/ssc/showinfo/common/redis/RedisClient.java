package com.ssc.showinfo.common.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @program: show-info
 * @description: redis工具类
 * @author: ssc
 * @create: 2019/8/29 14:36
 **/
@Component
public class RedisClient {

    private final static Logger logger = LoggerFactory.getLogger(RedisClient.class);

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 指定缓存失效时间
     *
     * @param key 键
     * @param time 时间 （秒）
     * @return
     */
    public boolean expire(String key, long time){
        try {
            if(time > 0){
                redisTemplate.expire(key,time, TimeUnit.SECONDS);
            }
            return true;
        }catch (Exception e){
            logger.error("RedisClient中的expire方法出错：", e);
        }
        return false;
    }

    /**
     * 根据key获取剩余过期时间
     *
     * @param key 键
     * @return 时间 单位秒 0 代表永久有效
     */
    public long ttl(String key){
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    public boolean exists(String key){
        try{
            return redisTemplate.hasKey(key);
        }catch(Exception e){
            logger.error("RedisClient中的exists方法出错：", e);
        }
        return false;
    }

    /**
     * 删除缓存
     *
     * @param key 可以传一个或多个key
     */
    public void del(String... key){
        try{
            if(key!=null && key.length>0){
                if(key.length == 1){
                    redisTemplate.delete(key[0]);
                }else{
                    redisTemplate.delete(CollectionUtils.arrayToList(key));
                }
            }
        }catch(Exception e){
            logger.error("RedisClient中的del方法出错", e);
        }
    }

    /**
     * 模糊匹配批量删除
     *
     * @param pattern 匹配的前缀
     */
    public void deleteByPattern(String pattern){
        try{
            Set<String> keys = redisTemplate.keys(pattern);
            if(!CollectionUtils.isEmpty(keys)){
                redisTemplate.delete(keys);
            }
        }catch (Exception e){
            logger.error("RedisClient中的deleteByPattern方法出错：", e);
        }
    }

    /**
     * 设置指定key value以及缓存时间
     *
     * @param key 键
     * @param value 值
     * @param time 缓存时间 key 小于等于0 则永久有效 key必须大于等于0
     * @return
     */
    public boolean set(String key, Object value, long time){
        try {
            if(time == CacheTime.CACHE_EXP_FOREVER){
                redisTemplate.opsForValue().set(key,value);
            }else{
                redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);
            }
            return true;
        }catch(Exception e){
            logger.error("RedisClient中的set方法出错：", e);
        }
        return false;
    }

    /**
     * 获取指定key的值
     *
     * @param key
     * @param <T>
     * @return
     */
    public <T> T get(String key){
        return key == null? null: (T) redisTemplate.opsForValue().get(key);
    }

    /**
     * 将key中储存的值的缓存时间增加
     *
     * @param key
     * @param delta 增加多少（大于0）
     * @return
     */
    public long incr(String key, long delta){
        if(delta <= 0){
            throw new IllegalArgumentException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 将key中的储存的缓存时间减少
     *
     * @param key
     * @param delta 减少多少 （大于0）
     * @return
     */
    public long decr(String key, long delta){
        if(delta <= 0){
            throw new IllegalArgumentException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().decrement(key, delta);
    }

    /**
     * 将hash表中的key对应的field字段的值设置为value
     *
     * @param key
     * @param field 字段
     * @param value
     * @param time  时间(秒) 注意:如果已存在的hash表有时间,这里将会替换原有的时间
     * @return
     */
    public boolean hset(String key,String field, Object value,long time){
        try{
            redisTemplate.opsForHash().put(key,field,value);
            if(time != CacheTime.CACHE_EXP_FOREVER){
                // 指定缓存失效时间
                expire(key,time);
            }
            return true;
        }catch (Exception e){
            logger.error("RedisClient中的hset方法出错：", e);
        }
        return false;
    }

    /**
     * 同时将多个 field-value (域-值)对设置到哈希表 key 中
     *
     * @param key
     * @param map 对应多个键值
     * @param time
     * @return
     */
    public boolean hmset(String key, Map<String,Object> map, long time){
        try{
            redisTemplate.opsForHash().putAll(key,map);
            if(time != CacheTime.CACHE_EXP_FOREVER){
                // 指定缓存失效时间
                expire(key,time);
            }
            return true;
        }catch(Exception e){
            logger.error("RedisClient中的hmset方法出错：", e);
        }
        return false;
    }

    /**
     * 删除一个或多个哈希表字段
     *
     * @param key
     * @param field
     */
    public void hdel(String key,Object... field){
        redisTemplate.opsForHash().delete(key,field);
    }

    /**
     * 获取存储在hash表中指定字段的值
     *
     * @param key
     * @param field
     * @param <T>
     * @return
     */
    public <T> T hget(String key,Object field){
        return (T) redisTemplate.opsForHash().get(key,field);
    }

    /**
     * 获取在hash表中所有字段和值
     *
     * @param key
     * @return
     */
    public Map<Object,Object> hmget(String key){
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 查看hash表 key中指定字段是否存在
     *
     * @param key
     * @param field
     * @return
     */
    public boolean hexists(String key, Object field){
        return redisTemplate.opsForHash().hasKey(key,field);
    }

    /**
     * 获取hash表中字段的数量
     *
     * @param key
     * @return
     */
    public long hlen(String key){
        return redisTemplate.opsForHash().size(key);
    }

    /**
     * 向集合中添加一个或多个成员
     *
     * @param key
     * @param time 缓存时间
     * @param value 成员 可以是多个
     * @return
     */
    public long sadd(String key, long time, Object... value){
        try{
            long count = redisTemplate.opsForSet().add(key,value);
            if(time != CacheTime.CACHE_EXP_FOREVER){
                expire(key, time);
            }
            return count;
        }catch(Exception e){
            logger.error("RedisClient中的sadd方法出错：", e);
        }
        return 0L;
    }

    /**
     * 移除集合中一个或多个成员
     *
     * @param key
     * @param value 成员，可以是多个
     * @return
     */
    public long srem(String key, Object... value){
        try {
            return redisTemplate.opsForSet().remove(key,value);
        }catch (Exception e){
            logger.error("RedisClient中的srem方法出错：", e);
        }
        return 0L;
    }

    /**
     * 返回 集合中所有的成员
     *
     * @param key
     * @param <T>
     * @return
     */
    public <T> Set<T> smembers(String key){
        return (Set<T>) redisTemplate.opsForSet().members(key);
    }

    /**
     * 判断member元素是否是key中的成员
     *
     * @param key
     * @param member
     * @return
     */
    public boolean sismember(String key,Object member){
        try {
            return redisTemplate.opsForSet().isMember(key, member);
        }catch(Exception e){
            logger.error("RedisClient中的sismember方法出错：", e);
        }
        return false;
    }

    /**
     * 获取集合的成员数
     *
     * @param key
     * @return
     */
    public long slen(String key){
        try{
            return redisTemplate.opsForSet().size(key);
        }catch(Exception e){
            logger.error("RedisClient中的slen方法出错：", e);
        }
        return 0L;
    }

    /**
     * 在列表头部添加一个值
     *
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean lpush(String key,Object value,long time){
        try{
            redisTemplate.opsForList().leftPush(key,value);
            if(time != CacheTime.CACHE_EXP_FOREVER){
                expire(key,time);
            }
            return true;
        }catch(Exception e){
            logger.error("RedisClient中的lpush方法出错：", e);
        }
        return false;
    }

    /**
     * 在列表头部添加多个值
     *
     * @param key
     * @param values
     * @param time
     * @return
     */
    public boolean lpush(String key, List<Object> values, long time){
        try{
            redisTemplate.opsForList().leftPushAll(key,values);
            if(time != CacheTime.CACHE_EXP_FOREVER){
                expire(key,time);
            }
            return true;
        }catch(Exception e){
            logger.error("RedisClient中的lpush方法出错：", e);
        }
        return false;
    }

    /**
     * 在列表尾部添加一个值
     *
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean rpush(String key,Object value,long time){
        try{
            redisTemplate.opsForList().rightPush(key,value);
            if(time != CacheTime.CACHE_EXP_FOREVER){
                expire(key,time);
            }
            return true;
        }catch(Exception e){
            logger.error("RedisClient中的rpush方法出错：", e);
        }
        return false;
    }

    /**
     * 在列表尾部添加多个值
     *
     * @param key
     * @param values
     * @param time
     * @return
     */
    public boolean rpush(String key,List<Object> values,long time){
        try{
            redisTemplate.opsForList().rightPushAll(key,values);
            if(time != CacheTime.CACHE_EXP_FOREVER){
                expire(key,time);
            }
            return true;
        }catch(Exception e){
            logger.error("RedisClient中的rpush方法出错：", e);
        }
        return false;
    }

    /**
     * 移除列表元素
     *
     * @param key
     * @param count 移除元素的个数
     * @param value
     * @return
     */
    public long lrem(String key, long count, Object value){
        try{
            return redisTemplate.opsForList().remove(key,count,value);
        }catch(Exception e){
            logger.error("RedisClient中的lrem方法出错：", e);
        }
        return 0L;
    }

    /**
     * 通过索引设置列表元素的值
     *
     * @param key
     * @param index
     * @param value
     * @return
     */
    public boolean lset(String key,long index,Object value){
        try{
            redisTemplate.opsForList().set(key,index,value);
            return true;
        }catch (Exception e){
            logger.error("RedisClient中的lset方法出错：", e);
        }
        return false;
    }

    /**
     * 获取列表指定范围内的元素
     *
     * @param key
     * @param start 开始
     * @param end  结束 0 到 -1代表所有值
     * @param <T>
     * @return
     */
    public <T> List<T> lrange(String key, long start, long end){
        try{
            return (List<T>) redisTemplate.opsForList().range(key,start,end);
        }catch (Exception e){
            logger.error("RedisClient中的lrange方法出错：", e);
        }
        return null;
    }

    /**
     * 通过索引获取列表中的元素
     *
     * @param key
     * @param index 索引值 索引 index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    public Object lindex(String key, long index){
        try {
            return redisTemplate.opsForList().index(key, index);
        }catch(Exception e){
            logger.error("RedisClient中的lindex方法出错：", e);
        }
        return null;
    }

    /**
     * 获取列表长度
     *
     * @param key
     * @return
     */
    public long llen(String key){
        try {
            return redisTemplate.opsForList().size(key);
        }catch(Exception e){
            logger.error("RedisClient中的llen方法出错：", e);
        }
        return 0L;
    }

    /**
     * 向有序集合添加一个成员，或者更新已存在成员的分数
     *
     * @param key
     * @param time
     * @param member
     * @param score 分数
     * @return
     */
    public boolean zadd(String key,long time,Object member, double score){
        try{
            boolean ret = redisTemplate.opsForZSet().add(key,member,score);
            if(time != CacheTime.CACHE_EXP_FOREVER){
                expire(key,time);
            }
            return ret;
        }catch (Exception e){
            logger.error("RedisClient中的zadd方法出错：", e);
        }
        return false;
    }

    /**
     * 移除有序集合中一个或多个成员
     *
     * @param key
     * @param value
     * @return
     */
    public long zrem(String key, Object... value){
        try {
            return redisTemplate.opsForZSet().remove(key, value);
        }catch (Exception e){
            logger.error("RedisClient中的zrem方法出错：", e);
        }
        return 0L;
    }

    /**
     * 通过索引区间返回有序集合成指定区间内的成员 分数从低到高
     *
     * @param key
     * @param start
     * @param end  结束 0 到 -1代表所有值
     * @return
     */
    public Set<Object> zrange(String key,long start,long end){
        try {
            return redisTemplate.opsForZSet().range(key, start, end);
        }catch (Exception e){
            logger.error("RedisClient中的zrange方法出错：", e);
        }
        return null;
    }

    /**
     * 通过索引区间返回有序集合成指定区间内的成员 分数从高到低
     *
     * @param key
     * @param start
     * @param end  结束 0 到 -1代表所有值
     * @return
     */
    public Set<Object> zrevrange(String key,long start,long end){
        try {
            return redisTemplate.opsForZSet().range(key, start, end);
        }catch (Exception e){
            logger.error("RedisClient中的zrevrange方法出错：", e);
        }
        return null;
    }

    /**
     * 返回有序集合中某个成员的分数值
     *
     * @param key    键
     * @param member 成员
     * @return 分数值
     */
    public double zscore(String key, Object member){
        try {
            return redisTemplate.opsForZSet().score(key, member);
        }catch (Exception e){
            logger.error("RedisClient中的zscore方法出错：", e);
        }
        return 0.0;
    }

    /**
     * 判断有序集合中某个成员是否存在
     *
     * @param key
     * @param member
     * @return
     */
    public boolean zexist(String key,Object member){
        try{
            return  null != redisTemplate.opsForZSet().score(key, member);
        }catch (Exception e){
            logger.error("RedisClient中的zexist方法出错：", e);
        }
        return false;
    }

    /**
     * 获取有序集合的成员数
     *
     * @param key
     * @return
     */
    public long zlen(String key){
        try{
            return redisTemplate.opsForZSet().size(key);
        }catch (Exception e){
            logger.error("RedisClient中的zlen方法出错：", e);
        }
        return 0L;
    }

}
