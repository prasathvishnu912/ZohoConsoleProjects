package com.zsgs.interviewpanel.candidate.addcandidate;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.zsgs.interviewpanel.Candidate;

public class AddCandidateView {
	String name;
    int age;
	String emailId;
    String mobNum;
      

  	Scanner sc = new Scanner(System.in);
    AddCandidateVM adCandVM = new AddCandidateVM();
  	AddCandidateModel adCandModel = new AddCandidateModel();  
   
  	
  	public void askingDetails() {
    	getName("your");getAge("your");getEmail("your");getMobNum("your");
    	Candidate cand = new Candidate(name, age, emailId, mobNum);
    	adCandVM.addingCandidate(cand);
    	System.out.println("Candidate Added Successfully");
    }
    
    private void getMobNum(String k) {
    	System.out.println("Enter "+k+" mobile number: ");
    	this.mobNum = sc.nextLine().trim();
    	if(!adCandVM.validateMobNum(this.mobNum))
    		getMobNum("valid");
		
	}

	private void getName(String k) {
    	System.out.println("Enter "+k+" name: ");
    	this.name = sc.nextLine().trim();
    	if(!adCandVM.validateName(this.name))
    		getName("valid");
    }
    
	private void getAge(String k) {
		  System.out.println("Enter " + k + " age: ");
		  try {
		    this.age = sc.nextInt();sc.nextLine();
		    if (!adCandVM.validateAge(this.age)) {
		      System.out.println("Applicable age is less than 40. Please try again.");
		      getAge(k); 
		    }
		  } catch (InputMismatchException input) {
		    System.out.println("Please enter a valid number.");
		    sc.nextLine(); 
		    getAge(k); 
		  }
		}

    
    private void getEmail(String k) {
    	System.out.println("Enter "+k+" Email ID:");
    	this.emailId = sc.nextLine();
    	if(!adCandVM.validateEmail(this.emailId)) {
    		getEmail("valid");
    	}
    }
    
}
