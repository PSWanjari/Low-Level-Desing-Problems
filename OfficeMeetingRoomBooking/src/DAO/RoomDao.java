package DAO;

import java.util.HashMap;

import Enums.RoomStatus;
import Exceptions.InvalidRoomIdException;
import Model.Room;

public class RoomDao {
	HashMap<Integer, Room> roomsInDB = new HashMap<Integer,Room>();
	
	public String addRoom(int id,String roomName,RoomStatus status)
	{
		Room room = new Room(id, roomName, status);
		roomsInDB.put(id, room);
		return "Room added Succesfully";
	}
	
	public Room getRoom(int roomId) throws InvalidRoomIdException
	{
		
		if(!roomsInDB.containsKey(roomId))
		{
			throw new InvalidRoomIdException();
		}
		return roomsInDB.get(roomId);
	}

	public HashMap<Integer, Room> getRoomsInDB() {
		return roomsInDB;
	}
	
}
