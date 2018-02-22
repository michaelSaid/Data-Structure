package eg.edu.alexu.csd.datastructure.hangman.cs38;

import java.util.Random;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

/**
 * @author DELL
 *
 *
 */
public class Hangman implements IHangman {

	/**
	 * dictionary is array of words.
	 */
	/**
	 * dictionary is array of words.
	 */
	/**
	 * dictionary is array of words.
	 */
	/**
	 * dictionary is array of words.
	 */
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
				String subs = secretWord.substring(i, i + 1);
				if (subs.equalsIgnoreCase(c.toString())) {
					String temp = guessWord;
					guessWord = temp.substring(0, i);
					guessWord += secretWord.charAt(i);
					guessWord += temp.substring(i + 1);
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
}
