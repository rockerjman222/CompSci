package me.joshuatherrien.CompSci.unitFour.wordRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 11/7/2016
 * Description: takes input and creates a word rectangle with given input
 */
public class WordRectangle {

	private static boolean wantsToTryAgain = true;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Word Rectangle");

		while(wantsToTryAgain) {
			String word = getInput(br);
			System.out.println();

			for(int i = 0; i < word.length(); i++) {
				word = shift(word);
				System.out.println(word);
			}

			wantsToTryAgain = wantsToTryAgain(br);
		}

		System.exit(0);
	}

	private static String shift(String s) {
		return s.substring(1, s.length()) + s.charAt(0);
	}

	private static String getInput(BufferedReader br) {
		String input = "";

		System.out.println();
		System.out.println("Please enter a word to create a word rectangle for");

		try {
			input = String.valueOf(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return input;
	}

	private static boolean wantsToTryAgain(BufferedReader br) {
		String response = "";

		System.out.println();
		System.out.println("Would you like to create another word rectangle (yes/no)");

		try {
			response = String.valueOf(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

		switch (response.toLowerCase()) {
			case "yes":
				return true;
			case "no":
				return false;
			default:
				return false;
		}

	}


}
