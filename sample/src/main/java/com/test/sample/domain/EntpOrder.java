/*
 *Project: order
 ****************************************************************
 * 版权所有@2024 冠德数智机器人  保留所有权利.
 ***************************************************************/
package com.test.sample.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gdsz.framework.jdbc.domain.BasicEntity;
import com.test.sample.ano.FromEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 企业购：订单表 DO
 *
 * @author huangxuezhong
 * @since 1.0.0
 * @date 2024/01/09 11:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("oc_entp_order")
public class EntpOrder extends BasicEntity implements Serializable {

	// 数据库通用字段

	/**
	 * 是否删除
	 */
	@TableField("is_deleted")
	@TableLogic
	private Boolean deleted;



	/**
	 * 订单号
	 */
	@NotBlank(message = "订单号 不能为空")
	private String orderNo;

	/**
	 * 订单状态：
	 * 1:草稿/无状态,
	 * 2:已取消,
	 * 3:待客户经理确认/待确认,
	 * 5:待采购员确认/待确认,
	 * 7:待支付,
	 * 9:已关闭,
	 * 10:待发货,
	 * 12:待收货,
	 * 13:部分收货,
	 * 20:待配货,
	 * 22:待自提,
	 * 30:已完成。
	 * 40:已拆单。
	 */

	private Integer status;

	/**
	 * 支付状态。
	 * 0：未支付。
	 * 1：已支付。
	 * 2：支付中。
	 * 101：取消中。
	 */

	private Integer payStatus;


	/**
	 * 关闭原因
	 */
	private String closeReason;
}
