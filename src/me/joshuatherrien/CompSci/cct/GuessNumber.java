package me.joshuatherrien.CompSci.cct;

import javax.swing.*;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 1/12/2017
 * Description: The Guess number frame for the program. This frame handles all logic and input for the game.
 */
public class GuessNumber extends Frame {

	public JPanel getPanel() {
		Frame frame = new Frame();

		JPanel panel = new JPanel();

		JLabel textTitle = new JLabel("Guess Number");
		JLabel textInfo = new JLabel("<html>In this game, you'll set a range of numbers and the computer will randomly generate a number between<br><div>" +
				"these numbers. Then you'll try to guess the number.<html>");

		JButton btnReturn = new JButton("Return to Main Frame");

		panel.setLayout(null);

		textInfo.setBounds(30, 100, 1000, 30);
		btnReturn.setBounds(235, 410, 215, 30);


		btnReturn.addActionListener(e -> {
			removeAll();
			revalidate();
			repaint();
			setCurrentPanel(Frame.menu.getPanel());
		});

		panel.add(textInfo);
		panel.add(btnReturn);

		return panel;
	}
}
