package src;

import java.util.Scanner;

public class Main {
	private static int ATTEMPTS = 3;
	private static int usedAttempts = 0;
	
	public static void main(String[] args) {
		Hangman hM = new Hangman();
		System.out.println("Hello world again!   " + hM.getTheWord());
		
		System.out.println("The word has " + hM.getWordLength() + " letters");
		try (Scanner scanner = new Scanner(System.in)) {
			while(usedAttempts<ATTEMPTS) {
				System.out.println(usedAttempts+ "/"+ ATTEMPTS);
				System.out.print("word: ");
				String providedWord = scanner.nextLine();
				System.out.println(hM.CheckTheWord(providedWord));
				if(hM.getTheWord().equalsIgnoreCase(providedWord)) {
					System.out.println("U won! Congratz.");
					return;
				}
				usedAttempts++;
				if(usedAttempts == ATTEMPTS) {
					System.out.println("U lost! Try again.");
					return;
				}
			}
			

		}
	}
}
