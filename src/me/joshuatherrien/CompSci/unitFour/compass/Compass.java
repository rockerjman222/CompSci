package me.joshuatherrien.CompSci.unitFour.compass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 11/8/2016
 * Description: takes compass directions and will output them as a sentence of instructions.
 */
public class Compass {

	public static void main(String[] args) {
		boolean wantsToTryAgain = true;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Compass Directions");

		while(wantsToTryAgain) {
			String input = getInput(br);

			System.out.println();
			System.out.println("Start facing " + isNorth(input) + ". Turn " + getDegree(input) + " degrees towards " + isEast(input) + ".");

			wantsToTryAgain = wantsToTryAgain(br);
		}
	}

	private static String isNorth(String s) {
		boolean isNorth;
		char check = s.toLowerCase().charAt(0);

		if(check == 'n')
			isNorth = true;
		else
			isNorth = false;

		return isNorth ? "North" : "South";
	}

	private static String isEast(String s) {
		boolean isEast;
		char check = s.toLowerCase().charAt(s.length() - 1);

		if(check == 'e')
			isEast = true;
		else
			isEast = false;

		return isEast ? "East" : "West";
	}

	private static double getDegree(String s) {
		return Double.parseDouble(s.substring(1, s.length() - 1));
	}

	private static String getInput(BufferedReader br) {
		String input = "";

		System.out.println();
		System.out.println("Please enter a compass direction (S45E)");

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
		System.out.println("Would you like to enter another compass direction? (yes/no)");

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
