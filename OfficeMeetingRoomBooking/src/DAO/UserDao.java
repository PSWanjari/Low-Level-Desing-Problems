package DAO;

import java.util.HashMap;

import Exceptions.InvalidUserException;
import Model.User;

public class UserDao {
	HashMap<String, User> userInDB = new HashMap<String, User>();
	
	public String addUser(String userNmae,String userId)
	{
		User user = new User(userNmae, userId);
		userInDB.put(userId, user);
		return "User "+userNmae+" added succesfully";
	}
	
	public User getUser(String id) throws InvalidUserException 
	{
		if(!userInDB.containsKey(id))
		{
			throw new InvalidUserException();
		}
		return userInDB.get(id);
	}
}
