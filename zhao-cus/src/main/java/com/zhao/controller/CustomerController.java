package com.zhao.controller;

import com.github.pagehelper.PageInfo;
import com.zhao.entity.cus.Customer;
import com.zhao.service.CustomerService;
import com.zhao.utils.PageRequest;
import com.zhao.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * customer(Customer)表控制层
 *
 * @author makejava
 * @since 2024-03-01 15:24:56
 */
@RestController
@RequestMapping("/cus/customer")
public class CustomerController {
    /**
     * 服务对象
     */
    @Resource
    private CustomerService customerService;

    /**
     * 分页查询
     *
     * @param customer 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("/qryCustomer")
    public R<PageInfo<Customer>> queryByPage(Customer customer, PageRequest pageRequest) {
        return R.success(this.customerService.queryByPage(customer, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/qryCustomerById/{id}")
    public R<Customer> queryById(@PathVariable("id") Long id) {
        return R.success(this.customerService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param customer 实体
     * @return 新增结果
     */
    @PostMapping("/addCustomer")
    public R<Customer> add(Customer customer) {
        return R.success(this.customerService.insert(customer));
    }

    /**
     * 编辑数据
     *
     * @param customer 实体
     * @return 编辑结果
     */
    @PostMapping("/updCustomer")
    public R<Customer> edit(Customer customer) {
        return R.success(this.customerService.update(customer));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delCustomerById")
    public R<Boolean> deleteById(Long id) {
        return R.success(this.customerService.deleteById(id));
    }

}

