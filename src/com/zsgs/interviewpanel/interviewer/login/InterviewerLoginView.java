package com.zsgs.interviewpanel.interviewer.login;

import java.util.Scanner;


public class InterviewerLoginView {

	String name;
	String pwd;
	
	Scanner sc = new Scanner(System.in);
	InterviewerLoginVM interviewerVM = new InterviewerLoginVM();
	
	public boolean authenticateLogin() {
		getDetails();
	    if(!interviewerVM.checkAuth(this)) {
	    	System.out.println("Your privilage is not valid!!");
	    	return false;
	    }
		return true;
     }
	
	private void getDetails() {
	  System.out.println("Enter your name");
	  this.name = sc.nextLine();
	  System.out.println("Enter your password");
	  this.pwd = sc.nextLine();
	}
	
	
	
}
