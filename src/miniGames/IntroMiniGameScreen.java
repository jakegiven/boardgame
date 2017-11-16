package miniGames;

import java.awt.GridBagConstraints;
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
		constraint.fill = (GridBagConstraints.HORIZONTAL);
		constraint.gridx = 0;
		constraint.gridy = 0;
		
		Inputs.add(Title, constraint);
		constraint.ipadx = 600;
		constraint.ipady = 400;
		constraint.gridy = 1;
		Inputs.add(Rules, constraint);

		constraint.fill = GridBagConstraints.CENTER;
		constraint.gridy = 2;
		constraint.ipady = 1;
		constraint.ipadx = 1;
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
