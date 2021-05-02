package DAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import Enums.DriverStatus;
import exceptions.UserAlreadyExist;
import exceptions.UserNotFound;
import model.Driver;


public class DriverDAO {
   
	HashMap<Long, Driver> registered_drivers;
	
	public DriverDAO() {
		// TODO Auto-generated constructor stub
		registered_drivers = new HashMap<Long, Driver>();
	}
	
	public String registerDriver(String name,long number,String licno) throws UserAlreadyExist
	{
		if(registered_drivers.containsKey(number))
		{
			throw new UserAlreadyExist();
		}
		Driver driver = new Driver(name, number, licno);
		registered_drivers.put(number, driver);
		return "Driver "+name+" succesfully registered";
	}
	
	public Driver getDriver(long number) throws UserNotFound
	{
		if(!registered_drivers.containsKey(number))
		{
			throw new UserNotFound();
		}
		
		return registered_drivers.get(number);
	}
	public List<Driver> getallDrivers()
	{
		List<Driver> drivers = new ArrayList<Driver>();
		for (Entry<Long, Driver> item : registered_drivers.entrySet()) {
			drivers.add(item.getValue());
		}
		return drivers;
	}
	public void markdriveraway(long number) throws UserNotFound
	{
		if(!registered_drivers.containsKey(number))
		{
			throw new UserNotFound();
		}
		
		registered_drivers.get(number).setStatus(DriverStatus.away);
	}
}
