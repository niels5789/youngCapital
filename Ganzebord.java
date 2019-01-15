package ganzebord;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Ganzebord {
	
	static Scanner sc = new Scanner(System.in);
	static Scanner sc2 = new Scanner(System.in);
	
	//create array list for player objects
	static ArrayList<Player> player = new ArrayList<Player>();

	public static void main(String[] args) {
		
		//Welcome text
		printWelcomeText();
		
		//get amount of players
		System.out.println("Enter number of players");
		int p = sc.nextInt();
		System.out.println( "You selected a " + p + " player game.\n");
		
		//add player objects to player list
		for(int i = 0; i < p ; i++) {
			player.add(i, new Player(i));
		}
		
		while(true) {
			for (int j = 0; j < player.size(); j++) {
				if(player.get(j).isInPut()) {
					System.out.println(player.get(j).getName() + " zit in de put en slaat nog een beurtje over.\n");
				} else if(player.get(j).getTurnsToWait() > 0) {
					player.get(j).waitTurn();
					System.out.println("PLayer " + (j + 1) + " skips a turn.\n");
				} else {
					System.out.print("Player " + (j + 1) + " it's your turn. ");
					takeTurn(player.get(j));
				}
				
			}
		}
	}

	private static void takeTurn(Player p) {
		//vraag speler om de dobbelsteen te gooien
		throwDice();
		//get dice value
		p.setLastThrow(getValueDiceThrow());
		//move Player
		p.moveThrow();
		//geef nieuwe locatie van speler
		int currentPosition = p.getPosition();
		System.out.println("Your current position = " + currentPosition + "\n");
		//check for special location
		specialCases(p);
		
	}

	// Method to check and alter position
	private static void specialCases(Player p) {
		int pos = p.getPosition();
		if(pos == 6) {brug(p);}
		else if(pos == 19) {herberg(p);}
		else if(pos == 31) {put(p);}
		else if(pos == 42) {doolhof(p);}
		else if(pos == 52) {gevangenis(p);}
		else if(pos == 58) {dood(p);}
		else if(pos == 63) {winnen(p);}
		else if(pos > 63) {teHoog(p);}
		
	}
	
	private static void dood(Player p) {
		System.out.println("Oops, let je even niet op, ben je dood. \nGa terug naar positie 0, en begin opnieuw.");
		p.setPosition(0);
	}
	
	private static void teHoog(Player p) {
		System.out.println("Je gooide te hoog een moest terug lopen.");
		p.setPosition(63 + (63 - p.getPosition()));
	}
	
	private static void winnen(Player p) {
		System.out.println("Gefeliciteerd " + p.getName() + ", Je hebt gewonnen! ");
		System.exit(0);
	}
	
	private static void gevangenis(Player p) {
		System.out.println("Je bent opgepakt en moet 3 beurten brommen in de bak.");
		p.waitTurn(3);
	}

	private static void doolhof(Player p) {
		System.out.println("Je bent verdwaald in een doolhof en bent terug bij positie 39. \n");
		p.setPosition(39);
	}

	private static void put(Player p) {
		
		System.out.println("Helaas, " + p.getName() + " je bent in de put gevallen!");
		
		for(Player pl: player) {
			if(pl.isInPut()){
				System.out.println(pl.getName() + " mag uit de put!");
			}
			pl.uitPut();
		}
		p.setInPut();
	}

	private static void herberg(Player p) {
		System.out.println("Je komt in een herberg en slaat een beurt over om je kater uit te slapen.\n");
		p.waitTurn(1);
	}

	private static void brug(Player p) {
		System.out.println("You take a bridge to take a shortcut and arrive on position 12!\n");
		p.setPosition(12);
	}

	private static void printWelcomeText() {
		System.out.println("\n\n---- WELCOME AT GANZEBORD THE GAME ----\n\n");
		System.out.println("");
	}

	private static void throwDice() {
		String s;
		boolean correctInput = true;
		
		while (correctInput) {
			s = sc2.nextLine();
			
			if (s.equals("g")) {
				correctInput = false;
			} else if (s.equals("q")) {
				System.exit(0);
			} else {
				System.out.println("Wrong input, please enter (g) to throw the dice or (q) to exit program.");
			} 
		}	
	}

	private static int getValueDiceThrow() {
		Random random = new Random(); int a = random.nextInt(6) + 1;
		System.out.println("Your throw = " + a);
		return a;
	}
}
