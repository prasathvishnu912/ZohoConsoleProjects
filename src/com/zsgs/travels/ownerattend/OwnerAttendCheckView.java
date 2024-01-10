package com.zsgs.travels.ownerattend;

import java.util.Iterator;
import java.util.List;

import com.zsgs.travels.Employee;

public class OwnerAttendCheckView {

	private OwnerAttendCheckVM ownerAttendVm = new OwnerAttendCheckVM();

	public void attendCheck() {
		ownerAttendVm.checkAttendance();
	}

	public void printAbscentEmployees(List<Employee> abscentCarDriv) {
		printMsg("Todays Abscents Employee List!!");
		
		Iterator<Employee> empIter = abscentCarDriv.iterator();
		
		while(empIter.hasNext()) {
			Employee emp = empIter.next();
			
			printMsg("");
			printMsg("|----------------------------|");
			printMsg("| Emp ID: "+emp.getEmpId());
			printMsg("| Employee Name: "+emp.getName());
			printMsg("| Mobile Num: "+emp.getMobNum());
			printMsg("| Vechile Type:  "+emp.getVechileType());
			printMsg("|----------------------------|");
			printMsg("");
		}
		
		
	}
	
	
	private void printMsg(String s) {
		System.out.println(s);
	}
	
}
