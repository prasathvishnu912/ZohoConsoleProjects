package com.zsgs.interviewpanel.admin.login;

import java.util.Scanner;

public class AdminLoginView {
   
	 String un;
	 String pwd;
	 
	 AdminLoginVM adminVM = new AdminLoginVM ();
	 
	public boolean adminLogin() {
		loginPage();
		if(!adminVM.loginCheck(this)) {
			System.out.println("Enter Valid Credentials!");
			adminLogin();
		}
		return true;
	}
	
	
	
	private void loginPage() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username: ");
		 un = sc.nextLine();
		System.out.println("Enter password: ");
		 pwd = sc.nextLine(); 
		 sc.close();
	}
}
