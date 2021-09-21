package com.hzero.order.api.controller.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hzero.core.base.BaseConstants;
import org.hzero.boot.platform.lov.annotation.LovValue;
import java.lang.annotation.Target;
import java.math.BigDecimal;
import java.sql.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

/**
 *订单汇总查询返回的结果集
 * 数据传输对象，XXXDTO.java，对于一些复杂页面需要多个实体类组合时，可使用DTO对象来传递数据
 *
 */
public class OrderReturnDTO implements BaseConstants {

	@ApiModelProperty("")
	@Id
	@GeneratedValue
	private Long soHeaderId;
	@ApiModelProperty(value = "订单编号")
	private String orderNumber;
	@ApiModelProperty(value = "公司名称")
	private String companyName;
	@ApiModelProperty(value = "客户名称")
	private String customerName;
	@ApiModelProperty(value = "订单日期" )
	@javax.validation.constraints.Pattern(regexp = Pattern.DATE)
	private Date orderDate;
	@ApiModelProperty(value = "订单状态")
	private String orderStatusMeaning;
	@LovValue(value ="HZERO.ORDER.STATUS" ,meaningField = "orderStatusMeaning")
	private String orderStatus;
	@ApiModelProperty(value = "订单金额")
	private BigDecimal orderAmount;
	@ApiModelProperty(value = "版本号")
	private Long objectVersionNumber;
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Long getSoHeaderId() {
		return soHeaderId;
	}

	public void setSoHeaderId(Long soHeaderId) {
		this.soHeaderId = soHeaderId;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public Long getObjectVersionNumber() {
		return objectVersionNumber;
	}

	public void setObjectVersionNumber(Long objectVersionNumber) {
		this.objectVersionNumber = objectVersionNumber;
	}

	@Override
	public String toString() {
		return "OrderReturnDTO{" +
				"soHeaderId=" + soHeaderId +
				", orderNumber='" + orderNumber + '\'' +
				", companyName='" + companyName + '\'' +
				", customerName='" + customerName + '\'' +
				", orderDate=" + orderDate +
				", orderStatusMeaning='" + orderStatusMeaning + '\'' +
				", orderStatus='" + orderStatus + '\'' +
				", orderAmount=" + orderAmount +
				", objectVersionNumber=" + objectVersionNumber +
				'}';
	}
}
