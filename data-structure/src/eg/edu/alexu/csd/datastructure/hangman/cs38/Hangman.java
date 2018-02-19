package eg.edu.alexu.csd.datastructure.hangman.cs38;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

public class Hangman implements IHangman {

	String[] Dictionary;
	String SecretWord;
	int MaxWrongGuesses;
	String GuessWord = "-";

	@Override
	public void setDictionary(String[] words) {
		// TODO Auto-generated method stub

		Dictionary = words;
	}

	@Override
	public String selectRandomSecretWord() {
		// TODO Auto-generated method stub
		Random ran = new Random();
		if (Dictionary.length > 0) {
			SecretWord = Dictionary[ran.nextInt(Dictionary.length)];
			for (int i = 1; i < SecretWord.length(); i++) {
				GuessWord += "-";
			}
			return SecretWord;
		}
		return null;
	}

	@Override
	public String guess(Character c) throws Exception {
		// TODO Auto-generated method stub
		if (MaxWrongGuesses > 1) {
			boolean found = false;
			SecretWord.substring(0, 0).equalsIgnoreCase(c.toString());
			for (int i = 0; i < SecretWord.length(); i++) {
				if (SecretWord.substring(i, i+1).equalsIgnoreCase(c.toString())) {
					GuessWord = GuessWord.substring(0, i) + SecretWord.charAt(i) + GuessWord.substring(i + 1);
					found = true;
				}
			}
			if (!found) {
				MaxWrongGuesses--;
			}
			return GuessWord;
		}
		return null;
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		// TODO Auto-generated method stub
		if (max != null) {
			MaxWrongGuesses = max;
		} else {
			MaxWrongGuesses = 1;
		}
	}

	@SuppressWarnings("null")
	@Override
	public String[] readFromFile(String name) throws FileNotFoundException {
		// TODO Auto-generated method stub
		File file = new File(name);
		String[] in = null ;
	    try {

	        Scanner sc = new Scanner(file);

	        while (sc.hasNextLine()) {
	            int i = 0;
	            in[i]=sc.nextLine();
	            i++;
	        }
	        sc.close();
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
		return in;
	 }

}
