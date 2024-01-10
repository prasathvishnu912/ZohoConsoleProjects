package com.zsgs.interviewpanel.admin.arrange;

import java.time.LocalDate;
import java.util.Queue;

import com.zsgs.interviewpanel.Candidate;
import com.zsgs.interviewpanel.InterviewDetails;
import com.zsgs.interviewpanel.Interviewer;
import com.zsgs.json.CandDBFunc;
import com.zsgs.json.InterDetailsListDBFunc;
import com.zsgs.json.InterviewerDBFunc;

public class InterviewArrangeModel {
	private InterviewerDBFunc iDbF = new InterviewerDBFunc();
	private CandDBFunc cDbF = new CandDBFunc();
	private InterDetailsListDBFunc iDDbF = new InterDetailsListDBFunc();
	
	
	public Queue<Interviewer> getInterviewersList() {
		// TODO Auto-generated method stub	
		return iDbF.getInterviewersList();
	}

	public void addDetailsToDB(String selectedIW, String selectedCand, LocalDate date) {
		Queue<InterviewDetails> interviewsList = iDDbF.getInterviewsList();
		
		InterviewDetails newInterview = new InterviewDetails(selectedIW, selectedCand, date);
		interviewsList.add(newInterview);
		
		iDDbF.addIntToDB(interviewsList);
	}

	public Queue<Candidate> getCandList() {
		// TODO Auto-generated method stub
		return cDbF.getCandidatesList();
	}

}
