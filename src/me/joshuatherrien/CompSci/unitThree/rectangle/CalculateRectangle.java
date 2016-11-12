package me.joshuatherrien.CompSci.unitThree.rectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 10/19/2016
 * Description: a program that calculates the area and perimeter of a given rectangle
 */

public class CalculateRectangle {

	static BufferedReader br;

	static double width;
	static double height;
	static double perimeter;
	static double area;

	public static void main(String[] args) {
		br = new BufferedReader(new InputStreamReader(System.in));

		width = 0;
		height = 0;
		perimeter = 0;
		area = 0;

		boolean goAgain = true;

		System.out.println("Welcome to the rectangle calculator!");
		System.out.println("------------------------------------");

		while (goAgain) {

			try {
				getRectangleValues();

				System.out.println("Your rectangles perimeter is: " + perimeter);
				System.out.println("Your rectangles area is     : " + area);
				System.out.println();

				goAgain = wantsToContinue(br);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		System.out.println();
		System.out.println("Goodbye.");
		System.exit(0);

	}

	public static void getRectangleValues() throws IOException {
		System.out.println();
		System.out.println("Please enter your rectangles width:");
		width = Double.parseDouble(br.readLine());
		System.out.println();
		System.out.println("Please enter your rectangles height:");
		height = Double.parseDouble(br.readLine());

		perimeter = (width + height) * 2;
		area = width * height;
	}

	private static boolean wantsToContinue(BufferedReader in) {
		String input = "";

		System.out.println("Would you like to calculate for another rectangle? yes/no:");

		try {
			input = in.readLine().toLowerCase();
		} catch (IOException e) {
			e.printStackTrace();
		}

		switch(input) {
			case "yes":
				return true;
			case "y":
				return true;
			case "no":
				return false;
			case "n":
				return false;
			default:
				return false;

		}
	}
}

