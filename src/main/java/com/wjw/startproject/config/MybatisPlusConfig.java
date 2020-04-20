package com.wjw.startproject.config;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
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
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }
}
