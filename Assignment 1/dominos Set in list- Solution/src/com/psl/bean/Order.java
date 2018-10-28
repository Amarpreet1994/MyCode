package com.psl.bean;

public class Order {

	private int dishId;
	private int locationCode;
	private double totalCost;
	
	public Order(int dishId,
	int locationCode,
	double totalCost){
		this.dishId = dishId;
		this.locationCode =locationCode;
		this.totalCost =totalCost;
	}
	@Override
	public String toString() {
	return "["+dishId+" , "+locationCode+" , "+totalCost+"]";
	}
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	public int getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(int locationCode) {
		this.locationCode = locationCode;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	
}
