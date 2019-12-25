package com.charli.provider.mybatistest;

import com.charli.provider.model.T_entity;
import com.charli.provider.service.T_service;
import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

/**
 * @Description : 
 * @Author xiaoli.cheng
 * @Date 2019/12/24 17:32
 */
public class ApplicationContext {

//    配置自己的即可 , 在自己电脑随便搭建了一个

   private static final String driver ="com.mysql.jdbc.Driver";
   private static final String url = "jdbc:mysql://192.168.101.217:3308/test";
   private static final String username = "dev";
   private static final String password = "x1skrFBxdtFl3p4G";


    public static void main(String[] args) {
//      init datasource
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

//		事务
        TransactionFactory transactionFactory =
                new JdbcTransactionFactory();
//		环境-事务-数据源
        Environment environment =
                new Environment("development", transactionFactory, dataSource);
//		整个配置
        Configuration configuration = new Configuration(environment);
//		打印sql
//        configuration.setLogImpl(Log4j2Impl.class);
//		dao缓存
        configuration.addMapper(T_dao.class);
//		初始化mybatis的工厂
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(configuration);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        T_dao mapper = sqlSession.getMapper(T_dao.class);

        T_service t_service = new T_service();

        t_service.setT_dao(mapper);

        t_service.query();
//        t_service.query();
        t_service.update();

        sqlSession.close();
        //一级缓存 , 跟session有关的(相当于里面有一个map,key是sql语句,value是结果) , 如果这里close了,
        // 以及缓存就失效了,这样再调用语句的时候需要申请两个sqlsession了, 这样就会查两次语句

//        二级缓存是cacheNameSpace 这个是在同一作用域下的, 会缓存同一nameSpace下的语句 如果注解打开了,
//        那么当同时调用两次查询时候, 第一次从数据库中拿 , 第二次就不会打印sql语句了, 因为是从缓存中拿的

        SqlSession sqlSession1 = sqlSessionFactory.openSession();

        T_dao mapper1 = sqlSession1.getMapper(T_dao.class);

        T_service t_service1 = new T_service();
        t_service1.setT_dao(mapper1);
        t_service1.query();

    }
}
