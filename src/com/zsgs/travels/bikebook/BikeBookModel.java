package com.zsgs.travels.bikebook;

import java.util.List;

import com.zsgs.travels.Customer;
import com.zsgs.travels.TravelsVechile;
import com.zsgs.travelsjson.BookingDetailsDBFunc;
import com.zsgs.travelsjson.TravelVechileListDBFunc;

public class BikeBookModel {

	private TravelVechileListDBFunc vechileListDb = new TravelVechileListDBFunc();
	private BookingDetailsDBFunc bookingDb = new BookingDetailsDBFunc();

	public List<TravelsVechile> getTravelList(String key) {
		return vechileListDb.getVechileList("bike", key);
	}

	public TravelsVechile getAvailableBike(String key) {
		List<TravelsVechile> availBikeList = vechileListDb.getVechileList("bike", key);

		if (availBikeList.size() != 0) {
			TravelsVechile availBike = availBikeList.get(0);

			List<TravelsVechile> bookedCarList = vechileListDb.getVechileList("bike", "bookedbike");
			bookedCarList.add(availBike);
			vechileListDb.addVechileListToDB(bookedCarList,"bike", "bookedbike");

			availBikeList.remove(0);
			vechileListDb.addVechileListToDB(availBikeList, "bike", key);
			return availBike;
		}
		return null;
	}

	public void addBookingsToDb(Customer newCus) {
		List<Customer> cusList = bookingDb.getCusList("bikeCusDetailsList");
		cusList.add(newCus);
		bookingDb.addDetailsToDB(cusList, "bikeCusDetailsList");
	}
}
