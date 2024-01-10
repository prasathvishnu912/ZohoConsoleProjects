package com.zsgs.interviewpanel;

import java.util.PriorityQueue;
import java.util.Queue;

public class InterviewersList {
	static Queue<Candidate> interviewersList;
	private InterviewersList() {
		
	}
	
	
	public static Queue<Candidate> getInstance(){
		
		if(interviewersList==null) {
			interviewersList = new PriorityQueue<>();
		}
		return interviewersList;
	}
}
