package com.zsgs.travels.bikebook;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.zsgs.travels.Customer;
import com.zsgs.travels.TravelDetails;
import com.zsgs.travels.TravelsVechile;

public class BikeBookView {

	private BikeBookVM bikeBookVm = new BikeBookVM();
	private Scanner sc = new Scanner(System.in);
	
	public void startBook() {
		AskDetails();
		
	}

	private void AskDetails() {
		TravelsVechile availBike = bikeBookVm.getAvailableBike("availablebike");
		if(availBike==null) {
			System.out.println("All Bikes are busy!! Wait sometimes and Retry to get your Bike.");
		}else {
			String cusName = getName();
			String mobNum = getMobNumber();
			String curLoc = getCurLocation();
			String destination = getDestination();
			
			LocalDateTime departure = LocalDateTime.now();
			LocalDateTime arrival = LocalDateTime.now();
			
			TravelDetails traDet = new TravelDetails(curLoc, destination, departure, arrival, availBike);
			
			Customer newCus = new Customer(cusName, mobNum, traDet);
			bikeBookVm.addBookings(newCus);
			System.out.println("You Booked a cap, wait sometime to get your Bike!");
		    
		}
			
		
		
	}

	private String getDestination() {
		System.out.println("Enter the valid destination You want to go: ");
		String destination = sc.nextLine();
		if(destination.isEmpty()) {
			getDestination();
		}
		return destination;
	}

	private String getCurLocation() {
		System.out.println("Enter your current Location: ");
		String curLoc = sc.nextLine();
		if(curLoc.isBlank()) {
			getCurLocation();
		}
		return curLoc;
	}

	private String getMobNumber() {
		System.out.println("Enter your valid Mobile number: ");
		String mobNum = sc.nextLine();
		if(mobNum.length()!=10) {
			getMobNumber();
		}
		return mobNum;
	}

	private String getName() {
		System.out.println("Enter your Valid name: ");
		String name = sc.nextLine();
		if(name.isBlank()) {
			getName();
		}
		return name;
	}

}
