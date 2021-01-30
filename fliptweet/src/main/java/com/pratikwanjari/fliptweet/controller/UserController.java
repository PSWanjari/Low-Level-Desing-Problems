package com.pratikwanjari.fliptweet.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

import com.pratikwanjari.fliptweet.DAO.FlipTweetOnlinePlatform;
import com.pratikwanjari.fliptweet.DAO.UserDAO;
import com.pratikwanjari.fliptweet.exceptions.UserAleradyAddedFollowers;
import com.pratikwanjari.fliptweet.exceptions.UserNotFoundException;
import com.pratikwanjari.fliptweet.model.Tweet;
import com.pratikwanjari.fliptweet.model.User;

public class UserController {
	
	private FlipTweetOnlinePlatform flipTweetOnlinePlatform;
	private UserDAO userDAO;
	
	private HashMap<String,String> tweetshiddenfrom;
	
	//injecting Dependencies through the constructor
	public UserController(FlipTweetOnlinePlatform flipTweetOnlinePlatform, UserDAO userDAO) {
		super();
		this.flipTweetOnlinePlatform = flipTweetOnlinePlatform;
		this.userDAO = userDAO;
		tweetshiddenfrom= new HashMap<String, String>();
	}

	public void CreateUser(String user_name)
	{
		try {
			userDAO.addUser(user_name);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("User already exist");
		}
	}
	
	public void AddFollowers(String userName,List<String> followers)
	{
		try {
			userDAO.addFollowers(userName, followers);
		}catch (UserNotFoundException e) {
			// TODO: handle exception
			System.out.println("User not Found");
		}catch (UserAleradyAddedFollowers e) {
			// TODO: handle exception
			System.out.println("User alredy added followers");
		}
	}
	public String postTweet(String user_name,String tweet)
	{
		try{
			if(userDAO.checkIfUserExist(user_name))
			{
				User user = userDAO.getUserFromUserName(user_name);
				System.out.println(flipTweetOnlinePlatform.addTweet(user, tweet));
			}else {
				System.out.println("User not exixst");
			}
		  
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("user not exist");
		}
		return "";
	}
	
	public String getUserTweetbyuserName(String user_name)
	{
		try{
			if(userDAO.checkIfUserExist(user_name))
			{
				User user = userDAO.getUserFromUserName(user_name);
				HashMap<String, Tweet<String>> map =flipTweetOnlinePlatform.allTweetDoneByUser(user);
				for (Entry<String, Tweet<String>> item	 : map.entrySet()) {
					
						System.out.println(item.getValue().getId()+" "+item.getValue().getTweet());
					
					
				}
				
			}else {
				System.out.println("User not exixst");
			}
		  
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("eee");
			e.printStackTrace();
			System.out.println("user not exist");
		}
		return "";
	}
	
	public String getUserFeedByUserName(String user_name)
	{
		try{
			if(userDAO.checkIfUserExist(user_name))
			{
				User user = userDAO.getUserFromUserName(user_name);
				HashSet<String> following = user.getFollowing();
				for (String string : following) {
					System.out.println(getUserTweetbyuserName(string));
				}
				
			}else {
				System.out.println("User not exixst");
			}
		  
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("user not exist");
		}
		return "";
	}
	
	public void hidetweetfromuser(String id,String user_name)
	{
		try{
			if(userDAO.checkIfUserExist(user_name))
			{
				tweetshiddenfrom.put(id, user_name);
			}else {
				System.out.println("User not exixst");
			}
		  
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("user not exist");
		}
	
	}
}
