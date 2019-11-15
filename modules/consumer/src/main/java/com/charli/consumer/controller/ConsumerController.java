package com.charli.consumer.controller;

import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description :
 * @Author xiaoli.cheng
 * @Date 2019/11/12 17:07
 */
@RestController
public class ConsumerController {

    @RequestMapping(value = "/checked-out")
    public String checkedOut() {
        return "Spring Boot in Action";
    }

    /**
     * 测试hystrix 方法抛异常熔断启动
     * @return
     */
    @RequestMapping("/recommended")
    public String readingList() {
        int i = 0;
        Assert.isNull(i,"不是空的, 错了");
        return "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)";
    }
}
