package Controller;

import DAO.RoomDao;
import Enums.RoomStatus;

public class RoomAdminController {
	
	private RoomDao roomDao;
	
	public RoomAdminController(RoomDao roomDao) {
		super();
		this.roomDao = roomDao;
	}

	public String addRoom(int id,String roomName)
	{
		String resp="";
		resp=roomDao.addRoom(id, roomName,RoomStatus.Free);
		return resp;
		
	}
}
