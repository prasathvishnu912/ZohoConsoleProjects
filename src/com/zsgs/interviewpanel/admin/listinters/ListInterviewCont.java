package com.zsgs.interviewpanel.admin.listinters;

import java.util.Queue;

import com.zsgs.interviewpanel.InterviewDetails;

public class ListInterviewCont {

	ListInterviewsView listInterView = new ListInterviewsView();
	ListInterviewsModel listInterModel = new ListInterviewsModel();
	Queue<InterviewDetails> interviewsList;
	
	public void listIntersCont() {
		getInterviewsList();
		listInterView.listInterviews(interviewsList);
		
	}

	private void getInterviewsList() {
		this.interviewsList = listInterModel.getIntersList();
	}

}
