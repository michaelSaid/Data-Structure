package eg.edu.alexu.csd.datastructure.hangman.cs38;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

/**
 * @author DELL
 *
 *
 */
public class Hangman implements IHangman {

	String[] Dictionary;
	String SecretWord;
	int MaxWrongGuesses;
	String GuessWord = "-";
	int numWords;

	@Override
	public void setDictionary(String[] words) {
		// TODO Auto-generated method stub

		Dictionary = words;
	}

	@Override
	public String selectRandomSecretWord() {
		// TODO Auto-generated method stub
		Random ran = new Random();
		if (numWords > 0) {
			SecretWord = Dictionary[ran.nextInt(numWords)];
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
		if (MaxWrongGuesses < 2) {
			return null;
		}
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
			boolean found = false;
			for (int i = 0; i < SecretWord.length() && c != null; i++) {
				if (SecretWord.substring(i, i + 1).equalsIgnoreCase(c.toString())) {
					GuessWord = GuessWord.substring(0, i) + SecretWord.charAt(i) + GuessWord.substring(i + 1);
					found = true;
				}
			}
			if (!found && c != null) {
				MaxWrongGuesses--;
			}
		}
		return GuessWord;
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		// TODO Auto-generated method stub
		if (max != null) {
			MaxWrongGuesses = max.intValue();
		} else {
			MaxWrongGuesses = 1;
		}
	}

	@SuppressWarnings("resource")
	public String[] readFromFile(String name) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String[] in = new String[1000];
		try {
			Scanner input = new Scanner(System.in);
			File file = new File(name);
			input = new Scanner(file);
			while (input.hasNextLine()) {
				in[numWords] = input.nextLine();
				numWords++;
			}
			input.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return in;
	}
}
