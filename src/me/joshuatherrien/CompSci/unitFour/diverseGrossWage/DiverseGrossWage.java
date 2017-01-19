package me.joshuatherrien.CompSci.unitFour.diverseGrossWage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 12/6/2016
 * Description: calculates the gross wage given the hours and rate of pay, also compares the wage to other countries
 */
public class DiverseGrossWage {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat format = new DecimalFormat("#######.00");

		double hours;
		double pay;

		System.out.println("Diverse Gross Wage Calculator");

		hours = Double.parseDouble(getInput(br, "Enter the number of hours worked:"));
		pay = Double.parseDouble(getInput(br, "Enter the hourly rate of pay ($):"));

		System.out.println();
		System.out.println("Gross Wage:");
		System.out.println("Canada     (1.00CAD): " + format.format(getGrossWage(hours, pay, true)));
		System.out.println("Bangladesh (0.15CAD): " + format.format(getGrossWage(hours, pay, false) * .15));
		System.out.println("China      (0.48CAD): " + format.format(getGrossWage(hours, pay, false) * .48));
		System.out.println("Dominican  (1.60CAD): " + format.format(getGrossWage(hours, pay, false) * 1.6));
		System.out.println("Haiti      (0.55CAD): " + format.format(getGrossWage(hours, pay, false) * .55));

	}

	private static double getGrossWage(double hours, double pay, boolean earnsOvertime) {
		double wage = 0;

		for (int i = 0; i < hours; i++) {
			wage += pay;
			if (earnsOvertime && i > 39)
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
