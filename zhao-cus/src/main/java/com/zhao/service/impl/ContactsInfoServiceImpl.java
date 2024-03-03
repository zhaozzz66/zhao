package com.zhao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhao.entity.cus.ContactsInfo;
import com.zhao.mapper.ContactsInfoMapper;
import com.zhao.service.ContactsInfoService;
import com.zhao.utils.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * contacts_info(ContactsInfo)表服务实现类
 *
 * @author makejava
 * @since 2024-03-01 15:24:56
 */
@Service("contactsInfoService")
public class ContactsInfoServiceImpl implements ContactsInfoService {
    @Resource
    private ContactsInfoMapper contactsInfoMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param contactId 主键
     * @return 实例对象
     */
    @Override
    public ContactsInfo queryById(Long contactId) {
        return this.contactsInfoMapper.queryById(contactId);
    }

    /**
     * 分页查询
     *
     * @param contactsInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public PageInfo<ContactsInfo> queryByPage(ContactsInfo contactsInfo, PageRequest pageRequest) {
        PageInfo<ContactsInfo> contactsInfoPageInfo = new PageInfo<>();
        Page<Object> objects = PageHelper.startPage(pageRequest.getStartIndex(), pageRequest.getPageSize());
        List<ContactsInfo> contactsInfos = this.contactsInfoMapper.queryAllByLimit(contactsInfo);
        contactsInfoPageInfo.setList(contactsInfos);
        contactsInfoPageInfo.setTotal(objects.getTotal());
        return contactsInfoPageInfo;
    }

    /**
     * 新增数据
     *
     * @param contactsInfo 实例对象
     * @return 实例对象
     */
    @Override
    public ContactsInfo insert(ContactsInfo contactsInfo) {
        this.contactsInfoMapper.insert(contactsInfo);
        return contactsInfo;
    }

    /**
     * 修改数据
     *
     * @param contactsInfo 实例对象
     * @return 实例对象
     */
    @Override
    public ContactsInfo update(ContactsInfo contactsInfo) {
        this.contactsInfoMapper.update(contactsInfo);
        return this.queryById(contactsInfo.getContactId());
    }

    /**
     * 通过主键删除数据
     *
     * @param contactId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long contactId) {
        return this.contactsInfoMapper.deleteById(contactId) > 0;
    }
}
