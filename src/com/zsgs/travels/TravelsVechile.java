package com.zsgs.travels;

public class TravelsVechile {
  
	public String getVechileNum() {
		return VechileNum;
	}
	public void setVechileNum(String carNum) {
		this.VechileNum = carNum;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public TravelsVechile(String carNum, String driverName) {
		super();
		this.VechileNum = carNum;
		this.driverName = driverName;
	}
	private String VechileNum;
	private String driverName;
	
	
	
}
