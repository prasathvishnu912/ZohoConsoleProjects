package com.zsgs.interviewpanel.interviewer.login;

import java.util.Queue;

import com.zsgs.interviewpanel.Interviewer;
import com.zsgs.json.InterviewerDBFunc;

public class InterviewerLoginModel {
	
	private InterviewerDBFunc intDbFunc = new InterviewerDBFunc();
	
	public Queue<Interviewer> getInterList() {
		return intDbFunc.getInterviewersList();
	}

	
	
}
