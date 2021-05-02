package model;

import Enums.DriverStatus;

public class Driver extends Person {
	String Licno;
	DriverStatus status;
	public Driver(String name,long mobile,String licno) {
		// TODO Auto-generated constructor stub
		this.contact=mobile;
		this.Name=name;
		this.Licno=licno;
		this.status=DriverStatus.free;
	}
	public String getLicno() {
		return Licno;
	}
	public void setLicno(String licno) {
		Licno = licno;
	}
	public DriverStatus getStatus() {
		return status;
	}
	public void setStatus(DriverStatus status) {
		this.status = status;
	}
	
	
}
