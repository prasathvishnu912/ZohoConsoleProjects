package com.zsgs.tollqueue.addcar;

import java.util.Queue;

import com.zsgs.json.CarDBFunc;
import com.zsgs.tollqueue.Car;

public class AddCarModel {
	private CarDBFunc carDb = new CarDBFunc();
	public void addCar(Car carObj) {
		Queue<Car> carQueue = carDb.getCarList();
		carQueue.offer(carObj);
		carDb.addCarQueueToDB(carQueue);
     }

	public Queue<Car> getCarList() {
		return carDb.getCarList();
	}
}