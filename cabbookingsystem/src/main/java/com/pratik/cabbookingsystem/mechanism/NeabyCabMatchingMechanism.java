package com.pratik.cabbookingsystem.mechanism;

import java.util.List;

import com.pratik.cabbookingsystem.model.Cab;
import com.pratik.cabbookingsystem.model.Location;

public class NeabyCabMatchingMechanism implements MatchingMechanism {

	public Cab matchRiderToCab(Location from, Location to, List<Cab> nearbycabs) throws Exception {
		// TODO Auto-generated method stub
		if(nearbycabs.size()==0)
		{
			throw new Exception("No cabs found!!");
		}
		return nearbycabs.get(0); 
	}

}
