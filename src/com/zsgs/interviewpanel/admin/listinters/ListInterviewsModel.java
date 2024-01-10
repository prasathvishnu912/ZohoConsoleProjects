package com.zsgs.interviewpanel.admin.listinters;

import java.util.Queue;

import com.zsgs.interviewpanel.InterviewDetails;
import com.zsgs.json.InterDetailsListDBFunc;

public class ListInterviewsModel {

	InterDetailsListDBFunc iDLDbF = new InterDetailsListDBFunc();
	
	public Queue<InterviewDetails> getIntersList() {
		return iDLDbF.getInterviewsList();
	}

}
