package com.zsgs.interviewpanel.interviewer.leave;


public class LeaveApplyView {
  private LeaveApplyVM listApplyVm = new LeaveApplyVM();
 
  public void leaveApplyView() {
    listApplyVm.removeInterviewer("Arshith");
    System.out.println("Leave Approved!!");
   }
}
