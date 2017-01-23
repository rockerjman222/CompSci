package me.joshuatherrien.CompSci.cct;

import javax.swing.*;
import java.text.NumberFormat;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 1/12/2017
 * Description: Reduce Fraction frame for the program. This frame handles all logic and input for the program.
 */
public class ReduceFraction extends Frame {

	public JPanel getPanel() {
		Frame frame = new Frame();

		JPanel panel = new JPanel();

		//Define and initialize the labels for the program, these are all the text the user will see
		JLabel textTitle = new JLabel("Reduce Fractions");
		JLabel textInfo = new JLabel("This program will reduce a fraction to its lowest terms.");
		JLabel textNumerator = new JLabel("Numerator");
		JLabel textDenominator = new JLabel("Denominator");
		JLabel textFraction = new JLabel("");

		//Define and initialize the textfields for the program
		JFormattedTextField fieldNumerator = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JFormattedTextField fieldDenominator = new JFormattedTextField(NumberFormat.getIntegerInstance());

		//Define and initialize the buttons for the program
		JButton btnCalculate = new JButton("Calculate");
		JButton btnReturn = new JButton("Return to Main Frame");

		//Set the layout to null, this allows me to change the location of each component
		panel.setLayout(null);

		//Set the locations of each of the components
		textTitle.setBounds(302, 20, 100, 15);
		textInfo.setBounds(197, 50, 310, 15);
		textNumerator.setBounds(268, 74, 100, 15);
		textDenominator.setBounds(368, 74, 100, 15);
		textFraction.setBounds(215, 180, 275, 15);

		fieldNumerator.setBounds(250, 90, 100, 25);
		fieldDenominator.setBounds(355, 90, 100, 25);

		btnCalculate.setBounds(277, 130, 150, 30);
		btnReturn.setBounds(245, 410, 215, 30);

		//Add an action listner to the calculate button. This waits for the button to be clicked, then executes the code
		btnCalculate.addActionListener(e -> {
			//Define the variables for the fraction
			int numerator = 0;
			int denominator = 0;

			//Disable the text fields so the user can't change the values when parsing
			fieldNumerator.setEnabled(false);
			fieldDenominator.setEnabled(false);

			//Enter a try and catch when parsing for the values, without this the user could input text into the field and crash the program
			try {
				numerator = Integer.parseInt(fieldNumerator.getText());
				denominator = Integer.parseInt(fieldDenominator.getText());
			} catch (NumberFormatException | NullPointerException exception) {
				exception.printStackTrace();
			}

			//Set the text for the final result
			textFraction.setText(numerator + "/" + denominator + " in lowest terms is " + asLowestFraction(numerator, denominator) + ", with a GCM of " + gcm(numerator, denominator));

			revalidate();
			repaint();

			//Re-Enable the use of the text fields
			fieldNumerator.setEnabled(true);
			fieldDenominator.setEnabled(true);
		});

		//Add an action listner to the return button, this allows us to return to the main menu
		btnReturn.addActionListener(e -> {
			removeAll();
			revalidate();
			repaint();
			setCurrentPanel(Frame.menu.getPanel());
		});

		//Add all of the components to the panel to be drawn
		panel.add(textTitle);
		panel.add(textInfo);
		panel.add(textNumerator);
		panel.add(textDenominator);
		panel.add(textFraction);

		panel.add(fieldNumerator);
		panel.add(fieldDenominator);

		panel.add(btnCalculate);
		panel.add(btnReturn);

		//Return the panel
		return panel;
	}

	//Get the GCM for 2 given numbers, if num2 is 0, then return num1. If not, recurse back to the beginning and divide the denominator by the remainder of the numerator from the denominator
	private int gcm(int num1, int num2) {
		return num2 == 0 ? num1 : gcm(num2, num1 % num2);
	}

	//Calculate for lowest terms with the GCM and return it in a fraction form
	private String asLowestFraction(int num1, int num2) {
		int gcm = gcm(num1, num2);
		return (num1 / gcm) + "/" + (num2 / gcm);
	}
}
