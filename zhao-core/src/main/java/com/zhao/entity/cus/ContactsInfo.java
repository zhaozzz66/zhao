package com.zhao.entity.cus;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * contacts_info(ContactsInfo)实体类
 *
 * @author makejava
 * @since 2024-03-01 15:24:54
 */
@Getter
@Setter
public class ContactsInfo implements Serializable {
    private static final long serialVersionUID = -89588329513089748L;
    /**
     * 联系信息主键标识
     */
    private Long contactId;
    /**
     * 联系人性别
     */
    private String contactGender;
    /**
     * CUST_PHONE
     */
    private String custPhone;
    /**
     * REMARK
     */
    private String remark;
    /**
     * STATUS_CD
     */
    private String statusCd;
    /**
     * 状态时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date statusDate;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createDate;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateDate;

}

