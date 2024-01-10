package com.zsgs.travels;

public class Customer {

	public Customer(String cusName, String mobNum, TravelDetails travelDetails) {
		super();
		this.cusName = cusName;
		this.mobNum = mobNum;
		this.travelDetails = travelDetails;
	}
	
	private String cusName;
	private String mobNum;
	private TravelDetails travelDetails;
	
	
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getMobNum() {
		return mobNum;
	}
	public void setMobNum(String mobNum) {
		this.mobNum = mobNum;
	}
	public TravelDetails getTravelDetails() {
		return travelDetails;
	}
	public void setTravelDetails(TravelDetails travelDetails) {
		this.travelDetails = travelDetails;
	}
	
	
}
