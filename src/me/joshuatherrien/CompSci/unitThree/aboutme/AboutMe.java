package me.joshuatherrien.CompSci.unitThree.aboutme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 10/18/2016
 * Description:
 */

public class AboutMe {
	public static void main(String[] args) {
		System.out.println("Name             : Joshua T. Therrien");
		System.out.println("Favourite Colour : Red");
		System.out.println("Favourite Hobby  : Surprising Teachers.");
		System.out.println();
		System.out.println("Would you like to continue? yes/no:");

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		if(wantsToContinue(in)) {
			System.out.println();
			System.out.println("Favourite Game   : Portal 2");
			System.out.println("Favourite IDE    : IntelliJ");
			System.out.println();
			System.out.println("Well, hope you enjoyed.");
			System.exit(0);
		} else {
			System.out.println("Alright then.");
			System.exit(0);
		}
	}

	private static boolean wantsToContinue(BufferedReader in) {
		String input = "";

		try {
			input = in.readLine().toLowerCase();
		} catch (IOException e) {
			e.printStackTrace();
		}

		switch(input) {
			case "yes":
				return true;
			case "y":
				return true;
			case "no":
				return false;
			case "n":
				return false;
			default:
				return false;

		}
	}
}

