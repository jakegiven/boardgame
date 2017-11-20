package miniGames;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import main.Game;
import main.Tile;
import main.Player;

public class BoardGame extends Game {
	private ArrayList<Tile> Tiles;
	private int Turns;
	private boolean play;
	private JFrame gameBoard;
	JLabel player1;
	JLabel player2;
	JLabel background;
	ImageIcon backgroundIcon;
	public static final String BOARD_FILENAME = "Board.jpg";
	public static final String FIRE_FILENAME = "Paper.jpg";
	public static final String WATER_FILENAME = "Water.jpg";
	
	
	public BoardGame() {
		introScreen = new IntroMiniGameScreen("Bored Game", "The objective of the game is to get the most points possible.  \nYou score points"+
	" by landing on + squares and winning minigames.  \nYou lose points by losing minigames and by landing on - squares.");
		setTiles(new ArrayList<Tile>());

		
		setTurns(40); //May need to change depending on the implementation of player turns
		playGame();
	}
	public int playGame() {
		while(!introScreen.play) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		play = true;
		Player player1 = new Player();
		player1.setLocation(0);
		player1.setName("Jake");
		player1.setScore(0);
		player1.setIcon(null);
		Player player2 = new Player();
		player2.setLocation(0);
		player2.setName("Sarah");
		player2.setScore(0);
		player2.setIcon(null);
		PlayerList.add(player1);
		PlayerList.add(player2);
		CreateBoard();
		while(play) {
			for(Player P:PlayerList) {
				PlayTurn(P);
			}
			
		}
		
		
		return 0;
		
	}
	public void updateLocations() {
		for(Player P:PlayerList) {
		}
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
	public void CreateBoard() {
		gameBoard = new JFrame("Bored Game");
		gameBoard.setPreferredSize(new Dimension(300,300));
		JLayeredPane layeredPane = new JLayeredPane();
		player1 = new JLabel(PlayerList.get(0).getIcon());
		player2 = new JLabel(PlayerList.get(1).getIcon());
		player1.setLocation(200, 200);
		player2.setLocation(250,250);
		background = new JLabel("Game Board");
		background.setOpaque(true);
		background.setIcon(backgroundIcon);
		background.setForeground(Color.red);
		background.setHorizontalAlignment(JLabel.CENTER);
		background.setVerticalAlignment(JLabel.TOP);
		gameBoard.add(background);
		gameBoard.setVisible(true);
		
		
		
	}
	
	
	
}
