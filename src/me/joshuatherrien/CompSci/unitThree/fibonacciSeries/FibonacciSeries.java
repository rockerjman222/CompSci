package me.joshuatherrien.CompSci.unitThree.fibonacciSeries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 11/4/2016
 * Description: a program that outputs the fibonacci series to a x number of times
 */
public class FibonacciSeries {

	public static void main(String[] args) {
		System.out.println("Fibonacci Series:");

		int recursions = getRecursions();
		System.out.println();

		if(recursions < 1) {
			System.out.println("Please enter a number that is greater than 0");
			System.out.println();
			recursions = getRecursions();
			System.out.println();
		}

		for(int i = 1; i <= recursions; i++) {
			System.out.println(getSeries(i) + ",");
		}

	}

	private static int getRecursions() {
		int recursions = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Please enter the number of recursions that you'd like in the series:");
		System.out.println();

		try {
			recursions = Integer.parseInt(br.readLine());
		} catch(IOException e) {
			e.printStackTrace();
		}

		return recursions;
	}

	private static int getSeries(int number) {
		if(number == 1 || number == 2)
			return 1;

		int f1 = 1;
		int f2 = 1;
		int fibonacci = 1;

		for(int i = 3; i <= number; i++) {
			fibonacci = f1 + f2;
			f1 = f2;
			f2 = fibonacci;
		}

		return fibonacci;
	}


}
