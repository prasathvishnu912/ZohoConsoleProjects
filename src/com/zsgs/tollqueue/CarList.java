package com.zsgs.tollqueue;

import java.util.PriorityQueue;
import java.util.Queue;



public class CarList {
	static Queue<Car> carList;
	private CarList() {
		
	}
	
	
	public static Queue<Car> getInstance(){
		
		if(carList==null) {
			carList = new PriorityQueue<>();
		}
		return carList;
	}
}
