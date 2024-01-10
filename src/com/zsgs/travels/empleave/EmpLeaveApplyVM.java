package com.zsgs.travels.empleave;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.zsgs.travels.Employee;
import com.zsgs.travels.TravelsVechile;

public class EmpLeaveApplyVM {

	private EmpLeaveApplyModel empApplyModel = new EmpLeaveApplyModel();
	
	public void removeEmpFromAvailList(String uName, String vechileType) {
		
		List<TravelsVechile> availEmpList = empApplyModel.getAvailEmpList(vechileType);
		
		Iterator<TravelsVechile> empListIter = availEmpList.iterator();
		
		List<TravelsVechile> filteredList = new LinkedList<>();
		
		while(empListIter.hasNext()) {
			TravelsVechile vechile = empListIter.next();
			if(!vechile.getDriverName().equals(uName)) {
				filteredList.add(vechile);
			}
		}
		empApplyModel.addFilterListToDb(filteredList, vechileType);
		new EmpLeaveApplyView().leaveApplied();
	}

	public void removeFromAttendance(Employee emp) {
		
		List<Employee> attendList = empApplyModel.getAttendanceList();
		
		Iterator<Employee> empIter = attendList.iterator();
		
		while(empIter.hasNext()) {
			Employee employee = empIter.next();
			if(employee.getUserName().equals(emp.getUserName())) {
				attendList.remove(employee);
			}
		}
		
		empApplyModel.addAttendToDb(attendList);
		
	}

}
