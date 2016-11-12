package me.joshuatherrien.CompSci.unitThree.rightTriangle;

import javax.swing.*;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 10/25/2016
 * Description: a program to check 3 sides to see if you can make a right triangle with them
 */

public class RightTriangle {

	public static void main(String[] args) {
		String in1 = JOptionPane.showInputDialog("A right triangle has a property in which the square of the 2 sides will equal the hypotenuse. \nPlease enter the first side of the triangle");
		String in2 = JOptionPane.showInputDialog("Please enter the second side of the triangle");
		String in3 = JOptionPane.showInputDialog("Please enter the third side of the triangle");

		double sideOne = Double.parseDouble(in1);
		double sideTwo = Double.parseDouble(in2);
		double sideThree = Double.parseDouble(in3);

		String isRightTriangle = isRight(sideOne, sideTwo, sideThree) ? "can" : "cannot";
		System.out.println("This set of lines " + isRightTriangle + " make a right triangle.");
	}

	private static boolean isRight(double sideOne, double sideTwo, double sideThree) {
		double a;
		double b;
		double c;

		if (sideOne > sideTwo && sideOne > sideThree) {
			a = Math.pow(sideTwo, 2);
			b = Math.pow(sideThree, 2);
			c = Math.pow(sideOne, 2);
		} else if(sideTwo > sideOne && sideTwo > sideThree) {
			a = Math.pow(sideOne, 2);
			b = Math.pow(sideThree, 2);
			c = Math.pow(sideTwo, 2);
		} else if(sideThree > sideOne && sideThree > sideTwo) {
			a = Math.pow(sideOne, 2);
			b = Math.pow(sideTwo, 2);
			c = Math.pow(sideThree, 2);
		} else
			return false;

		return a + b == c || c - a == b || c - b == a;
	}


}
