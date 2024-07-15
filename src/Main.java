package src;



///word api that can be used
///https://random-word-api.herokuapp.com/home
///https://www.datamuse.com/api/


public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world again!");
		
		Dictionary dic = new Dictionary();
		
		String result = dic.getAsyncRandomWord()
        .join();
		
		//String result = dic.getSyncRandomWord();
		
		int wordLength = result.length();
		
		System.out.println(result.substring(2, wordLength-2));
	}
}
