package eg.edu.alexu.csd.datastructure.hangman.cs38;

import java.util.Scanner;
public class test {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Hangman mygame = new Hangman();
		String[]Wo= mygame.readFromFile("C:\\Users\\DELL\\Desktop\\hangman.txt");
		mygame.setDictionary(Wo);
		mygame.selectRandomSecretWord();
		mygame.setMaxWrongGuesses(5);
		System.out.println(mygame.GuessWord);
		Scanner inp = new Scanner(System.in);
		String in = "0";
		while(in!=null) {
			char c = inp.next().charAt(0);
			 in = mygame.guess(c);
			 if(in!=null)
			System.out.println(in);
	}
		System.out.println("game over");

}
}
