package com.orderfilter.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderHeader {

	@JsonProperty("orderId")
	private int orderId;

	@JsonProperty("userId")
	private String userId;

	@JsonProperty("finalOrderAmount")
	private float finalOrderAmount;

	@JsonProperty("orderAmoount")
	private float orderAmoount;

	@JsonProperty("discountAmount")
	private float discountAmount;

	@JsonProperty("totalItemCount")
	private int totalItemCount;

	@JsonProperty("deliveryType")
	private String deliveryType;

	@JsonProperty("orderItems")
	private List<OrderItems> orderItems;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public float getFinalOrderAmount() {
		return finalOrderAmount;
	}

	public void setFinalOrderAmount(float finalOrderAmount) {
		this.finalOrderAmount = finalOrderAmount;
	}

	public float getOrderAmoount() {
		return orderAmoount;
	}

	public void setOrderAmoount(float orderAmoount) {
		this.orderAmoount = orderAmoount;
	}

	public float getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(float discountAmount) {
		this.discountAmount = discountAmount;
	}

	public int getTotalItemCount() {
		return totalItemCount;
	}

	public void setTotalItemCount(int totalItemCount) {
		this.totalItemCount = totalItemCount;
	}

	public String getDeliveryType() {
		return deliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

}
