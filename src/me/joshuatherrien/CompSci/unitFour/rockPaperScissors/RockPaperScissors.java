package me.joshuatherrien.CompSci.unitFour.rockPaperScissors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 12/8/2016
 * Description:
 */
public class RockPaperScissors {

	private static int ROCK = 0;
	private static int PAPER = 1;
	private static int SCISSORS = 2;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean wantsToTryAgain = true;

		int choice = 3;
		int computerChoice;

		int tied = 0;
		int won = 0;
		int lost = 0;

		System.out.println("Rock, Paper, Scissors");

		while (wantsToTryAgain) {
			choice = getResponse(br, "Choose: (Rock, Paper, or Scissors");

			while (choice > 2) {
				System.out.println("Invalid entry!");
				choice = getResponse(br, "Choose: (Rock, Paper, or Scissors");
			}

			Random random = new Random();
			computerChoice = random.nextInt(2);

			int outcome = getOutcome(choice, computerChoice);

			//getOutcome(choice, computerChoice) == 0 ? tied++ : tied = tied;
		}


	}

	public static int getOutcome(int playerChoice, int computerChoice) {
		// 0 = tied
		// 1 = won
		// 2 = lost

		if (playerChoice == computerChoice)
			return 0;

		if ((playerChoice == ROCK && computerChoice == SCISSORS) || (playerChoice == 1 && computerChoice == ROCK) || (playerChoice == SCISSORS && computerChoice == PAPER))
			return 1;

		return 2;
	}

	private static String getInput(BufferedReader br, String inputMessage) {
		String input = "";

		System.out.println();
		System.out.println(inputMessage);

		try {
			input = String.valueOf(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return input;
	}

	private static int getResponse(BufferedReader br, String message) {
		String response = getInput(br, message);

		switch (response.toLowerCase()) {
			case "rock":
				return ROCK;
			case "paper":
				return PAPER;
			case "scissors":
				return SCISSORS;
			default:
				return 3;
		}
	}

	private static boolean wantsToTryAgain(BufferedReader br, String message) {
		String response = getInput(br, message);

		switch (response.toLowerCase()) {
			case "yes":
				return true;
			case "no":
				return false;
			default:
				return false;
		}

	}
}
