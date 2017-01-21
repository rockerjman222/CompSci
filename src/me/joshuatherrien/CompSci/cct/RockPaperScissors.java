package me.joshuatherrien.CompSci.cct;

import javax.swing.*;
import java.util.Random;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 1/12/2017
 * Description: The Rock, Paper, Scissors frame for the program. This frame handles all logic and input for the game.
 */
public class RockPaperScissors extends Frame {

	//Define the variables to keep track of progress in the game
	private int wins = 0;
	private int losses = 0;
	private int ties = 0;

	public JPanel getPanel() {
		Frame frame = new Frame();

		JPanel panel = new JPanel();

		//Define the choices that the play has for the drop-down menu
		final int[] choice = {0};
		String[] choices = {"Rock", "Paper", "Scissors"};

		//Define and initialize the labels for the program, these are all the text that the player will see
		JLabel textTitle = new JLabel("Rock, Paper, Scissors");
		JLabel textInfo = new JLabel("Please choose an option from the drop-down box, and then click complete.");
		JLabel textGameWinner = new JLabel();
		JLabel textWins = new JLabel("Wins: 0");
		JLabel textLosses = new JLabel("Losses: 0");
		JLabel textTies = new JLabel("Ties: 0");

		//Define and initialize all the components for the program, these are all the buttons the player will interact with
		JComboBox<String> boxChoice = new JComboBox<>(choices);
		JButton btnComplete = new JButton("Complete");
		JButton btnReturn = new JButton("Return to Main Frame");

		//Set the layout of the panel to null, this allows me to change the location of each component
		panel.setLayout(null);

		//Set the locations of each of the components
		textTitle.setBounds(287, 20, 130, 15);
		textInfo.setBounds(140, 50, 425, 15);
		textGameWinner.setBounds(190, 180, 330, 15);
		textWins.setBounds(25, 390, 90, 15);
		textLosses.setBounds(25, 410, 90, 15);
		textTies.setBounds(25, 430, 90, 15);

		boxChoice.setBounds(245, 90, 215, 30);
		btnComplete.setBounds(277, 130, 150, 30);
		btnReturn.setBounds(245, 410, 215, 30);

		//Add an action listener to the complete button. This waits for the button to be clicked then executes this code
		btnComplete.addActionListener(e -> {
			choice[0] = boxChoice.getSelectedIndex();
			boxChoice.setEnabled(false); //Disable changing the box for this instant to prevent a player changing their answer after clicked the button
			textGameWinner.setText(getWinner(choice[0], getOutcome(choice[0])));

			textWins.setText("Wins: " + this.wins);
			textLosses.setText("Losses: " + this.losses);
			textTies.setText("Ties: " + this.ties);

			revalidate();
			repaint();

			boxChoice.setEnabled(true); //Re-enable the use of the choice box to allow the player to try again
		});

		//Add an action listener to the return button. Once pressed the button will reset the frame and send the user to the main menu
		btnReturn.addActionListener(e -> {
			removeAll();
			revalidate();
			repaint();
			setCurrentPanel(Frame.menu.getPanel());
		});


		//Add all of the components to the panel to be drawn
		panel.add(textTitle);
		panel.add(textInfo);
		panel.add(textGameWinner);
		panel.add(textWins);
		panel.add(textLosses);
		panel.add(textTies);

		panel.add(boxChoice);
		panel.add(btnComplete);
		panel.add(btnReturn);

		//Return the panel
		return panel;
	}

	//Get the outcome of the choice
	private int getOutcome(int choice) {
		Random rand = new Random();
		int computerChoice = rand.nextInt(2); //Get the computers choice, clamped between 0 and 2

		/*
		 * Return outcomes:
		 * 0 = won
		 * 1 = lost
		 * 2 = tied
		 */

		if (choice == computerChoice)
			return 2;

		if (choice == 0 && computerChoice == 1)
			return 1;

		if (choice == 1 && computerChoice == 2)
			return 1;

		if (choice == 2 && computerChoice == 0)
			return 1;

		return 0;
	}

	//Get the string for the winner
	private String getWinner(int choice, int outcome) {
		switch (outcome) {
			case 0:
				this.wins++;
				return "You drew " + (choice == 0 ? "rock" : choice == 1 ? "paper" : "scissors") + ", the computer drew " + (choice == 0 ? "scissors" : choice == 1 ? "rock" : "paper") + ", you've won!";
			case 1:
				this.losses++;
				return "You drew " + (choice == 0 ? "rock" : choice == 1 ? "paper" : "scissors") + ", the computer drew " + (choice == 0 ? "paper" : choice == 1 ? "scissors" : "rock") + ", you've lost.";
			case 2:
				this.ties++;
				return "You drew " + (choice == 0 ? "rock" : choice == 1 ? "paper" : "scissors") + ", the computer drew " + (choice == 0 ? "rock" : choice == 1 ? "paper" : "scissors") + ", you've tied.";
			default:
				return "";
		}

	}
}
