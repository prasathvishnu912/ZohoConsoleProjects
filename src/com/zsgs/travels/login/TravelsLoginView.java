package com.zsgs.travels.login;

import java.util.Scanner;

import com.zsgs.travels.Employee;

public class TravelsLoginView {
   
	private TravelsLoginVM loginVm = new TravelsLoginVM();
	private Scanner sc = new Scanner(System.in); 
	private String uName;
	private String pwd;
	private String vechileType;
	
	public Employee empCheckAuth(){
		getLoginDetails();
		getVechileType("your");
		loginVm.empCheckAuthentication(uName, pwd);
	  return new Employee(uName, pwd, vechileType);
   }
	
	
	public String ownerAuthCheck() {
		getLoginDetails();
		boolean isValid = loginVm.ownerCheckAuthentication(uName, pwd);
	  if(!isValid) {
		  printMsg("Invalid username and password, Please login again!!!");
		  ownerAuthCheck();
	  }
		return uName;
	}
	
	private void getLoginDetails() {
		printMsg("Enter your Username:");
		this.uName = sc.nextLine();
		printMsg("Enter your password: ");
		this.pwd = sc.nextLine();
	}
	private void getVechileType(String k) {
		printMsg("Enter " + k + " vechile type?(car/bike)");
		String vechileType = sc.nextLine();
		if (!(vechileType.equalsIgnoreCase("car") || vechileType.equalsIgnoreCase("bike"))) {
			getVechileType("valid");
		}
		this.vechileType = vechileType;
	}

	public void printMsg(String string) {
		System.out.println(string);
	}

}
