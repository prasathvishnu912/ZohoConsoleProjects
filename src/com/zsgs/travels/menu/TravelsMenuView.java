package com.zsgs.travels.menu;

import java.util.Scanner;

import com.zsgs.travels.Employee;
import com.zsgs.travels.bikebook.BikeBookView;
import com.zsgs.travels.cabbook.CabBookView;
import com.zsgs.travels.empleave.EmpLeaveApplyView;
import com.zsgs.travels.empworks.EmployeeWorkListView;
import com.zsgs.travels.login.TravelsLoginView;
import com.zsgs.travels.ownerattend.OwnerAttendCheckView;
import com.zsgs.travels.termination.OwnerTerminateEmpView;

public class TravelsMenuView {
    private Scanner sc = new Scanner(System.in);
    
	public void startTravels() {
		printMsg("Welcome to Sundara Travels!!");
		int option ;
		outerLoop:
	    do {
	    	
	    	listOptions(new String[]{"1. Customer", "2. Employee", "3. Owner", "4. Exit"});
	    	option = getOption();
	    	
	    	if(option>4||option<=0) {
	    		printMsg("Enter Valid option!!");
	    		continue;
	    	}
	    	
	    	switch(option) {
	    	case 1:
	    		listOptions(new String[] {"1. Book Cab", "2. Book Bike", "3. Back", "4. Exit"});
	    		int cusOption;
	    		customerLoop:
	    		do {
	    			
	    			cusOption = getOption();
	    			
	    			if(cusOption>4||cusOption<=0) {
	    				printMsg("Enter valid option!!");
	    				continue;
	    			}
	    			
	    			switch(cusOption) {
	    			case 1:
	    				CabBookView cabBookView = new CabBookView();
	    				cabBookView.startBook();
	    				break customerLoop;
	    			case 2:
	    				BikeBookView bikeBookView = new BikeBookView();
	    				bikeBookView.startBook();
	    				break customerLoop;
	    			case 3:
	    				break customerLoop;
	    			case 4:
	    				break outerLoop;
	    			}
	    			
	    		}while(cusOption<5);
	    	break;
	    		
	    	case 2:
	    		 
	    	   int empOption;
	    	   Employee emp = new TravelsLoginView().empCheckAuth();
	    	   if(emp!=null) {
	    		   empLoop:
	    	    	   do {
	    	    		   listOptions(new String[] {"1. Get today work", "2. Leave apply", "3. Back", "4. Exit"});
	    	    		   empOption = getOption();
	    	    		   
	    	    		   if(empOption>4||empOption<=0) {
	    	    				printMsg("Enter valid option!!");
	    	    				continue;
	    	          		}
	    	    		  
	    	    		   switch(empOption) {
	    	    		   case 1:
	    	    			   EmployeeWorkListView empWork = new EmployeeWorkListView();
	    	    			   empWork.listWorks(emp);
	    	    			   break empLoop;
	    	    		   case 2:
	    	    			   EmpLeaveApplyView empLeaveView = new EmpLeaveApplyView();
	    	    			   empLeaveView.applyView(emp);
	    	    			   break empLoop;
	    	    		   case 3:
	    	    			   break empLoop;
	    	    		   case 4:
	    	    			   break outerLoop;
	    	    		   }
	    	    		   
	    	    	   }while(empOption<5);
	    	   }
	    	   	break;
	    	case 3:
	    		int ownerOpt;
	    		String owner = new TravelsLoginView().ownerAuthCheck();
	    	   	
	    		if(owner!=null) {
	    		ownerLoop:
	    		do {	
	    		 listOptions(new String[] {"1. Attendance check", "2. Terminate", "3. Back", "4. Exit"});
	    		 ownerOpt = getOption();
	    		 
	    		 if(ownerOpt>4||ownerOpt<1) {
	    			 printMsg("Enter valid option!!");
	    			 continue;
	    		 }
	    			 
	    		 
	    		 switch(ownerOpt) {
	    		 case 1:
	    			OwnerAttendCheckView attendCheck = new OwnerAttendCheckView();
	    			attendCheck.attendCheck();
	    			break;
	    		 case 2:
	    			 OwnerTerminateEmpView terminateView = new OwnerTerminateEmpView();
	    			 terminateView.terminateEmp();
	    			 break;
	    		 case 3:
	    			 break ownerLoop;
	    		 case 4:
	    			 break outerLoop;
	    			 
	    		 }
	    		 
	    		}while(ownerOpt<5);
	    }
	    break;				
	    	case 4:
	    		break outerLoop;
	    }
	    	
	    }while(option<5);
	    printMsg("Thank you!!");
	    
	    
    }
	
	void printMsg(String s) {
		System.out.println(s);
	}
	
	private void listOptions(String[] options) {
		printMsg("|---------------------------------|");
		for(String s: options) {
			printMsg("| "+s);
		}
		printMsg("|---------------------------------|");
		printMsg("Select any one Valid option");
	}



	private int getOption() {
		int option=4;
		if(sc.hasNextInt()) {
			 option = sc.nextInt();	
		}else {
			printMsg("Enter valid numeric value!!");
			sc.next();
			getOption();
		}
		
		return option;
	}
}
