package com.pratik.cabbookingsystem.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.pratik.cabbookingsystem.Exception.CabAlreadyRegisterException;
import com.pratik.cabbookingsystem.enums.TripStatus;
import com.pratik.cabbookingsystem.model.Cab;
import com.pratik.cabbookingsystem.model.Location;
import com.pratik.cabbookingsystem.model.NormalCab;


public class CabDAO{
	
	//to store the cabs
	HashMap<String, Cab> cabsInSystem = new HashMap<String, Cab>();
	
	//cab upto range of 10 km from the picup location will be consider for a ride
	private static final double DISTANCE = 10.0;
	//creating the cab
	public void creatcab(String driver_id,String driver_name) throws Exception
	{
		//checking if the cab is already register
		if(cabsInSystem.containsKey(driver_id))
		{
			throw new CabAlreadyRegisterException();
		}else {
			Cab normalCab = new NormalCab(driver_id, driver_name);
			cabsInSystem.put(driver_id, normalCab);
		}
		
	}
	
	//getting all the cab
	public HashMap<String, Cab> getallcab()
	{
		return cabsInSystem;
	}
	
	//upadte availibility
	public void changeAvailibility(String driver_id,boolean isavail) throws Exception
	{
		if(!cabsInSystem.containsKey(driver_id))
		{
			throw new Exception("Driver not found !");
		}else {
			Cab normalcab = cabsInSystem.get(driver_id);
			normalcab.setavailibility(isavail);
		}
	}
	
	//check if cab is available
	public boolean isAvail(String driver_id)
	{
		if(!cabsInSystem.containsKey(driver_id))
		{
			return false;
		}else {
			Cab normalcab = cabsInSystem.get(driver_id);
			return normalcab.getavailibilty();
		}
	}
	
	//check if cab is in_progress
	public boolean isInProgress(String driver_id)
	{
		if(!cabsInSystem.containsKey(driver_id))
		{
			return false;
		}else {
			Cab normalcab = cabsInSystem.get(driver_id);
			
			if(normalcab.getStatus().equals(TripStatus.In_Progress))
			{
				return true;
			}
		}
		return false;
	}
	
	//getCabDeatils
	public void printCabDetail(String driver_id) throws Exception
	{
		if(cabsInSystem.containsKey(driver_id))
		{
			throw new Exception("Driver not found!");
		}else {
			Cab normalCab = cabsInSystem.get(driver_id);
			normalCab.toString();
		}
	}
	
	//update the cab location
	public void updateLocation(String driver_id,double x,double y)throws Exception
	{
		if(!cabsInSystem.containsKey(driver_id))
		{
			throw new Exception("Driver not found!");
		}else {
			Cab normalCab = cabsInSystem.get(driver_id);
			Location location = new Location(x, y);
			normalCab.setLocation(location);
		}
	}
	
	//getcabsnearby
	public List<Cab> getNearByCab(Location location) throws Exception
	{
		ArrayList<Cab> nearbycabs = new ArrayList<Cab>();
		for (Entry<String, Cab> item : cabsInSystem.entrySet()) {
			Cab cab = item.getValue();
			if(cab.getLocation().distance(location)<DISTANCE && cab.getavailibilty() && cab.getTrip()==null)
			{
				nearbycabs.add(cab);
			}
		}
		if(nearbycabs.size()==0)
		{
			throw new Exception("no cabs found");
		}
		return nearbycabs;
		
	}
	
}
