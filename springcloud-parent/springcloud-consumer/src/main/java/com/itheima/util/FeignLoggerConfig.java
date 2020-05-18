package com.itheima.util;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLoggerConfig {

    /**
     * 定义feign的日志级别
     * @return
     */
    @Bean
    public Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }
}
