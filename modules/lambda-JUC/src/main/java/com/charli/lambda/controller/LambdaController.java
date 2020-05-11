package com.charli.lambda.controller;

import com.charli.common.response.CommonResponse;
import com.charli.lambda.model.Params;
import com.charli.lambda.service.LambdaService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description :
 * @Author xiaoli.cheng
 * @Date 2019/11/12 17:07
 */
@RestController
@RequestMapping("/api/v1")
public class LambdaController {

    @Autowired
    private LambdaService lambdaService;

    @RequestMapping(value = "/checked-out")
    public String checkedOut() {
        return "Spring Boot in Action";
    }

    /**
     * 测试hystrix 方法抛异常熔断启动
     *
     * @return
     */
    @RequestMapping("/recommended")
    public String readingList() {
        int i = 0;
        Assert.isNull(i, "不是空的, 错了");
        return "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)";
    }


    /**
     * Feign
     *
     * @return
     */
    @RequestMapping("/getDatabaseInfo")
    public Params getDatabaseInfo(@RequestBody Params params) {

        Long id = params.getId();
        params.setPassword("6666666");
        params.setEmail("334567463@qq,com");

        return params;
    }

    @ApiOperation(value = "jdk8四大函数", notes = "jdk8四大函数", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true, dataType = "Long")
    })
    @RequestMapping("/getDatabaseInfo")
    public CommonResponse getUserInfo(Params params) {
        List<Params> list = lambdaService.selectByParams(params);
        return CommonResponse.success(list);
    }
}
