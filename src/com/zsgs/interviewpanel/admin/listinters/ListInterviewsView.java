package com.zsgs.interviewpanel.admin.listinters;

import java.util.Queue;

import com.zsgs.interviewpanel.InterviewDetails;

public class ListInterviewsView {
	public void listInterviews(Queue<InterviewDetails> interviewsList) {
		for(InterviewDetails interD : interviewsList) {
			System.out.println();
			System.out.println("|----------------------------------------|");
			System.out.println("| Interviewer: "+interD.getInterviewerName());
			System.out.println("| Candidate: "+interD.getCandName());
			System.out.println("| date: "+interD.getDate());
			System.out.println("|----------------------------------------|");
			System.out.println();
		}
	}
}
