package controller;

import DAO.DriverDAO;
import DAO.PlatformDAO;
import exceptions.NoDriverFoundException;
import exceptions.NoRideFoundWithTheRideIdException;
import exceptions.UserAlreadyExist;

public class DriverController {
	
	private DriverDAO driverDAO;
	private PlatformDAO priPlatformDAO;
  public DriverController(DriverDAO driverDAO,PlatformDAO platformDAO) {
	// TODO Auto-generated constructor stub
	  this.driverDAO=driverDAO;
	  this.priPlatformDAO=platformDAO;
  }
  public String registerDriver(String name,long number,String licno)
  {
	  String resp="";
	  try {
		resp=driverDAO.registerDriver(name, number, licno);
	} catch (UserAlreadyExist e) {
		// TODO Auto-generated catch block
		return e.getMessage();
	}
	  return resp;
  }
  public String endtrip(String rideid)
  {
	  String resp="";
	  try {
		resp= priPlatformDAO.endRide(rideid);
	} catch (NoRideFoundWithTheRideIdException e) {
		// TODO Auto-generated catch block
		return e.getMessage();
	}
	  return resp;
  }
}
