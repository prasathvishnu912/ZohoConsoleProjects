package com.zsgs.interviewpanel.admin.arrange;

import java.time.LocalDate;
import java.util.Queue;

import com.zsgs.interviewpanel.Candidate;
import com.zsgs.interviewpanel.Interviewer;

public class InterviewArrangeVM {

	private InterviewArrangeModel iAM = new InterviewArrangeModel();
	
	public Queue<Interviewer> getIntviewerList() {
		return iAM.getInterviewersList();
	}

	public boolean validateInterviewer(int option) {
		if(option>0&&option<iAM.getInterviewersList().size())
			return true;
		return false;
	}
	
	public boolean checkDateIsValid(String dateInput) {
		 String[] dateArray = dateInput.split("-");
		 if(dateArray.length!=3)
			 return false;
		 int date = Integer.parseInt(dateArray[0]);
		 int month = Integer.parseInt(dateArray[1]);
		 int year = Integer.parseInt(dateArray[2]);
		 
		 LocalDate curDate = LocalDate.now();
		 int curDay = curDate.getDayOfMonth();
		 int curMonth = curDate.getMonthValue();
		 int curYear = curDate.getYear();
		 if((date>=curDay&&date<32)&&(month>=curMonth&&month<13)&&(year>=curYear)){
			 return true;
		 }
		 
		return false;
	}

	public void addToDB(String selectedIW, String selectedCand ,LocalDate date) {
		iAM.addDetailsToDB(selectedIW, selectedCand ,date);
		
	}

	public Queue<Candidate> getCandList() {
		return iAM.getCandList();
	}

	public boolean validateCandidate(int option) {
		System.out.println(iAM.getCandList().size());
		if(option>0&&option<=iAM.getCandList().size())
			return true;
		return false;
	};;
}
