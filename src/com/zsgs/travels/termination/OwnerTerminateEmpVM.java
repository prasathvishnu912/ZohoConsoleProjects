package com.zsgs.travels.termination;

import java.util.Iterator;
import java.util.List;

import com.zsgs.travels.Employee;

public class OwnerTerminateEmpVM {

	private OwnerTerminateEmpModel termEmpModel = new OwnerTerminateEmpModel(); 
	
	public void removeEmployee(String driver, int id) {
		
		List<Employee> empList = termEmpModel.getEmpList();
		List<Employee> removedEmpList =  removeEmployeeFromDB(empList, driver, id);
		termEmpModel.addEmpListToDb(removedEmpList);
		
		List<Employee> empAttendList = termEmpModel.getEmpAttendList();
		List<Employee> removedAttendEmp = removeEmployeeFromDB(empAttendList, driver, id);
		termEmpModel.addAttendEmpListToDb(removedAttendEmp);
		
	}
	
	private List<Employee> removeEmployeeFromDB(List<Employee> empList ,String empName, int id) {
		
		Iterator<Employee> empIter = empList.iterator();
		
		while(empIter.hasNext()) {
			Employee emp =  empIter.next();
			if(emp.getName().equals(empName)&&emp.getEmpId()==id) {
				empList.remove(emp);
				break;
			}
		}
		return empList;
	}

}
