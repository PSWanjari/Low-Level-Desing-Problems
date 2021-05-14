package Interfaces;

import DAO.PlatformDao;
import DAO.RoomDao;
import Exceptions.NoRoomCurrentlyAvailableException;
import Model.Booking;
import Model.Room;

import java.util.Date;
import java.util.Map.Entry;

public class SequentiallyDistribuition implements RoomAllocatingStratergy {

	@Override
	public Room getRoom(Date from,Date to,RoomDao roomDao,PlatformDao platformDao) throws NoRoomCurrentlyAvailableException {
		Room roomSelected = null;
		for (Entry<Integer, Room> a_room : roomDao.getRoomsInDB().entrySet()) {
			Room room = a_room.getValue();
			boolean isroomfree=true;
			for (Entry<String, Booking> booking_element : platformDao.getBookings().entrySet()) {
				Booking booking = booking_element.getValue();
				if(booking.getRoom().getId()==room.getId())
				{
					if((booking.getDateFrom().compareTo(from)<=0 && booking.getDateTo().compareTo(from)>=0)
					 || (booking.getDateFrom().compareTo(to)<=0 && booking.getDateTo().compareTo(to)>=0)
					 || booking.getDateFrom().compareTo(from)>=0 && booking.getDateTo().compareTo(to)<=0)
					{
						isroomfree=false;
					}
				}
			}
			if(isroomfree)
			{
				roomSelected=room;
				break;
			}
		}
		if(roomSelected==null)
		{
			throw new NoRoomCurrentlyAvailableException();
		}
		return roomSelected;
	}
	

	
	
}
