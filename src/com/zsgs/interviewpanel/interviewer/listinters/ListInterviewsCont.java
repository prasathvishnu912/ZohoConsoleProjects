package com.zsgs.interviewpanel.interviewer.listinters;

import java.util.Queue;

import com.zsgs.interviewpanel.InterviewDetails;

public class ListInterviewsCont {
	
	private ListInterviewsModel listInterModel = new ListInterviewsModel();
	private ListInterviewsView listInterView = new ListInterviewsView();
	
	
  public void listInterviews() {
	  Queue<InterviewDetails> intersList = listInterModel.getInterviewsList();
	  listInterView.printInterviews(intersList);
  }
}
