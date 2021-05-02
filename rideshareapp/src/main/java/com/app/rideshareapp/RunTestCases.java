package com.app.rideshareapp;

import java.util.Scanner;

import CostingStrategeries.CostingStratergy;
import CostingStrategeries.DistanceAndSeatsBasedCostingStratergy;
import DAO.DriverDAO;
import DAO.PlatformDAO;
import DAO.UserDAO;
import DriverMatchingStraterigies.DriverMatachingStratergies;
import DriverMatchingStraterigies.MatchFreeDriverToUserStratergy;
import controller.DriverController;
import controller.UserController;
import model.Ride;

/**
 * Hello world!
 *
 */
public class RunTestCases 
{
    public static void main( String[] args )
    {
       UserDAO userDAO = new UserDAO();
       
       DriverDAO driverDAO = new DriverDAO();
       DriverMatachingStratergies driverMatachingStratergies = new MatchFreeDriverToUserStratergy(driverDAO);
       PlatformDAO platformDAO = new PlatformDAO();
       CostingStratergy costingStratergy = new DistanceAndSeatsBasedCostingStratergy(platformDAO);
       
       UserController userController = new UserController(platformDAO, driverDAO, userDAO, driverMatachingStratergies,costingStratergy);
       DriverController driverController = new  DriverController(driverDAO,platformDAO);
       
       Scanner sc = new Scanner(System.in);
      while(true)
      {
    	  System.out.println("press 0 to register User");
    	  System.out.println("press 1 to register Driver");
    	  System.out.println("Press 2 to request ride");
    	  System.out.println("press 3 to end ried");
    	  int opt = sc.nextInt();
    	  if(opt ==0)
    	  {
    		  System.out.println("Enter name");
    		  String name = sc.next();
    		  System.out.println("Enter number");
    		  long number = sc.nextLong();
    		  System.out.println(userController.registerUser(name, number));
    	  }else if(opt==1) {
    		  System.out.println("Enter name");
    		  String name = sc.next();
    		  System.out.println("Enter number");
    		  long number = sc.nextLong();
    		  System.out.println("Enter License number");
    		  String licno = sc.next();
    		  System.out.println(driverController.registerDriver(name, number, licno));
    	  }else if(opt==2){
    
    			  System.out.println("Enter user mobile");
    			  long number = sc.nextLong();
    			  System.out.println("Enter origin");
    			  int from = sc.nextInt();
    			  System.out.println("Enter destination");
    			  int to = sc.nextInt();
    			  System.out.println("Enter seats");
    			  int seats= sc.nextInt();
    			  System.out.println(userController.RequestRide(number, from, to, seats));
    		}else if(opt==3)
    		{
    		    System.out.println("Enter ride id to end the ride");
    		    String rideid = sc.next();
    		    System.out.println(driverController.endtrip(rideid));
    		}else {
    			System.out.println("Invalid operation");
    		}
		 System.out.println("************************************88");
      }
       
       
    }
}
