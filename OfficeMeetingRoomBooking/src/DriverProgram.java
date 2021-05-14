import java.util.List;

import Controller.RoomAdminController;
import Controller.UserController;
import DAO.PlatformDao;
import DAO.RoomDao;
import DAO.UserDao;
import Interfaces.RoomAllocatingStratergy;
import Interfaces.SequentiallyDistribuition;

public class DriverProgram {
	public static void main(String[] args) {
		PlatformDao platformDao = new PlatformDao();
		RoomDao roomDao = new RoomDao();
		UserDao userDao = new UserDao();
		
		//room stratergy
		RoomAllocatingStratergy roomAllocatingStratergy = new SequentiallyDistribuition();
		
		//creating controller
		UserController userController = new UserController(roomDao, platformDao, userDao, roomAllocatingStratergy);
		RoomAdminController roomAdminController = new RoomAdminController(roomDao);
		
		//adding rooms in office
		System.out.println(roomAdminController.addRoom(1, "Room 1"));
		System.out.println(roomAdminController.addRoom(2, "Room 2"));
		
		System.out.println(userController.addUser("Pratik Wanjari", "4400321"));
		System.out.println(userController.addUser("Rahul Mahajan", "1232132"));
		System.out.println(userController.addUser("Shweta", "43278667"));
		
		System.out.println(userController.bookRoom("4400321", "15-05-2021 10:00:00", "15-05-2021 12:00:00"));
		System.out.println("******************");
		System.out.println(userController.bookRoom("43278667", "15-05-2021 09:00:00", "15-05-2021 11:00:00"));
		System.out.println("******************");
		System.out.println(userController.bookRoom("1232132", "15-05-2021 13:00:00", "15-05-2021 14:30:00"));
		System.out.println("******************");
		//trying to get a room with no slot
		System.out.println(userController.bookRoom("43278667", "15-05-2021 9:00:00", "15-05-2021 18:30:00"));
		System.out.println("******************");
		
		//adding a room and trying again
		roomAdminController.addRoom(3, "Room 3");
		
		System.out.println(userController.bookRoom("43278667", "15-05-2021 8:30:00", "15-05-2021 18:30:00"));
		System.out.println("******************");
		
		System.out.println("All bookings :");
		List<String> list = userController.viewAllBooking();
		for (String string : list) {
			System.out.println(string);
		}
		
		
		
	}
}
