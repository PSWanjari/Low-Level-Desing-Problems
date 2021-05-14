package Interfaces;



import java.util.Date;

import DAO.PlatformDao;
import DAO.RoomDao;
import Exceptions.NoRoomCurrentlyAvailableException;
import Model.Booking;
import Model.Room;

public interface RoomAllocatingStratergy {
	public Room getRoom(Date from,Date to,RoomDao roomDao,PlatformDao bookings) throws NoRoomCurrentlyAvailableException;
}	
