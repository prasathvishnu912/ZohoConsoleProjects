package com.zsgs.interviewpanel.interviewer.listinters;

import java.util.Queue;

import com.zsgs.interviewpanel.InterviewDetails;

public class ListInterviewsView {

	public void printInterviews(Queue<InterviewDetails> intersList) {
		for(InterviewDetails interD : intersList) {
			System.out.println("|-------------------------------------------|");
			System.out.println("| Candidate name: "+interD.getCandName());
			System.out.println("| Interview Date: "+interD.getDate());
			System.out.println("|-------------------------------------------|");
		}
	}

}
