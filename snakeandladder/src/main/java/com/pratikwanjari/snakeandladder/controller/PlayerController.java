package com.pratikwanjari.snakeandladder.controller;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pratikwanjari.snakeandladder.DAO.PlatformDAO;
import com.pratikwanjari.snakeandladder.DAO.PlayerDAO;
import com.pratikwanjari.snakeandladder.model.Game;
import com.pratikwanjari.snakeandladder.model.Player;


@RestController(value = "/player/")
public class PlayerController {
	
	private PlayerDAO playerdao;
	private PlatformDAO platformDAO;
	public PlayerController() {
		playerdao = new PlayerDAO();
		platformDAO= new PlatformDAO();
	}

	
	public PlayerController(PlayerDAO playerdao) {
		super();
		this.playerdao = playerdao;
	}

	@RequestMapping(value = "/initgame",method = RequestMethod.POST)
	public Game InitGame(int row,int column,int noofplayer,List<Player> playerlist) {
		
		Game game=playerdao.initGame(row, column, noofplayer, playerlist);
		String token = RandomStringUtils.random(8, true, true);
		platformDAO.addGame(token, game);
		System.out.println("Token genrated for the game is :"+token);
		return game;
	}
	
	@RequestMapping(value ="/roll",method = RequestMethod.GET)
	public Game RollDice(String token,String player_name) {
		Game game=platformDAO.getGamefromPlatform(token);
		playerdao.RoleDice(game, player_name);
		return game;
	}
}
