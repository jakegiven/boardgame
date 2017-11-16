package miniGames;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import main.*;

//umm Hello
public class RPS extends Game{
	private ArrayList<Player> players;
	private IntroMiniGameScreen intro;
	private int player1_character;
	private int player2_character;
	private RPSCharacterScreen chosing;
	private int endGame;
	private double score; // 1.26 means player 1 wins 26 points and 2.53 means player 2 wins 36 ect..
	
	public RPS() {
		intro = new IntroMiniGameScreen("Let's Play Rock, Paper, Scissors!!", "\r\n" + "Rules: The two players each chose a object: a rock, a sheet of paper, or a pair of scissors.\r\n\t" +  
				"The winner of that round depends on the items chosen." +"\r\n\t" +  "If the same item is chosen, it's a tie." + "\r\n\t" + "Rock beats scissors, because a rock can smash scissors."+"\r\n\t"+ "Scissors beats paper, because scissors can cut paper." + "\r\n\t" + "Paper beats rock, because a sheet of paper can cover a rock." + "\r\n\t" + "Play continues until one player wins twice.");
		endGame = 0;
		players = new ArrayList<Player>();
	}
	
	public void PlayGame() {
		
		while(endGame == 0) {
			PlayTurn(players.get(0), 1);
			PlayTurn(players.get(1), 2);
			CompareCharacters();
			endGame = checkGame();
			endGame = 1;
		}
		
	}
	
	private int checkGame() {
		
		return 0;
	}

	private void CompareCharacters() {
		
		
	}

	public void PlayTurn(Player player, int num) {
		if(player.getName() == "Computer") {
			player1_character = ThreadLocalRandom.current().nextInt(1, 3 + 1);
		}
		else if(num == 1) {
			chosing = new RPSCharacterScreen("Choose an Item", "\r\n" + "If the same item is chosen, it's a tie." + "\r\n\t" + "Rock beats scissors, because a rock can smash scissors."+"\r\n\t"+ "Scissors beats paper, because scissors can cut paper." + "\r\n\t" + "Paper beats rock, because a sheet of paper can cover a rock." + "\r\n\t");
			player1_character = chosing.getPlayer();
		}
		else if(num == 2) {
			chosing = new RPSCharacterScreen("Choose an Item", "\r\n" + "If the same item is chosen, it's a tie." + "\r\n\t" + "Rock beats scissors, because a rock can smash scissors."+"\r\n\t"+ "Scissors beats paper, because scissors can cut paper." + "\r\n\t" + "Paper beats rock, because a sheet of paper can cover a rock." + "\r\n\t");
			player2_character = chosing.getPlayer();
		}
	}
}
