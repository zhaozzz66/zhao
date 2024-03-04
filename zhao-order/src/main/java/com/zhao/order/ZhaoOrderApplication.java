package com.zhao.order;

import com.zhao.openfeign.clients.CusClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(clients = {CusClients.class})
@SpringBootApplication
public class ZhaoOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhaoOrderApplication.class, args);
    }

}
