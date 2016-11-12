package me.joshuatherrien.CompSci.unitThree.compoundInvesting;

import javax.swing.*;
import java.text.DecimalFormat;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 10/31/2016
 * Description: takes a number, calculates the interest and returns a table of the interest for 15 years
 */
public class CompoundInvesting {

	public static void main(String[] args) {
		double originalInvestment = Double.parseDouble(JOptionPane.showInputDialog("Enter an amount to calculate the interest and total for"));
		double interestRate = Double.parseDouble(JOptionPane.showInputDialog("Please enter an input rate in percent (%)"));
		int yearsForInvestment = Integer.parseInt(JOptionPane.showInputDialog("Please enter the total amount of years for this investment"));

		DecimalFormat format = new DecimalFormat("###00.00");
		double amountInAccount = 0;
		double interest;

		System.out.format("%37s", "Compound Interest Calculator");
		System.out.println();
		System.out.format("%-2s%20s%12s%9s", "Year:", "Amount in Account:", "Interest:", "Total:");
		System.out.println();

		for(int i = 1; i <= yearsForInvestment; i++) {
			amountInAccount = amountInAccount + originalInvestment;
			interest = amountInAccount * interestRate / 100;

			System.out.format("%-2s%11s%20s%13s", i, format.format(amountInAccount), format.format(interest), format.format(amountInAccount + interest));
			System.out.println();

			amountInAccount = amountInAccount + interest;

		}

		System.exit(0);
	}
}
