package uk.ac.abdn.t3.model;

import java.util.UUID;

public class BboxData {
	String uniqueID = UUID.randomUUID().toString();
	private String device_id="unknown";
	private float lt;
	private float ln;
	private float al;
	private int sp;
	private String provid;
	public String getProvid() {
		return provid;
	}
	public void setProvid(String provid) {
		this.provid = provid;
	}
	private double ax_min;
	private double ax_max;
	private double ax_avg;
	private double ay_min;
	private double ay_max;
	private double ay_avg;
	private double az_min;
	private double az_max;
	private double az_avg;
	private int temp;
	private String time="00-00-00 00:00:00";
	private String tm="00-00-00 00:00:00";
	private int cs;
	private float batt;	
	private int cornering_level;
	private int braking_level;
	private int distance;
	
	String prefixes="PREFIX ttt:<http://t3.abdn.ac.uk/ontologies/t3.owl#"+
	"				 PREFIX iota:<http://t3.abdn.ac.uk/ontologies/iota.owl#"
	+ "           prefix rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "+
			"";
					
	
	public int getCornering_level() {
		return cornering_level;
	}
	public void setCornering_level(int cornering_level) {
		this.cornering_level = cornering_level;
	}
	public int getBraking_level() {
		return braking_level;
	}
	public void setBraking_level(int braking_level) {
		this.braking_level = braking_level;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getUniqueID() {
		return uniqueID;
	}
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public float getLt() {
		return lt;
	}
	public void setLt(float lt) {
		this.lt = lt;
	}
	public float getLn() {
		return ln;
	}
	public void setLn(float ln) {
		this.ln = ln;
	}
	public float getAl() {
		return al;
	}
	public void setAl(float al) {
		this.al = al;
	}
	public int getSp() {
		return sp;
	}
	public void setSp(int sp) {
		this.sp = sp;
	}
	public double getAx_min() {
		return ax_min;
	}
	public void setAx_min(double ax_min) {
		this.ax_min = ax_min;
	}
	public double getAx_max() {
		return ax_max;
	}
	public void setAx_max(double ax_max) {
		this.ax_max = ax_max;
	}
	public double getAx_avg() {
		return ax_avg;
	}
	public void setAx_avg(double ax_avg) {
		this.ax_avg = ax_avg;
	}
	public double getAy_min() {
		return ay_min;
	}
	public void setAy_min(double ay_min) {
		this.ay_min = ay_min;
	}
	public double getAy_max() {
		return ay_max;
	}
	public void setAy_max(double ay_max) {
		this.ay_max = ay_max;
	}
	public double getAy_avg() {
		return ay_avg;
	}
	public void setAy_avg(double ay_avg) {
		this.ay_avg = ay_avg;
	}
	public double getAz_min() {
		return az_min;
	}
	public void setAz_min(double az_min) {
		this.az_min = az_min;
	}
	public double getAz_max() {
		return az_max;
	}
	public void setAz_max(double az_max) {
		this.az_max = az_max;
	}
	public double getAz_avg() {
		return az_avg;
	}
	public void setAz_avg(double az_avg) {
		this.az_avg = az_avg;
	}
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getTm() {
		return tm;
	}
	public void setTm(String tm) {
		this.tm = tm;
	}
	public int getCs() {
		return cs;
	}
	public void setCs(int cs) {
		this.cs = cs;
	}
	public float getBatt() {
		return batt;
	}
	public void setBatt(float batt) {
		this.batt = batt;
	}
	
	
	

}
