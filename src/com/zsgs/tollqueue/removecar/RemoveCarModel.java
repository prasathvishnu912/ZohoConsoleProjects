package com.zsgs.tollqueue.removecar;

import java.util.Queue;

import com.zsgs.json.CarDBFunc;
import com.zsgs.tollqueue.Car;

public class RemoveCarModel {

	 Car removeCurCar;
	
	public boolean removeCurrCar() {
		CarDBFunc carDb = new CarDBFunc();
		Queue<Car> carList = carDb.getCarList();
		removeCurCar = carList.poll();
		if(removeCurCar!=null) {
			carDb.addCarQueueToDB(carList);
			return true;
		}
		return false;
	}

}
