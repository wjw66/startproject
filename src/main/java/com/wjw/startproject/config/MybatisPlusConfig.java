package com.wjw.startproject.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : wjwjava01@163.com
 * @date : 0:58 2020/4/19
 * @description : Mybatis Plus配置
 */
@Configuration
public class MybatisPlusConfig {
    /**
     * 开启mybatis plus的乐观锁配置
     *
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * 配置自动每次查询的总条数:total
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();

        //数据库类型配置
        paginationInterceptor.setDbType(DbType.MYSQL);
        return paginationInterceptor;
    }
}
