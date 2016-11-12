package me.joshuatherrien.CompSci.unitThree.threeDigit;

import javax.swing.*;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 10/25/2016
 * Description: A program that calculates the cumulative digits of a given number
 */
public class ThreeDigit {

	public static void main(String[] args) {
		String in = JOptionPane.showInputDialog("Please enter a number for the sum of its digits.");
		char[] numbers = in.toCharArray();
		int result = 0;

		for(int i = 0; i < in.length(); i++) {
			result = result + Integer.parseInt(String.valueOf(numbers[i]));
		}

		System.out.println("Result: " + result);

	}
}
