package game.minigames;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SimonSays{
	private ArrayList<Integer> Answers;
	private int points;
	private String Instructions;

	public SimonSays() {
		Answers = new ArrayList<Integer>();
		points = 0;
		Instructions = "TODO insert game description here";

		this.newAnswer();
		this.newAnswer();
		this.newAnswer();
		this.newAnswer();
		String Dialogue= "Memorize! ";
		for(int i = 0;i<this.getAnswers().size();i++) {
			Dialogue = Dialogue + this.getAnswers().get(i) + " ";
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
				if(this.compareAnswers(Input.getText()+" ") == true) {
					JOptionPane.showMessageDialog(null, "you win! \n" + this.getPoints() + " points awarded");
				}
				else {
					JOptionPane.showMessageDialog(null, "you lose!");
				}
//				JOptionPane.showMessageDialog(null, Input.getText()+" : "+ this.fetchAnswers());
				JOptionPane.showMessageDialog(null, this.fetchAnswers());
			} 
			else {
			}
		} 
		else {
		}
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
			temp = temp + Answers.get(i) + " ";
		}		
		return temp;
	}
	public boolean compareAnswers(String answers) {
		ArrayList<Integer> compare = new ArrayList<Integer>();
		for(int i = 0;i<answers.length();i++) {
			if(answers.charAt(i) != ",".charAt(0)) {
				if(answers.charAt(i) != " ".charAt(0)) {
					compare.add(Integer.parseInt(""+answers.charAt(i)));
				}
			}
		}
		String comp = "";
		for(int i = 0;i<compare.size();i++) {
			comp = comp + compare.get(i) + " ";
		}
		if(comp.equals(this.fetchAnswers())) {
			return true;
		}

		/*		if(answers.size() != Answers.size()) {
			return false;			
		}
		else {
			for(int i = 0;i<answers.size();i++) {
				if(answers.get(i) != Answers.get(i)) {
					return false;
				}
			}
-		}*/
		return false;
	}
	public void newGame(String name){
	}
}
