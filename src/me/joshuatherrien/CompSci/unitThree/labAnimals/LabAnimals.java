package me.joshuatherrien.CompSci.unitThree.labAnimals;

import javax.swing.*;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 11/4/2016
 * Description: calculates the amount of time that a food supply will support a growing population
 */
public class LabAnimals {

	public static void main(String[] args) {
		int hour = 0;
		int animalsAtStart = Integer.parseInt(JOptionPane.showInputDialog("At a lab, there is y enough food for x animals.\n" +
				"At the end of every hour, the population doubles and enough food is added to\n" +
				"support z more animals. During the hour the animals will eat only enough food\n" +
				"only themselves.\n" +
				"This program will determine when the population will outgrow the food supply.\n" +
				"Enter the initial animal population"));
		int foodAtStart = Integer.parseInt(JOptionPane.showInputDialog("Enter the initial food supply"));
		int foodAdded = Integer.parseInt(JOptionPane.showInputDialog("Enter the food added each hour"));

		int currentAnimals = animalsAtStart;
		int currentFood = foodAtStart;

		System.out.format("%-2s%19s%16s%14s%17s", "Hour", "Animals at Start", "Food At Start", "Food at End", "Animals at End");
		System.out.println();

		while(currentFood >= currentAnimals && hour < 150) {
			int foodAtEnd = currentFood - currentAnimals + foodAdded;
			int animalsAtEnd = currentAnimals * 2;
			System.out.format("%4s%19s%16s%14s%17s", hour, currentAnimals, currentFood, foodAtEnd, animalsAtEnd);
			System.out.println();
			currentAnimals = animalsAtEnd;
			currentFood = foodAtEnd;
			hour++;
		}

		System.out.println();
		System.out.println("By hour " + hour + ", the population outgrows the food supply.");
		System.out.println("Therefore, it's survival of the fittest by hour " + hour);
	}
}
