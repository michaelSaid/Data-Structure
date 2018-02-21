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
	Integer maxWrongGuesses;
	String guessWord;

	@Override
	public void setDictionary(final String[] words) {
		// TODO Auto-generated method stub
		dictionary = words;
	}

	@Override
	public String selectRandomSecretWord() {
		// TODO Auto-generated method stub
		if (dictionary != null) {
			Random ran = new Random();
			secretWord = dictionary[ran.nextInt(dictionary.length)];
			guessWord = "-";
			for (int i = 1; i < secretWord.length(); i++) {
				guessWord += "-";
			}
			return secretWord;
		}
		return null;
	}

	@Override
	public String guess(final Character c) throws Exception {
		// TODO Auto-generated method stub
		if (maxWrongGuesses == null) {
			throw new Exception();
		}
		if (secretWord.trim().isEmpty() || secretWord == null) {
			throw new Exception();
		}

		if (maxWrongGuesses == 0) {
			return null;
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
	public void setMaxWrongGuesses(final Integer max) {
		// TODO Auto-generated method stub
		if (max == null) {
			maxWrongGuesses = 1;
		} else {
			maxWrongGuesses = max;
		}
	}

	@SuppressWarnings("resource")
	public String[] readFromFile(final String name) throws FileNotFoundException {
		// TODO Auto-generated method stub
		try {
			Scanner input = new Scanner(System.in);
			File file = new File(name);
			input = new Scanner(file);
			int size = 0, i = 0;
			while (input.hasNextLine()) {
				input.nextLine();
				size++;
			}
			String[] in = new String[size];
			while (input.hasNextLine()) {
				in[i] = input.nextLine();
				i++;
			}
			input.close();
			return in;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
