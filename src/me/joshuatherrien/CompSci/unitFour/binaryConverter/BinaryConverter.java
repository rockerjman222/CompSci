package me.joshuatherrien.CompSci.unitFour.binaryConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 11/8/2016
 * Description: takes a binary number and converts it to decimal
 */
public class BinaryConverter {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Binary Converter");

		String input = getInput(br);
		int result = 0;

		boolean first = Integer.parseInt(input.substring(0, 1)) == 1;
		boolean second = Integer.parseInt(input.substring(1, 2)) == 1;
		boolean third = Integer.parseInt(input.substring(2, 3)) == 1;
		boolean fourth = Integer.parseInt(input.substring(3, 4)) == 1;
		boolean fifth = Integer.parseInt(input.substring(4, 5)) == 1;
		boolean sixth = Integer.parseInt(input.substring(5, 6)) == 1;
		boolean seventh = Integer.parseInt(input.substring(6, 7)) == 1;
		boolean eighth = Integer.parseInt(input.substring(7, 8)) == 1;

		if(first)
			result += 1;

		if(second)
			result += 2;

		if(third)
			result += 4;

		if(fourth)
			result += 8;

		if(fifth)
			result += 16;

		if(sixth)
			result += 32;

		if(seventh)
			result += 64;

		if(eighth)
			result += 128;

		System.out.println("The binary number " + input + " = " + result);

	}

	private static String getInput(BufferedReader br) {
		String input = "";

		System.out.println();
		System.out.println("Please enter a binary number (8 characters of 0 or 1)");

		try {
			input = String.valueOf(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return input;
	}

}