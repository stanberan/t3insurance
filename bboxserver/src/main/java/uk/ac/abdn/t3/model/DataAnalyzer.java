package uk.ac.abdn.t3.model;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DataAnalyzer {
	
	double basic_rate=30;
	
	int low_turns;      // 1.001; %
	int medium_turns;   // 1.003; %
	int high_turns;     //1.01;   %
	
	int low_braking;    //1.001;
	int medium_braking;  //1.003;
	int high_braking;   //1.01;
	
	int speeding;        //1.02
	
	double LOW_TURN_RATE=0.001;
	double MEDIUM_TURN_RATE=0.003;
	double HIGH_TURN_RATE=0.01;
	double LOW_BRAKING_RATE=0.001;
	double MEDIUM_BRAKING_RATE=0.003;
	double HIGH_BRAKING_RATE=0.001;
	
	DB db=DB.getDB();
	
	
	public void calculatePremium(Client u){
		String deviceid=u.getDeviceid();
		//last ten minutes
		String query="SELECT * FROM data WHERE tsreceived>=NOW() - INTERVAL 10 MINUTE AND deviceid=?";
	try{
		if(DB.conn.isClosed()){
			DB.conn=DriverManager.getConnection(Configuration.url+Configuration.dbName,Configuration.userName,Configuration.password);
		}
		PreparedStatement p=DB.conn.prepareStatement(query);
		p.setString(1, deviceid);
		ResultSet rs=p.executeQuery();	
		while(rs.next()){
			int cornering=rs.getInt("cornering_level");
			int braking=rs.getInt("braking_level");
			if(cornering==2){
				low_turns++;
			}
			if(cornering==3){
				medium_turns++;
			}
			if(cornering==4){
				high_turns++;
			}
			if(braking==2){
				low_braking++;
			}
			if(braking==3){
				medium_braking++;
				
			}
			if(braking==4){
				high_braking++;
			}
		}
		
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
		
	double currentP=u.getCurrentPremium();
	double newP=((LOW_TURN_RATE*low_turns+MEDIUM_TURN_RATE*medium_turns+HIGH_TURN_RATE*high_turns+low_braking*LOW_BRAKING_RATE
			+medium_braking*MEDIUM_BRAKING_RATE+high_braking*HIGH_BRAKING_RATE)*currentP)+currentP;
	//check total distance
	//check speeding
	
	if(newP>currentP){
		String update="UPDATE clients SET premium=? WHERE id=?";
		try{
		PreparedStatement p=DB.conn.prepareStatement(update);
		p.setDouble(1, newP);
		p.setInt(2, u.getId());
		int i=p.executeUpdate();
		if(i>0){
			String message="Dear "+u.getLast_name()+",\n\n We are writing to you as your insurance premium has been increased due to your past "+
					"driving behaviour.\n\n Old Premium:\t"+currentP +"\n UPDATED Premium:\t"+newP+"\n\nKind Regards\n INSUREBBOX LTD Financial Team";
			new SendMailTLS().sendMail(u.getEmail(), message);
		}
		}
		catch(Exception e){e.printStackTrace();}
	
	
		
		
	}
		
		
	}
	

}
