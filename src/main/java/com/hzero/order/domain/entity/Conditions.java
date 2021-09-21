package com.hzero.order.domain.entity;

import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 订单查询条件
 *
 */
@ApiModel("订单查询条件")
public class Conditions extends AuditDomain {

	@ApiModelProperty(value = "公司id")
	private Long  companyId;
	@ApiModelProperty(value = "客户id")
	private Long customerId;
	@ApiModelProperty(value = "订单编号")
	private String orderNumber;
	@ApiModelProperty(value = "订单状态")
	private String orderStatus;

	public Conditions(Long companyId, Long customerId, String orderNumber, String orderStatus){
		this.companyId = companyId;
		this.customerId = customerId;
		this.orderNumber = orderNumber;
		this.orderStatus = orderStatus;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Conditions{" +
				"companyId=" + companyId +
				", customerId=" + customerId +
				", orderNumber='" + orderNumber + '\'' +
				", orderStatus='" + orderStatus + '\'' +
				'}';
	}
}
