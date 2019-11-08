package com.charli.common.constant;


public class CacheConstant {

    //===========缓存key前缀==============================
    //-------------------------------------------------

    /**
     * 缓存key前缀｛分隔符｝
     */
    public static final String DELIMITER_CACHE = ":";

    //===========缓存key前缀==============================

    /**
     * 盐
     */
    public static final String SALT = "ds^#(&(@)%%#fdas2#@@$";


    /**
     * （用户登录信息）缓存数据过期时间单位秒
     */
    public static final long LOGIN_INFO_TIMEOUT = 1800;
    /**
     * Excel导入数据缓存过期时间（单位秒）
     */
    public static final long UPLOAD_DATA_TIMEOUT = 43200;


}
