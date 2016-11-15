package me.joshuatherrien.CompSci.unitFour.numberWords;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 11/10/2016
 * Description: A program that takes an integer and will change it to its word counterpart (10 - 99)
 */
public class NumberWords {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean wantsToTryAgain = true;

		System.out.println("Numbers to Words (10-99)");

		while(wantsToTryAgain) {
			double input = Double.parseDouble(getInput(br, "Input a number (10-99) to have it repeated back in word form:"));

			while(input < 10 || input > 99) {
				System.out.println("You've entered an invalid number!");
				input = Double.parseDouble(getInput(br, "Input a number (10-99) to have it repeated back in word form"));
			}

			System.out.println();
			System.out.println(getNumberInWords(input));

			wantsToTryAgain = wantsToTryAgain(br, "Do you want to try again?");

		}

		System.exit(0);

	}

	private static String getNumberInWords(double input) {
		String response = "";

		if (input >= 1 && input <= 9)
			response = getDigit(input, 0);

		if (input >= 10 && input <= 19)
			response = getDigit(input, 1);

		if (input >= 20 && input <= 99)
			response = getDigit(input, 2) + " " + getDigit(input, 0);

		return response;
	}

	private static String getDigit(double input, int state) {
		/* state:
		 * 	0 = ones
		 * 	1 = teens
		 * 	2 = tens
		 */

		int digit = 0;
		boolean isOnes = true;
		boolean isTeens = false;
		boolean isTens = false;

		switch (state) {
			case 0:
				digit = (int) input % 10;
				isOnes = true;
				isTeens = false;
				isTens = false;
				break;
			case 1:
				digit = (int) input % 10;
				isOnes = false;
				isTeens = true;
				isTens = false;
				break;
			case 2:
				digit = Math.floorDiv((int) input, 10);
				if (digit > 9)
					digit = digit % 10;
				isOnes = false;
				isTeens = false;
				isTens = true;
				break;
		}

		switch (digit) {
			case 0:
				return isTeens ? "Ten" : "";
			case 1:
				return isOnes ? "One" : isTeens ? "Eleven" : isTens ? "" : "";
			case 2:
				return isOnes ? "Two" : isTeens ? "Twelve" : isTens ? "Twenty" : "";
			case 3:
				return isOnes ? "Three" : isTeens ? "Thirteen" : isTens ? "Thirty" : "";
			case 4:
				return isOnes ? "Four" : isTeens ? "Fourteen" : isTens ? "Forty" : "";
			case 5:
				return isOnes ? "Five" : isTeens ? "Fifteen" : isTens ? "Fifty" : "";
			case 6:
				return isOnes ? "Six" : isTeens ? "Sixteen" : isTens ? "Sixty" : "";
			case 7:
				return isOnes ? "Seven" : isTeens ? "Seventeen" : isTens ? "Seventy" : "";
			case 8:
				return isOnes ? "Eight" : isTeens ? "Eighteen" : isTens ? "Eighty" : "";
			case 9:
				return isOnes ? "Nine" : isTeens ? "Nineteen" : isTens ? "Ninety" : "";
			default:
				return "";

		}

	}

	private static String getInput(BufferedReader br, String inputMessage) {
		String input = "";

		System.out.println();
		System.out.println(inputMessage);

		try {
			input = String.valueOf(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return input;
	}

	private static boolean wantsToTryAgain(BufferedReader br, String message) {
		String response = "";

		System.out.println();
		System.out.println(message);

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
