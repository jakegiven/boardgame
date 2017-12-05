package miniGames;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JOptionPane;

import main.*;

public class RPS extends Game{
	
	private IntroMiniGameScreen End;
	private int player1_character;
	private int player2_character;
	private RPSCharacterScreen chosing;
	private int endGame;
	private int gamesPlayed;
	private int score; 
	private int winner;
	private int realScore;
	private String[] types= { "","Scissors","Paper","Rock"};
	private String comp;
	private String previous1;
	private String previous2;
	private CharacterCompareGUI CompareScreen;

	
	public RPS(Player real) {
		introScreen = new IntroMiniGameScreen("Let's Play Rock, Paper, Scissors!!", "\r\n" + "Rules: The two players each chose a object: a rock, a sheet of paper, or a pair of scissors.\r\n\t" +  
				"The winner of that round depends on the items chosen." +"\r\n\t" +  "If the same item is chosen, it's a tie." + "\r\n\t" + "Rock beats scissors, because a rock can smash scissors."+"\r\n\t"+ "Scissors beats paper, because scissors can cut paper." + "\r\n\t" + "Paper beats rock, because a sheet of paper can cover a rock." + "\r\n\t" + "Play continues until one player wins twice.");
		introScreen.setAlwaysOnTop(true);

		while(introScreen.getCheckNext() == 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		endGame = 0;
		gamesPlayed = 0;
		score = 0;
		realScore = 20;
		PlayerList = new ArrayList<Player>();
		Player comp = new Player();
		comp.setName("Computer");
		previous1 = "";
		previous2 = "";
		this.comp = "";
		
		
		PlayerList.add(comp);
		PlayerList.add(real);
		PlayGame();
	}
	
	public void PlayGame() {

		while(endGame == 0) {
			
			PlayTurn(PlayerList.get(1), 2);
			PlayTurn(PlayerList.get(0), 1);
			CompareCharacters();
			gamesPlayed++;
			CompareScreen = new CharacterCompareGUI("Checking Winner" , player1_character, player2_character, PlayerList);
			while(CompareScreen.getButtonPressed() == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			endGame = checkGame();
		}
		
		End = new IntroMiniGameScreen("The Game has been won.", "\r\nAnd the Winner is.....\r\n\t"+ PlayerList.get(winner - 1).getName().toUpperCase() + "!!!");
		while(End.getCheckNext() == 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//system.out.println("Player "+ winner + " won");
	}

	public int checkGame() {
		
		if(gamesPlayed == 3) {
			if(score == 5) {
				setWinner(2);				
			}
			else if(score == 4) {
				setWinner(1);
			}
			return 1;
		}
		else if(score == 4 && gamesPlayed == 2) {
			setWinner(2);
			return 1;
		}
		else if(score == 2 && gamesPlayed == 2) {
			setWinner(1);
			return 1;
		}
		return 0;
	}

	private void CompareCharacters() {
		if(player1_character == player2_character) {
			gamesPlayed--;
			//system.out.println("Tied this round");
			comp = "Tied this round";
			return;
		}//paper == 2 ,scissors == 1, rock == 3
		else if(player1_character == 3 &  player2_character == 1) {
			//system.out.println("Player 1 wins this round");
			score = score + 1;
			comp = "Player 1 wins this round";
		}
		else if(player1_character == 2 &  player2_character == 3) {
			//system.out.println("Player 1 wins this round");
			score = score + 1;
			comp = "Player 1 wins this round";
		}
		else if(player1_character == 1 &  player2_character == 2) {
			//system.out.println("Player 1 wins this round");
			score = score + 1;
			comp = "Player 1 wins this round";
		}
		else {
			//system.out.println("Player 2 wins this round");
			score = score + 2;
			comp = "Player 2 wins this round";
		}
		
	}

	public void PlayTurn(Player player, int num) {
		if(player.getName() == "Computer") {
			player1_character = ThreadLocalRandom.current().nextInt(1, 3 + 1);
			previous1 = types[player1_character];
			//system.out.println("Computer played turn. Computer plays "+ player1_character);
		}
		else if(num == 2) {
			chosing = new RPSCharacterScreen("Choose an Item", "\r\n" + "If the same item is chosen, it's a tie." + 
											"\r\n" + "Rock beats scissors, because a rock can smash scissors."+"\r\n"+
											"Scissors beats paper, because scissors can cut paper." + "\r\n" + 
											"Paper beats rock, because a sheet of paper can cover a rock.");// + "\r\n"+
											//"\r\n\r\n\r\n\r\n" + "Last turn player 1 played:"+previous1+" and player 2 played:"+previous2+
										//	"\r\n\r\n"+comp)
			while(chosing.getTurnComplete() == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			player2_character = chosing.getPlayer();
			previous2 = types[player2_character];
			//system.out.println("Player 2 has played. They chose "+ player2_character);
			chosing.dispose();
		}
	}

	public int getWinner() {
		return winner;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}

	public int getScore() {
		// TODO Auto-generated method stub
		return realScore;
	}
}
