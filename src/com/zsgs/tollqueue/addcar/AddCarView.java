package com.zsgs.tollqueue.addcar;

import java.time.LocalTime;
import java.util.Scanner;

import com.zsgs.tollqueue.Car;

public class AddCarView {
	Scanner scanner = new Scanner(System.in);
	Car carObj;
	public void printCurrentCar(String currCar) {
	        if(currCar!= null) {
	            System.out.println("Current billing car is: " + currCar);
	        }else {
	        	System.out.println("Queue is empty!!!");
	        }
	        System.out.println("The Toll Queue has space. Do you want to add to the Queue? (yes/no)");
	    }
	

	public boolean getCarDetails(int carCount) {
	       if (carCount < 10) {
	            String response = scanner.nextLine().toLowerCase();
	            if (response.equals("yes")) {
	                System.out.println("Enter your car number: ");
	                String carNum = scanner.nextLine();
	                LocalTime currentTime = LocalTime.now();
	                carObj = new Car(carNum, currentTime.toString());
	                System.out.println("Car added to Queue!!");
	                return true;
	            }else if(response.equals("no")){
	            	System.out.println("Ok, You can move to next Queue. Thank you!");
	            }else {
	            	System.out.println("Enter valid option?");
	            	getCarDetails(carCount);
	            }
	            
	        }else {
	        	System.out.println("Car Queue is Full, Wait sometimes!!!!");
		        return false;

	        }
	       return false;
	    }
}
