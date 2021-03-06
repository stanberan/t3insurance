package uk.ac.abdn.t3.rest;

import java.util.ArrayList;













import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import uk.ac.abdn.t3.model.AnalyseTimer;
import uk.ac.abdn.t3.model.Client;
import uk.ac.abdn.t3.model.DB;
import uk.ac.abdn.t3.model.DataAnalyzer;
import uk.ac.abdn.t3.model.ProvTrack;
import uk.ac.abdn.t3.model.SendMailTLS;

@Path("check")
public class Check {
	static  AnalyseTimer timer=null;
		
	  @GET
	    @Path("carmanufacturer/toggle")
	    @Produces(MediaType.TEXT_PLAIN)
	    public String activatePerf(){
		 DataAnalyzer.SHARE_DATA=!DataAnalyzer.SHARE_DATA;
		  return ""+DataAnalyzer.SHARE_DATA;
	  }
	
	@GET
	@Path("premiums/once")
	public String check_premiums(){
		System.out.println("Checking premiums");
		ArrayList<Client> clients=DB.getDB().getClients();
		
		for(int i=0;i<clients.size();i++){
			DataAnalyzer analyse=new DataAnalyzer();
			analyse.calculatePremium(clients.get(i));
		
			
		}
		
		return "Done";
	}
		@GET
		@Path("email/send")
		public String check_email(){
		SendMailTLS mail=new SendMailTLS();
			
	mail.sendMail("contact@stanberan.org", "This is a test message from bbox server.");
			
			return "Done";
		
	}
	@GET
	@Path("premiums/loop/{minutes}")
	public String loop_premiums(@PathParam ("minutes") int minutes){
		timer=new AnalyseTimer(minutes);
		timer.start();
		
		return "Timer Started";
		
		
	}
	@GET
	@Path("premiums/stop/timer")
	public String cancel(){
	if(timer!=null){
		timer.stopTimer();
	}
		return "Timer Stopped";
		
		
	}
}
