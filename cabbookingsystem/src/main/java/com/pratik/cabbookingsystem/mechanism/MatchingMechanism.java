package com.pratik.cabbookingsystem.mechanism;

import java.util.ArrayList;
import java.util.List;

import com.pratik.cabbookingsystem.model.Cab;
import com.pratik.cabbookingsystem.model.Location;

public interface MatchingMechanism {
	Cab matchRiderToCab(Location from,Location to,List<Cab> nearbycabs) throws Exception;
}
