package com.pratikwanjari.snakeandladder;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pratikwanjari.snakeandladder.DAO.PlayerDAO;
import com.pratikwanjari.snakeandladder.controller.PlayerController;
import com.pratikwanjari.snakeandladder.model.Game;
import com.pratikwanjari.snakeandladder.model.Player;

@SpringBootApplication
public class SnakeandladderApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SnakeandladderApplication.class, args);
		
		PlayerController playerController = new PlayerController();
		ArrayList<Player> players = new ArrayList<Player>();
		Player player = new Player("Pratik");
		Player player2 = new Player("Rahul");
		Player player3 = new Player("Shubham");
		players.add(player);
		players.add(player2);
		players.add(player3);
		
		playerController.InitGame(100, 100, 3, players);
		
		Scanner sc = new Scanner(System.in);
		String token = sc.nextLine();
		int turn =1;
		while(true)
		{
			Game game=null;
			if(turn ==1)
			{
				game =playerController.RollDice(token, "Pratik");
				if(game==null)
				{
					break;
				}
				turn=2;
			}else if(turn ==2){
				game =playerController.RollDice(token, "Rahul");
				if(game==null)
				{
					break;
				}
				turn =3;
			}else if(turn ==3) {
				game =playerController.RollDice(token, "Shubham");
				if(game==null)
				{
					break;
				}
				turn =1;
			}
			if(game.isIsfinished())
			{
				break;
			}
		}
		
	}

}
