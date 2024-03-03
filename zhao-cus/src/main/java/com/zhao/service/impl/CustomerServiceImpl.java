package com.zhao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhao.entity.cus.Customer;
import com.zhao.mapper.CustomerMapper;
import com.zhao.service.CustomerService;
import com.zhao.utils.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * customer(Customer)表服务实现类
 *
 * @author makejava
 * @since 2024-03-01 15:24:56
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param custId 主键
     * @return 实例对象
     */
    @Override
    public Customer queryById(Long custId) {
        return this.customerMapper.queryById(custId);
    }

    /**
     * 分页查询
     *
     * @param customer 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public PageInfo<Customer> queryByPage(Customer customer, PageRequest pageRequest) {
        PageInfo<Customer> customerPageInfo = new PageInfo<>();
        Page<Object> objects = PageHelper.startPage(pageRequest.getStartIndex(), pageRequest.getPageSize());
        List<Customer> customers = this.customerMapper.queryAllByLimit(customer);
        customerPageInfo.setList(customers);
        customerPageInfo.setTotal(objects.getTotal());
        return customerPageInfo;
    }

    /**
     * 新增数据
     *
     * @param customer 实例对象
     * @return 实例对象
     */
    @Override
    public Customer insert(Customer customer) {
        this.customerMapper.insert(customer);
        return customer;
    }

    /**
     * 修改数据
     *
     * @param customer 实例对象
     * @return 实例对象
     */
    @Override
    public Customer update(Customer customer) {
        this.customerMapper.update(customer);
        return this.queryById(customer.getCustId());
    }

    /**
     * 通过主键删除数据
     *
     * @param custId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long custId) {
        return this.customerMapper.deleteById(custId) > 0;
    }
}
