package com.zhao.order.controller;

import com.zhao.openfeign.clients.CusClients;
import com.zhao.entity.cus.Customer;
import com.zhao.utils.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/ord/api/v1")
public class TestController {

    @Resource
    private CusClients clients;

    @GetMapping("/qryCustomerById/{id}")
    public R<Customer> qryCustData(@PathVariable("id") Long id){
        return clients.queryById(id);
    }
}
