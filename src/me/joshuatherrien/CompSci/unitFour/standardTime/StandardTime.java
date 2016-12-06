package me.joshuatherrien.CompSci.unitFour.standardTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 11/22/2016
 * Description: Converts traditional time to standard time
 */
public class StandardTime {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean wantsToTryAgain = true;

		System.out.println("Traditional Time to Standard Time Converter");

		while (wantsToTryAgain) {
			int counter = 0;
			int sum = 0;
			while (counter < 10) {
				counter += 3;
				sum += counter;
			}
			System.out.println(sum);
			String input = getInput(br, "Please input a time in traditional form to be converted to standard form: (HH:MM:SS)");

			while (input.length() < 8 || input.length() > 8) {
				System.out.println();
				System.out.println("You've entered an invalid time!");
				input = getInput(br, "Please input a time in traditional form to be converted to standard form: (HH:MM:SS)");
			}

			try {
				System.out.println(input + " is equivalent to " + getStandardForm(input));
			} catch (ParseException e) {
				e.printStackTrace();
			}

			wantsToTryAgain = wantsToTryAgain(br, "Would you like to convert another time?");
		}
	}

	private static String getStandardForm(String input) throws ParseException {
		SimpleDateFormat traditionalForm = new SimpleDateFormat("HH:mm:ss");
		SimpleDateFormat standardForm = new SimpleDateFormat("hh:mm a");
		return standardForm.format(traditionalForm.parse(input));
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
