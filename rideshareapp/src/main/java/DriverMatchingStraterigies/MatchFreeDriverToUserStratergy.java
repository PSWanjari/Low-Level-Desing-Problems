package DriverMatchingStraterigies;

import java.util.List;
import java.util.Map.Entry;

import DAO.DriverDAO;
import Enums.DriverStatus;
import exceptions.NoDriverFoundException;
import model.Driver;
import model.User;

public class MatchFreeDriverToUserStratergy implements DriverMatachingStratergies {

	private DriverDAO driverDAO;
	public MatchFreeDriverToUserStratergy(DriverDAO driverDAO) {
		// TODO Auto-generated constructor stub
		this.driverDAO=driverDAO;
	}
	public Driver MatchDriverToUSer(User user, int from, int to) throws NoDriverFoundException {
		// TODO Auto-generated method stub
		//matching free driver 
		Driver matchdriver=null;
		List<Driver> drivers = driverDAO.getallDrivers();
		for (Driver driver : drivers) {
			if(driver.getStatus().equals(DriverStatus.free))
			{
				matchdriver=driver;
				break;
			}
		}
		if(matchdriver==null)
		{
			throw new NoDriverFoundException();
		}
		return matchdriver;
	}

}
