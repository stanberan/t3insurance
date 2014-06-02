package uk.ac.abdn.t3.rest;

import java.util.ArrayList;








import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import uk.ac.abdn.t3.model.AnalyseTimer;
import uk.ac.abdn.t3.model.Client;
import uk.ac.abdn.t3.model.DB;
import uk.ac.abdn.t3.model.DataAnalyzer;

@Path("check")
public class Check {


	
	@GET
	@Path("premiums/once")
	public String check_premiums(){
		ArrayList<Client> clients=DB.getDB().getClients();
		
		for(int i=0;i<clients.size();i++){
			DataAnalyzer analyse=new DataAnalyzer();
			analyse.calculatePremium(clients.get(i));
		
			
		}
		
		return "Done";
		
		
	}
	@GET
	@Path("premiums/loop/{minutes}")
	public String loop_premiums(@PathParam ("minutes") int minutes){
		 AnalyseTimer timer=new AnalyseTimer(minutes);
		timer.start();
		
		return "Timer Started";
		
		
	}
}
