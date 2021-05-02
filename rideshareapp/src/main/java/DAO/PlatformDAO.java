package DAO;

import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.lang3.RandomStringUtils;

import com.google.gson.Gson;

import CostingStrategeries.CostingStratergy;
import Enums.DriverStatus;
import exceptions.NoRideFoundWithTheRideIdException;
import model.Driver;
import model.Ride;
import model.User;

public class PlatformDAO {
	HashMap<String, Ride> rides ;
	public static final int PRIORITY_RIDE_COUNT=10;
	private CostingStratergy costingStratergy;
	public PlatformDAO() {
		// TODO Auto-generated constructor stub
		rides = new HashMap<String, Ride>();
	}
	
	public int numberOfRidesBy(User user)
	{
		int count=0;
		for (Entry<String, Ride> map : rides.entrySet()) {
			if(map.getValue().getUser().getContact().equals(user.getContact()))
			{
				count++;
			}
		}
		return count;
	}
	
	public Ride startRide(User user,Driver driver,int from,int to,int seats)
	{
		String rideid = RandomStringUtils.random(10, true, true);
		Ride ride = new Ride(rideid,user, driver, from, to,seats);
		driver.setStatus(DriverStatus.driving);
		rides.put(rideid, ride);
		return ride;
		
	}
	public String endRide(String rideid) throws NoRideFoundWithTheRideIdException
	{
		if(!rides.containsKey(rideid))
		{
			throw new NoRideFoundWithTheRideIdException();
		}
		Ride ride = rides.get(rideid);
		ride.endRide();
		if(numberOfRidesBy(ride.getUser())>=PRIORITY_RIDE_COUNT)
		{
			ride.getUser().setPreffereduser(true);
		}
		ride.getDriver().setStatus(DriverStatus.free);
		return "Ride Ended Succesfully";
	}
	
}
