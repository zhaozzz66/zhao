package com.zhao.service;

import com.github.pagehelper.PageInfo;
import com.zhao.entity.cus.Customer;
import com.zhao.utils.PageRequest;

/**
 * customer(Customer)表服务接口
 *
 * @author makejava
 * @since 2024-03-01 15:24:56
 */
public interface CustomerService {

    /**
     * 通过ID查询单条数据
     *
     * @param custId 主键
     * @return 实例对象
     */
    Customer queryById(Long custId);

    /**
     * 分页查询
     *
     * @param customer 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    PageInfo<Customer> queryByPage(Customer customer, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param customer 实例对象
     * @return 实例对象
     */
    Customer insert(Customer customer);

    /**
     * 修改数据
     *
     * @param customer 实例对象
     * @return 实例对象
     */
    Customer update(Customer customer);

    /**
     * 通过主键删除数据
     *
     * @param custId 主键
     * @return 是否成功
     */
    boolean deleteById(Long custId);

}
