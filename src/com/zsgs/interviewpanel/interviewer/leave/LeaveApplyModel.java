package com.zsgs.interviewpanel.interviewer.leave;

import java.util.Queue;

import com.zsgs.interviewpanel.Interviewer;
import com.zsgs.json.InterviewerDBFunc;

public class LeaveApplyModel {

	private InterviewerDBFunc intDbF = new InterviewerDBFunc(); 
	
	public Queue<Interviewer> getInterviewList() {
	  return intDbF.getInterviewersList();	
	}

	public void addInterviewList(Queue<Interviewer> newList) {
		intDbF.addIntToDB(newList);
		
	}

}
