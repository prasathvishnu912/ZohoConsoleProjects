package com.zsgs.travels.empworks;

import java.util.Iterator;
import java.util.List;

import com.zsgs.travels.Customer;
import com.zsgs.travels.Employee;

public class EmployeeWorkListView {

	private EmployeeWorkListVM empWorkVM = new EmployeeWorkListVM();

	public void listWorks(Employee emp) {
		 empWorkVM.getWorksList(emp.getUserName(),emp.getVechileType());
		
	}

	public void listCustomers(List<Customer> cusList) {
		Iterator<Customer> cusIterator = cusList.iterator();

		while (cusIterator.hasNext()) {
			Customer cus = cusIterator.next();
			printMsg("");
			printMsg("|--------------------------------------------|");
			printMsg("| Customer name: " + cus.getCusName());
			printMsg("| Mobile number: " + cus.getMobNum());
			printMsg("| From: " + cus.getTravelDetails().getFrom());
			printMsg("| To: " + cus.getTravelDetails().getTo());
			printMsg("| Pick-up time: " + cus.getTravelDetails().getDepatureTime());
			printMsg("|--------------------------------------------|");
			printMsg("");
		}

	}


	public void printMsg(String s) {
		System.out.println(s);
	}


}
