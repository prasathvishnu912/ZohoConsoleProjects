package com.zsgs.tollqueue;

import com.zsgs.tollqueue.addcar.AddCarCont;
import com.zsgs.tollqueue.removecar.RemoveCarCont;

public class TollQueueMain {

	
	
	 public  void start() {
	    	
	        Runnable adC = new AddCarCont();
	        Runnable remC = new RemoveCarCont();

	         Thread addingCarThread = new Thread(adC);
	         Thread removingCarThread = new Thread(remC);

	         addingCarThread.setPriority(10);
	         removingCarThread.setPriority(8);
	         
	        
	        addingCarThread.start();
	        removingCarThread.start();
	        
	        
	    }

	

}
