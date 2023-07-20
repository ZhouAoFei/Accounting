package com.java.admin.entity;

import lombok.Data;
import lombok.ToString;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>t_account表对应实体类对象</p>
 *
 * @author 波波老师(微信 ： javabobo0513)
 */
@Data
@ToString
public class Account {

    private Integer id;//主键ID

    private Date createTime;//记账时间

    private Integer accountType;//账目类型（1：收入；2：支出）

    private String accountDesc;//账目描述

    private BigDecimal accountMoney;//记账金额
}
