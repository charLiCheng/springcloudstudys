package com.charli.lambda.service.impl;

import com.charli.lambda.model.Params;
import com.charli.lambda.service.LambdaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description : 
 * @Author xiaoli.cheng
 * @Date 2020/4/10 20:56
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LambdaServiceImpl implements LambdaService {


    @Override
    public List<Params> selectByParams(Params params) {

        return null;
    }
}
