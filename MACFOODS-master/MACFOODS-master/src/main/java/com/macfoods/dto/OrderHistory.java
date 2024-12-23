package com.macfoods.dto;

public class OrderHistory {
   
	private int orderHistoryId;
	private int userId;
	private int orderId;
	private Float total;
	private String date;
	private int restId;
	private int totalQuantity;
	
	public OrderHistory(int orderHistoryId, int userId, int orderId, Float total, int restId,int totalQuantity) {
		super();
		this.orderHistoryId = orderHistoryId;
		this.userId = userId;
		this.orderId = orderId;
		this.total = total;
		
		this.restId=restId;
		this.totalQuantity=totalQuantity;
	}


	public OrderHistory(int userId, int orderId, Float total,int restId,int totalQuantity) {
		super();
		this.userId = userId;
		this.orderId = orderId;
		this.total = total;
		
		this.restId=restId;
		this.totalQuantity=totalQuantity;
	}
	
	public OrderHistory(int userId, int orderId,String date, Float total,int restId,int totalQuantity) {
		super();
		this.userId = userId;
		this.orderId = orderId;
		this.date=date;
		this.total = total;
		
		this.restId=restId;
		this.totalQuantity=totalQuantity;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getTotalQuantity() {
		return totalQuantity;
	}


	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}


	public int getRestId() {
		return restId;
	}


	public void setRestId(int restId) {
		this.restId = restId;
	}


	public OrderHistory() {
		super();
	}


	public int getOrderHistoryId() {
		return orderHistoryId;
	}


	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public Float getTotal() {
		return total;
	}


	public void setTotal(Float total) {
		this.total = total;
	}


	


	
	
	
}
