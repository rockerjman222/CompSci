package me.joshuatherrien.CompSci.unitThree.bodyMass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 10/26/2016
 * Description: a program that takes the input for an individuals weight and calculates their BMI
 */
public class BodyMassIndex {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.println("Welcome to the Body Mass Index (BMI) calculator!");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println();
			System.out.println("Please select your preferred units:");
			System.out.println("1. Metric System (kg/m)");
			System.out.println("2. Imperial System (lbs/in)");

			boolean isMetric = br.readLine().startsWith("1");
			System.out.println();

			System.out.println("Input your weight " + (isMetric ? "(kg)" : "(lbs)"));

			double weight = Double.parseDouble(br.readLine());
			System.out.println();

			System.out.println("Input your height " + (isMetric ? "(m)" : "(in)"));

			double height = Double.parseDouble(br.readLine());
			System.out.println();

			double bmi = isMetric ? (weight / Math.pow(height, 2)) : ((weight * 703) / Math.pow(height, 2));
			DecimalFormat format = new DecimalFormat("##.##");
			System.out.println("Your BMI is " + format.format(bmi));

			if (bmi < 15)
				System.out.println("You are starving.");
			else if(bmi >= 15 && bmi < 18.5)
				System.out.println("You are underweight.");
			else if(bmi >= 18.5 && bmi <= 25)
				System.out.println("You are the ideal weight.");
			else if(bmi > 25 && bmi <= 30)
				System.out.println("You are overweight.");
			else if(bmi > 30 && bmi <= 40)
				System.out.println("You are obese.");
			else if(bmi > 40)
				System.out.println("You are morbidly obese");

		} catch(IOException e) {
			e.printStackTrace();
		}

	}


}
