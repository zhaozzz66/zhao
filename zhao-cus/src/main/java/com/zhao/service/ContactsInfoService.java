package com.zhao.service;

import com.github.pagehelper.PageInfo;
import com.zhao.entity.cus.ContactsInfo;
import com.zhao.utils.PageRequest;

/**
 * contacts_info(ContactsInfo)表服务接口
 *
 * @author makejava
 * @since 2024-03-01 15:24:55
 */
public interface ContactsInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param contactId 主键
     * @return 实例对象
     */
    ContactsInfo queryById(Long contactId);

    /**
     * 分页查询
     *
     * @param contactsInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    PageInfo<ContactsInfo> queryByPage(ContactsInfo contactsInfo, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param contactsInfo 实例对象
     * @return 实例对象
     */
    ContactsInfo insert(ContactsInfo contactsInfo);

    /**
     * 修改数据
     *
     * @param contactsInfo 实例对象
     * @return 实例对象
     */
    ContactsInfo update(ContactsInfo contactsInfo);

    /**
     * 通过主键删除数据
     *
     * @param contactId 主键
     * @return 是否成功
     */
    boolean deleteById(Long contactId);

}
