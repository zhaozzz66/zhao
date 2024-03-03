package com.zhao.service;


import com.github.pagehelper.PageInfo;
import com.zhao.entity.cus.CustContactInfoRel;
import com.zhao.utils.PageRequest;

/**
 * cust_contact_info_rel(CustContactInfoRel)表服务接口
 *
 * @author makejava
 * @since 2024-03-01 15:24:56
 */
public interface CustContactInfoRelService {

    /**
     * 通过ID查询单条数据
     *
     * @param custConnectId 主键
     * @return 实例对象
     */
    CustContactInfoRel queryById(Long custConnectId);

    /**
     * 分页查询
     *
     * @param custContactInfoRel 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    PageInfo<CustContactInfoRel> queryByPage(CustContactInfoRel custContactInfoRel, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param custContactInfoRel 实例对象
     * @return 实例对象
     */
    CustContactInfoRel insert(CustContactInfoRel custContactInfoRel);

    /**
     * 修改数据
     *
     * @param custContactInfoRel 实例对象
     * @return 实例对象
     */
    CustContactInfoRel update(CustContactInfoRel custContactInfoRel);

    /**
     * 通过主键删除数据
     *
     * @param custConnectId 主键
     * @return 是否成功
     */
    boolean deleteById(Long custConnectId);

}
