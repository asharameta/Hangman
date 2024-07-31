package src;

import java.util.Scanner;

public class Hangman {
	private static final String RESET = "\u001B[0m";
	private static final String GREEN = "\u001B[32m";
	private static final String YELLOW = "\u001B[33m";
	private static final int ATTEMPTS = 5;
	private final int maxAttempts;
	private int usedAttempts;
	private Dictionary dic;
	
	public Hangman() {
		this(ATTEMPTS);
	}
	
	public Hangman(int _maxAttempts) {
		this.maxAttempts = _maxAttempts;
		dic = new Dictionary();
	}
	
	private String drawWord() {
		String wordToGuess = dic.getSyncRandomWord();
		return wordToGuess.substring(2, wordToGuess.length()-2);
	}
	
	private String compareWords(String word, String targetWord){
		if (word == null || word.isBlank()) {
	        return "Input cannot be empty. Please try again.";
	    }
	    if (targetWord.length() != word.length()) {
	        return "Your word has a different number of characters than the word to guess.";
	    }
		
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < targetWord.length(); i++){
			char wordChar = word.charAt(i);
			char cleanedWordChar = targetWord.charAt(i);
			
			if(wordChar==cleanedWordChar) {
				result.append(GREEN).append(wordChar).append(RESET);
			}
			else if(targetWord.contains(Character.toString(wordChar))) {
				result.append(YELLOW).append(wordChar).append(RESET);
			}else {
				result.append(wordChar);
			}
		}
		
		return result.toString();
	}
	
	
	public void startGame() {
		usedAttempts = 0;
		String targetWord = drawWord();
		System.out.println("The word has " + targetWord.length() + " letters   "+targetWord);
		try (Scanner scanner = new Scanner(System.in)) {
			while(usedAttempts<maxAttempts) {
				System.out.println(usedAttempts+ "/"+ maxAttempts);
				String providedWord = scanner.nextLine();
				System.out.println(compareWords(providedWord, targetWord));
				if(targetWord.equalsIgnoreCase(providedWord)) {
					System.out.println("U won! Congratz.");
					return;
				}
				usedAttempts++;
				if(usedAttempts == maxAttempts) {
					System.out.println("You've lost! The correct word was: " + targetWord);
					return;
				}
			}
		}
	}
	
	
	
}
