package me.joshuatherrien.CompSci.unitFour.grossWage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 12/6/2016
 * Description:
 */
public class GrossWage {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		double hours;
		double pay;

		System.out.println("Gross Wage Calculator");

		hours = Double.parseDouble(getInput(br, "Enter the number of hours worked:"));
		pay = Double.parseDouble(getInput(br, "Enter the hourly rate of pay ($):"));

		System.out.println();
		System.out.println("Gross Wage: " + getGrossWage(hours, pay));

	}

	private static double getGrossWage(double hours, double pay) {
		double wage = 0;

		for (int i = 0; i < hours; i++) {
			wage += pay;
			if (i > 39)
				wage += (pay * 0.5);
		}

		return wage;
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
}
