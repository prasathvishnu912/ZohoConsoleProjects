package com.zsgs.interviewpanel.candidate.listcandidate;

import java.util.Queue;

import com.zsgs.interviewpanel.Candidate;

public class ListCandidateView {
	public void emptyList() {
		System.out.println("Candidates list is Empty!!");
	}
	
	public void printCandidatesList(Queue<Candidate> candList) {
		System.out.println("Candidates List!!!!\n");
		for(Candidate cand : candList) {
			System.out.println("|---------------------------------------|");
			System.out.println("| Candidate name : " + cand.getName());
			System.out.println("| Age : "+cand.getAge());
			System.out.println("| Email-ID : "+cand.getEmailId());
			System.out.println("| Mobile Number : "+cand.getMobNum());
			System.out.println("|---------------------------------------|");			
		System.out.println();
		}
	}
}
