package uk.ac.abdn.t3.model;

import java.util.UUID;

public class BboxData {
	String uniqueID = UUID.randomUUID().toString();
	private String device_id="unknown";
	private float lt;
	private float ln;
	private float al;
	private int sp;
	private int ax_min;
	private int ax_max;
	private int ax_avg;
	private int ay_min;
	private int ay_max;
	private int ay_avg;
	private int az_min;
	private int az_max;
	private int az_avg;
	private int temp;
	private String time="00-00-00 00:00:00";
	private String tm="00-00-00 00:00:00";
	private int cs;
	private float batt;
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
	public int getAx_min() {
		return ax_min;
	}
	public void setAx_min(int ax_min) {
		this.ax_min = ax_min;
	}
	public int getAx_max() {
		return ax_max;
	}
	public void setAx_max(int ax_max) {
		this.ax_max = ax_max;
	}
	public int getAx_avg() {
		return ax_avg;
	}
	public void setAx_avg(int ax_avg) {
		this.ax_avg = ax_avg;
	}
	public int getAy_min() {
		return ay_min;
	}
	public void setAy_min(int ay_min) {
		this.ay_min = ay_min;
	}
	public int getAy_max() {
		return ay_max;
	}
	public void setAy_max(int ay_max) {
		this.ay_max = ay_max;
	}
	public int getAy_avg() {
		return ay_avg;
	}
	public void setAy_avg(int ay_avg) {
		this.ay_avg = ay_avg;
	}
	public int getAz_min() {
		return az_min;
	}
	public void setAz_min(int az_min) {
		this.az_min = az_min;
	}
	public int getAz_max() {
		return az_max;
	}
	public void setAz_max(int az_max) {
		this.az_max = az_max;
	}
	public int getAz_avg() {
		return az_avg;
	}
	public void setAz_avg(int az_avg) {
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
