package com.zsgs.travels.cabbook;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.zsgs.travels.Customer;
import com.zsgs.travels.TravelsVechile;
import com.zsgs.travels.TravelDetails;

public class CabBookView {

	private Scanner sc = new Scanner(System.in);
	private CabBookVM cabBookVm = new CabBookVM();
	
	public void startBook() {
		AskDetails();
		
	}

	private void AskDetails() {
		TravelsVechile availCar = cabBookVm.getAvailableCar("availablecar");
		if(availCar==null) {
			System.out.println("All Cars are busy!! Wait sometimes and Retry to get your car.");
		}else {
			String cusName = getName();
			String mobNum = getMobNumber();
			String curLoc = getCurLocation();
			String destination = getDestination();
			
			LocalDateTime departure = LocalDateTime.now();
			LocalDateTime arrival = LocalDateTime.now();
			
			TravelDetails traDet = new TravelDetails(curLoc, destination, departure, arrival, availCar);
			
			Customer newCus = new Customer(cusName, mobNum, traDet);
			cabBookVm.addBookings(newCus);
			System.out.println("You Booked a cap, wait sometime to get your car!");
		    
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
