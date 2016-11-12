package me.joshuatherrien.CompSci.unitThree.debt;

import java.text.DecimalFormat;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 10/19/2016
 * Description: a program that calculates the canadian debt burden over a period of a few years
 */

public class CanadianDebt {

	public static void main(String[] args) {
		double debt = 481.7;

		System.out.println("The Canadian debt burden was $" + debt + " billion in 2007");
		System.out.println("However the government promised to reduce this by 3% each year.");
		System.out.println();

		for(int yearsPassed = 0; yearsPassed < 4; yearsPassed++) {
			double newDebt = debt - (debt * (0.03 * yearsPassed));

			DecimalFormat df = new DecimalFormat("000.0");


			System.out.println("This means that in " + (2007 + yearsPassed) + " the debt burden would be $" + df.format(newDebt) + " billion.");
		}
	}
}
