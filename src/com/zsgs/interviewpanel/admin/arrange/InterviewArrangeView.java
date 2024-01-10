package com.zsgs.interviewpanel.admin.arrange;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Queue;
import java.util.Scanner;

import com.zsgs.interviewpanel.Candidate;
import com.zsgs.interviewpanel.Interviewer;

public class InterviewArrangeView {

	Scanner scanner = new Scanner(System.in);
	LocalDate date;
	String interviewer;
	InterviewArrangeVM intArrVM = new InterviewArrangeVM();
	Queue<Interviewer> interviewersList;
	Queue<Candidate> candList;
	
	
	public void interviewArrView() {
		askDetails();
		System.out.println("Interview Arranged!!!");
	}

	private void askDetails() {
		askDate("");
		String selectedIW = askInterviewer();
		String selectedCand = askCandidate();
		intArrVM.addToDB(selectedIW, selectedCand, date);
		printArrangedMsg();
	}

	private String askCandidate() {
		candList = intArrVM.getCandList() ;
		listCandList(candList);
		
		return getCandidate();
	}

	void printArrangedMsg() {
		System.out.println("Interview Arranged!!");
	}
	
	private String getCandidate() {
		System.out.println("Select valid option!");
		int selectedOpt = scanner.nextInt();
		if(!intArrVM.validateCandidate(selectedOpt)) {
			getCandidate();
		}
		return getCandidateName(selectedOpt);
	}

	private String getCandidateName(int selectedOpt) {
		int count = 1;
		for(Candidate cand : candList) {
			if(count==selectedOpt) {
				return cand.getName();
				
			}
			count++;
		}
		return null;
	}

	private void listCandList(Queue<Candidate> candList) {
		int count =1;
		for(Candidate i:candList) {
			System.out.println(count+"-> "+i.getName());	
			count++;
		}	
	}
	
	private String askInterviewer() {
		interviewersList = intArrVM.getIntviewerList() ;
		listInterviewerList(interviewersList);	
		return getInterviewer("");
	}

	private String getInterviewer(String k) {
		System.out.println("Select any one "+ k+" Interviewer");
		int selectedOpt = scanner.nextInt();
		boolean valid = intArrVM.validateInterviewer(selectedOpt);
		if(!valid)
			getInterviewer("valid");
		return getSelectedInterviewer(selectedOpt);
	}

	

	private String getSelectedInterviewer(int selectedOpt) {
		for(Interviewer i : interviewersList) {
			if(i.getId()==selectedOpt)
				return i.getName();
		}
		return null;
	}

	private void listInterviewerList(Queue<Interviewer> list) {
		for(Interviewer i:list)
			System.out.println(i.getId()+" "+i.getName());
	}

	private void askDate(String valid) {
        System.out.println("Enter a "+valid+" date (format: dd-MM-yyyy): ");
        String dateInput = scanner.nextLine();

       boolean validDate = intArrVM.checkDateIsValid(dateInput);
        if(!validDate) {
        	askDate("valid");
        }
        	
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try {
            LocalDate date = LocalDate.parse(dateInput, dateFormatter);
            this.date = date;
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please enter date in dd-MM-yyyy format.");
        }
		
	}

	
}
