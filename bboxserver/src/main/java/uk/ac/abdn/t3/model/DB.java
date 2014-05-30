package uk.ac.abdn.t3.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;




public class DB {
	static{
		System.setProperty("http.proxyHost", "proxy.abdn.ac.uk");
		  System.setProperty("http.proxyPort", "8080");
	}
	static DB singleton=null;
	static Connection conn=null;
	static int id=12;
	 public static DB getDB(){
   	  if (singleton!=null){
   		  return singleton;
   	  }
   	  else{
   		singleton=new DB();  
   	  
   	  try{
     Class.forName(Configuration.driver).newInstance();
     conn = DriverManager.getConnection(Configuration.url+Configuration.dbName,Configuration.userName,Configuration.password);
     return singleton;
   	  }
   	  catch(Exception e){
   		 
   		  e.printStackTrace();
   		  return null;
   	  }
   	  }
     }
	 
	 public String registerData(BboxData d) {
		 
			try{
				if(conn.isClosed()){
					conn=DriverManager.getConnection(Configuration.url+Configuration.dbName,Configuration.userName,Configuration.password);
				}
				Date da=new Date();
				Timestamp received=new Timestamp(da.getTime());
				Date gpsdate = new SimpleDateFormat("dd-mm-yy hh:mm:ss").parse(d.getTm());
				Date sentDate=new SimpleDateFormat("dd-mm-yy hh:mm:ss").parse(d.getTime());
				
				
			PreparedStatement pStatement=conn.prepareStatement("INSERT into data values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pStatement.setTimestamp(1,received);
			pStatement.setString(2,d.getUniqueID());
			pStatement.setString(3, d.getDevice_id());
			pStatement.setFloat(4, d.getLt());
			pStatement.setFloat(5, d.getLn());
			pStatement.setFloat(6,d.getAl());
			pStatement.setInt(7,d.getSp());
			pStatement.setInt(8,d.getCs());
			pStatement.setInt(9,d.getAx_min());
			pStatement.setInt(10,d.getAx_max());
			pStatement.setInt(11,d.getAx_avg());
			pStatement.setInt(12,d.getAy_min());
			pStatement.setInt(13,d.getAy_max());
			pStatement.setInt(14,d.getAy_avg());
			pStatement.setInt(15,d.getAz_min());
			pStatement.setInt(16,d.getAz_max());
			pStatement.setInt(17,d.getAz_avg());
			pStatement.setInt(18,d.getTemp());
			pStatement.setTimestamp(19,new Timestamp(gpsdate.getTime()));
			pStatement.setTimestamp(20,new Timestamp(sentDate.getTime()));
			

			int i= pStatement.executeUpdate();
			System.out.println("Result is"+i);
			return "All is fine and sound:"+i;
			}
			catch(Exception e){
				e.printStackTrace();
				return "Something went wrong when saving to DB:"+e.getMessage();
			}
		}

	 public static void main(String[] args){
		
	
}
}