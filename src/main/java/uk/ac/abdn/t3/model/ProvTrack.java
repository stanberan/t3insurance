package uk.ac.abdn.t3.model;

import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class ProvTrack {
	
	
	 
	static String type="<http://www.w3.org/1999/02/22-rdf-syntax-ns#type> "; //space
	static  String ttt_ns="ttt:";static String ttt_prefix="http://t3.abdn.ac.uk/ontologies/t3.owl#";
	static  String prov_ns="prov:";static String prov_prefix="http://www.w3.org/ns/prov#";
	public static String bbox_ns="bbox:";
	
	String devid;
	String bbox_prefix;
	ArrayList<String> provTrack=new ArrayList<String>();
	
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
    static String qualifiedUsage=prov_ns+"qualifiedUsage ";
    static String Accelerometer=ttt_ns+"Accelerometer";
    static String Location=ttt_ns+"Location";
    static String Performance=ttt_ns+"Performance";
    static String Speed=ttt_ns+"Speed";
    static String BillingData=ttt_ns+"BillingData";
   static String SP=" ";
   static String DT=".";
   public ProvTrack(String devid){
	   bbox_prefix="http://t3.abdn.ac.uk/t3v2/1/device/"+devid+"/";
	   this.devid=devid;
   }
   
   public void getTrack(){

	   
	   
   }
	
	public void addStatement(String statement){
		provTrack.add(statement);		
	}
	
	
	public void checkPolicy(){
		
	//	String prefixes="@prefix : <"+bbox_ns+"> . ";
		String body="{\"body\":\"@prefix bbox: <"+bbox_prefix+"> ."+"@prefix prov: <"+prov_prefix+"> ."+"@prefix ttt: <"+ttt_prefix+"> ."+"@prefix xsd:<http://www.w3.org/2001/XMLSchema>.";
				
				
				for (int i=0; i<provTrack.size();i++){
					String line=provTrack.get(i);
					body+=line+" .";		
					
				}
		

		
	 body+="\"}";
System.out.println(body);
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		try {
		    HttpPost request = new HttpPost("http://t3.abdn.ac.uk:8080/t3v2/1/device/"+devid+"/policy/check");
		    StringEntity params = new StringEntity(body);
		    request.addHeader("content-type", "application/json");
		    request.setEntity(params);
		   HttpResponse resp= httpClient.execute(request);
		  System.out.println("StatusCode: "+ resp.getStatusLine().getStatusCode());
	
		} catch (Exception ex) {
		   ex.printStackTrace();
		} finally {
		   // httpClient.close();
		}
		
		
		
		
	}
	
	
	public void sendProv(){
		
	//	String prefixes="@prefix : <"+bbox_ns+"> . ";
		String body="{\"body\":\"@prefix bbox: <"+bbox_prefix+"> ."+"@prefix prov: <"+prov_prefix+"> ."+"@prefix ttt: <"+ttt_prefix+"> ."+"@prefix xsd:<http://www.w3.org/2001/XMLSchema>.";
				
				
				for (int i=0; i<provTrack.size();i++){
					String line=provTrack.get(i);
					body+=line+" .";		
					
				}
		
		provTrack.clear();
		
	 body+="\"}";
System.out.println(body);
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		try {
		    HttpPost request = new HttpPost("http://t3.abdn.ac.uk:8080/t3v2/1/device/upload/"+devid+"/prov");
		    StringEntity params = new StringEntity(body);
		    request.addHeader("content-type", "application/json");
		    request.setEntity(params);
		   HttpResponse resp= httpClient.execute(request);
		  System.out.println("StatusCode: "+ resp.getStatusLine().getStatusCode());
	
		} catch (Exception ex) {
		   ex.printStackTrace();
		} finally {
		   // httpClient.close();
		}
		
		
		
	}
}
