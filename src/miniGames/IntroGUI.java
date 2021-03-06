package miniGames;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public abstract class IntroGUI extends JFrame{
	protected JLabel Title;
	protected JTextArea Rules;
	protected JButton next;
	protected JPanel Inputs;
	protected boolean play;
	
	public boolean getPlay() {
		return play;
	}
	
	public IntroGUI(String TitleContent, String RulesContent) {
		super(TitleContent);
		
		setSize(600, 600);
		
		setLayout(new GridBagLayout());
		
		Inputs = new JPanel(new GridBagLayout());
		Title = new JLabel();
		Rules = new JTextArea();
		
		Title.setText(TitleContent);		
		
		Rules.setText(RulesContent);
		Rules.setOpaque(false);
		Rules.setFont(Title.getFont());
		Rules.setEditable(false);
		this.setResizable(false);
	}

	protected abstract void buildGUI();

	
	
}
