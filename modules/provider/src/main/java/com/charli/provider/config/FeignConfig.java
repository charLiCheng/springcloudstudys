package com.charli.provider.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @description: 解决Feign进行内部服务调用发生401错误
 * @author: xiaoli.cheng
 * @date: 2018/12/29
 */
@Configuration
public class FeignConfig implements RequestInterceptor {


    @Override
    public void apply(RequestTemplate requestTemplate) {
        //获取request
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
//                .getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//
//        //添加头部
//        Enumeration<String> headerNames = request.getHeaderNames();
//        if (headerNames != null) {
//            while (headerNames.hasMoreElements()) {
//                String name = headerNames.nextElement();
//                String values = request.getHeader(name);
//                requestTemplate.header(name, values);
//            }
//        }
//
//        //添加body
//        Enumeration<String> bodyNames = request.getParameterNames();
//        StringBuffer body = new StringBuffer();
//        if (bodyNames != null) {
//            while (bodyNames.hasMoreElements()) {
//                String name = bodyNames.nextElement();
//                String values = request.getParameter(name);
//                //添加参数
//                requestTemplate.query(name,values);
//                //自定义加的
//                body.append(name).append("=").append(values).append("&");
//            }
//        }
//        if (body.length() != 0) {
//            //自定义加的,只是用来做判断的可以不用
//            body.deleteCharAt(body.length() - 1);
//            //有需要可以判断完接着再添加参数这个参数是在body中
//            requestTemplate.query("token",request.getParameter("token"));
//        }


//        下面是通过restTemplate获取head信息,body信息,或者往head和body里放信息

//        设置头部信息
        requestTemplate.header("token","dksjlakdjfakw#jk$%&klda");

//        解析body
        byte[] body = requestTemplate.body();
        String s = new String(body);
        JSONObject json = JSON.parseObject(s);
        json.put("mobile","13564897546");
        s = JSON.toJavaObject(json, String.class);
//        放置body信息
        requestTemplate.body(s);

    }

}
