package me.joshuatherrien.CompSci.unitFour.sinChecker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 11/8/2016
 * Description: takes a sin number and calculates its validity
 */
public class SinChecker {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Social Insurance Number Validity Checker");
		System.out.println();

		String input = getInput(br);
		String eightDigits = input.substring(0, 8);
		String checkDigit = input.substring(8);

		int total;
		int finalDigit;
		int counter = 0;

		int first = Integer.parseInt(eightDigits.substring(0, 1));
		int second = Integer.parseInt(eightDigits.substring(1, 2)) * 2;
		int third = Integer.parseInt(eightDigits.substring(2, 3));
		int fourth = Integer.parseInt(eightDigits.substring(3, 4)) * 2;
		int fifth = Integer.parseInt(eightDigits.substring(4, 5));
		int sixth = Integer.parseInt(eightDigits.substring(5, 6)) * 2;
		int seventh = Integer.parseInt(eightDigits.substring(6, 7));
		int eighth = Integer.parseInt(eightDigits.substring(7, 8)) * 2;

		if(second > 9)
			second = (second / 10) + (second % 10);

		if(fourth > 9)
			fourth = (fourth / 10) + (fourth % 10);

		if(sixth > 9)
			sixth = (sixth / 10) + (sixth % 10);

		if(eighth > 9)
			eighth = (eighth / 10) + (eighth % 10);

		total = first + second + third + fourth + fifth + sixth + seventh + eighth;
		finalDigit = total;

		while(total > 0) {
			counter++;
			total = total - 10;
		}

		int result = counter * 10;

		if(result - finalDigit == Integer.parseInt(checkDigit))
			System.out.println("You've entered a valid SIN Number.");
		else
			System.out.println("That is an invalid SIN Number.");

	}

	private static String getInput(BufferedReader br) {
		String input = "";

		System.out.println();
		System.out.println("Please enter a SIN number to check its validity");

		try {
			input = String.valueOf(br.readLine());
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return input;
	}

}
