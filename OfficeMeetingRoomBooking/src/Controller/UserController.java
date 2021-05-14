package Controller;



import java.awt.print.Book;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.apache.commons.lang3.RandomStringUtils;

import DAO.PlatformDao;
import DAO.RoomDao;
import DAO.UserDao;
import Exceptions.InvalidUserException;
import Exceptions.NoRoomCurrentlyAvailableException;
import Interfaces.RoomAllocatingStratergy;
import Model.Booking;
import Model.Room;
import Model.User;

public class UserController {
	private PlatformDao platformDao;
	private UserDao userDao;
	private RoomDao roomDao;
	private SimpleDateFormat formatter1;
	private RoomAllocatingStratergy roomAllocatingStratergy;
	public UserController(RoomDao roomDao,PlatformDao platformDao, UserDao userDao,RoomAllocatingStratergy roomAllocatingStratergy) {
		super();
		this.roomDao=roomDao;
		this.platformDao = platformDao;
		this.userDao = userDao;
		this.roomAllocatingStratergy=roomAllocatingStratergy;
		 formatter1=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); 
	}
	
	public String addUser(String userNmae,String userId)
	{
		String resp="";
		resp=userDao.addUser(userNmae, userId);
		return resp;
	}
	
	public String bookRoom(String userid,String dateFrom,String dateto)
	{
		
		User user;
		try {
			user = userDao.getUser(userid);
		} catch (InvalidUserException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		Room room=null;
		try {
			try {
				room = roomAllocatingStratergy.getRoom(formatter1.parse(dateFrom),formatter1.parse(dateto),roomDao,platformDao);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				return "wrong date fromat";
			}
		} catch (NoRoomCurrentlyAvailableException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
		try {
			return platformDao.book(user, room, formatter1.parse(dateFrom), formatter1.parse(dateto));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			return "wrong date fromat";
		}
		
	}
	
	public  List<String> viewAllBooking()
	{
		HashMap<String, Booking> bookings =platformDao.getBookings();
		ArrayList<String> list = new ArrayList<String>();
		for (Entry<String, Booking> element : bookings.entrySet()) {
			Booking booking = element.getValue();
			String str = "Booking id:"+booking.getBookingid()+" | User: "+booking.getUser().getUserNmae()+" has booked "+booking.getRoom().getRoomName()+" From "+ booking.getDateFrom()+" To "+booking.getDateTo();
			list.add(str);
		}
		return list;
	}
}

