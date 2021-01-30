package com.pratikwanjari.fliptweet.DAO;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.pratikwanjari.fliptweet.exceptions.UserAleradyAddedFollowers;
import com.pratikwanjari.fliptweet.exceptions.UserAlreadyExistException;
import com.pratikwanjari.fliptweet.exceptions.UserNotFoundException;
import com.pratikwanjari.fliptweet.model.User;

public class UserDAO {
	private HashMap<String,User> user_in_systems;
	
	public UserDAO() {
		user_in_systems = new HashMap<String,User>();
	}
	
	public void addUser(String username) throws UserAlreadyExistException
	{
		if(checkIfUserExist(username))
		{
			throw new UserAlreadyExistException();
		}
		User newuser = new User(username);
		System.out.println("User "+username+" added succesfully!");
		user_in_systems.put(username,newuser);
	    	
	}
	public boolean checkIfUserExist(String user_name)   {
		if(user_in_systems.containsKey(user_name))
		{
			return true;
		}
		return false;
	}
	
	public void addFollowers(String user_name,List<String> followers) throws UserNotFoundException,UserAleradyAddedFollowers{
		if(!checkIfUserExist(user_name))
		{
			throw new UserNotFoundException();
		}
		User user = user_in_systems.get(user_name);
		if(user.getFollowers().size()>0)
		{
			throw new UserAleradyAddedFollowers();
		}
		HashSet<String> followers_set = new HashSet<String>();
		for (String string : followers) {
			User user1 = user_in_systems.get(string);
			user1.getFollowing().add(string);
			followers_set.add(string);
		}
		System.out.println("Followers added succesfully!");
		user.setFollowers(followers_set);
	}
	
	
	public User getUserFromUserName(String name)
	{
		if(!user_in_systems.containsKey(name))
		{
			System.out.println("User not exist");
		}
		return user_in_systems.get(name);
	}
}
