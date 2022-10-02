package com.beanClasses;

public class BusDetailsBean {
     
	private String busName;
	private String busStart;
	private String busEnd;
	private String busType;
	private int totalSeats;
	private String departureTime;
	private String busarrivalTime;
	
	
	public BusDetailsBean(String busName, String busStart, String busEnd, String busType, int totalSeats,
			String departureTime, String busarrivalTime) {
		super();
		this.busName = busName;
		this.busStart = busStart;
		this.busEnd = busEnd;
		this.busType = busType;
		this.totalSeats = totalSeats;
		this.departureTime = departureTime;
		this.busarrivalTime = busarrivalTime;
	}


	public BusDetailsBean() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "BusDetailsBean [busName=" + busName + ", busStart=" + busStart + ", busEnd=" + busEnd + ", busType="
				+ busType + ", totalSeats=" + totalSeats + ", departureTime=" + departureTime + ", busarrivalTime="
				+ busarrivalTime + "]";
	}


	public String getBusName() {
		return busName;
	}


	public void setBusName(String busName) {
		this.busName = busName;
	}


	public String getBusStart() {
		return busStart;
	}


	public void setBusStart(String busStart) {
		this.busStart = busStart;
	}


	public String getBusEnd() {
		return busEnd;
	}


	public void setBusEnd(String busEnd) {
		this.busEnd = busEnd;
	}


	public String getBusType() {
		return busType;
	}


	public void setBusType(String busType) {
		this.busType = busType;
	}


	public int getTotalSeats() {
		return totalSeats;
	}


	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}


	public String getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}


	public String getBusarrivalTime() {
		return busarrivalTime;
	}


	public void setBusarrivalTime(String busarrivalTime) {
		this.busarrivalTime = busarrivalTime;
	}

	
	
	
}
