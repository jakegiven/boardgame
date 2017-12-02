package miniGames;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import main.Player;

public class CharacterCompareGUI extends JFrame{
	
	private ArrayList<Player> playerList;
	private JButton next;
	private JPanel Inputs;
	private JLabel Rock;
	private JLabel Paper;
	private JLabel Scissors;
	private JLabel winner;
	private int buttonPressed;
	public static final String RES_PATH = "/my/Images";
	public static final String ROCK_FILENAME = "Rock.jpg";
	public static final String SCISSOR_FILENAME = "Scissors.jpg";
	public static final String PAPER_FILENAME = "Paper.jpg";
	public static final String ALL_FILENAME = "Rock_Paper_Scissors.jpg";
	private JLabel title;

	
	
	public CharacterCompareGUI(String TitleContent, int player1_character, int player2_character, ArrayList<Player> players) {
		super(TitleContent);
		
		setSize(600, 600);
		
		setLayout(new GridBagLayout());
		
		Inputs = new JPanel(new GridBagLayout());
		
		next = new JButton("Next");
		Rock = new JLabel(new ImageIcon(ROCK_FILENAME));
		Paper = new JLabel( new ImageIcon(PAPER_FILENAME));
		Scissors = new JLabel(new ImageIcon(SCISSOR_FILENAME));
		setButtonPressed(0);
		playerList = new ArrayList<Player>();
		playerList.addAll(players);
		title = new JLabel();
		title.setText( "And the Winner is....");
		winner = new JLabel();
		buildGUI(player1_character, player2_character);
		
		this.setResizable(false);
	}


	private void buildGUI(int player1_character, int player2_character) {
		int tie = 0;
		if(player1_character == player2_character) {
			winner.setText("No one!!! Tied Round.");
			tie = 1;
		}
		else if(player1_character == 3 &  player2_character == 1) {
			winner.setText( playerList.get(0).getName() + "!!!!!");
		}
		else if(player1_character == 2 &  player2_character == 3) {
			winner.setText(playerList.get(0).getName() + "!!!!!");
		}
		else if(player1_character == 1 &  player2_character == 2) {
			winner.setText(playerList.get(0).getName() + "!!!!!");
		}
		else {
			winner.setText(playerList.get(1).getName() + "!!!!!");
		}
		
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.ipadx = 300 - (int)title.getSize().getWidth();
		constraint.gridx = 0;
		constraint.gridy = 0;
		
		add(title, constraint);
		
		constraint.anchor = GridBagConstraints.LINE_START;
		constraint.insets = new Insets(0, 15, 0, 0);
		constraint.gridy = 1;
		constraint.gridx = 0;
		constraint.ipady = 0;
		constraint.ipadx = 0;
		
		if(player1_character == 3 ) {
			Inputs.add(Rock, constraint);
		}
		else if(player1_character == 2) {
			Inputs.add(Paper, constraint);
		}
		else if(player1_character == 1) {
			Inputs.add(Scissors, constraint);
		}
		
		
		constraint.insets = new Insets(0, 5, 0, 5);
		constraint.anchor = GridBagConstraints.CENTER;
		constraint.gridy = 1;
		constraint.gridx = 2;
		if(tie == 0) {
			if(player2_character == 3) {
				Inputs.add(Rock, constraint);
			}
			else if(player2_character == 2) {
				Inputs.add(Paper, constraint);
			}
			else if(player2_character == 1) {
				Inputs.add(Scissors, constraint);
			}
		}
		
		constraint.insets = new Insets(0, 5, 0, 5);
		constraint.gridy = 2;
		constraint.gridx = 0;
		
		
		Inputs.add(winner, constraint);
		
		next.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent e) {
	        	JButton source = (JButton)(e.getSource());
	        	if(source.equals(next)) {
	        		setButtonPressed(1);
	        		setVisible(false);
	        	}
	        }
	    });
		
		constraint.gridy = 3;
		constraint.gridx = 0;
		Inputs.add(next, constraint);
		
		constraint.gridy = 1;
		constraint.gridx = 0;
		
		add(Inputs, constraint);
		setVisible(true);
		
	}


	public int getButtonPressed() {
		return buttonPressed;
	}


	public void setButtonPressed(int buttonPressed) {
		this.buttonPressed = buttonPressed;
	}

}
