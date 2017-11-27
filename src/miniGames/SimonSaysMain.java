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
	private IntroMiniGameScreen intro;
	private int score;
	private boolean finished;

	private JPanel Standby;
	private JButton Start;
	private boolean play;
	private boolean finishedRound;
	
	
	
	public SimonSaysMain(String string) {
		intro = new IntroMiniGameScreen("Simon says", "You will be presented with a few numbers between 1 and 4\n memorize and then repeat them to score points.");
		intro.setAlwaysOnTop(true);
		
		//setSize(400, 200);
		//setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//add(new JLabel("<HTML><center>Simon Says" + "<BR>You will be presented with a few numbers between 1 and 4\n, memorize and then repeat them to score points.</center></HTML>"));
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//buildGUI();	
		//setVisible(true);
		
		while(!intro.getPlay()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int j = 4;
		play = true;
		while(play) {
			Run(j);
			while(!finishedRound) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			finishedRound = false;
			j ++;
		}
		finished = true;
		dispose();

	}
	
	public int getScore() {
		return score;
	}
	
	

	private void Run(int num)
	{
		SimonSays Simon = new SimonSays();
		for(int i = 0; i < num; i++) {
			Simon.newAnswer();
		}
		String Dialogue= "Memorize! ";
		for(int i = 0;i<Simon.getAnswers().size();i++) {
			Dialogue = Dialogue + Simon.getAnswers().get(i) + " ";
		}
		Dialogue = Dialogue + "\n Press OK when ready.";

		JTextField Input = new JTextField();
		Object[] message = { /*Dialogue,*/
		    "Repeat!", Input,
		};
		JOptionPane.showMessageDialog(null, Dialogue, "Simon Says", -1);
		JOptionPane.showMessageDialog(null, message, "Simon Says", -1);

				//FIXME compare Input to Answers
				if(Simon.compareAnswers(Input.getText()+" ")) {
					int option3 = JOptionPane.showConfirmDialog(null, "You won the round!\n Continue?","Simon Says",JOptionPane.YES_NO_OPTION);
					if(option3 == JOptionPane.YES_OPTION) {
						finishedRound = true;
						play = true;
					}
					else {
						JOptionPane.showMessageDialog(null, "You won and earned:"+Simon.getPoints()+" points","Simon Says", -1);
						play = false;
						score = Simon.getPoints();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "you lose!");
					play = false;
					score = 0;
				}		
		finishedRound = true;

	}
	
	public boolean Finished() {
		return finished;
	}

}
