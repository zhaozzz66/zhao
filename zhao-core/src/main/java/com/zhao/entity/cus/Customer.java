package com.zhao.entity.cus;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * customer(Customer)实体类
 *
 * @author makejava
 * @since 2024-03-01 15:24:56
 */
@Getter
@Setter
public class Customer implements Serializable {
    private static final long serialVersionUID = -14478631193889972L;
    /**
     * 客户主键
     */
    private Long custId;
    /**
     * CUST_NAME
     */
    private String custName;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    /**
     * 创建人
     */
    private String createStaff;
    /**
     * 客户类型1000：政企、1100：个人
     */
    private String custType;
    /**
     * 区域标识
     */
    private Integer regionId;
    /**
     * REMARK
     */
    private String remark;
    /**
     * 状态1000：可用、1100：删除
     */
    private String statusCd;
    /**
     * 状态时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date statusDate;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;
}

