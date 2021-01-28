package com.pratik.cabbookingsystem.DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import com.pratik.cabbookingsystem.enums.TripStatus;
import com.pratik.cabbookingsystem.mechanism.MatchingMechanism;
import com.pratik.cabbookingsystem.model.Cab;
import com.pratik.cabbookingsystem.model.Location;
import com.pratik.cabbookingsystem.model.Rider;
import com.pratik.cabbookingsystem.model.Trip;


public class TripDAO {
	HashMap<String ,Trip> trips_in_system = new  HashMap<String,Trip>();
	private MatchingMechanism matchingMechanism;
	private CabDAO cabDAO;
	
	
	
	public TripDAO(MatchingMechanism matchingMechanism, CabDAO cabDAO) {
		this.matchingMechanism = matchingMechanism;
		this.cabDAO = cabDAO;
	}

	
	//create trip
	public void createTrip(Rider rider ,Location from,Location to) throws Exception
	{
		
		Cab matchedCab;
		matchedCab = matchingMechanism.matchRiderToCab(from, to, cabDAO.getNearByCab(from));
		Trip trip = new Trip(from, to, TripStatus.In_Progress, rider, matchedCab);
		matchedCab.setTrip(trip);
		matchedCab.setStatus(TripStatus.In_Progress);
		
		trips_in_system.put(rider.getId(), trip);
		
		
		
	}
	
	//end Trip
	public void endTrip(String rider_id)
	{
		Trip currtrip = trips_in_system.get(rider_id);
		currtrip.getCab().setStatus(TripStatus.Finished);
		currtrip.endtrip();
		currtrip.getCab().setTrip(null);
	}
	
	//fetch trip history
	public List<Trip> fetchHistory(String rider_id) throws Exception
	{
		ArrayList<Trip> trips = new ArrayList<Trip>();
		for (Entry<String, Trip> item : trips_in_system.entrySet()) {
			if(item.getKey().equals(rider_id))
			{
				trips.add(item.getValue());
			}
		}
		if(trips.size()==0)
		{
			throw new Exception("No trips found for rider id "+rider_id);
		}
		
		return trips;
	}
	
	//get all trips
	public void getalltrips()
	{
		for (Entry<String, Trip> item : trips_in_system.entrySet()) {
			System.out.println(item.getValue().toString());
		}
	}
	
	
}
