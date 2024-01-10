package com.zsgs;

import com.zsgs.interviewpanel.InterviewPanel;
import com.zsgs.tollqueue.TollQueueMain;
import com.zsgs.travels.TravelsMain;

public class ZSGSProjects {
    
	
	
	public static void main(String[] args) {
	     ZSGSProjectsView zsgsProjView = new ZSGSProjectsView();
	     zsgsProjView.printInitialMsg();
		int selectOpt;
		
		do {
			
			zsgsProjView.listOptions(new String[] {"1. InterviewPanel", "2. TollQueue", "3. Travels", "4. Exit"});
			selectOpt = zsgsProjView.getInput();
			
			if(selectOpt>4||selectOpt<=0) {
				zsgsProjView.printMsg("Enter valid input!!");
				continue;
			}
			
			switch(selectOpt) {
			case 1:
				InterviewPanel interPanel = new InterviewPanel();
				interPanel.start();
			    break;
			case 2:
				TollQueueMain tollQueue = new TollQueueMain();
				tollQueue.start();
				break;
			case 3:
				TravelsMain travelsMain = new TravelsMain();
				travelsMain.start();
				break;
			}
			
		}while(selectOpt!=4);
		zsgsProjView.printMsg("Thank you!!");
	}

}
