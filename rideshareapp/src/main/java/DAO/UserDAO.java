package DAO;

import java.util.HashMap;
import exceptions.UserAlreadyExist;
import exceptions.UserNotFound;
import model.User;

public class UserDAO {

	HashMap<Long, User> Registered_Users ;
	
	public UserDAO() {
		Registered_Users= new HashMap<Long, User>();
		// TODO Auto-generated constructor stub
	}
	public String registerUser(String name,long contact) throws UserAlreadyExist
	{
		if(Registered_Users.containsKey(contact))
		{
			throw new UserAlreadyExist();
		}
		User user = new User(name, contact);
		Registered_Users.put(contact, user);
		return "Successfully registered "+name;
	}
	public User getUser(long contact) throws UserNotFound
	{
		if(!Registered_Users.containsKey(contact))
		{
			throw new UserNotFound();
		}
		return Registered_Users.get(contact);
		
	}
	
}
