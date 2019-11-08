package com.charli.common.tools;

import org.apache.log4j.Logger;

import java.util.Map;
import java.util.Set;

/**
 * @Description : 
 * @Author xiaoli.cheng
 * @Date 2019/11/8 11:08
 */
public class MapUtil {

    private static Logger logger = Logger.getLogger(MapUtil.class);

    /**
     * 根据Map中的key对应对象的属性来更新对象的值
     * <li>
     *      updateProperties中的key必须跟bean中的字段名保持一致才能更新
     * </li>
     * @param updateProperties 要更新的字段以及值
     * @param bean 要更新的对象
     */
    public static <T> void copyPropertiesInclude(Map<String, Object> updateProperties, T bean){
        Set<Map.Entry<String, Object>> revisabilityFiledSet = updateProperties.entrySet();
        for (Map.Entry<String, Object> entry : revisabilityFiledSet) {
            Object value = entry.getValue();
            if(value != null){
                try {
                    org.apache.commons.beanutils.BeanUtils.setProperty(bean, entry.getKey(), value);
                } catch (Exception e) {
                    logger.error("从Map"+updateProperties.getClass()+" 复制 到对象 "+bean.getClass()+" 属性"+entry.getKey()+" 错误key"+e+" 异常");
                }
            }
        }
    }
}
