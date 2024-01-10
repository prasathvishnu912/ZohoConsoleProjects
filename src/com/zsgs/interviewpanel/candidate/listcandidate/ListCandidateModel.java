package com.zsgs.interviewpanel.candidate.listcandidate;

import java.util.Queue;

import com.zsgs.interviewpanel.Candidate;
import com.zsgs.json.CandDBFunc;

public class ListCandidateModel {

	public Queue<Candidate> getCandList() {
		CandDBFunc candDb = new CandDBFunc();
		return candDb.getCandidatesList();
	}

	

}
