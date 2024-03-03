package com.zhao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@MapperScan("com.zhao.mapper")
@SpringBootApplication
public class ZhaoCusApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhaoCusApplication.class, args);
    }

}
