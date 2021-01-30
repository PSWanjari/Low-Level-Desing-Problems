package com.pratikwanjari.fliptweet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pratikwanjari.fliptweet.DAO.FlipTweetOnlinePlatform;
import com.pratikwanjari.fliptweet.DAO.UserDAO;
import com.pratikwanjari.fliptweet.controller.UserController;

@SpringBootApplication
public class FliptweetApplication {

	public static void main(String[] args) {
		//SpringApplication.run(FliptweetApplication.class, args);
		System.out.println("Hello world");
		FlipTweetOnlinePlatform flipTweetOnlinePlatform = new FlipTweetOnlinePlatform();
		UserDAO userdao = new UserDAO();
		UserController uc = new UserController(flipTweetOnlinePlatform, userdao);
		
		uc.CreateUser("Pratik");
		uc.CreateUser("Shubham");
		uc.CreateUser("Lucky");
		uc.CreateUser("Ram");
		
		
		List<String> followersOfPratik = new ArrayList<String>();
		followersOfPratik.add("Shubham");
		followersOfPratik.add("Lucky");
		uc.AddFollowers("Pratik", followersOfPratik);
		
		List<String> followersOfRam = new ArrayList<String>();
		followersOfRam.add("Lucky");
		followersOfRam.add("Pratik");
		uc.AddFollowers("Ram", followersOfRam);
		
		uc.postTweet("Pratik", "Hi I am Pratik");
		
		uc.getUserFeedByUserName("Pratik");
		uc.getUserTweetbyuserName("Pratik");
		
		uc.postTweet("Ram", "I my name is ram");
		uc.postTweet("Ram", "I my name is ram");
		uc.postTweet("Ram", "I my name is ram");
		System.out.println("----------------------------");
		uc.getUserTweetbyuserName("Ram");
		
		uc.getUserFeedByUserName("Pratik");
		System.out.println("----------------------------");
		
	}

}
