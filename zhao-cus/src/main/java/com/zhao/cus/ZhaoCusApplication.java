package com.zhao.cus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.zhao.cus.mapper")
@SpringBootApplication
public class ZhaoCusApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhaoCusApplication.class, args);
    }

}
