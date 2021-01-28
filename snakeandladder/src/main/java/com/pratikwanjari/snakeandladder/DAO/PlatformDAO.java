package com.pratikwanjari.snakeandladder.DAO;

import java.util.HashMap;

import com.pratikwanjari.snakeandladder.model.Game;

public class PlatformDAO {

	HashMap<String, Game> gamesplatform;
	

	public PlatformDAO() {
		gamesplatform = new HashMap<String, Game>();
	}

	public Game getGamefromPlatform(String token) {
		return gamesplatform.get(token);
	}

	public void endgame(String token) {
		gamesplatform.get(token).setIsfinished(true);
	}
	public void addGame(String token,Game game)
	{
		gamesplatform.put(token, game);
	}
	
	
}
