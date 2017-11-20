package main;

import miniGames.ClickerGame;
import miniGames.boredGameGUI;
import miniGames.*;

public class GameDriver {

	
	public static void main(String[] args) {
		//clicker
		BoardGame mainGame = new BoardGame();
		ClickerGame click = new ClickerGame("Click game");
		while(!click.Finished()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(click.GetPoints());
		
		
		//simonsays
		boredGameGUI newGUI;
        newGUI = new boredGameGUI("BGGUI");	
        
        //rps
		IntroMiniGameScreen miniGame = new IntroMiniGameScreen("Let's Play Rock, Paper, Scissors!", "Rules:");
		IntroGUI introScreen = new RPSCharacterScreen("Let's Play Rock, Paper, Scissors!", "Rules:");
		
		
	}
}
