package com.zsgs.interviewpanel.interviewer.listinters;

import java.util.Queue;

import com.zsgs.interviewpanel.InterviewDetails;
import com.zsgs.json.InterDetailsListDBFunc;

public class ListInterviewsModel {
	private InterDetailsListDBFunc iDlDb = new InterDetailsListDBFunc();
	public Queue<InterviewDetails> getInterviewsList() {
		return iDlDb.getInterviewsList();
	}
}
