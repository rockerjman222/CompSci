package me.joshuatherrien.CompSci.unitThree.makeChange;

import javax.swing.*;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 10/20/2016
 * Description: a program that gives the change of a given number
 */

public class MakeChange {

	public static void main(String[] args) {
		String change = JOptionPane.showInputDialog("Please enter the change that you would like to find.");
		double input = Double.parseDouble(change);

		System.out.println("Calculating total change for: " + input);
		System.out.println();

		input = input * 100;

		int totalHundreds = Math.floorDiv((int)input, 10000);
		input = input - totalHundreds * 10000;

		int totalFifties = Math.floorDiv((int)input, 5000);
		input = input - totalFifties * 5000;

		int totalTwenties = Math.floorDiv((int)input, 2000);
		input = input - totalTwenties * 2000;

		int totalTens = Math.floorDiv((int)input, 1000);
		input = input - totalTens * 1000;

		int totalFives = Math.floorDiv((int)input, 500);
		input = input - totalFives * 500;

		int totalToonies = Math.floorDiv((int)input, 200);
		input = input - totalToonies * 200;

		int totalLoonies = Math.floorDiv((int)input, 100);
		input = input - totalLoonies * 100;

		int totalQuarters = Math.floorDiv((int)input, 25);
		input = input - totalQuarters * 25;

		int totalDimes = Math.floorDiv((int)input, 10);
		input = input - totalDimes * 10;

		int totalNickels = Math.floorDiv((int)input, 5);
		input = input - totalNickels * 5;

		int totalPennies = (int)input;

		System.out.println("Total Hundreds: " + totalHundreds);
		System.out.println("Total Fifties : " + totalFifties);
		System.out.println("Total Twenties: " + totalTwenties);
		System.out.println("Total Tens    : " + totalTens);
		System.out.println("Total Fives   : " + totalFives);
		System.out.println("Total Toonies : " + totalToonies);
		System.out.println("Total Loonies : " + totalLoonies);
		System.out.println("Total Quarters: " + totalQuarters);
		System.out.println("Total Dimes   : " + totalDimes);
		System.out.println("Total Nickels : " + totalNickels);
		System.out.println("Total Pennies : " + totalPennies);

		System.exit(0);

	}

}
