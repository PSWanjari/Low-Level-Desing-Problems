package DAO;


import java.util.Date;
import java.util.HashMap;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import Enums.RoomStatus;
import Model.Booking;
import Model.Room;
import Model.User;

public class PlatformDao {
	HashMap<String,Booking> bookings = new HashMap<String, Booking>();
	
	public String book(User user,Room room,Date from,Date to)
	{
		String id=RandomStringUtils.random(5, true, true);
		Booking booking = new Booking(id,room, user, from, to);
		room.setStatus(RoomStatus.Occupied);
		bookings.put(id, booking);
		return booking.toString();
	}

	public HashMap<String, Booking> getBookings() {
		return bookings;
	}
	
	
	
}
