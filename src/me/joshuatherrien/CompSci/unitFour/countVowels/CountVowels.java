package me.joshuatherrien.CompSci.unitFour.countVowels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 11/7/2016
 * Description:
 */
public class CountVowels {

	private static boolean wantsToTryAgain = true;

	public static void main(String[] args) {
		System.out.println("Vowel Counter");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(wantsToTryAgain) {
			int totalVowels = getVowels(getInput(br));

			System.out.println();
			System.out.println("There " + (totalVowels == 1 ? "is" : "are") + " " + totalVowels + " " + (totalVowels == 1 ? "vowel" : "vowels") + " in that phrase.");
			System.out.println();

			wantsToTryAgain = wantsToTryAgain(br);
		}

		System.exit(0);
	}

	private static String getInput(BufferedReader br) {
		String input = "";

		System.out.println();
		System.out.println("Please enter a phrase that you'd like to know the total amount of vowels in.");

		try {
			input = String.valueOf(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return input;
	}

	private static int getVowels(String input) {
		int totalVowels = 0;
		for(int i = 0; i < input.length(); i++) {
			switch (input.toLowerCase().charAt(i)) {
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					totalVowels++;
					break;
			}

		}

		return totalVowels;
	}

	private static boolean wantsToTryAgain(BufferedReader br) {
		String response = "";

		System.out.println("Would you like to count the vowels for another phrase? (yes/no)");

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
