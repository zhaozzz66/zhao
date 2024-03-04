package com.zhao.cus.controller;

import com.github.pagehelper.PageInfo;
import com.zhao.cus.service.CustContactInfoRelService;
import com.zhao.entity.cus.CustContactInfoRel;
import com.zhao.utils.PageRequest;
import com.zhao.utils.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * cust_contact_info_rel(CustContactInfoRel)表控制层
 *
 * @author makejava
 * @since 2024-03-01 15:24:56
 */
@RestController
@RequestMapping("/cus/custContactInfoRel")
public class CustContactInfoRelController {
    /**
     * 服务对象
     */
    @Resource
    private CustContactInfoRelService custContactInfoRelService;

    /**
     * 分页查询
     *
     * @param custContactInfoRel 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("/qryCustContactInfoRel")
    public R<PageInfo<CustContactInfoRel>> queryByPage(CustContactInfoRel custContactInfoRel, PageRequest pageRequest) {
        return R.success(this.custContactInfoRelService.queryByPage(custContactInfoRel, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/qryCustContactInfoRelById/{id}")
    public R<CustContactInfoRel> queryById(@PathVariable("id") Long id) {
        return R.success(this.custContactInfoRelService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param custContactInfoRel 实体
     * @return 新增结果
     */
    @PostMapping("/addCustContactInfoRel")
    public R<CustContactInfoRel> add(CustContactInfoRel custContactInfoRel) {
        return R.success(this.custContactInfoRelService.insert(custContactInfoRel));
    }

    /**
     * 编辑数据
     *
     * @param custContactInfoRel 实体
     * @return 编辑结果
     */
    @PostMapping("/updCustContactInfoRel")
    public R<CustContactInfoRel> edit(CustContactInfoRel custContactInfoRel) {
        return R.success(this.custContactInfoRelService.update(custContactInfoRel));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PostMapping("/delCustContactInfoRelById")
    public R<Boolean> deleteById(Long id) {
        return R.success(this.custContactInfoRelService.deleteById(id));
    }

}

