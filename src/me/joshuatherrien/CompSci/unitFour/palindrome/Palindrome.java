package me.joshuatherrien.CompSci.unitFour.palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 11/8/2016
 * Description: takes input and reverses it to see if it is a palindrome
 */
public class Palindrome {

	public static void main(String[] args) {
		boolean wantsToTryAgain = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		System.out.println("Palindrome Checker");

		while(wantsToTryAgain) {
			String input = getInput(br);
			sb.append(input);
			sb.reverse();

			System.out.println();
			System.out.println(input + " backwards is " + sb.toString());
			System.out.println((input.equals(sb.toString()) ? "Therefore, " + input + " is a palindrome!" : "Therefore, " + input + " isn't a palindrome!"));

			sb.delete(0, sb.length());

			wantsToTryAgain = wantsToTryAgain(br);
		}

		System.exit(0);
	}

	private static String getInput(BufferedReader br) {
		String input = "";

		System.out.println();
		System.out.println("Please enter a word to see if it's a palindrome");

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
		System.out.println("Would you like to enter another word? (yes/no)");

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
