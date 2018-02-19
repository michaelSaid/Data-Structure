package eg.edu.alexu.csd.datastructure.hangman.cs38;

import java.util.Scanner;
public class test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Hangman mygame = new Hangman();
		String[]Wo = {"EGYPT","sfdss","ERWDTR","EWREW"};
		mygame.setDictionary(Wo);
		mygame.selectRandomSecretWord();
		mygame.setMaxWrongGuesses(3);
		System.out.println(mygame.GuessWord);
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String in = "0";
		while(in!=null) {
			char c = input.next().charAt(0);
			 in = mygame.guess(c);
			 if(in!=null)
			System.out.println(in);
	}
		System.out.println("the end");

}
}
