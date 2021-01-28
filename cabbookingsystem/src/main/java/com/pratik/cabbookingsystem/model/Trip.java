package com.pratik.cabbookingsystem.model;

import com.pratik.cabbookingsystem.enums.TripStatus;

public class Trip {
	private Location from;
	private Location to;
	private TripStatus status;
	private Rider rider;
	private Cab cab;
	public Trip(Location from, Location to, TripStatus status, Rider rider,Cab cab) {
		super();
		this.from = from;
		this.to = to;
		this.status = status;
		this.rider = rider;
		this.cab=cab;
	}
	
	@Override
	public String toString() {
		return "Trip [from=" + from.toString() + ", to=" + to.toString() + ", status=" + status.toString() + ", rider=" + rider.getName() + ", cab=" + cab.getName() + "]";
	}

	public TripStatus getStatus() {
		return status;
	}
	public void setStatus(TripStatus status) {
		this.status = status;
	}
	public Rider getRider() {
		return rider;
	}
	
	public Cab getCab() {
		return cab;
	}
	
	public void endtrip()
	{
		this.status=TripStatus.Finished;
	}
}
