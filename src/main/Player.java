package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Player {
	private int Score;
	private String Name;
	private ImageIcon Icon;
	private int Location;
	private JLabel playerIcon;
	private int offset;
	private JLabel playerScore;
	
	
	public Player() {
		Score = 0;
		Name = "None";
		Location = 0;
		Icon = null;
		offset = 0;
	}
	public void updateScore() {
		playerScore.setText("Score:"+Integer.toString(Score));
	}
	public void addIconLabel(JLabel j) {
		playerIcon = j;
	}
	public void addScoreLabel(JLabel j) {
		playerScore = j;
	}
	public JLabel getIconLabel() {
		return playerIcon;
	}
	public int getOffset() {
		return offset;
	}
	
	public void setName(String name) {this.Name = name;}
	
	public String getName() {return this.Name;}
	
	public ImageIcon getIcon() {return Icon;}
	
	public void setIcon(ImageIcon icon) { this.Icon = icon;}
	
	public int getScore() {return this.Score;}
	
	public void setScore(int score) {this.Score = score;}
	
	public void addToScore(int num) {Score = Score + num;}
	
	public void subtractFromScore(int num) {Score = Score - num;}

	public int getLocation() {return Location;}
	
	public void setLocation(int location) {this.Location = location;}
	
	public int rollDice() {
		//int roll = ThreadLocalRandom.current().nextInt(1, 6 + 1);//FIXME: add this when done testing

		int roll = 29;
		Location = (Location + roll)%29;

		return roll;
	}

	public void setOffset(int i) {
		 offset = i;
		
	}
}
