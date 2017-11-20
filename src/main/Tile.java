package main;

import java.util.concurrent.ThreadLocalRandom;

import miniGames.*;

public class Tile {
	private int Type;
	
	public Tile() {
		setType(-100);
	}

	public int getType() {	return Type;}

	public void setType(int type) {	Type = type;}
	
	public void useType(Player player) {
		if(Type == 1) { //addTile
			player.addToScore(ThreadLocalRandom.current().nextInt(10, 25 + 1)); //adds 15 points to playerScore
		}
		else if(Type == 2) {//subtractTile
			player.subtractFromScore(ThreadLocalRandom.current().nextInt(10, 25 + 1));
		}
		else if(Type == 3) {//Rock, Paper, Scissors minigame
			RPS Roc_Pap_Sciss = new RPS();
		}
		else if(Type == 4) {//Clicker Game
			ClickerGame Clicks = new ClickerGame("Click game"); 
			player.addToScore(Clicks.GetPoints());
		}
		else if(Type == 5) {
			SimonSays Simon = new SimonSays();
			player.addToScore(Simon.getPoints());
		}
		else if(Type == -100) {
			System.out.println("The Type of this tile wasn't initialized properly and is still" + Type);
		}
		else {
			System.out.println(Type + "isn't a valid type number and couldn't be used");
		}
	}
}
