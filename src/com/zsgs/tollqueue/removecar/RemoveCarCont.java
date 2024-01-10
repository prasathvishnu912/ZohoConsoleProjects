package com.zsgs.tollqueue.removecar;


public class RemoveCarCont implements Runnable{
	
		private RemoveCarView rmCarView = new RemoveCarView();
		private RemoveCarModel removeCarModel = new RemoveCarModel();
		
		
		private void removeCar() {
	       
	       if(removeCarModel.removeCurrCar()) {
	    	   rmCarView.printSuccessRmMsg(removeCarModel.removeCurCar);   
	       }
	       
	    }
	    
	    public void run() {
	        while (true) {
	            try {
	            	Thread.sleep(60000);
	            	removeCar();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
}
