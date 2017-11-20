package miniGames;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import main.*;

public class RPS extends Game{
	private ArrayList<Player> players;
	private IntroMiniGameScreen intro;
	private int player1_character;
	private int player2_character;
	private RPSCharacterScreen chosing;
	private int endGame;
	private int gamesPlayed;
	private double score; 
	private int winner;
	
	public RPS() {
		intro = new IntroMiniGameScreen("Let's Play Rock, Paper, Scissors!!", "\r\n" + "Rules: The two players each chose a object: a rock, a sheet of paper, or a pair of scissors.\r\n\t" +  
				"The winner of that round depends on the items chosen." +"\r\n\t" +  "If the same item is chosen, it's a tie." + "\r\n\t" + "Rock beats scissors, because a rock can smash scissors."+"\r\n\t"+ "Scissors beats paper, because scissors can cut paper." + "\r\n\t" + "Paper beats rock, because a sheet of paper can cover a rock." + "\r\n\t" + "Play continues until one player wins twice.");
		endGame = 0;
		gamesPlayed = 0;
		score = 0;
		players = new ArrayList<Player>();
		Player comp = new Player();
		comp.setName("Computer");
		
		Player real = new Player();
		real.setName("Sarah");
		players.add(comp);
		players.add(real);
		PlayGame();
	}
	
	public void PlayGame() {
		while(endGame == 0) {
			PlayTurn(players.get(0), 1);
			PlayTurn(players.get(1), 2);
			
			CompareCharacters();
			gamesPlayed++;
			endGame = checkGame();
			
		}
		System.out.println("Player "+ winner + " won");
	}

	private int checkGame() {
		
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
			System.out.println("Tied this round");
			return;
		}
		else if(player1_character == 3 &  player2_character == 1) {
			System.out.println("Player 1 wins this round");
			score = score + 1;
		}
		else if(player1_character == 2 &  player2_character == 3) {
			System.out.println("Player 1 wins this round");
			score = score + 1;
		}
		else if(player1_character == 1 &  player2_character == 2) {
			System.out.println("Player 1 wins this round");
			score = score + 1;
		}
		else {
			System.out.println("Player 2 wins this round");
			score = score + 2;
		}
		
	}

	public void PlayTurn(Player player, int num) {
		if(player.getName() == "Computer") {
			player1_character = ThreadLocalRandom.current().nextInt(1, 3 + 1);
			System.out.println("Computer played turn. Computer plays "+ player1_character);
		}
		else if(num == 1) {
			chosing = new RPSCharacterScreen("Choose an Item:", "\r\n" + "If the same item is chosen, it's a tie." + "\r\n" + "Rock beats scissors, because a rock can smash scissors."+"\r\n"+ "Scissors beats paper, because scissors can cut paper." + "\r\n" + "Paper beats rock, because a sheet of paper can cover a rock." + "\r\n");
			while(chosing.getTurnComplete() == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			player1_character = chosing.getPlayer();
			System.out.println("Player 1 has played. They chose "+ player1_character);
			chosing.dispose();
		}
		else if(num == 2) {
			chosing = new RPSCharacterScreen("Choose an Item", "\r\n" + "If the same item is chosen, it's a tie." + "\r\n" + "Rock beats scissors, because a rock can smash scissors."+"\r\n"+ "Scissors beats paper, because scissors can cut paper." + "\r\n" + "Paper beats rock, because a sheet of paper can cover a rock." + "\r\n");
			while(chosing.getTurnComplete() == 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			player2_character = chosing.getPlayer();
			System.out.println("Player 2 has played. They chose "+ player2_character);
			chosing.dispose();
		}
	}

	public int getWinner() {
		return winner;
	}

	public void setWinner(int winner) {
		this.winner = winner;
	}
}
