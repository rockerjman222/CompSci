package me.joshuatherrien.CompSci.unitThree.triangle;

import javax.swing.*;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 10/25/2016
 * Description: a program to check 3 sides to see if those sides are able to make a triangle
 */
public class Triangle {

	public static void main(String[] args) {
		String in1 = JOptionPane.showInputDialog("A triangle has a property in which the added two sides will have to be larger than the remaining. \nPlease enter the first side of the triangle");
		String in2 = JOptionPane.showInputDialog("Please enter the second side of the triangle");
		String in3 = JOptionPane.showInputDialog("Please enter the third side of the triangle");

		double sideOne = Double.parseDouble(in1);
		double sideTwo = Double.parseDouble(in2);
		double sideThree = Double.parseDouble(in3);

		if((sideOne + sideTwo) > sideThree && (sideOne + sideThree) > sideTwo && (sideTwo + sideThree) > sideOne)
			System.out.println("The sides can make a triangle");
		else
			System.out.println("The sides cannot make a triangle");
	}
}
