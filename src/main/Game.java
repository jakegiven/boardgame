package main;

import java.util.ArrayList;

import miniGames.IntroGUI;
import miniGames.IntroMiniGameScreen;


public abstract class Game {
	
	protected IntroMiniGameScreen introScreen;
	protected ArrayList<Player> PlayerList;

	public ArrayList<Player> getPlayerList() {
		return PlayerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		PlayerList = playerList;
	}
	public Game() {
		PlayerList = new ArrayList<Player>();
	}
	
}
