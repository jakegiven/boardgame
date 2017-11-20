package main;

import java.util.ArrayList;

import miniGames.IntroGUI;


public abstract class Game {
	
	private IntroGUI introScreen;
	private ArrayList<Player> PlayerList;

	public ArrayList<Player> getPlayerList() {
		return PlayerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		PlayerList = playerList;
	}
	public Game() {
		
	}
	
}
