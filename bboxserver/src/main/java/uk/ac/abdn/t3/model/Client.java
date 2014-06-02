package uk.ac.abdn.t3.model;

public class Client {
	
	private int id;
	private String first_name;
	private String last_name;
	private String deviceid;
	private float totalDistance;
	private double currentPremium;
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	public float getTotalDistance() {
		return totalDistance;
	}
	public void setTotalDistance(float totalDistance) {
		this.totalDistance = totalDistance;
	}
	public double getCurrentPremium() {
		return currentPremium;
	}
	public void setCurrentPremium(double currentPremium) {
		this.currentPremium = currentPremium;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
