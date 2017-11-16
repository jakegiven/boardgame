package miniGames;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

//import ece.game.iteration2.IntroGUI;

public class RPSCharacterScreen extends IntroGUI {
	private JButton Rock;
	private JButton Paper;
	private JButton Scissors;
	private int compareator;
	public static final String RES_PATH = "/my/Images";
	public static final String ROCK_FILENAME = "Rock.jpg";
	public static final String SCISSOR_FILENAME = "Scissors.jpg";
	public static final String PAPER_FILENAME = "Paper.jpg";
	public static final String ALL_FILENAME = "Rock_Paper_Scissors.jpg";
	
	
	public RPSCharacterScreen(String TitleContent, String RulesContent) {
		super(TitleContent, RulesContent);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		constraint.fill = (GridBagConstraints.HORIZONTAL);
		constraint.gridx = 0;
		constraint.gridy = 0;
		
		Inputs.add(Title, constraint);
		constraint.ipadx = 200;
		constraint.ipady = 300;
		constraint.gridy = 1;
		Inputs.add(Rules, constraint);

		constraint.insets = new Insets(0, 5, 0, 5);
		constraint.fill = GridBagConstraints.CENTER;
		constraint.gridy = 2;
		constraint.ipady = 0;
		constraint.ipadx = 0;
		Inputs.add(Rock, constraint);
		
		constraint.gridy = 2;
		constraint.gridx = 2;
		Inputs.add(Paper, constraint);
		
		constraint.gridy = 2;
		constraint.gridx = 3;
		Inputs.add(Scissors, constraint);
		
		constraint.insets = new Insets(5, 0, 5, 0);
		constraint.gridy = 3;
		constraint.gridx = 2;
		Inputs.add(next, constraint);
		
		add(Inputs);
	}
	
	private class JButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) //this is the method MenuListener must implement, as it comes from the ActionListener interface.
		{
			handlenext();		
		}

		private void handlenext() {
			
			setVisible(false);
			dispose();
			
		}

		
	}
}
