package com.zsgs.interviewpanel.interviewer.login;

import java.util.Queue;

import com.zsgs.interviewpanel.Interviewer;

public class InterviewerLoginVM {
    
    private InterviewerLoginModel intLogModel = new InterviewerLoginModel();
	
    public boolean checkAuth(InterviewerLoginView interDetails) {
    	Queue<Interviewer> interList = intLogModel.getInterList();
    	
    	return checkInterAuth(interDetails, interList);
	}

	private boolean checkInterAuth(InterviewerLoginView interDetails, Queue<Interviewer> interList) {
		for(Interviewer inter : interList) {
			if(inter.getName().equals(interDetails.name)&&inter.getPwd().equals(interDetails.pwd)) {
				return true;
			}
		}
		return false;
	}
	
}
