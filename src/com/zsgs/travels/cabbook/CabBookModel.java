package com.zsgs.travels.cabbook;

import java.util.List;

import com.zsgs.travels.Customer;
import com.zsgs.travels.TravelsVechile;
import com.zsgs.travelsjson.BookingDetailsDBFunc;
import com.zsgs.travelsjson.TravelVechileListDBFunc;

public class CabBookModel {
	private TravelVechileListDBFunc traCarListDb = new TravelVechileListDBFunc();
	private BookingDetailsDBFunc bookingDb = new BookingDetailsDBFunc();

	public List<TravelsVechile> getTravelList(String key) {
		return traCarListDb.getVechileList("car", key);
	}

	public TravelsVechile getAvailableCar(String key) {
		List<TravelsVechile> availCarList = traCarListDb.getVechileList("car", key);

		if (availCarList.size() != 0) {
			TravelsVechile availCar = availCarList.get(0);

			List<TravelsVechile> bookedCarList = traCarListDb.getVechileList("car", "bookedcar");
			bookedCarList.add(availCar);
			traCarListDb.addVechileListToDB(bookedCarList, "car", "bookedcar");

			availCarList.remove(0);
			traCarListDb.addVechileListToDB(availCarList, "car", key);
			return availCar;
		}
		return null;
	}

	public void addBookingsToDb(Customer newCus) {
		List<Customer> cusList = bookingDb.getCusList("carCusDetailsList");
		cusList.add(newCus);
		bookingDb.addDetailsToDB(cusList, "carCusDetailsList");
	}

}
