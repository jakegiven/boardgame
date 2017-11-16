package miniGames;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class RPSCharacterScreen extends IntroGUI {
	private JButton Rock;
	private JButton Paper;
	private JButton Scissors;
	private int player;
	public static final String RES_PATH = "/my/Images";
	public static final String ROCK_FILENAME = "Rock.jpg";
	public static final String SCISSOR_FILENAME = "Scissors.jpg";
	public static final String PAPER_FILENAME = "Paper.jpg";
	public static final String ALL_FILENAME = "Rock_Paper_Scissors.jpg";
	
	
	public RPSCharacterScreen(String TitleContent, String RulesContent) {
		super(TitleContent, RulesContent);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPlayer(0);
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
		GridBagConstraints constraint1 = new GridBagConstraints();
		constraint1.ipadx = 200;
		constraint1.ipady = 250;
		constraint1.gridy = 1;
		constraint1.gridx = 0;
		Inputs.add(Rules, constraint1);

		GridBagConstraints constraint2 = new GridBagConstraints();
		constraint2.anchor = GridBagConstraints.LINE_START;
		constraint2.insets = new Insets(0, 0, 0, 0);
		constraint2.gridy = 2;
		constraint1.gridx = 0;
		constraint2.ipady = 0;
		constraint2.ipadx = 0;
		Inputs.add(Rock, constraint2);
		
		GridBagConstraints constraint3 = new GridBagConstraints();
		constraint3.insets = new Insets(0, -75, 0, 0);
		constraint3.anchor = GridBagConstraints.CENTER;
		constraint3.gridy = 2;
		constraint3.gridx = 2;
		Inputs.add(Paper, constraint3);
		
		GridBagConstraints constraint4 = new GridBagConstraints();
		constraint4.anchor = GridBagConstraints.LINE_START;
		constraint4.insets = new Insets(0, 5, 0, 5);
		constraint4.gridy = 2;
		constraint4.gridx = 3;
		Inputs.add(Scissors, constraint4);
		
		GridBagConstraints constraint5 = new GridBagConstraints();
		constraint5.fill = GridBagConstraints.CENTER;
		constraint5.insets = new Insets(5, 0, 5, 0);
		constraint5.gridy = 3;
		constraint5.gridx = 2;
		Inputs.add(next, constraint5);
		
		add(Inputs);
	}
	
	public int getPlayer() {
		return player;
	}

	public void setPlayer(int player) {
		this.player = player;
	}

	private class JButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) //this is the method MenuListener must implement, as it comes from the ActionListener interface.
		{
			JButton source = (JButton)(e.getSource());
			if(source.equals(Rock)) {
				handleRock();
			}
			else if( source.equals(next)) {
				handlenext();		
			}
			else if( source.equals(Paper)) {
				handlePaper();
			}
			else if(source.equals(Scissors)) {
				handleScissors();
			}
		}

		private void handleScissors() {
			System.out.println("Scissors was pressed");
			setPlayer(1);
		}

		private void handlePaper() {
			// TODO Auto-generated method stub
			System.out.println("Paper was pressed");
			setPlayer(2);
		}

		private void handleRock() {
			// TODO Auto-generated method stub
			System.out.println("Rock was pressed");
			setPlayer(3);
		}

		private void handlenext() {
			setVisible(false);
			dispose();
			
		}

		
	}
}
