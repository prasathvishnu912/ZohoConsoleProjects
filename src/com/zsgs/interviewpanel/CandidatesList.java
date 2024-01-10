package com.zsgs.interviewpanel;

import java.util.Queue;
import java.util.PriorityQueue;

public class CandidatesList {
	static Queue<Candidate> candidatesList;
	private CandidatesList() {
		
	}
	
	
	public static Queue<Candidate> getInstance(){
		
		if(candidatesList==null) {
			candidatesList = new PriorityQueue<>();
		}
		return candidatesList;
	}
}
