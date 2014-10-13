package uk.ac.abdn.t3.rest;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig;
import org.json.JSONObject;

import uk.ac.abdn.t3.model.BboxData;
import uk.ac.abdn.t3.model.DB;
import uk.ac.abdn.t3.model.ProvTrack;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("upload")
public class MyResource {

	DB d=DB.getDB();
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public int getIt(@DefaultValue("-10") @QueryParam("temp") int temp, 
    @DefaultValue("-10") @QueryParam("sp") int speed,
    @QueryParam("ax_min") int ax_min,
    @QueryParam("ax_max") int ax_max,
    @QueryParam("ax_avg") int ax_avg,
    @QueryParam("ay_min") int ay_min,
    @QueryParam("ay_max") int ay_max,
    @QueryParam("ay_avg") int ay_avg,
    @QueryParam("az_min") int az_min,
    @QueryParam("az_max") int az_max,
    @QueryParam("az_avg") int az_avg,
    @DefaultValue ("1") @QueryParam("gps") int gps,
    @QueryParam("time") String time,
    @QueryParam("tm")  String gpsTimeDate,
    @QueryParam("lt")  float latitude,
    @QueryParam("ln")  float longtitude,
    @QueryParam("al")  float altitude,
    @QueryParam("cs")  int course ) {
    	
    
    	
    	BboxData data=new BboxData();
    	data.setTemp(temp);
    	data.setAx_min(ax_min);
    	data.setAx_max(ax_max);
    	data.setAx_avg(ax_avg);
    	data.setAy_min(ay_min);
    	data.setAy_max(ay_max);
    	data.setAy_avg(ay_avg);
    	data.setAz_min(az_min);
    	data.setAz_max(az_max);
    	data.setAz_avg(az_avg);
    	data.setTime(time);
    	
    	if(gps!=0){
    	data.setTm(gpsTimeDate);
    	data.setAl(altitude);
    	data.setLn(longtitude);
    	data.setLt(latitude);
    	data.setCs(course);
    	}
    	return d.registerData(data);
    	
    }
    
    
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getReadings(String data) throws JsonParseException, JsonMappingException, IOException{
    	ObjectMapper mapper=new ObjectMapper();
    	mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    	BboxData dat=mapper.readValue(data,BboxData.class);
    int i=	d.registerData(dat);
    JSONObject json=new JSONObject();
    if(i==1){
    	json.put("collected", true);
    	json.put("agent", ProvTrack.bbox_ns+"BboxServer");
    	return Response.ok().entity(json.toString()).build();
    
    }
    else{
    	json.put("collected", false);
    }
 	return Response.ok().entity(json.toString()).build();
    	
    }
    
  
    
}
