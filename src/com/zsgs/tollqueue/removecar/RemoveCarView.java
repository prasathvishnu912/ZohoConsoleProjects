package com.zsgs.tollqueue.removecar;

import com.zsgs.tollqueue.Car;

public class RemoveCarView {

	public void printSuccessRmMsg(Car removeCurCar) {
		System.out.println("|-----------------------------|");
		System.out.println("|  A car removed from Queue   |");	
		System.out.println("|  CarNo: "+removeCurCar.getCarNum()+"          |");
		System.out.println("|-----------------------------|");
	}

}
