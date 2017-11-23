package miniGames;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.Timer;

public class ClickerGame extends JFrame{
	private int time;
	private int UserClicks;
	private int CompClicks;
	private JButton clicker;
	private int pointsEarned;
	private JDialog click;
	private boolean gameFinished;
	
	public ClickerGame(String windowTitle) {
		super(windowTitle);
		
		time = 1;//FIXME change when not testing anymore
		UserClicks = 0;
		CompClicks = 0;
		pointsEarned = 0;
		gameFinished = false;
		setSize(300,300);
		JButton Easy = new JButton("Easy");
		JButton Medium = new JButton("Medium");
		JButton Hard = new JButton("Hard");
		JButton Play = new JButton("Play");
		GridLayout gl = new GridLayout(1,3);
		setLayout(gl);
		Easy.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CompClicks = 0;//FIXME change when not testing anymore
				pointsEarned = 5;

				playGame();
			}
		});
		Medium.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CompClicks = 30;
				pointsEarned = 10;
				playGame();
			}
		});
		Hard.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				CompClicks = 40;
				pointsEarned = 15;
				playGame();
			}
		});
		add(Easy);
		add(Medium);
		add(Hard);
		
		setVisible(true);
	}
	public int GetPoints() {
		return pointsEarned;
	}
	public boolean Finished() {
		return gameFinished;
	}
	


	public void initializeGame() {
		click = new JDialog(new JFrame(),"The magical clicker game");
		click.setSize(300, 300);
		clicker = new JButton(Integer.toString(UserClicks));
		clicker.setEnabled(true);
		
		clicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserClicks ++;
				clicker.setText(Integer.toString(UserClicks));

			}
		});
		
		click.add(clicker);
		click.setVisible(true);
		clicker.requestFocusInWindow(); 		
	}
	public void playGame()  {
		initializeGame();
		dispose();
		click.setVisible(true);
		clicker.requestFocusInWindow();
		new Timer(1000*time, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(UserClicks < CompClicks) {
					pointsEarned = 0;
				}
				endGame();
				((Timer)e.getSource()).stop();
				gameFinished = true;
			}
		}).start();


	}
	public void endGame() {
	    Object[] options = {"OK"};
	    int n = JOptionPane.showOptionDialog(new JFrame(),
	    		"You earned "+pointsEarned+" points.","",
	                   JOptionPane.PLAIN_MESSAGE,
	                   JOptionPane.QUESTION_MESSAGE,
	                   null,
	                   options,
	                   options[0]);
	    click.dispose();
	}
	

}
