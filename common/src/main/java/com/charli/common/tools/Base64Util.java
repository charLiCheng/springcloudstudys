package com.charli.common.tools;

import com.charli.common.constant.CacheConstant;
import org.apache.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;

import java.nio.charset.Charset;

/**
 * @Description : 
 * @Author xiaoli.cheng
 * @Date 2019/11/8 11:06
 */
public final class Base64Util {
    private final static Logger logger = Logger.getLogger(Base64Util.class);

    /**
     * 生成操作唯一码
     *
     * @param prefix 模型编号
     * @return uid
     */
    public static String generateCode(String prefix, String username) {
        // 将用户名 + 时间戳base64转码
        return Base64.encodeBase64String((prefix + CacheConstant.DELIMITER_CACHE + username + System.currentTimeMillis()).getBytes(Charset.forName("UTF-8")));
    }

}
