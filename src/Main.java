package src;

import java.util.Scanner;

public class Main {
	private static int ATTEMPTS = 3;
	private static int usedAttempts = 0;
	
	public static void main(String[] args) {
		Hangman hM = new Hangman();
		System.out.println("Hello world again!" + hM.getTheWord());
		
		System.out.println("The word has " + hM.getWordLength() + " letters");
		try (Scanner scanner = new Scanner(System.in)) {
			while(usedAttempts<ATTEMPTS) {
				System.out.println(usedAttempts+ "/"+ ATTEMPTS);
				System.out.print("word: ");
				if(hM.CheckTheWord(scanner.nextLine())) {
					System.out.println("U won! Congratz.");
					scanner.close();
					return;
				}
				usedAttempts++;
				if(usedAttempts == ATTEMPTS) {
					System.out.println("U lost! Try again.");
					scanner.close();
					return;
				}
			}
			

		}
	}
}
