package me.joshuatherrien.CompSci.unitThree.ouncesGrams;

import java.text.DecimalFormat;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 10/31/2016
 * Description: a program that demonstrates the looping structure to convert 1 - 15 ounces to grams
 */
public class OuncesGrams {

	public static void main(String[] args) {
		System.out.format("%-2s%10s", "Ounces", "Grams");
		System.out.println();

		for(int i = 0; i <= 15; i++) {
			double gram = i * 28.35;
			DecimalFormat format = new DecimalFormat("#00.00");
			System.out.format("%-2s%14s", i, format.format(gram));
			System.out.println();
		}
	}
}
