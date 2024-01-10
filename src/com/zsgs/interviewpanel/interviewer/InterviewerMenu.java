package com.zsgs.interviewpanel.interviewer;

import java.util.Scanner;

import com.zsgs.interviewpanel.interviewer.login.InterviewerLoginView;

public class InterviewerMenu {
	
	public void interMenu() {
		InterviewerLoginView interLogView = new InterviewerLoginView();
		Scanner sc = new Scanner(System.in);
		
		if(interLogView.authenticateLogin()) {
			listInterviewerOptions();
		}else {
			System.out.println("If you want to login again: Enter yes!");
			String ans = sc.nextLine();
			if(ans.toLowerCase().equals("yes")) {
				interMenu();
			}else {
				System.out.println("You are navigate to Home option!!");
			}
		}
		sc.close();
	}
public void listInterviewerOptions() {
		System.out.println("|---------------------------------------|");
		System.out.println("|   Select any of the options below     |");
		System.out.println("|    1. List assigned Candidates        |");
		System.out.println("|    2. Apply leave                     |");
		System.out.println("|    3. Back                            |");
		System.out.println("|    4. Exit                            |");
		System.out.println("|---------------------------------------|");
	}
}
