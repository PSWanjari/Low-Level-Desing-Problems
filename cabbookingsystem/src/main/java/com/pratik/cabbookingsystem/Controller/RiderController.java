package com.pratik.cabbookingsystem.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pratik.cabbookingsystem.DAO.CabDAO;
import com.pratik.cabbookingsystem.DAO.RiderDAO;
import com.pratik.cabbookingsystem.DAO.TripDAO;
import com.pratik.cabbookingsystem.mechanism.MatchingMechanism;
import com.pratik.cabbookingsystem.mechanism.NeabyCabMatchingMechanism;
import com.pratik.cabbookingsystem.model.Location;
import com.pratik.cabbookingsystem.model.Trip;

@RequestMapping(value = "/rider/")
public class RiderController {
	private RiderDAO riderDAO;
	private TripDAO tDao;
	
	
	public RiderController(RiderDAO riderDAO, TripDAO tDao) {
		super();
		this.riderDAO = riderDAO;
		this.tDao = tDao;
		
	}

	//register a dreiver
	@RequestMapping(value = "/register" , method = RequestMethod.POST)
	public ResponseEntity RegisterRider(String rider_id,String name)
	{
		
		try {
			riderDAO.registerRider(rider_id, name);
			System.out.println("rider registered succesfully!!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok("");
	}
	
	//bookcab
	@RequestMapping(value = "/book/cab",method = RequestMethod.POST)
	public ResponseEntity BookCab(String id,double x,double y,double x1,double y1)
	{
		
		try {
			tDao.createTrip(riderDAO.getrider(id), new Location(x, y), new Location(x1, y1));
			System.out.println("Trip created succesfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok("");
	}
	
	@RequestMapping(value = "/endtrip")
	public ResponseEntity endTrip(String rider_id)
	{
		tDao.endTrip(rider_id);
		return null;
	}
	//fetch rider history
	@RequestMapping(value = "/fetchhistory")
	public ResponseEntity FetchTripHiostory(String rider_id)
	{
		try {
			List<Trip> trips =tDao.fetchHistory(rider_id);
			for (Trip trip : trips) {
				System.out.println(trip.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok("");
		
	}
	
}
