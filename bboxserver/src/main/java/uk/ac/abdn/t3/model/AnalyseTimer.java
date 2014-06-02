package uk.ac.abdn.t3.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class AnalyseTimer {

	
	long delay = 10*60*1000; // ms
    LoopTask task = new LoopTask();
    Timer timer = new Timer("TaskName");
   
    public AnalyseTimer(int minutes){
    	if(minutes!=0 && minutes>0){
    	
    		delay=minutes*60*1000;
    	}
    }
    public void start() {
    timer.cancel();
    timer = new Timer("Tailor Premiums");
    Date executionDate = new Date(); 
    timer.scheduleAtFixedRate(task, executionDate, delay);
    }

    private class LoopTask extends TimerTask {
    public void run() {
    	System.out.println("Every minute:"+new Date().toString());
ArrayList<Client> clients=DB.getDB().getClients();
		
		for(int i=0;i<clients.size();i++){
			DataAnalyzer analyse=new DataAnalyzer();
			analyse.calculatePremium(clients.get(i));
		
			
		}
    }
    }

    public static void main(String[] args) {
    AnalyseTimer executingTask = new AnalyseTimer(1);
    executingTask.start();
    }
	
}
