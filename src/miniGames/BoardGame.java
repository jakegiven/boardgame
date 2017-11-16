package miniGames;

import java.util.ArrayList;

import main.Game;
import main.Tile;
import main.Player;

public class BoardGame extends Game {
	private ArrayList<Tile> Tiles;
	private int Turns;
	
	public BoardGame() {
		setTiles(new ArrayList<Tile>());
		setTurns(40); //May need to change depending on the implementation of player turns
	}

	public int getTurns() {return Turns;}

	public void setTurns(int turns) {Turns = turns;}

	public ArrayList<Tile> getTiles() {return Tiles;}

	public void setTiles(ArrayList<Tile> tiles) {Tiles = tiles;}
	
	public void addPlayer(Player newPlayer) {
		if(!this.getPlayerList().contains(newPlayer)) {
			this.getPlayerList().add(newPlayer);
		}
	}
	
	public void PlayTurn(Player player) {
		player.rollDice();
		player.setLocation(player.getLocation() % Tiles.size());
		Tiles.get(player.getLocation()).useType(player);
		
	}
	
	
	
}
