package com.pratikwanjari.snakeandladder.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import com.pratikwanjari.snakeandladder.boardmakingstratergies.GameBoardMakingStratergies;
import com.pratikwanjari.snakeandladder.boardmakingstratergies.RandomGameBorad;
import com.pratikwanjari.snakeandladder.model.Game;
import com.pratikwanjari.snakeandladder.model.GameBoard;
import com.pratikwanjari.snakeandladder.model.Player;

import sun.util.logging.resources.logging;

@Component
public class PlayerDAO {

	//initialize game
	public Game initGame(int row,int column,int noofplayer,List<Player> players) {
		
		GameBoard gameboard = new GameBoard(row, column,new HashMap<Integer, Integer>() , new HashMap<Integer, Integer>());
		GameBoardMakingStratergies gameBoardMakingStratergies = new RandomGameBorad();
		gameBoardMakingStratergies.fillGameBoard(gameboard);
		Game game = new Game( gameboard, noofplayer, players,false);
		return game;
	}
	
	//player roll dice
	public Game RoleDice(Game game,String player_name) {
		if(game==null)
		{
			System.out.println("Invalid ToKen");
			return null;
		}
		if(game.isIsfinished())
		{
			System.out.println("Game is Already Finished");
			return game;
		}
		Random rand = new Random();
		int dice_no = rand.nextInt(7);
		System.out.println(player_name+" roll dice and got "+dice_no);
		Player player = getPlayerfromGame(game,player_name);
		if(player==null)
		{
			System.out.println("Player Invalid");
			return null;
		}
		int new_position = player.getPosition()+dice_no;
		
		if(new_position==(game.getGameboard().getRow()*game.getGameboard().getCol())){
			System.out.println("********"+player_name+" Wins *****************");
			game.setIsfinished(true);
			return game;
		}
		if(new_position>(game.getGameboard().getRow()*game.getGameboard().getCol())) {
			System.out.println("More than "+game.getGameboard().getRow()*game.getGameboard().getCol());
			return game;
		}
		//no snake bite
		int pos = checkIfSnake(new_position, game);
		if(pos==-1)
		{
			pos=checkIfLadder(new_position, game);
			if(pos==-1)
			{
				System.out.println("Player "+player_name+" moves to location "+new_position);
				player.setPosition(new_position);
				return game;
			}
			System.out.println("//////Ladder got !!Player "+player_name+" moves up to location "+pos);
			player.setPosition(pos);
			return game;
			
			
		}
		System.out.println("------Snake Bite !! playe "+player_name+" Comes down to location "+pos);
		player.setPosition(pos);
		return game;
		
	}
	
	public Player getPlayerfromGame(Game game,String player_name)
	{
		for(int i=0;i<= game.getPlayersplaying().size();i++)
		{
			if(game.getPlayersplaying().get(i).getPlayer_name().equals(player_name))
			{
				return game.getPlayersplaying().get(i);
			}
		}
		return null;
	}
	
	public int checkIfSnake(int position,Game game)
	{
		HashMap<Integer, Integer> snakes = game.getGameboard().getSnakes();
		if(snakes.containsKey(position))
		{
			return snakes.get(position);
		}
		return -1;
	}
	public int checkIfLadder(int position,Game game)
	{
		HashMap<Integer, Integer> ladder = game.getGameboard().getLadders();
		if(ladder.containsKey(position))
		{
			return ladder.get(position);
		}
		return -1;
	}
	
	
	
}
