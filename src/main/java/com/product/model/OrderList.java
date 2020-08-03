package com.product.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class OrderList {
	@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private Integer orderItemid;
	private Integer VendorProductId;
	private Integer quantity;
    private Double priceTotal;
    private Float priceEach;
    private Integer productId;
    private String status;
    private Date approvedDateTime;
    private Integer buyUserId;
    private Date rejectDateTime;
    private Date deliveryDateTime;
    private Date DispacheDateTime;
    private String reason;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getOrderItemid() {
		return orderItemid;
	}
	public void setOrderItemid(Integer orderItemid) {
		this.orderItemid = orderItemid;
	}
	public Integer getVendorProductId() {
		return VendorProductId;
	}
	public void setVendorProductId(Integer vendorProductId) {
		VendorProductId = vendorProductId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPriceTotal() {
		return priceTotal;
	}
	public void setPriceTotal(Double priceTotal) {
		this.priceTotal = priceTotal;
	}
	public Float getPriceEach() {
		return priceEach;
	}
	public void setPriceEach(Float priceEach) {
		this.priceEach = priceEach;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getApprovedDateTime() {
		return approvedDateTime;
	}
	public void setApprovedDateTime(Date approvedDateTime) {
		this.approvedDateTime = approvedDateTime;
	}
	public Integer getBuyUserId() {
		return buyUserId;
	}
	public void setBuyUserId(Integer buyUserId) {
		this.buyUserId = buyUserId;
	}
	public Date getRejectDateTime() {
		return rejectDateTime;
	}
	public void setRejectDateTime(Date rejectDateTime) {
		this.rejectDateTime = rejectDateTime;
	}
	public Date getDeliveryDateTime() {
		return deliveryDateTime;
	}
	public void setDeliveryDateTime(Date deliveryDateTime) {
		this.deliveryDateTime = deliveryDateTime;
	}
	public Date getDispacheDateTime() {
		return DispacheDateTime;
	}
	public void setDispacheDateTime(Date dispacheDateTime) {
		DispacheDateTime = dispacheDateTime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	@Override
	public String toString() {
		return "OrderList [orderId=" + orderId + ", orderItemid=" + orderItemid + ", VendorProductId=" + VendorProductId
				+ ", quantity=" + quantity + ", priceTotal=" + priceTotal + ", priceEach=" + priceEach + ", productId="
				+ productId + ", status=" + status + ", approvedDateTime=" + approvedDateTime + ", buyUserId="
				+ buyUserId + ", rejectDateTime=" + rejectDateTime + ", deliveryDateTime=" + deliveryDateTime
				+ ", DispacheDateTime=" + DispacheDateTime + ", reason=" + reason + "]";
	}
	public OrderList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	}
