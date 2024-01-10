package com.zsgs.travels.termination;

import java.util.Scanner;

public class OwnerTerminateEmpView {

	private OwnerTerminateEmpVM ownerTerVm = new OwnerTerminateEmpVM();
	private Scanner sc = new Scanner(System.in);
	
	
	public void terminateEmp() {
		printMsg("Enter the Employee name: ");
		String driver = sc.nextLine();
		printMsg("Enter Employee ID: ");
		int id = sc.nextInt();
		ownerTerVm.removeEmployee(driver, id);
		
	}

	
	private void printMsg(String s) {
		System.out.println(s);
	}
}
