package me.joshuatherrien.CompSci.unitFour.velocityCalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 11/9/2016
 * Description: takes input to calculate the velocity given its distance and time
 */
public class VelocityCalculator {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat format = new DecimalFormat("####.###");
		boolean wantsToTryAgain = true;

		System.out.println("Velocity Calculator");

		while(wantsToTryAgain) {
			double distance = Integer.parseInt(getInput(br, "Enter a distance in meters:"));
			double time = Integer.parseInt(getInput(br, "Enter a time in seconds:"));

			System.out.println();
			System.out.println("The velocity is " + format.format(velocityCalculator(distance, time)) + " m/s.");

			wantsToTryAgain = wantsToTryAgain(br, "Would you like to calculate another velocity? (yes/no)");
		}

		System.exit(0);

	}

	private static double velocityCalculator(double distance, double time) {
		return distance / time;
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
