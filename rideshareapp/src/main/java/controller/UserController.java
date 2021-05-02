package controller;


import com.google.gson.Gson;

import CostingStrategeries.CostingStratergy;
import DAO.DriverDAO;
import DAO.PlatformDAO;
import DAO.UserDAO;
import DriverMatchingStraterigies.DriverMatachingStratergies;
import exceptions.NoDriverFoundException;
import exceptions.UserAlreadyExist;
import exceptions.UserNotFound;
import model.Driver;
import model.Ride;
import model.User;

public class UserController {

	private PlatformDAO platformDAO;
	private DriverDAO driverDAO;
	private UserDAO userDAO;
	private DriverMatachingStratergies driverMatachingStratergies;
	private CostingStratergy costingStratergy;
	public UserController(PlatformDAO platformDAO,DriverDAO driverDAO,UserDAO userDAO,DriverMatachingStratergies driverMatachingStratergies,CostingStratergy costingStratergy) {
		// TODO Auto-generated constructor stub
		this.driverDAO=driverDAO;
		this.platformDAO=platformDAO;
		this.userDAO=userDAO;
		this.driverMatachingStratergies = driverMatachingStratergies;
		this.costingStratergy=costingStratergy;
	}
	public String registerUser(String name,long number)
	{
		String resp="";
		try {
			resp= userDAO.registerUser(name, number);
		} catch (UserAlreadyExist e) {
			// TODO Auto-generated catch block
		    resp=e.getMessage();
		}
		
		return resp;
	}
	public String RequestRide(long number,int from,int to,int seats)
	{
		 String resp="";
		try {
			
			User user = userDAO.getUser(number);
			Driver matchdriver = driverMatachingStratergies.MatchDriverToUSer(user, from, to);
			Ride ride=platformDAO.startRide(userDAO.getUser(number), matchdriver, from, to, seats);
			resp ="{ "
					+ "\"cost\":"+costingStratergy.calaculateCost(ride)+","+new Gson().toJson(ride);
		} catch (UserNotFound e) {
			
			return e.getMessage();
		}catch (NoDriverFoundException e) {
			return e.getMessage();
		}
		
		return resp;
		
		
	}
	
	
}
