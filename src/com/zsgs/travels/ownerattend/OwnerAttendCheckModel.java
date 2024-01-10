package com.zsgs.travels.ownerattend;

import java.util.List;

import com.zsgs.travels.Employee;
import com.zsgs.travelsjson.EmpListDbFunc;

public class OwnerAttendCheckModel {

	private EmpListDbFunc empDbFunc = new EmpListDbFunc();

	
	public List<Employee> getAttendList() {
		return empDbFunc.getAttendEmpList();
	}

	public List<Employee> getEmpList() {
		return empDbFunc.getEmployeeList();
	}
}
