package com.zsgs.tollqueue;


public class Car {
	String carNum;
	String time;
	
	public Car(String carNum, String time) {
		super();
		this.carNum = carNum;
		this.time = time;
	}
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	
}
