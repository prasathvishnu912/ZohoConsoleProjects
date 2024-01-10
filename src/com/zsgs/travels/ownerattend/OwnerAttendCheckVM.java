package com.zsgs.travels.ownerattend;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.zsgs.travels.Employee;

public class OwnerAttendCheckVM {

	private OwnerAttendCheckModel ownerAttendModel = new OwnerAttendCheckModel();
	
	public void checkAttendance() {
		List<Employee> attendList = ownerAttendModel.getAttendList();
		List<Employee> empList = ownerAttendModel.getEmpList();
		List<Employee> abscentList = getAbscentVechileDriv(attendList, empList);
		new OwnerAttendCheckView().printAbscentEmployees(abscentList);
	}

	private List<Employee> getAbscentVechileDriv(List<Employee> attendList, List<Employee> empList) {
		
		List<String> availDrivers = new LinkedList<>();
		Iterator<Employee> attendEmpIterator = attendList.iterator();
		List<Employee> abscentEmps = new LinkedList<>();
		
		while(attendEmpIterator.hasNext()) {
			availDrivers.add(attendEmpIterator.next().getName());
		}
		
		Iterator<Employee> empIterator = empList.iterator();
		
		while(empIterator.hasNext()) {
			Employee emp = empIterator.next();
		  if(!availDrivers.contains(emp.getName())) {
			  abscentEmps.add(emp);
		  }
		}
		
		return abscentEmps;
	}

}
