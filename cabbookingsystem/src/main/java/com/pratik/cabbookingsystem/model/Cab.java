package com.pratik.cabbookingsystem.model;

import com.pratik.cabbookingsystem.enums.TripStatus;

public interface Cab {
	String getName();
	void setName(String name);
	void setLocation(Location location);
	Location getLocation();
	void setavailibility(boolean isavil);
	boolean getavailibilty();
	Trip getTrip();
	void setTrip(Trip trip);
	TripStatus getStatus();
	void setStatus(TripStatus t);
}
