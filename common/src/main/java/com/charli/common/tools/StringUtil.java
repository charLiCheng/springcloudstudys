package com.charli.common.tools;

import com.charli.common.constant.Constant;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description : 字符串工具类
 * @Author xiaoli.cheng
 * @Date 2019/11/8 11:12
 */
public class StringUtil {

    /*
     * 判断字符串是否为空
     * */
    public static boolean isBlank(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }
        return false;
    }

    /*
     * 判断字符串是否为空或者NULL
     * */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str) || "NULL".equals(str)) {
            return true;
        }
        return false;
    }

    /*
     * 判断字符串是否可以转为int
     * */
    public static boolean isStr2Int(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
     * 判断字符串是否可以转为float
     * */
    public static boolean isStr2Float(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /*
     * 判断字符串是否可以转为double
     * */
    public static boolean isStr2Double(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static String parseNull(Object object) {
        if (object == null) {
            return "";
        } else {
            return object.toString();
        }
    }

    /**
     * map.toString()字符串转换为 Map<String,Integer>
     *
     * @param str
     * @return Map<String                                                                                                                                                                                                                                                               ,                                                                                                                                                                                                                                                               Integer>
     */
    public static Map<String, Integer> mapStrToMap(String str) {
        Map<String, Integer> map = new HashMap<>(Constant.INT_SIXTEEN);

        if (!isBlank(str)) {
            str = str.substring(1, str.length() - 1);
            String[] strArr = str.split(",");
            for (String s : strArr) {
                String[] keyValue = s.split("=");
                if (keyValue.length < 2) {
                    continue;
                }
                map.put(keyValue[0].trim(), Integer.parseInt(keyValue[1]));
            }
        }
        return map;
    }

    /**
     * 驼峰转下划线：简单写法，效率低于humpToLine2(String)
     *
     * @param str
     * @return
     */
    public static String humpToLine(String str) {
        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
    }

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 驼峰转下划线,效率比humpToLine高
     *
     * @param str
     * @return
     */
    public static String humpToLine2(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 根据uid获取模型
     *
     * @param uid
     * @return
     */
    public static String getModelByUid(String uid) {
        return StringUtils.substringBefore(uid, ":");
    }

}
