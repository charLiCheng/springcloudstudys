package com.charli.lambda.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
@Slf4j
public class AspectLog {

    @Pointcut("@annotation(com.charli.lambda.aop.TagLog)")
    public void PointCutof(){}

    //拦截@注解的方法
    @AfterReturning(value="PointCutof()",returning = "ret")
    public void afterReturn (JoinPoint joinPoint, Object ret){
        //获取参数
        Object[] objs=joinPoint.getArgs();
        //获取返回值
        Object obj=objs[0];
//        Map<String ,Object> inMap= getParameter(obj);
//        Map<String ,Object> outMap= getParameter(ret);
        log.info("入参======{}",obj);
        log.info("出参======{}",ret);
    }

    //拓展日志的功能，对拦截的入参进行反射获取信息
    private Map<String, Object> getParameter(Object obj) {
        try {
            //反射对象中的属性
            Class clazz=obj.getClass();
            Field[] fields= clazz.getDeclaredFields();
            Map<String,Object> resultMap=new HashMap<String, Object>(2);

            return resultMap;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
