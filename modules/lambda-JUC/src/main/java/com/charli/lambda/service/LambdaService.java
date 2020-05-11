package com.charli.lambda.service;

import com.charli.lambda.model.Params;

import java.util.List;

/**
 * @Description : 
 * @Author xiaoli.cheng
 * @Date 2020/4/10 20:55
 */
public interface LambdaService {

    /**
     * 查询所有
     * @param params
     * @return
     */
    List<Params> selectByParams(Params params);
}
