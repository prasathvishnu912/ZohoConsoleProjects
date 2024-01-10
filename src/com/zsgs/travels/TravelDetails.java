package com.zsgs.travels;

import java.time.LocalDateTime;

public class TravelDetails {
   
	private String from;
	private String to;
	private LocalDateTime depatureTime;
	private LocalDateTime arrivalTime;
	private TravelsVechile bookedCar;
	
	public TravelsVechile getBookedCar() {
		return bookedCar;
	}


	public void setBookedCar(TravelsVechile bookedCar) {
		this.bookedCar = bookedCar;
	}


	public TravelDetails(String from, String to, LocalDateTime depatureTime, LocalDateTime arrivalTime, TravelsVechile bookedCar) {
		this.from = from;
		this.to = to;
		this.depatureTime = depatureTime;
		this.arrivalTime = arrivalTime;
		this.bookedCar = bookedCar;
	}


	public String getFrom() {
		return from;
	}


	public void setFrom(String from) {
		this.from = from;
	}


	public String getTo() {
		return to;
	}


	public void setTo(String to) {
		this.to = to;
	}


	public LocalDateTime getDepatureTime() {
		return depatureTime;
	}


	public void setDepatureTime(LocalDateTime depatureTime) {
		this.depatureTime = depatureTime;
	}


	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
 
    
   
}
