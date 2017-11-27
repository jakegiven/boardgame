package miniGames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.Timer;

import main.Game;
import main.Tile;
import main.Player;

public class BoardGame extends Game {
	private ArrayList<Tile> Tiles;
	private int Turns;
	private boolean play;
	private JFrame gameBoard;
	private JLabel player1;
	private JLabel player2;
	private JLabel background;
	private ImageIcon backgroundIcon;
	private Player currentPlayer;
	boolean rolled;
	public static JLabel infoMessage;
	public static JLabel rollLabel;
	
	
	
	public static final String BOARD_FILENAME = "Board.jpg";
	public static final String FIRE_FILENAME = "fire.png";
	public static final String WATER_FILENAME = "Water.jpg";
	public static final String PLUS_FILENAME = "plussquare.jpg";
	public static final String MINUS_FILENAME = "minussquare.jpg";
	public static final String RAINBOW_FILENAME = "rainbowsquare.jpg";
	private static final String FINISH_FILENAME = "finish.jpg";
	
	private String[] Squares = {PLUS_FILENAME,MINUS_FILENAME,RAINBOW_FILENAME};
	//public static final ArrayList<String> Squares = [PLUS_FILENAME, MINUS_FILENAME, RAINBOW_FILENAME];
	
	
	public BoardGame() {
		introScreen = new IntroMiniGameScreen("Bored Game", "The objective of the game is to get the most points possible.  \nYou score points"+
	" by landing on + squares and winning minigames.  \nYou lose points by landing on - squares.");
		setTiles(new ArrayList<Tile>());
		introScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		player1.setOffset(30);
		PlayerList.add(player1);
		PlayerList.add(player2);
		CreateBoard();
		while(play) {
			for(Player P:PlayerList) {
				currentPlayer = P;
				PlayTurn(currentPlayer);
			}
		}
		return 0;
		
	}
	public void updateLocation(Player P) {
		int temp = P.getLocation()%Tiles.size();
		Rectangle temp2 = Tiles.get(temp).getLocation();
		
		P.getIconLabel().setBounds((int) temp2.getX()+P.getOffset(), (int) temp2.getY(), 20, 20);
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
		while(!rolled) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rolled = false;
		updateLocation(currentPlayer);
		
		Tiles.get(player.getLocation()).useType(player);
		player.updateScore();

		
		
	}
	public void CreateBoard() {
		int offset = 50;
		gameBoard = new JFrame("Bored game");
		gameBoard.setPreferredSize(new Dimension(450,450));
		gameBoard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLayeredPane layeredPane = new JLayeredPane();
		backgroundIcon = new ImageIcon(BOARD_FILENAME);
		
		PlayerList.get(0).setIcon(new ImageIcon(FIRE_FILENAME));
		PlayerList.get(1).setIcon(new ImageIcon(WATER_FILENAME));
		player1 = new JLabel(PlayerList.get(0).getIcon());
		player2 = new JLabel(PlayerList.get(1).getIcon());
		PlayerList.get(0).addIconLabel(player1);
		PlayerList.get(1).addIconLabel(player2);
		player1.setBounds(40, 50, 20, 20);
		player1.setOpaque(true);
		player2.setBounds(40, 80	, 20	, 20);
		player2.setOpaque(true);
		layeredPane.add(player1, new Integer(3));
		layeredPane.add(player2, new Integer(3));
		
		background = new JLabel();
		background.setOpaque(false);
		background.setIcon(backgroundIcon);
		background.setForeground(Color.red);
		background.setHorizontalAlignment(JLabel.CENTER);
		background.setVerticalAlignment(JLabel.TOP);
		layeredPane.add(background, 0);
		background.setBounds(0, 0, 450, 450);
		
		rollLabel = new JLabel();
		rollLabel.setBounds(180,200,100,100);
		rollLabel.setText("You rolled a "+6);
		layeredPane.add(rollLabel, new Integer(3));
		rollLabel.setVisible(false);
		
		infoMessage = new JLabel();
		infoMessage.setText("<html>Welcome again to bored game</html>");
		infoMessage.setVisible(true);
		infoMessage.setBounds(180, 250, 100, 100);
		layeredPane.add(infoMessage, new Integer(3));
		
		JButton Roll = new JButton("Roll");
		Roll.setMargin(new Insets(0,0,0,0));
		Roll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rollLabel.setText("You rolled a " + currentPlayer.rollDice());
				rollLabel.setVisible(true);
				infoMessage.setText("<html>"+Tiles.get(currentPlayer.getLocation()).getText()+"</html>");
//				System.out.println(currentPlayer.getName());
//				System.out.println(currentPlayer.getLocation());
//				System.out.println(Tiles.get(currentPlayer.getLocation()).getText());
				infoMessage.setVisible(true);
				rolled = true;
			}
		});

		
		Roll.setSize(40,20);
		Roll.setOpaque(true);
		Roll.setBounds(206,185,40,20);
		layeredPane.add(Roll, new Integer(1));
		
		JLabel square1 = new JLabel(new ImageIcon(FINISH_FILENAME));
		square1.setOpaque(true);
		square1.setBounds(25, 50, 50, 50);
		Tiles.add(new Tile(square1,7));
		layeredPane.add(square1,new Integer(2));
		for(int i = 0; i < 8; i ++) {
			JLabel square = new JLabel(new ImageIcon(Squares[i%3]));
			square.setOpaque(true);
			square.setBounds(i*offset+25, 0, 50, 50);
			Tiles.add(new Tile(square,i%3));
			layeredPane.add(square, new Integer(2));
		}
		for(int i = 8; i < 8+7; i ++) {
			JLabel square = new JLabel(new ImageIcon(Squares[i%3]));
			square.setOpaque(true);
			square.setBounds(8*offset-25, 50+offset*(i-8), 50, 50);
			Tiles.add(new Tile(square,i%3));
			layeredPane.add(square, new Integer(2));
		}
		for(int i = 0; i < 7; i ++) {
			JLabel square = new JLabel(new ImageIcon(Squares[i%3]));
			square.setOpaque(true);
			square.setBounds(325-i*offset, 350/*layeredPane.getHeight()-offset*/, 50, 50);
			Tiles.add(new Tile(square,i%3));
			layeredPane.add(square, new Integer(2));
		}
		for(int i = 0; i < 6; i ++) {
			JLabel square = new JLabel(new ImageIcon(Squares[i%3]));
			square.setOpaque(true);
			square.setBounds(25, 350-i*offset/*layeredPane.getHeight()-offset*/, 50, 50);
			Tiles.add(new Tile(square,i%3));
			layeredPane.add(square, new Integer(2));
		}

		JLabel player1Score = new JLabel();
		player1Score.setText("Score:"+Integer.toString(PlayerList.get(0).getScore()));
		player1Score.setBounds(120,75,100,100);
		player1Score.setForeground(Color.RED);
		layeredPane.add(player1Score,new Integer(2));
		PlayerList.get(0).addScoreLabel(player1Score);
		
		JLabel player2Score = new JLabel();
		player2Score.setText("Score:"+Integer.toString(PlayerList.get(1).getScore()));
		player2Score.setBounds(270,75,100,100);
		player2Score.setForeground(Color.BLUE);
		layeredPane.add(player2Score,new Integer(2));
		PlayerList.get(1).addScoreLabel(player2Score);
		
		gameBoard.add(layeredPane);
		gameBoard.pack();
		gameBoard.setVisible(true);
	}
}
