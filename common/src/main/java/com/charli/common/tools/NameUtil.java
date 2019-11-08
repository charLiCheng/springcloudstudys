package com.charli.common.tools;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * @Description : 
 * @Author xiaoli.cheng
 * @Date 2019/11/8 11:10
 */
public final class NameUtil {
    private final static Logger logger = Logger.getLogger(NameUtil.class);

    /**
     * 小驼峰转大驼峰
     *
     * @param name
     * @return
     */
    public static String smallHumpToBigHump(String name) {
        if (StringUtils.isBlank(name) || Character.isUpperCase(name.charAt(0))) {
            return name;
        }
        return (new StringBuilder()).append(Character.toUpperCase(name.charAt(0))).append(name.substring(1)).toString();
    }

    /**
     * 大驼峰转小驼峰
     *
     * @param name
     * @return
     */
    public static String bigHumpToSmallHump(String name) {
        if (StringUtils.isBlank(name) || Character.isLowerCase(name.charAt(0))) {
            return name;
        }
        return (new StringBuilder()).append(Character.toLowerCase(name.charAt(0))).append(name.substring(1)).toString();
    }

}
