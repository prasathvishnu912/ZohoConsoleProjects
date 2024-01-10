package com.zsgs.tollqueue.addcar;

import java.util.Queue;

import com.zsgs.tollqueue.Car;

public class AddCarCont  implements Runnable{

	private Queue<Car> carQueue;
	
	 private AddCarModel addCarModel = new AddCarModel();
	 private AddCarView addCarView = new AddCarView();
	
	private void setCurrentCar() {
		carQueue = addCarModel.getCarList();
		if(carQueue.size()!=0) {
			String currCar = getCurCar();
			addCarView.printCurrentCar(currCar);
			boolean isGetCar = addCarView.getCarDetails(carQueue.size());
			
			if(isGetCar) {
				addCarModel.addCar(addCarView.carObj);
			}	
		}
		
	}
	 
	 private String getCurCar() {
		return carQueue.peek().getCarNum();
	}

	public void run() {
	        while (true) {
	            try {
	            	setCurrentCar();
	            	Thread.sleep(5000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	
}
