package src;

import java.util.Scanner;

public class Hangman {
	private Dictionary dic;
	public Hangman() {
		dic = new Dictionary();
	}

	private static final String RESET = "\u001B[0m";
	private static final String GREEN = "\u001B[32m";
	private static final String YELLOW = "\u001B[33m";
	
	private static int ATTEMPTS = 3;
	private static int usedAttempts = 0;
	
	
	private String DrawWord() {
		String wordToGuess = dic.getSyncRandomWord();
		String cleanedWord = wordToGuess.substring(2, wordToGuess.length()-2);
		return cleanedWord;
	}
	
	private String CheckTheWord(String word, String drawnWord){
		if(drawnWord.length() != word.length()) return "your word is less/more characters than word you have to guess";
		
		StringBuilder strToReturn = new StringBuilder();
		for(int i = 0; i < drawnWord.length(); i++){
			char wordChar = word.charAt(i);
			char cleanedWordChar = drawnWord.charAt(i);
			
			if(wordChar==cleanedWordChar) {
				strToReturn.append(GREEN+wordChar+RESET);
			}
			else if(drawnWord.contains(Character.toString(wordChar))) {
				strToReturn.append(YELLOW+wordChar+RESET);
			}else {
				strToReturn.append(wordChar);
			}
		}
		
		return strToReturn.toString();
	}
	
	
	public void StartGame() {
		String drawnWord = DrawWord();
		System.out.println("The word has " + drawnWord.length() + " letters   "+drawnWord);
		try (Scanner scanner = new Scanner(System.in)) {
			while(usedAttempts<ATTEMPTS) {
				System.out.println(usedAttempts+ "/"+ ATTEMPTS);
				System.out.print("word: ");
				String providedWord = scanner.nextLine();
				System.out.println(CheckTheWord(providedWord, drawnWord));
				if(drawnWord.equalsIgnoreCase(providedWord)) {
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
