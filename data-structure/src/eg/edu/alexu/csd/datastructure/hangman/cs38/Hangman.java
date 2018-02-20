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

	String[] dictionary;
	String secretWord;
	int maxWrongGuesses;
	String guessWord = "-";
	int numWords;

	@Override
	public void setDictionary(String[] words) {
		// TODO Auto-generated method stub

		dictionary = words;
	}

	@Override
	public String selectRandomSecretWord() {
		// TODO Auto-generated method stub
		Random ran = new Random();
		if (numWords > 0) {
			secretWord = dictionary[ran.nextInt(numWords)];
			for (int i = 1; i < secretWord.length(); i++) {
				guessWord += "-";
			}
			return secretWord;
		}
		return null;
	}

	@Override
	public String guess(Character c) throws Exception {
		// TODO Auto-generated method stub
		if (maxWrongGuesses < 2) {
			return null;
		}
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
			boolean found = false;
			for (int i = 0; i < secretWord.length() && c != null; i++) {
				if (secretWord.substring(i, i + 1).equalsIgnoreCase(c.toString())) {
					guessWord = guessWord.substring(0, i) + secretWord.charAt(i) + guessWord.substring(i + 1);
					found = true;
				}
			}
			if (!found && c != null) {
				maxWrongGuesses--;
			}
		}
		return guessWord;
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		// TODO Auto-generated method stub
		if (max != null) {
			maxWrongGuesses = max.intValue();
		} else {
			maxWrongGuesses = 1;
		}
	}

	@SuppressWarnings("resource")
	public String[] readFromFile(String name) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String[] in = new String[100];
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
