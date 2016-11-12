package me.joshuatherrien.CompSci.unitFour.numberWords;

import java.awt.im.InputContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 11/10/2016
 * Description:
 */
public class NumberWords {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean wantsToTryAgain = true;

		System.out.println("Numbers to Words (10-99)");

		while(wantsToTryAgain) {
			double input = Double.parseDouble(getInput(br, "Input a number (10-99) to have it repeated back in word form:"));
			double ones;
			double tens;

			while(input < 10 || input > 99) {
				System.out.println("You've entered an invalid number!");
				input = Double.parseDouble(getInput(br, "Input a number (10-99) to have it repeated back in word form"));
			}

			ones = input % 10;
			tens = Math.floor((input % 10) / 10);

			System.out.println(getNumberInWords(input));


		}

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
		String response = "";

		switch ((int)input) {
			case 10:
				response = "Ten";
				break;
			case 11:
				response = "Eleven";
				break;
			case 12:
				response = "Twelve";
				break;
			case 13:
				response = "Thirteen";
				break;
			case 14:
				response = "Fourteen";
				break;
			case 15:
				response = "Fifteen";
				break;
			case 16:
				response = "Sixteen";
				break;
			case 17:
				response = "Seventeen";
				break;
			case 18:
				response = "Eighteen";
				break;
			case 19:
				response = "Nineteen";
				break;
			default:
				response = "";
		}

		return response;
	}

	private static String getOnes(double input) {
		String response = "";

		return response;
	}

	private static String getTens(double input) {
		String response = "";
		double digit = Math.floor((input % 10) / 10);

		switch ((int)digit) {
			case 20:
				response = String.valueOf(digit);
		}

		return response;
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
