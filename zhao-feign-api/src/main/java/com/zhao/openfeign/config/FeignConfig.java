package com.zhao.openfeign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

public class FeignConfig {
    /**
     * NONE 默认的不显示任何日志
     * BASIC 仅记录请求方法，rul，响应状态码及执行时间
     * HEADERS 除了BASIC中定义的信息之外还有请求和响应的头信息
     * FULL 除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
