package src;

public class Hangman {
	private Dictionary dic = new Dictionary();
	private final String wordToGuess = dic.getSyncRandomWord();
	private final String cleanedWord = wordToGuess.substring(2, wordToGuess.length()-2);
	private final int wordLength = cleanedWord.length();

	private static final String RESET = "\u001B[0m";
	private static final String GREEN = "\u001B[32m";
	private static final String YELLOW = "\u001B[33m";
	
	public String getTheWord() {
		return cleanedWord;
	}
	
	public int getWordLength() {
		return wordLength;
	}
	
	public String CheckTheWord(String word){
		if(cleanedWord.length() != word.length()) return "your word is less/more characters than word you have to guess";
		
		StringBuilder strToReturn = new StringBuilder();
		for(int i = 0; i < cleanedWord.length(); i++){
			char wordChar = word.charAt(i);
			char cleanedWordChar = cleanedWord.charAt(i);
			
			if(wordChar==cleanedWordChar) {
				strToReturn.append(GREEN+wordChar+RESET);
			}
			else if(cleanedWord.contains(Character.toString(wordChar))) {
				strToReturn.append(YELLOW+wordChar+RESET);
			}else {
				strToReturn.append(wordChar);
			}
		}
		
		return strToReturn.toString();
	}
	
}
