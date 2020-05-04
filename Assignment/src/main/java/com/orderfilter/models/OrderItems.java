package com.orderfilter.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrderItems {

	@JsonProperty("itemId")
	private String itemId;
	
	@JsonProperty("itemName")
	private String itemName;
	
	@JsonProperty("itemPrice")
	private float itemPrice;
	
	@JsonProperty("itemImage")
	private String itemImage;
	
	@JsonProperty("itemCount")
	private int itemCount;
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemImage() {
		return itemImage;
	}
	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
}
