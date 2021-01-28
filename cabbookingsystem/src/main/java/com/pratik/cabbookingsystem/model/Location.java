package com.pratik.cabbookingsystem.model;

public class Location {
	private double x;
	private double y;
	public Location(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	//manhattan distance
	public double distance(Location location)
	{
		return Math.abs(this.x-location.x)+Math.abs(this.y-location.y);
	}

	@Override
	public String toString() {
		return "Location [x=" +x + ", y=" +y + "]";
	}
	
}
