package me.joshuatherrien.CompSci.unitThree.acidRain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 10/25/2016
 * Description: a program that will take an input of ph to see the survivability of the wildlife in the water
 */
public class AcidRain {

	static double pHValue = 0;

	public static void main(String[] args) {
		System.out.println("Acid rain is becoming a much more important issue, with the");
		System.out.println("increase in green house gases that are being pumped into the ecosystem,");
		System.out.println("rain is becoming more acidic and is damaging aquamarine life. The higher the");
		System.out.println("acidity, the more dangerous is becomes.");
		System.out.println();
		System.out.println("Please enter the pH value of the water to determine the safety of the water.");
		System.out.println();

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			pHValue = Double.parseDouble(in.readLine());
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if(pHValue >= 6.5 && pHValue <= 7.5)
			System.out.println("Neutral: The fish in streams, rivers, and lakes will survive");
		else if(pHValue < 6.5)
			System.out.println("Too Acidic: The fish in streams, rivers, and lakes will not survive");
		else if(pHValue > 7.5)
			System.out.println("Too Alkaline: The fish in streams, rivers, and lakes will not survive");
	}
}
