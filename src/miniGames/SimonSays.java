package miniGames;
import java.util.ArrayList;
import java.util.Random;

public class SimonSays{
	private ArrayList<Integer> Answers;
	private int points;
	private String Instructions;

	public SimonSays() {
		Answers = new ArrayList<Integer>();
		points = 0;
		Instructions = "TODO insert game description here";
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
		String comp = "";
		for(int i = 0;i<Answers.size();i++) {
			comp = comp + Answers.get(i) + " ";
		}
		if(answers.equals(comp)) {
			return true;
		}

		return false;
	}
	public void newGame(String name){
	}
}