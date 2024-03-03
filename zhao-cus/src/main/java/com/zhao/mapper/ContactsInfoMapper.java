package com.zhao.mapper;

import com.zhao.entity.cus.ContactsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * contacts_info(ContactsInfo)表数据库访问层
 *
 * @author makejava
 * @since 2024-03-01 15:24:54
 */
public interface ContactsInfoMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param contactId 主键
     * @return 实例对象
     */
    ContactsInfo queryById(Long contactId);

    /**
     * 查询指定行数据
     *
     * @param contactsInfo 查询条件
     * @return 对象列表
     */
    List<ContactsInfo> queryAllByLimit(ContactsInfo contactsInfo);

    /**
     * 统计总行数
     *
     * @param contactsInfo 查询条件
     * @return 总行数
     */
    long count(ContactsInfo contactsInfo);

    /**
     * 新增数据
     *
     * @param contactsInfo 实例对象
     * @return 影响行数
     */
    int insert(ContactsInfo contactsInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ContactsInfo> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ContactsInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ContactsInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ContactsInfo> entities);

    /**
     * 修改数据
     *
     * @param contactsInfo 实例对象
     * @return 影响行数
     */
    int update(ContactsInfo contactsInfo);

    /**
     * 通过主键删除数据
     *
     * @param contactId 主键
     * @return 影响行数
     */
    int deleteById(Long contactId);

}

