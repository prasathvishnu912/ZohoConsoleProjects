package com.zsgs.travels.login;

import java.util.List;

import com.zsgs.travels.Employee;
import com.zsgs.travelsjson.EmpListDbFunc;

public class TravelsLoginModel {
	private EmpListDbFunc empDbFunc  = new EmpListDbFunc();

	public List<Employee> getEmployeeList() {
		return empDbFunc.getEmployeeList();
	}
}
