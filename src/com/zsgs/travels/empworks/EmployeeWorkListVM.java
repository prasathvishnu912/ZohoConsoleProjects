package com.zsgs.travels.empworks;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.zsgs.travels.Customer;

public class EmployeeWorkListVM {

	private EmployeeWorkListModel empWorkModel = new EmployeeWorkListModel();
	
	public void getWorksList(String uName, String vechileType) {
		List<Customer> cusList = empWorkModel.getCustomerList(vechileType);
		List<Customer> curDriverCus = new LinkedList<>();
		
		
		
		Iterator<Customer> cusIterator = cusList.iterator();
		
		while(cusIterator.hasNext()) {
			Customer cus = cusIterator.next();
			if(cus.getTravelDetails().getBookedCar().getDriverName().equalsIgnoreCase(uName)) {
				curDriverCus.add(cus);
			}
		}
		
		if(curDriverCus.size()==0) {
			new EmployeeWorkListView().printMsg("There is no works!!");
		}else {
			new EmployeeWorkListView().listCustomers(curDriverCus);
		}
	}

}
