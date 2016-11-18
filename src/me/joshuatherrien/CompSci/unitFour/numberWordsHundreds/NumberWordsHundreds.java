package me.joshuatherrien.CompSci.unitFour.numberWordsHundreds;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 11/14/2016
 * Description: A program that takes an integer and will change it to its word counterpart (0 - 999)
 */
public class NumberWordsHundreds {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean wantsToTryAgain = true;

		System.out.println("Numbers to Words (0 - 999)");

		while (wantsToTryAgain) {
			double input = Double.parseDouble(getInput(br, "Input a number (0 - 999) to have it repeated back in word form:"));

			while (input < 0 || input > 999) {
				System.out.println("You've entered an invalid number!");
				input = Double.parseDouble(getInput(br, "Input a number (0 - 999) to have it repeated back in word form"));
			}

			System.out.println();
			System.out.println(getNumberInWords(input));

			wantsToTryAgain = wantsToTryAgain(br, "Do you want to try again?");

		}

		System.exit(0);

	}

	private static String getNumberInWords(double input) {
		String response = "";

		if (input == 0)
			response = "Zero";

		if (input >= 1 && input <= 9)
			response = getDigit(input, 0);

		if (input >= 10 && input <= 19)
			response = getDigit(input, 1);

		if (input >= 20 && input <= 99)
			response = getDigit(input, 2) + " " + getDigit(input, 0);

		if (input >= 100 && input <= 999)
			response = getDigit(input, 3) + " Hundred " + (Math.floorDiv((int) input, 10) % 10 == 1 ? " " + getDigit(input, 1) : (getDigit(input, 2)) + " " + getDigit(input, 0));

		return response;
	}

	private static String getDigit(double input, int state) {
		/* state:
		 * 	0 = ones
		 * 	1 = teens
		 * 	2 = tens
		 * 	3 = hundreds
		 */

		int digit = 0;
		boolean isOnes = true;
		boolean isTeens = false;
		boolean isTens = false;
		boolean isHundreds = false;

		switch (state) {
			case 0:
				digit = (int) input % 10;
				isOnes = true;
				isTeens = false;
				isTens = false;
				isHundreds = false;
				break;
			case 1:
				digit = (int) input % 10;
				isOnes = false;
				isTeens = true;
				isTens = false;
				isHundreds = false;
				break;
			case 2:
				digit = Math.floorDiv((int) input, 10);
				if (digit > 9)
					digit = digit % 10;
				isOnes = false;
				isTeens = false;
				isTens = true;
				isHundreds = false;
				break;
			case 3:
				digit = Math.floorDiv((int) input, 100);
				isOnes = false;
				isTeens = false;
				isTens = false;
				isHundreds = true;
				break;
		}

		switch (digit) {
			case 0:
				return isTeens ? "Ten" : "";
			case 1:
				return isOnes ? "One" : isTeens ? "Eleven" : isTens ? "" : isHundreds ? "One" : "";
			case 2:
				return isOnes ? "Two" : isTeens ? "Twelve" : isTens ? "Twenty" : isHundreds ? "Two" : "";
			case 3:
				return isOnes ? "Three" : isTeens ? "Thirteen" : isTens ? "Thirty" : isHundreds ? "Three" : "";
			case 4:
				return isOnes ? "Four" : isTeens ? "Fourteen" : isTens ? "Forty" : isHundreds ? "Four" : "";
			case 5:
				return isOnes ? "Five" : isTeens ? "Fifteen" : isTens ? "Fifty" : isHundreds ? "Five" : "";
			case 6:
				return isOnes ? "Six" : isTeens ? "Sixteen" : isTens ? "Sixty" : isHundreds ? "Six" : "";
			case 7:
				return isOnes ? "Seven" : isTeens ? "Seventeen" : isTens ? "Seventy" : isHundreds ? "Seven" : "";
			case 8:
				return isOnes ? "Eight" : isTeens ? "Eighteen" : isTens ? "Eighty" : isHundreds ? "Eight" : "";
			case 9:
				return isOnes ? "Nine" : isTeens ? "Nineteen" : isTens ? "Ninety" : isHundreds ? "Nine" : "";
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
