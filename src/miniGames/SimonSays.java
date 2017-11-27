package miniGames;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Random;
import miniGames.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SimonSays{
	private ArrayList<Integer> Answers;
	private int points;
	private boolean done;
	private JFrame intro;

	public SimonSays() {
		Answers = new ArrayList<Integer>();
		points = 0;
		done = false;
	}
	public ArrayList<Integer> getAnswers(){
		return Answers;
	}
	public int getPoints() {
		points = Answers.size() * 10;
		return points;
	}
	
	public void newAnswer() {
		Random rand = new Random();
		int  n = rand.nextInt(4) + 1;
		Answers.add(n);
	}
	public String fetchAnswers() {
		String temp = "";
		for(int i = 0;i<Answers.size();i++) {
			temp = temp + Answers.get(i);
		}		
		return temp;
	}
	public boolean compareAnswers(String answers) {

		answers = answers.replaceAll("[^0-9]","");
		
		if(answers.equals(this.fetchAnswers())) {
			return true;
		}
		
		return false;
	}
	public boolean Finished(){
		return done;
	}
	public int getScore() {
		return points;
	}
}
