package com.pratik.cabbookingsystem.model;

import com.pratik.cabbookingsystem.enums.TripStatus;

public class NormalCab implements Cab {
	private String driver_id;
	private String vehicle="Shift diser";
	private String driver_name;
	private Location location;
	private boolean isAvail=true;
	private Trip trip;
	public NormalCab(String driver_id, String driver_name) {
		super();
		this.driver_id = driver_id;
		this.driver_name = driver_name;
		this.location=new Location(0,0);
	}
	public String getName() {
		// TODO Auto-generated method stub
		return this.driver_name;
	}
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.driver_name=name;
		
	}
	public void setLocation(Location location) {
		// TODO Auto-generated method stub
		this.location=location;
		
	}
	public Location getLocation() {
		// TODO Auto-generated method stub
		return this.location;
	}
	public void setavailibility(boolean isavil) {
		// TODO Auto-generated method stub
		this.isAvail = isavil;
		
	}
	public boolean getavailibilty() {
		// TODO Auto-generated method stub
		return isAvail;
	}
	public String getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(String driver_id) {
		this.driver_id = driver_id;
	}
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	public TripStatus getStatus() {
		// TODO Auto-generated method stub
		return this.trip.getStatus();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("driver_id=" + driver_id + ", vehicle=" + vehicle + ", driver_name=" + driver_name
				+ ", location=" + location.toString() + ", isAvail=" + isAvail + "");
		if(this.trip!=null)
		{
			sb.append(",Trip= "+sb.toString());
		}else {
			sb.append(",Trip= No Trip currently");
		}
		return sb.toString();
	}
	public void setStatus(TripStatus t) {
		// TODO Auto-generated method stub
		this.trip.setStatus(t);
		
	}
	
	
	
	
	
}
