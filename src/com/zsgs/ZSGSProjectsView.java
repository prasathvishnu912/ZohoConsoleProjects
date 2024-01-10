package com.zsgs;

import java.util.Scanner;

public class ZSGSProjectsView {

	Scanner sc = new Scanner(System.in);
	
	public void printInitialMsg() {
		printMsg("-----Welcome to My ZSGS Projects-----");
		printMsg("");
		printMsg("Select option to Explore projects!!");
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

	public void listOptions(String[] strings) {
		printMsg("");
		for(String s: strings) {
			printMsg(s);
		}
		
	}

	public void printMsg(String string) {
		System.out.println(string);
		
	}
	
	
}
