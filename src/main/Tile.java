package main;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import miniGames.*;

public class Tile {
	private int Type;
	private JLabel square;
	static int nextGameType = 1;
	String text;
	
	public Tile(JLabel square,int type) {
		this.square = square;
		if(type == 0) {
			Type = 1;
			text = "Yay you landed on an add tile";

		}
		else if(type == 1) {
			text = "Oh no, you landed on a subtract tile";
			Type = 2;
		}
		else if(type == 2) {
			Type = nextGameType + 3;
			if(Type == 3) {
				text = "You landed on Rock Paper Scissors game";

			}
			else if(Type == 4) {
				text = "You landed on clicker game";

			}
			else if(Type == 5) {
				text = "You landed on Simon Says game";

			}
			nextGameType = (nextGameType + 1 )% 3;
		}
		else if(type == 7) {
			text = "It's like monopoly except you get even more free points";
			Type = 25;
		}
		else {
			System.out.println("Something went wrong when creating the tile");
		}
		
	}
	public String getText() {
		return text;
	}
	public Rectangle getLocation() {
		return square.getBounds();
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
			while(Roc_Pap_Sciss.checkGame() == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(Roc_Pap_Sciss.getWinner() == 2) {
				player.addToScore(Roc_Pap_Sciss.getScore());
				JOptionPane.showMessageDialog(null, "Congrats you won!  You earned "+Roc_Pap_Sciss.getScore()+" points", "Win", -1);
			}
			else {
				JOptionPane.showMessageDialog(null, "You didn't win, better luck next time", "Win", -1);
			}
			
		}
		else if(Type == 4) {//Clicker GameFIXME
			ClickerGame Clicks = new ClickerGame("Click game"); 

			while(!Clicks.Finished()) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			player.addToScore(Clicks.GetPoints());
		}
		else if(Type == 5) {
			SimonSaysMain Simon = new SimonSaysMain("Simon says");

			while(!Simon.Finished()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			player.addToScore(Simon.getScore());
		}
		else if(Type == -100) {
			System.out.println("The Type of this tile wasn't initialized properly and is still" + Type);
		}
		else if(Type == 25) {
			//System.out.println("You passed the beginning");
			player.addToScore(200);
		}
		else {
			System.out.println(Type + "isn't a valid type number and couldn't be used");
		}
		new Timer(5000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoardGame.infoMessage.setVisible(false);
				BoardGame.rollLabel.setVisible(false);
				((Timer)e.getSource()).stop();
			}
		}).start();
	}
}
