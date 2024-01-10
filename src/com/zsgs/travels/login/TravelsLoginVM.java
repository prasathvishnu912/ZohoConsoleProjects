package com.zsgs.travels.login;

import java.util.Iterator;
import java.util.List;

import com.zsgs.travels.Employee;

public class TravelsLoginVM {

	private TravelsLoginModel travelsLoginModel = new TravelsLoginModel();
	
	private List<Employee> empList;
	
	
	public void getEmployeeList() {
		empList = travelsLoginModel.getEmployeeList();
	}

	public String empCheckAuthentication(String uName, String pwd) {
		 TravelsLoginView travelsLoginView = new TravelsLoginView();
		getEmployeeList();
		String userName = null;
		boolean isAuth = checkPriviliage(uName, pwd);
		if(isAuth) {
			travelsLoginView.printMsg("Login Successfull!!");
			userName = uName;
		}else {
			travelsLoginView.printMsg("Invalid userName and Password, try again!");
			travelsLoginView.empCheckAuth();
		}
		return userName;
	}
	
	
	private boolean checkPriviliage(String uName, String pwd) {
		Iterator<Employee> empIterator = empList.iterator();

		while (empIterator.hasNext()) {
			Employee emp = empIterator.next();
			if (emp.getUserName().equals(uName) && emp.getPwd().equals(pwd))
				return true;
		}

		return false;
	}

	public boolean ownerCheckAuthentication(String uName, String pwd) {
		if(uName.equalsIgnoreCase("sundara")&&pwd.equals("sundara")) {
			return true;
		}
		return false;
	}

}
