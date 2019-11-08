package com.charli.common.tools;

import java.lang.reflect.Field;

/**
 * @Description : 判断一个实体类对象实例的所有成员变量是否为空
 * @Author xiaoli.cheng
 * @Date 16:10 2019/6/26
 */
public class EntityUtil {

    public static Boolean isEntityFieldEmpty(Object obj){
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    if (field.get(obj) == null || field.get(obj) == "" || "null".equalsIgnoreCase((String)field.get(obj))) {
                        return true;
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
