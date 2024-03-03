package com.zhao.entity.cus;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * cust_contact_info_rel(CustContactInfoRel)实体类
 *
 * @author makejava
 * @since 2024-03-01 15:24:56
 */
@Getter
@Setter
public class CustContactInfoRel implements Serializable {
    private static final long serialVersionUID = 880690933860124453L;
    /**
     * 客户联系信息关系主键
     */
    private Long custConnectId;
    /**
     * 联系信息标识
     */
    private Long contactId;
    /**
     * 客户标识
     */
    private Long custId;
    /**
     * REMARK
     */
    private String remark;
    /**
     * STATUS_CD
     */
    private String statusCd;
}

