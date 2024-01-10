package com.zsgs.interviewpanel.interviewer.leave;

import java.util.PriorityQueue;
import java.util.Queue;

import com.zsgs.interviewpanel.Interviewer;

public class LeaveApplyVM {

	private LeaveApplyModel leaveAppModel = new LeaveApplyModel();
	
	public void removeInterviewer(String string) {
		// TODO Auto-generated method stub
		Queue<Interviewer> interList = leaveAppModel.getInterviewList();
		Queue<Interviewer> newList = new PriorityQueue<>();
		for(Interviewer inter:interList) {
			if(!(inter.getName()==string)) {
				newList.add(inter);
			}
		}
		leaveAppModel.addInterviewList(newList);
	}

}
