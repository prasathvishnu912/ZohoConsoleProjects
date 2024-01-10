package com.zsgs.interviewpanel.candidate.listcandidate;

import java.util.Queue;

import com.zsgs.interviewpanel.Candidate;

public class ListCandidateCont {
	public void listCandidateCont() {
		ListCandidateView candListView = new ListCandidateView();
		ListCandidateModel candListModel = new ListCandidateModel();
		Queue<Candidate> candList = candListModel.getCandList();
		if(candList.size()==0)
			candListView.emptyList();
		else {
		   candListView.printCandidatesList(candList);
		}
	}
}
