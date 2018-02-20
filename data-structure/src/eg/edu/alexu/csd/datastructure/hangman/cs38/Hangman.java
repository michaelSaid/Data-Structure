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

	@Override
	public void setDictionary(String[] words) {
		// TODO Auto-generated method stub

		dictionary = words;
	}

	@Override
	public String selectRandomSecretWord() {
		// TODO Auto-generated method stub
		if (dictionary == null) {
			throw new RuntimeException();
		}
		Random ran = new Random();
			secretWord = dictionary[ran.nextInt(dictionary.length)];
			for (int i = 1; i < secretWord.length(); i++) {
				guessWord += "-";
			}
			return secretWord;
	}

	@Override
	public String guess(Character c) throws Exception {
		// TODO Auto-generated method stub
		if (maxWrongGuesses == 0 || (secretWord.trim().isEmpty() || secretWord.isEmpty())||secretWord.equals(guessWord)) {
			throw new RuntimeException();
		}
		if (c == null) {
			return guessWord;
		}
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
			boolean found = false;
			for (int i = 0; i < secretWord.length(); i++) {
				if (secretWord.substring(i, i + 1).equalsIgnoreCase(c.toString())) {
					guessWord = guessWord.substring(0, i) + secretWord.charAt(i) + guessWord.substring(i + 1);
					found = true;
				}
			}
			if (!found) {
				maxWrongGuesses--;
			}
			if (maxWrongGuesses == 0) {
				return null;
			}
		}
		return guessWord;
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		// TODO Auto-generated method stub
		if (max != null && max > 0) {
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
			int i = 0;
			while (input.hasNextLine()) {
				in[i] = input.nextLine();
				i++;
			}
			input.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return in;
	}
}
