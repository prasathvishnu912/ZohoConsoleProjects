package com.zsgs.travels.bikebook;

import com.zsgs.travels.Customer;
import com.zsgs.travels.TravelsVechile;

public class BikeBookVM {
	private BikeBookModel bikeBookModel = new BikeBookModel();

	public TravelsVechile getAvailableBike(String key) {
		return bikeBookModel.getAvailableBike(key);

	}

	public void addBookings(Customer newCus) {
		bikeBookModel.addBookingsToDb(newCus);

	}
}
