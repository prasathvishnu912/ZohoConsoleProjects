package com.zsgs.travels.cabbook;

import com.zsgs.travels.Customer;
import com.zsgs.travels.TravelsVechile;

public class CabBookVM {

	private CabBookModel cabBookModel = new CabBookModel();
	
	public TravelsVechile getAvailableCar(String key) {
		return cabBookModel.getAvailableCar(key);
		
	}

	public void addBookings(Customer newCus) {
		cabBookModel.addBookingsToDb(newCus);
		
	}
   
}
