package com.pratik.cabbookingsystem;

import java.util.Map.Entry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.pratik.cabbookingsystem.Controller.CabsController;
import com.pratik.cabbookingsystem.Controller.RiderController;
import com.pratik.cabbookingsystem.DAO.CabDAO;
import com.pratik.cabbookingsystem.DAO.RiderDAO;
import com.pratik.cabbookingsystem.DAO.TripDAO;
import com.pratik.cabbookingsystem.mechanism.NeabyCabMatchingMechanism;
import com.pratik.cabbookingsystem.model.Cab;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CabMainApp 
{
	
    public static void main( String[] args )
    {
    	CabDAO cabdao = new CabDAO();
    	RiderDAO riderDAO = new RiderDAO();
    	NeabyCabMatchingMechanism neabyCabMatchingMechanism = new NeabyCabMatchingMechanism();
    	TripDAO tripDAO = new TripDAO(neabyCabMatchingMechanism, cabdao);
        CabsController cabsController= new CabsController(cabdao);
        RiderController riderController = new RiderController(riderDAO, tripDAO);
       
        //register a cab
    	cabsController.RegisterCab("1", "Pratik");
    	cabsController.RegisterCab("2", "Ramesh");
    	cabsController.RegisterCab("3", "Rahul");
    	
    	for (Entry<String, Cab> item : cabdao.getallcab().entrySet()) {
			System.out.println(item.getKey()+" "+item.getValue().getName());
		}
    	
    	cabsController.updateCabLocation("1", 1, 1);
    	cabsController.updateCabLocation("2", 2, 2);
    	cabsController.updateCabLocation("3", 2, 2);
    	
    	for (Entry<String, Cab> item : cabdao.getallcab().entrySet()) {
			System.out.println(item.getKey()+" "+item.getValue().toString());
		}
    	riderController.RegisterRider("1", "rider 1");
    	riderController.RegisterRider("2", "rider2");
    	riderController.RegisterRider("3", "rider3");
    	riderController.RegisterRider("4", "rider4");
    	
    	cabsController.ChangeAvailibility("1", false);
    	for (Entry<String, Cab> item : cabdao.getallcab().entrySet()) {
			System.out.println(item.getKey()+" "+item.getValue().toString());
		}
    	cabsController.ChangeAvailibility("1", true);
    	for (Entry<String, Cab> item : cabdao.getallcab().entrySet()) {
			System.out.println(item.getKey()+" "+item.getValue().toString());
		}
    	
    	System.out.println("-------------all riders----------------");
    	riderDAO.getallrider();
    	System.out.println();
    	riderController.BookCab("1", 0, 3, 4, 5);
    	System.out.println("-------------all trips------------------");
    	tripDAO.getalltrips();
    	System.out.println();
    	riderController.BookCab("2", 0, 4, 0, 2);
    	System.out.println("-------------all trips------------------");
    	tripDAO.getalltrips();
    	riderController.BookCab("3", 1, 4, 0, 2);
    	System.out.println("-------------all trips------------------");
    	tripDAO.getalltrips();
    	
    	
    	riderController.BookCab("4", 1, 4, 0, 2);
    	System.out.println("-------------all trips------------------");
    	tripDAO.getalltrips();
    	
    	riderController.endTrip("1");
    	
    	riderController.BookCab("4", 1, 4, 0, 2);
    	System.out.println("-------------all trips------------------");
    	tripDAO.getalltrips();
    	
    	
    	riderController.endTrip("2");
    	riderController.endTrip("3");
    	riderController.endTrip("4");
    	
    	System.out.println("-------------all trips------------------");
    	tripDAO.getalltrips();
    	
    }
}
