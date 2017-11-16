package main;

import javax.swing.ImageIcon;

// Rock, paper, scissor parent class
public abstract class Character {
	private String Name;
	private ImageIcon characterIcon;
	private int compareator;
	public static final String RES_PATH = "/my/Images";
	public static final String ROCK_FILENAME = "Rock.jpg";
	public static final String SCISSOR_FILENAME = "Scissors.jpg";
	public static final String PAPER_FILENAME = "Paper.jpg";
	public static final String ALL_FILENAME = "Rock_Paper_Scissors.jpg";
	
	
	public Character() {
		//has GUI stuff setting the size of each of the character squares
		Name = "not set";
		compareator = -1;
		characterIcon =  new ImageIcon(this.getClass().getResource(ALL_FILENAME));
	}

	public int CharacterCompare(Player Other) {
		return 0;
		
		/*if(compareator == Other.getPlayerCharacter().getCompareator()) {
			return -1;
		}
		else if(compareator == 3 &  Other.getPlayerCharacter().getCompareator() == 1) {
			return 1;
		}
		else if(compareator == 2 &  Other.getPlayerCharacter().getCompareator() == 3) {
			return 1;
		}
		else if(compareator == 1 &  Other.getPlayerCharacter().getCompareator() == 2) {
			return 1;
		}
		else {
			return 2;
		}
		*/
	}

	private int getCompareator() {return this.compareator;}
	
	private void ChooseCharacter(){
		
		
	}
	
	
}
