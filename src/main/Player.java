package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Player {
	private int Score;
	private String Name;
	private ImageIcon Icon;
	private int Location;
	
	public Player() {
		Score = 0;
		Name = "None";
		Location = 0;
		Icon = null;
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
	
	public void rollDice() {
		int roll = ThreadLocalRandom.current().nextInt(1, 6 + 1);
		Location = Location + roll;
		final JDialog Rolled = new JDialog(new JFrame(), Name + " Rolled");
		JPanel Inputs = new JPanel();
		Rolled.setSize(150, 125);
		
		JButton ok = new JButton("OK");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rolled.setVisible(false);
				Rolled.dispose();
			}
		});
		JTextArea Text = new JTextArea("You rolled a " + roll);
		Inputs.add(Text);
		Inputs.add(ok);
		Rolled.add(Inputs);
		
		Rolled.setVisible(true);
		
		Rolled.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
}
