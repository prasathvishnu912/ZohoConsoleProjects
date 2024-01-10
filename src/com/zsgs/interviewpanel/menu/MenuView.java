package com.zsgs.interviewpanel.menu;


import java.util.Scanner;

public class MenuView {
	
	Scanner sc = new Scanner(System.in);
	
	public void initialMsg() {
		System.out.println("|---------------------------------------------|");
		System.out.println("|   Hi welcome to Interview panel, Are you?   |");
		System.out.println("|    1. Admin                                 |");
		System.out.println("|    2. Interviewer                           |");
		System.out.println("|    3. Candidate                             |");
		System.out.println("|    4. Exit                                  |");
		System.out.println("|---------------------------------------------|");
	}
	
	public void printValidOpt() {
		System.out.println("Enter valid option!!");
	}
	
	public void printValidOpt2() {
		System.out.println("Please enter a valid option");
	}

	public void printTq() {
		System.out.println("Thank you!!");
	}
	
	public int getInput() {
		int opt=7;
		if(sc.hasNextInt()) {
			opt = sc.nextInt();
		}else {
			System.out.println("Enter valid Numeric value!");
			sc.next(); 
	        opt = getInput(); 
		}
		return opt;
	}
}
