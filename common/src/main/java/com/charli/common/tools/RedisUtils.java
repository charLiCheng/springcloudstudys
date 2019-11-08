package com.charli.common.tools;

import com.charli.common.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Description : 
 * @Author xiaoli.cheng
 * @Date 2019/11/8 11:10
 */
@Component
public class RedisUtils {

    /**
     * 默认过期时间
     */
    private static final int EXPIRE_TIME = Constant.LOGIN_EXPIRE_TIME;


    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 判断key是否存在
     *
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

}
