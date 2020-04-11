package com.charli.consumer.service.impl;

import com.charli.consumer.service.LambdaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description : 
 * @Author xiaoli.cheng
 * @Date 2020/4/10 20:56
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LambdaServiceImpl implements LambdaService {

}
