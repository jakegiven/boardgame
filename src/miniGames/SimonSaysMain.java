package miniGames;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;//FIXME
//import org.university.software.StreamChange;//FIXME

import javax.swing.*;

public class SimonSaysMain extends JFrame
{
	private JMenuBar menuBar;	//the horizontal container
	private JMenu gameMenu;		//JMenu objects are added to JMenuBar objects as the "tabs"
	private JMenuItem Exit; 
	private JMenuItem runGame;
	private JFrame intro;
	private int score;
	private boolean finished;

	private JPanel Standby;
	private JButton Start;
	
	
	
	public SimonSaysMain(String string) {
//		intro = new IntroMiniGameScreen("Simon says", "rules");
//		intro.setAlwaysOnTop(true);
		
		setSize(400, 200);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(new JLabel("<HTML><center>Simon Says" + "<BR>You will be presented with a few numbers between 1 and 4, memorize and then repeat them to score points.</center></HTML>"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();	
		setVisible(true);
	}
	
	public int getScore() {
		return score;
	}
	
	
	public void buildGUI() 
	{
		Start = new JButton("Start");
		Start.addActionListener(new MenuListener());
		add(Start);
		
/*		Standby.add(Start);
		menuBar = new JMenuBar();
		gameMenu = new JMenu("Game");
		runGame = new JMenuItem("Run");
		Exit = new JMenuItem("Exit");
		runGame.addActionListener(new MenuListener());
		Exit.addActionListener(new MenuListener());
		gameMenu.add(runGame);
		gameMenu.add(Exit);
		menuBar.add(gameMenu);
		
		setJMenuBar(menuBar);
//*/
	}
	
	private class MenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) //this is the method MenuListener must implement, as it comes from the ActionListener interface.
		{
			JButton source = (JButton)(e.getSource());
			
			if(source.equals(Start))
			{
				Run();
			}


			else if(source.equals(Exit))
			{
				Exit();
			}
		}
		
		private void Run()
		{
			SimonSays Simon = new SimonSays();
			Simon.newAnswer();
			Simon.newAnswer();
			Simon.newAnswer();
			Simon.newAnswer();
			String Dialogue= "Memorize! ";
			for(int i = 0;i<Simon.getAnswers().size();i++) {
				Dialogue = Dialogue + Simon.getAnswers().get(i) + " ";
			}
			Dialogue = Dialogue + "\n press OK when ready";

			JTextField Input = new JTextField();
			Object[] message = { /*Dialogue,*/
			    "Repeat!", Input,
			};
			int option = JOptionPane.showConfirmDialog(null, Dialogue, "Simon Says", JOptionPane.OK_CANCEL_OPTION);
			if (option == JOptionPane.OK_OPTION) {
				int option2 = JOptionPane.showConfirmDialog(null, message, "Simon Says", JOptionPane.OK_CANCEL_OPTION);
				if (option2 == JOptionPane.OK_OPTION) {
					//FIXME compare Input to Answers
					if(Simon.compareAnswers(Input.getText()+" ") == true) {
						JOptionPane.showMessageDialog(null, "you win! \n" + Simon.getPoints() + " points awarded");
						score = Simon.getPoints();
					}
					else {
						JOptionPane.showMessageDialog(null, "you lose!");
					}
//					JOptionPane.showMessageDialog(null, Input.getText()+" : "+Simon.fetchAnswers());
					finished = true;
				} 
				else {
				}
			} 
			else {
			}		
			

		}
		
		private void Exit() //EXIT
		{
			finished = true;
			setVisible(false);
			dispose();
		}
		
	}
	public boolean Finished() {
		return finished;
	}
}

