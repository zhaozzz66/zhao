package com.zhao.cus.controller;

import com.github.pagehelper.PageInfo;
import com.zhao.cus.service.ContactsInfoService;
import com.zhao.entity.cus.ContactsInfo;
import com.zhao.utils.PageRequest;
import com.zhao.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * contacts_info(ContactsInfo)表控制层
 *
 * @author makejava
 * @since 2024-03-01 15:24:53
 */
@RestController
@RequestMapping("/cus/contactsInfo")
public class ContactsInfoController {
    /**
     * 服务对象
     */
    @Resource
    private ContactsInfoService contactsInfoService;

    /**
     * 分页查询
     *
     * @param contactsInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("/qryContactsInfo")
    public R<PageInfo<ContactsInfo>> queryByPage(ContactsInfo contactsInfo, PageRequest pageRequest) {
        return R.success(this.contactsInfoService.queryByPage(contactsInfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/qryContactsInfoById/{id}")
    public R<ContactsInfo> queryById(@PathVariable("id") Long id) {
        return R.success(this.contactsInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param contactsInfo 实体
     * @return 新增结果
     */
    @PostMapping("/addContactsInfo")
    public R<ContactsInfo> add(ContactsInfo contactsInfo) {
        return R.success(this.contactsInfoService.insert(contactsInfo));
    }

    /**
     * 编辑数据
     *
     * @param contactsInfo 实体
     * @return 编辑结果
     */
    @PostMapping("/updContactsInfo")
    public R<ContactsInfo> edit(ContactsInfo contactsInfo) {
        return R.success(this.contactsInfoService.update(contactsInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delContactsInfoById")
    public R<Boolean> deleteById(Long id) {
        return R.success(this.contactsInfoService.deleteById(id));
    }

}

