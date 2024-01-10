package com.zsgs.interviewpanel.menu;


import com.zsgs.interviewpanel.admin.AdminMenu;
import com.zsgs.interviewpanel.admin.arrange.InterviewArrangeView;
import com.zsgs.interviewpanel.admin.listinters.ListInterviewCont;
import com.zsgs.interviewpanel.candidate.CandidateMenuCont;
import com.zsgs.interviewpanel.candidate.addcandidate.AddCandidateView;
import com.zsgs.interviewpanel.candidate.listcandidate.ListCandidateCont;
import com.zsgs.interviewpanel.interviewer.InterviewerMenu;
import com.zsgs.interviewpanel.interviewer.leave.LeaveApplyView;
import com.zsgs.interviewpanel.interviewer.listinters.ListInterviewsCont;

public class MenuController {

	
	
	public void startApp() {
		
		MenuView mView = new MenuView();
		
		int selectOpt;
		outerLoop:
		do {
			
			mView.initialMsg();
			selectOpt = mView.getInput();
			
			  if (selectOpt < 1 || selectOpt > 4) {
	                mView.printValidOpt2();
	                continue;
	            }
			
			switch(selectOpt) {
			case 1:
				AdminMenu adMenu = new AdminMenu();
			
				if (adMenu.adminMenu()) {
			        int adminOption;
			        adminLoop:
			        do {
			            adMenu.listAdminOptions();
			     
			            adminOption = mView.getInput();

			            if (adminOption<=0||adminOption>4) {
			            	mView.printValidOpt();
			                continue;
			            }

			            switch (adminOption) {
			                case 1:
			                    InterviewArrangeView intArrView = new InterviewArrangeView();
			                    intArrView.interviewArrView();
			                    break adminLoop;
			                case 2:
			                    ListInterviewCont listInterCont = new ListInterviewCont();
			                    listInterCont.listIntersCont();
			                    break adminLoop;
			                case 3:
			                	break adminLoop;
			            }
			        } while (adminOption < 4);
			          if(adminOption==4)
			        	break outerLoop;
			    }
			break;	
			case 2:
				InterviewerMenu interMenu = new InterviewerMenu();
				interMenu.interMenu();
				int interOpt;
				InterviewerLoop:
				do {
				 	interOpt=mView.getInput();
					
				 	if (interOpt<=0||interOpt>4) {
		            	mView.printValidOpt();
		                continue;
		            }
				 	
				 	switch(interOpt) {
				 	case 1:
				 		ListInterviewsCont listInterCont = new ListInterviewsCont();
				 		listInterCont.listInterviews();
				 		break InterviewerLoop;
				 	case 2:
				 		LeaveApplyView listAppView = new LeaveApplyView();
				 		listAppView.leaveApplyView();
				 		break InterviewerLoop;
				 	case 3:
				 		break InterviewerLoop;
				 	}
					
				}while(interOpt<4);
				if(interOpt==4)
				break outerLoop;
				
			case 3:	
				CandidateMenuCont candCont = new CandidateMenuCont();
				candCont.candMenu();
				int candSelectOpt;
				candLoop:
				do {
					candSelectOpt = mView.getInput();
					
					if(candSelectOpt<=0||candSelectOpt>4) {
						mView.printValidOpt();
						continue;
					}
					
					switch(candSelectOpt) {
					case 1:
						AddCandidateView adCandView = new AddCandidateView();
						adCandView.askingDetails();
						break candLoop;
					case 2:
						ListCandidateCont listCandCont = new ListCandidateCont();
						listCandCont.listCandidateCont();
						break candLoop;	
					case 3:
						break candLoop;
					}
				}while(candSelectOpt<4);
				if(candSelectOpt==4)
			     break outerLoop;
			}
			
		}while(selectOpt<4);
		mView.printTq();
		
	}

}
