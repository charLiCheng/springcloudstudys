package com.charli.common.tools;

import org.apache.commons.lang.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @Description : 
 * @Author xiaoli.cheng
 * @Date 2019/11/8 11:10
 */
public class ParamUtils {

    //获得对象的属性数组
    private static String[] getFiledName(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            fieldNames[i] = fields[i].getName();
        }
        return fieldNames;
    }

    //通过属性和对象获得属性值
    private static Object getFieldValueByName(String fieldName, Object o) {
        try {
            if (StringUtils.isBlank(fieldName)){
                return null;
            }
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter);
            Object value = method.invoke(o);
            return value;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List limitPage(List list, int start, int length) {
        int end;
        //null值判断
        if (list == null) {
            return null;
        }
        //如果start大于list的长度则从0开始
        if (list.size() < start) {
            start = 0;
        }
        //如果截取的长度大于list的size则为size
        end = start + length > list.size() ? list.size() : start + length;
        return list.subList(start, end);
    }

}
