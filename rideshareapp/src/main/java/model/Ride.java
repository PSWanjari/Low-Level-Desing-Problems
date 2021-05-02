package model;

enum RideStatus{
	Inprogress,
	Fineshed,
}
public class Ride {
	private String rideid;
	private User user;
	private Driver driver;
	private RideStatus status;
	private int from;
	private int to;
	private int seats;
	
	public Ride(String rideid,User user,Driver driver,int from,int to,int seats) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.user = user;
		this.to=to;
		this.from=from;
		this.seats=seats;
		this.status=RideStatus.Inprogress;
		this.rideid=rideid;
		
	}
	public String getRideid() {
		return rideid;
	}
	public void setRideid(String rideid) {
		this.rideid = rideid;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public RideStatus getStatus() {
		return status;
	}
	public void setStatus(RideStatus status) {
		this.status = status;
	}
	public int getFrom() {
		return from;
	}
	
	public int getTo() {
		return to;
	}
	
	public int getSeats() {
		return seats;
	}
	public void endRide()
	{
		this.status=RideStatus.Fineshed;
	}
}
