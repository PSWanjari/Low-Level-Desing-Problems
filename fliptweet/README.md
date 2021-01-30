FlipTweet
Problem Statement
Build an application that allows users to post tweets to their followers. This application provides the following limited functionality:

Each user will have some followers. Users can tweet a text message(tweet).
A user can see tweets which are posted by the users he/she follows . This view is called the feed of that user.
A user can hide other user’s tweets from his feed.
A user can delete his/her tweet which should hide this tweet from his followers feed.
Assumptions:
Name is a unique identifier for the user.
For a particular user, the list of followers can be added only once .
Every Tweet will have a uniqueId

Write a program that offer the following functions: 
CREATE_USER(userName): 
ADD_FOLLOWERS(userName,List<userName>)
POST_TWEET(msg,user):  Prints the tweet text and tweet id
GET_USER_TWEETS_BY_USER_NAME(userName):  Prints the tweet text of resultant tweets 
GET_USER_FEED_BY_USER_NAME(userName):   Prints the tweet text of resultant tweets 
HIDE_TWEET_FOR_USER_BY_TWEETID
DELETE_TWEET_BY_TWEETID

Sample Input
CREATE_USER(“Gopal”)
CREATE_USER(“Madhav”)
CREATE_USER(“Lucky”)
CREATE_USER(“Laxman”)
ADD_FOLLOWERS(“Gopal”,[“Madhav”,”Lucky”,”Laxman”])
ADD_FOLLOWERS(“Lucky”,[“Laxman”])
POST_TWEET(“Good morning”,”Gopal”)
Good morning,1
POST_TWEET(“Good night”,”Gopal”)
Good night,2
GET_USER_TWEETS_BY_USER_NAME(“Gopal”)	
Good morning
	            Good night		
POST_TWEET(“Bonjour”,”Lucky”)
Bonjour,3
GET_USER_FEED_BY_USER_NAME(“Laxman”)
Good morning
Good night
Bonjour
GET_USER_FEED_BY_USER_NAME(“Madhav”)
Good morning
Good night
      9.   HIDE_TWEET_FOR_USER_BY_TWEETID(”Madhav”, “1”)
     10.  GET_USER_FEED_BY_USER_NAME(“Madhav”)
     		Good night
     11.  DELETE_TWEET_BY_TWEETID(“2”)
     12. GET_USER_FEED_BY_USER_NAME(“Laxman”)
Good morning
 Bonjour
      13. GET_USER_FEED_BY_USER_NAME(“Madhav”)
		<No output>
      14. GET_USER_FEED_BY_USER_NAME(“Gopal)
		<No output>
Expectations
Code should be demo-able (very important), either by using a main driver program or test cases.
Code should handle edge cases properly and fail gracefully.
Create the sample data yourself to test your code. You can put it into a file, test case or main driver program itself.
Code should not be monolithic and it should be readable, extensible with proper naming conventions. Best practices followed.
Don’t use any database, store all the data in memory.
Email your code post completion of time.
