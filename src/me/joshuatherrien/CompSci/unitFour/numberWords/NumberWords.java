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
		if(input >= 10 && input <= 19)
			response = getTeens(input);

		if(input >= 20 && input <= 99)
			response = getTens(input) + " " + getOnes(input);

		return response;
	}

	private static String getTeens(double input) {
		switch ((int)input) {
			case 10:
				return "Ten";
			case 11:
				return "Eleven";
			case 12:
				return "Twelve";
			case 13:
				return "Thirteen";
			case 14:
				return "Fourteen";
			case 15:
				return "Fifteen";
			case 16:
				return "Sixteen";
			case 17:
				return "Seventeen";
			case 18:
				return "Eighteen";
			case 19:
				return "Nineteen";
			default:
				return "";
		}

	}

	private static String getOnes(double input) {
		double digit = input % 10;

		switch ((int) digit) {
			case 1:
				return "One";
			case 2:
				return "Two";
			case 3:
				return "Three";
			case 4:
				return "Four";
			case 5:
				return "Five";
			case 6:
				return "Six";
			case 7:
				return "Seven";
			case 8:
				return "Eight";
			case 9:
				return "Nine";
			default:
				return "";
		}

	}

	private static String getTens(double input) {
		double digit = Math.floorDiv((int) input, 10);

		switch ((int)digit) {
			case 2:
				return "Twenty";
			case 3:
				return "Thirty";
			case 4:
				return "Forty";
			case 5:
				return "Fifty";
			case 6:
				return "Sixty";
			case 7:
				return "Seventy";
			case 8:
				return "Eighty";
			case 9:
				return "Ninety";
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
