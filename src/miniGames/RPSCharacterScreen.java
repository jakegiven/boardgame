package miniGames;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RPSCharacterScreen extends IntroGUI {
	private JButton Rock;
	private JButton Paper;
	private JButton Scissors;
	private int turnComplete;
	private int buttonPressed;
	private int player;
	public static final String RES_PATH = "/my/Images";
	public static final String ROCK_FILENAME = "Rock.jpg";
	public static final String SCISSOR_FILENAME = "Scissors.jpg";
	public static final String PAPER_FILENAME = "Paper.jpg";
	public static final String ALL_FILENAME = "Rock_Paper_Scissors.jpg";
	private JPanel buttons;
	
	
	public RPSCharacterScreen(String TitleContent, String RulesContent) {
		super(TitleContent, RulesContent);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPlayer(0);
		setButtonPressed(0);
		buttons = new JPanel(new GridBagLayout());
		setTurnComplete(0);
		buildGUI();	
		setVisible(true);
	}
	
	protected void buildGUI() {
		next = new JButton("Next");
		Rock = new JButton("Rock", new ImageIcon(ROCK_FILENAME) );
		Paper = new JButton("Paper", new ImageIcon(PAPER_FILENAME) );
		Scissors = new JButton("Scissors", new ImageIcon(SCISSOR_FILENAME) );
	
		Rock.setHorizontalTextPosition(SwingConstants.CENTER);
		Rock.setVerticalTextPosition(JButton.BOTTOM);
		
		Paper.setHorizontalTextPosition(SwingConstants.CENTER);
		Paper.setVerticalTextPosition(JButton.BOTTOM);
		
		Scissors.setHorizontalTextPosition(SwingConstants.CENTER);
		Scissors.setVerticalTextPosition(JButton.BOTTOM);
		
		
		next.addActionListener(new JButtonListener());
		Rock.addActionListener(new JButtonListener());
		Paper.addActionListener(new JButtonListener());
		Scissors.addActionListener(new JButtonListener());
		
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.ipadx = 300 - (int)Title.getSize().getWidth();
		constraint.gridx = 0;
		constraint.gridy = 0;
		
		Inputs.add(Title, constraint);
		constraint.ipadx = 500 - (int)Rules.getSize().getWidth();
		constraint.ipady = 200 - (int)Rules.getSize().getHeight();
		constraint.gridy = 1;
		Inputs.add(Rules, constraint);
	
		GridBagConstraints constraint2 = new GridBagConstraints();
		constraint2.anchor = GridBagConstraints.LINE_START;
		constraint2.insets = new Insets(0, 15, 0, 0);
		constraint2.gridy = 2;
		constraint2.gridx = 0;
		constraint2.ipady = 0;
		constraint2.ipadx = 0;
		buttons.add(Rock, constraint2);
		
		GridBagConstraints constraint3 = new GridBagConstraints();
		constraint3.insets = new Insets(0, 5, 0, 5);
		constraint3.anchor = GridBagConstraints.CENTER;
		constraint3.gridy = 2;
		constraint3.gridx = 2;
		buttons.add(Paper, constraint3);
		
		GridBagConstraints constraint4 = new GridBagConstraints();
		constraint4.anchor = GridBagConstraints.LINE_START;
		constraint4.insets = new Insets(0, 5, 0, 5);
		constraint4.gridy = 2;
		constraint4.gridx = 3;
		buttons.add(Scissors, constraint4);
		
		GridBagConstraints constraint6 = new GridBagConstraints();
		constraint6.insets = new Insets(15, 0, 0, 0);
		constraint6.gridy = 0;
		constraint6.gridx = 0;
		
		add(Inputs, constraint6);
		
		constraint6.insets = new Insets(5, 0, 5, 0);
		constraint6.gridy = 1;
		add(buttons, constraint6);
	}
	
	public int getPlayer() {
		return player;
	}
	
	public void setPlayer(int player) {
		this.player = player;
	}
	
	public int getTurnComplete() {
		return turnComplete;
	}

	public void setTurnComplete(int turnComplete) {
		this.turnComplete = turnComplete;
	}

	public int getButtonPressed() {
		return buttonPressed;
	}

	public void setButtonPressed(int buttonPressed) {
		this.buttonPressed = buttonPressed;
	}

	private class JButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) //this is the method MenuListener must implement, as it comes from the ActionListener interface.
		{
			
			JButton source = (JButton)(e.getSource());
			if(source.equals(Rock)) {
				handleRock();
				setButtonPressed(1);
				setTurnComplete(1);
				handlenext();	
			}
			else if( source.equals(Paper)) {
				handlePaper();
				setButtonPressed(1);
				setTurnComplete(1);
				handlenext();	
			}
			else if(source.equals(Scissors)) {
				handleScissors();
				setButtonPressed(1);
				setTurnComplete(1);
				handlenext();	
			}
		}
	
		private void handleScissors() {
			//system.out.println("Scissors was pressed");
			setPlayer(1);
			
		}
	
		private void handlePaper() {
			// TODO Auto-generated method stub
			//system.out.println("Paper was pressed");
			setPlayer(2);
		}
	
		private void handleRock() {
			// TODO Auto-generated method stub
			//system.out.println("Rock was pressed");
			setPlayer(3);
		}
	
		private void handlenext() {
			setVisible(false);
			
		}
	
		
	}
}
