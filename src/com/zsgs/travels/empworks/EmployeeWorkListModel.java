package com.zsgs.travels.empworks;

import java.util.List;

import com.zsgs.travels.Customer;
import com.zsgs.travelsjson.BookingDetailsDBFunc;

public class EmployeeWorkListModel {

	private BookingDetailsDBFunc bookingListDb = new BookingDetailsDBFunc();
	
	public List<Customer> getCustomerList(String vechileType) {
		return bookingListDb.getCusList(vechileType.toLowerCase()+"CusDetailsList");
	}

}
