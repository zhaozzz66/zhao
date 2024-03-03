package com.zhao.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhao.entity.cus.CustContactInfoRel;
import com.zhao.mapper.CustContactInfoRelMapper;
import com.zhao.service.CustContactInfoRelService;
import com.zhao.utils.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * cust_contact_info_rel(CustContactInfoRel)表服务实现类
 *
 * @author makejava
 * @since 2024-03-01 15:24:56
 */
@Service("custContactInfoRelService")
public class CustContactInfoRelServiceImpl implements CustContactInfoRelService {
    @Resource
    private CustContactInfoRelMapper custContactInfoRelMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param custConnectId 主键
     * @return 实例对象
     */
    @Override
    public CustContactInfoRel queryById(Long custConnectId) {
        return this.custContactInfoRelMapper.queryById(custConnectId);
    }

    /**
     * 分页查询
     *
     * @param custContactInfoRel 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public PageInfo<CustContactInfoRel> queryByPage(CustContactInfoRel custContactInfoRel, PageRequest pageRequest) {
        PageInfo<CustContactInfoRel> custContactInfoRelPageInfo = new PageInfo<>();
        Page<Object> objects = PageHelper.startPage(pageRequest.getStartIndex(), pageRequest.getPageSize());
        List<CustContactInfoRel> custContactInfoRels = this.custContactInfoRelMapper.queryAllByLimit(custContactInfoRel);
        custContactInfoRelPageInfo.setList(custContactInfoRels);
        custContactInfoRelPageInfo.setTotal(objects.getTotal());
        return custContactInfoRelPageInfo;
    }

    /**
     * 新增数据
     *
     * @param custContactInfoRel 实例对象
     * @return 实例对象
     */
    @Override
    public CustContactInfoRel insert(CustContactInfoRel custContactInfoRel) {
        this.custContactInfoRelMapper.insert(custContactInfoRel);
        return custContactInfoRel;
    }

    /**
     * 修改数据
     *
     * @param custContactInfoRel 实例对象
     * @return 实例对象
     */
    @Override
    public CustContactInfoRel update(CustContactInfoRel custContactInfoRel) {
        this.custContactInfoRelMapper.update(custContactInfoRel);
        return this.queryById(custContactInfoRel.getCustConnectId());
    }

    /**
     * 通过主键删除数据
     *
     * @param custConnectId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long custConnectId) {
        return this.custContactInfoRelMapper.deleteById(custConnectId) > 0;
    }
}
