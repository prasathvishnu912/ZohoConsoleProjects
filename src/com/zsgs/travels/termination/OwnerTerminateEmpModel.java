package com.zsgs.travels.termination;

import java.util.List;

import com.zsgs.travels.Employee;
import com.zsgs.travelsjson.EmpListDbFunc;

public class OwnerTerminateEmpModel {

	private EmpListDbFunc empListDb = new EmpListDbFunc();
	
	public List<Employee> getEmpAttendList() {
		return empListDb.getAttendEmpList();
	}

	public List<Employee> getEmpList() {
		return empListDb.getEmployeeList();
	}

	public void addEmpListToDb(List<Employee> removedEmpList) {
		empListDb.addEmpList(removedEmpList);
	}

	public void addAttendEmpListToDb(List<Employee> removedAttendEmpList) {
		empListDb.addAttendEmpList(removedAttendEmpList);
	}
	
}
