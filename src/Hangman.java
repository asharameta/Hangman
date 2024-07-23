package src;

public class Hangman {
	private Dictionary dic = new Dictionary();
	private final String wordToGuess = dic.getSyncRandomWord();
	private final String cleanedWord = wordToGuess.substring(2, wordToGuess.length()-2);
	private final int wordLength = cleanedWord.length();

	
	public String getTheWord() {
		return wordToGuess;
	}
	
	public int getWordLength() {
		return wordLength;
	}
	
	public boolean CheckTheWord(String word){
		return word.equalsIgnoreCase(cleanedWord);
	}
	
}
