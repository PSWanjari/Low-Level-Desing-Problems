package Model;

import java.util.Date;

public class Booking {
	private Room room;
	private User user;
	private String bookingid;
	private Date dateFrom;
	private Date dateTo;
	public Booking(String bookingid,Room room, User user, Date dateFrom, Date dateTo) {
		super();
		this.room = room;
		this.user = user;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.bookingid=bookingid;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	@Override
	public String toString() {
		return "Booking successful !\n Dealtis:\nroom=" + room.toString() + "\n user=" + user.toString() + "\n bookingid=" + bookingid + "\n dateFrom=" + dateFrom
				+ "\n dateTo=" + dateTo ;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	public String getBookingid() {
		return bookingid;
	}
	
	
}
