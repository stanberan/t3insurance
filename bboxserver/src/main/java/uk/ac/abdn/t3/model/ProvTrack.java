package uk.ac.abdn.t3.model;

import java.util.ArrayList;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class ProvTrack {
	static String DEVICE_ID="BboxSimulatorV2";
	static ArrayList<String> provTrack=new ArrayList<String>();
	static String type="<http://www.w3.org/1999/02/22-rdf-syntax-ns#type> "; //space
	static String ttt_ns="ttt:";static String ttt_prefix="http://t3.abdn.ac.uk/ontologies/t3.owl#";
	static String prov_ns="prov:";static String prov_prefix="http://www.w3.org/ns/prov#";
	static String bbox_ns="bbox:"; static String bbox_prefix="http://t3.abdn.ac.uk/bbox/data#";
	
	
	static String wasAssociatedWith=prov_ns+"wasAssociatedWith ";
	static String wasGeneratedBy=prov_ns+"wasGeneratedBy ";
	static String used=prov_ns+"used ";
	static String entity=prov_ns+"entity ";
	static String atTime=prov_ns+"atTime ";
	static String Activity=prov_ns+"Activity ";
	static String Agent=prov_ns+"Agent ";
    static String Entity=prov_ns+"Entity ";
    static String Usage=prov_ns+"Usage ";
    static String PersonalData=ttt_ns+"PersonalData";
    static String purpose=ttt_ns+"purpose ";
    static String description=ttt_ns+"description ";
   static String SP=" ";
   static String DT=".";
   
   
   public void getTrack(){

	   
	   
   }
	
	public static void addStatement(String statement){
		provTrack.add(statement);		
	}
	
	
	
	
	
	public static void sendProv(){
		
		String prefixes="@prefix : <"+bbox_ns+"> . ";
		String body="{\"body\":\"@prefix bbox: <"+bbox_prefix+"> ."+"@prefix prov: <"+prov_prefix+"> ."+"@prefix ttt: <"+ttt_prefix+"> .";
				
				
				for (int i=0; i<provTrack.size();i++){
					String line=provTrack.get(i);
					body+=line+" .";		
					
				}
		
		provTrack.clear();
		
	 body+="\"}";
System.out.println(body);
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		try {
		    HttpPost request = new HttpPost("http://localhost:8080/t3v2/upload/"+DEVICE_ID+"/prov");
		    StringEntity params = new StringEntity(body);
		    request.addHeader("content-type", "application/json");
		    request.setEntity(params);
		   HttpResponse resp= httpClient.execute(request);
		  System.out.println("StatusCode: "+ resp.getStatusLine().getStatusCode());
		// handle response here...
		} catch (Exception ex) {
		   ex.printStackTrace();
		} finally {
		   // httpClient.close();
		}
		
		
		
	}
}
