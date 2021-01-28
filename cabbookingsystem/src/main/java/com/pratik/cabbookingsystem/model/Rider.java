package com.pratik.cabbookingsystem.model;

public class Rider {
	private String name;
	private String id;
	private Trip trip;
	
	public Rider(String id, String name) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
