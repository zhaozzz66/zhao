package com.zhao.cus.mapper;

import com.zhao.entity.cus.CustContactInfoRel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * cust_contact_info_rel(CustContactInfoRel)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-01 15:24:56
 */
public interface CustContactInfoRelMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param custConnectId 主键
     * @return 实例对象
     */
    CustContactInfoRel queryById(Long custConnectId);

    /**
     * 查询指定行数据
     *
     * @param custContactInfoRel 查询条件
     * @return 对象列表
     */
    List<CustContactInfoRel> queryAllByLimit(CustContactInfoRel custContactInfoRel);

    /**
     * 统计总行数
     *
     * @param custContactInfoRel 查询条件
     * @return 总行数
     */
    long count(CustContactInfoRel custContactInfoRel);

    /**
     * 新增数据
     *
     * @param custContactInfoRel 实例对象
     * @return 影响行数
     */
    int insert(CustContactInfoRel custContactInfoRel);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CustContactInfoRel> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CustContactInfoRel> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CustContactInfoRel> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<CustContactInfoRel> entities);

    /**
     * 修改数据
     *
     * @param custContactInfoRel 实例对象
     * @return 影响行数
     */
    int update(CustContactInfoRel custContactInfoRel);

    /**
     * 通过主键删除数据
     *
     * @param custConnectId 主键
     * @return 影响行数
     */
    int deleteById(Long custConnectId);

}

