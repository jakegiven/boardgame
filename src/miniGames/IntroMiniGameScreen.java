package miniGames;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class IntroMiniGameScreen extends IntroGUI{

	public IntroMiniGameScreen(String TitleContent, String RulesContent) {
		super(TitleContent, RulesContent);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();	
		setVisible(true);
	}
	
	protected void buildGUI() {
		next = new JButton("Next");
		
		next.addActionListener(new JButtonListener());
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.ipadx = 300 - (int)Title.getSize().getWidth();
		constraint.gridx = 0;
		constraint.gridy = 0;
		
		Inputs.add(Title, constraint);
		constraint.ipadx = 600 - (int)Rules.getSize().getWidth();
		constraint.ipady = 300 - (int)Rules.getSize().getHeight();
		constraint.gridy = 1;
		Inputs.add(Rules, constraint);

		constraint.insets = new Insets(0, -300, 0, 0);
		constraint.gridy = 2;
		constraint.ipady = 0;
		constraint.ipadx = 0;
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
