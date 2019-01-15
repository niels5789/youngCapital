package ganzebord;

import java.util.Random;
import java.util.Scanner;

public class Ganzebord {

	public static void main(String[] args) {
		
		//Welcome text
		printWelcomeText();
		
		//create player
		Player p1 = new Player();
		
		while(true) {
				
			//vraag speler om de dobbelsteen te gooien
			throwDice();
		
			//get dice value
			p1.setLastThrow(getValueDiceThrow());
		
			//verplaats speler
			p1.moveThrow();
		
			//geef nieuwe locatie van speler
			int currentPosition = p1.getPosition();
			System.out.println("The current position = " +currentPosition);
			
			//check for special location
			specialCases(p1);

		}
		
	}

	// Method to check and alter position
	private static void specialCases(Player p1) {
		if(p1.getPosition() % 10 == 0 ) {
			p1.moveThrow();
			System.out.println("Jeej! je krijgt " + p1.getLastThrow() + " bonus stapjes " + "je nieuwe positie is "+ p1.getPosition());
		} else if(p1.getPosition() >= 63) {
			System.out.println("Jeej, je hebt gewonnen");
			System.exit(0);
		} else if(p1.getPosition() == 23) {
			System.out.println("helaas pindakaas, je bent dood!");
			System.exit(0);
		}
		
	}

	private static void printWelcomeText() {
		System.out.println("\n\n----WELKOM BIJ GANZEBORD----\n\n");
		System.out.println("Type (g) in om de dobbelsteen te gooien.");		
	}

	private static void throwDice() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String s;
		boolean correctInput = true;
		
		while (correctInput) {
			s = sc.nextLine();
			
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
		Random random = new Random(); int a = random.nextInt(5) + 1;
		return a;
	}

}
