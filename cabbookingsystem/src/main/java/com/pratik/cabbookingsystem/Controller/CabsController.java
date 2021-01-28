package com.pratik.cabbookingsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.pratik.cabbookingsystem.DAO.CabDAO;
import com.pratik.cabbookingsystem.DAO.TripDAO;
import com.pratik.cabbookingsystem.model.Cab;
import com.pratik.cabbookingsystem.model.NormalCab;

@RestController(value = "/cab/")
public class CabsController {

	private CabDAO cabDAO;
	

	public CabsController(CabDAO cabDAO) {
		this.cabDAO = cabDAO;
}

	// register a cab
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity RegisterCab(String driver_id, String driver_name) {
		try {
			cabDAO.creatcab(driver_id, driver_name);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok("" + cabDAO.getallcab());
	}

	// Toggle visibility
	@RequestMapping(value = "/update/availibilty")
	public ResponseEntity ChangeAvailibility(String cabId, boolean isavil) {
		try {
			cabDAO.changeAvailibility(cabId, isavil);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok("");
	}

	// update location
	@RequestMapping(value = "/update/location")
	public ResponseEntity updateCabLocation(String driver_id,double x, double y) {
		try {
			cabDAO.updateLocation(driver_id, x, y);
			System.out.println("Location Updated succesfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return ResponseEntity.ok("");
	}

}
