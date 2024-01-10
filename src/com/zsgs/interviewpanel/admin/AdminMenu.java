package com.zsgs.interviewpanel.admin;


import com.zsgs.interviewpanel.admin.login.AdminLoginView;

public class AdminMenu {
	AdminLoginView adminView = new AdminLoginView();
	
	public boolean adminMenu() {
		return adminView.adminLogin();   
	}

	public void listAdminOptions() {
		
		System.out.println("|---------------------------------------|");
		System.out.println("|   Select any of the options below     |");
		System.out.println("|    1. Arrange interview               |");
		System.out.println("|    2. List Interviews                 |");
		System.out.println("|    3. Back                            |");
		System.out.println("|    4. Exit                            |");
		System.out.println("|---------------------------------------|");
	}
}
