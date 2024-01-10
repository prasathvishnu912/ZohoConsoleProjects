package com.zsgs.interviewpanel.candidate.addcandidate;

import java.util.Queue;

import com.zsgs.interviewpanel.Candidate;
import com.zsgs.json.CandDBFunc;

public class AddCandidateModel {

	public void addCandQueue(Candidate cand) {
		CandDBFunc candDb = new CandDBFunc();
		Queue<Candidate> candList = candDb.getCandidatesList();
		candList.add(cand);
		candDb.addCandidate(candList);
	}

    
}
