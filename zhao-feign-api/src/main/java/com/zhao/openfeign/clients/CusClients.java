package com.zhao.openfeign.clients;

import com.zhao.entity.cus.Customer;
import com.zhao.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "zhao-cus",path = "/cus")
public interface CusClients {
    @GetMapping("/customer/qryCustomerById/{id}")
    R<Customer> queryById(@PathVariable("id") Long id);
}
