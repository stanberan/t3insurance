package uk.ac.abdn.t3.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	 
	 
	 public ArrayList<Client> getClients(){
		 
		 ArrayList<Client> clients=new ArrayList<Client>();
		 try{
		 if(conn.isClosed()){
				conn=DriverManager.getConnection(Configuration.url+Configuration.dbName,Configuration.userName,Configuration.password);
			}
		 PreparedStatement pStatement=conn.prepareStatement("SELECT * FROM clients");
		 ResultSet rs=pStatement.executeQuery();
		 while(rs.next()){
			 Client c=new Client();
			 c.setCurrentPremium(rs.getDouble("premium"));
			 c.setDeviceid(rs.getString("deviceid"));
			 c.setEmail(rs.getString("email"));
			 c.setFirst_name(rs.getString("name"));
			 c.setLast_name(rs.getString("surname"));
			 c.setId(rs.getInt("id"));
			 
			 clients.add(c);
			 
		 }
		 return clients;
		 }
		 catch(Exception e){
			 e.printStackTrace();
			 return clients;
		 }
		 
		 
		 
	 }
	 public void trackIteration(String devid,long totalTime,boolean shared,boolean policycheck, boolean violated){
			Timestamp ts=new Timestamp(new Date().getTime());
			try{
			if(conn.isClosed()){
				conn=DriverManager.getConnection(Configuration.url+Configuration.dbName,Configuration.userName,Configuration.password);
			}
			PreparedStatement pStatement=conn.prepareStatement("INSERT into trackinsurance values(?,?,?,?,?,?)");
			pStatement.setTimestamp(1,ts);
			pStatement.setLong(2, totalTime);
			pStatement.setBoolean(3, shared);
			pStatement.setBoolean(4, policycheck);
			pStatement.setBoolean(5, violated);
			pStatement.setString(6, devid);
			int i= pStatement.executeUpdate();
			}
			catch(Exception e){
				e.printStackTrace();
			}
	 }
	 
	 
	 public int registerData(BboxData d) {
		 
			try{
				if(conn.isClosed()){
					conn=DriverManager.getConnection(Configuration.url+Configuration.dbName,Configuration.userName,Configuration.password);
				}
				Date da=new Date();
				Timestamp received=new Timestamp(da.getTime());
				Date gpsdate = new SimpleDateFormat("dd-mm-yy hh:mm:ss").parse(d.getTm());
				Date sentDate=new SimpleDateFormat("dd-mm-yy hh:mm:ss").parse(d.getTime());
				
				
			PreparedStatement pStatement=conn.prepareStatement("INSERT into data values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pStatement.setTimestamp(1,received);
			pStatement.setString(2,d.getUniqueID());
			pStatement.setString(3, d.getDevice_id());
			pStatement.setFloat(4, d.getLt());
			pStatement.setFloat(5, d.getLn());
			pStatement.setFloat(6,d.getAl());
			pStatement.setInt(7,d.getSp());
			pStatement.setInt(8,d.getCs());
			pStatement.setDouble(9,d.getAx_min());
			pStatement.setDouble(10,d.getAx_max());
			pStatement.setDouble(11,d.getAx_avg());
			pStatement.setDouble(12,d.getAy_min());
			pStatement.setDouble(13,d.getAy_max());
			pStatement.setDouble(14,d.getAy_avg());
			pStatement.setDouble(15,d.getAz_min());
			pStatement.setDouble(16,d.getAz_max());
			pStatement.setDouble(17,d.getAz_avg());
			pStatement.setInt(18,d.getTemp());
			pStatement.setTimestamp(19,new Timestamp(gpsdate.getTime()));
			pStatement.setTimestamp(20,new Timestamp(sentDate.getTime()));
			pStatement.setFloat(21, d.getDistance());
			pStatement.setFloat(22, d.getCornering_level());
			pStatement.setFloat(23, d.getBraking_level());
			pStatement.setString(24, d.getProvid());
			pStatement.setFloat(25, d.getBatt());

			int i= pStatement.executeUpdate();
			System.out.println("Result is"+i);
			return 1;
			}
			catch(Exception e){
				e.printStackTrace();
				return 0;
			}
		}

	 public static void main(String[] args){
		
	
}
}