package com.zsgs.travels.empleave;

import java.util.List;

import com.zsgs.travels.Employee;
import com.zsgs.travels.TravelsVechile;
import com.zsgs.travelsjson.EmpListDbFunc;
import com.zsgs.travelsjson.TravelVechileListDBFunc;

public class EmpLeaveApplyModel {

	private TravelVechileListDBFunc vechileList = new TravelVechileListDBFunc();
	private EmpListDbFunc empListDb = new EmpListDbFunc();
	
	public List<TravelsVechile> getAvailEmpList(String vechileType) {
		return vechileList.getVechileList(vechileType, "available"+vechileType);
	}

	public void addFilterListToDb(List<TravelsVechile> filteredList, String vechileType) {
		
		vechileList.addVechileListToDB(filteredList, vechileType, "available"+vechileType);
	}

	public List<Employee> getAttendanceList() {
		return empListDb.getAttendEmpList();
	}

	public void addAttendToDb(List<Employee> attendList) {
		empListDb.addAttendEmpList(attendList);
		
	}

}
