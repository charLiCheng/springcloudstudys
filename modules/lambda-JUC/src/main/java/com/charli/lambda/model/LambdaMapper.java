package com.charli.lambda.model;

import java.util.List;

/**
 * @Description : 
 * @Author xiaoli.cheng
 * @Date 2020/4/10 20:55
 */
public interface LambdaMapper {

    /**
     * 查询所有
     * @param params
     * @return
     */
    List<Params> selectByParams(Params params);
}
