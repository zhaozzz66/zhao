package com.zhao.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Slf4j
public class RedisUtil {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 设置指定 key 的值
     *
     */
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置指定 key 的值
     *
     * @param time  缓存失效时间(秒)
     */
    public void set(String key, String value, long time) {
        stringRedisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    /**
     * 指定 key 的值自增
     *
     */
    public Long incr(String key, Long value) {
        if (value == null) {
            return stringRedisTemplate.opsForValue().increment(key, 1L);
        }
        if (value < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return stringRedisTemplate.opsForValue().increment(key, value);
    }

    /**
     * 指定 key 的值自增
     *
     * @param time  缓存失效时间(秒)
     */
    public Long incr(String key, Long value, long time) {
        Long val = incr(key, value);
        setExpire(key, time);
        return val;
    }

    /**
     * 从右边插入一个集合
     *
     */
    public Long setList(String key, List<String> list) {
        return stringRedisTemplate.opsForList().rightPushAll(key, list);
    }

    /**
     * 获取指定 key 的值
     *
     */
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 获取list缓存的内容
     *
     * @param key   键
     * @param start 开始
     * @param end   结束 0 到 -1代表所有值
     */
    public List<String> getList(String key, long start, long end) {
        return stringRedisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 模糊删除key
     *
     */
    public Long removeKeysByPrefix(String keyPrefix) {
        Set<String> keys = stringRedisTemplate.keys(keyPrefix + "*");
        if (CollectionUtils.isEmpty(keys)) {
            return 0L;
        }
        return stringRedisTemplate.delete(keys);
    }

    /**
     * 删除key
     *
     */
    public Boolean delete(String key) {
        return stringRedisTemplate.delete(key);
    }

    /**
     * 判断key是否存在
     *
     */
    public boolean exists(String key) {
        return Boolean.TRUE.equals(stringRedisTemplate.hasKey(key));
    }

    /**
     * 判断key是否过期
     *
     * @return true-过期/不存在; false-有效;
     */
    /*public boolean expires(String key) {
        return getExpireTime(key) <= 0 && getExpireTime(key) != -1;
    }*/

    /**
     * 从redis中获取key对应的过期时间
     * 没有设置过期时间，则返回-1;
     * key不存在，则返回-2;
     *
     */
    /*public long getExpireTime(String key) {
        return stringRedisTemplate.opsForValue().getOperations().getExpire(key);
    }*/

    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间(秒)
     */
    public boolean setExpire(String key, long time) {
        try {
            if (time > 0) {
                stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.error("redis设置缓存失效时间时异常, key:{}, time:{}.", key, time, e);
            return false;
        }
    }
}
