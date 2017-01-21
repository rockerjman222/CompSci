package me.joshuatherrien.CompSci.cct;

import javax.swing.*;
import java.awt.*;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 1/12/2017
 * Description: The main program, this runs the main window that dispatches the information to the other games
 */
public class Frame extends JPanel {

	public static JFrame frame;
	public static JPanel currentPanel;

	public static Frame menu;
	public static RockPaperScissors rockPaperScissors;
	public static GuessNumber guessNumber;

	public static void main(String[] args) {
		//Define all frames of the window
		menu = new Frame();
		rockPaperScissors = new RockPaperScissors();
		guessNumber = new GuessNumber();

		//Initialize the main window
		frame = new JFrame("Computer Science Final CCT");

		//Give the window some information for its appearence
		frame.setSize(new Dimension(705, 500));
		frame.setBackground(Color.black);
		frame.setTitle("Computer Science Final CCT");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setContentPane(menu.getPanel());

		frame.setVisible(true);

	}

	public JPanel getPanel() {
		JPanel panel = new JPanel();

		//Push all the information for handling the frames to a separate thread from the main, this prevents the program from getting completely locked up with a bad frame
		SwingUtilities.invokeLater(() -> {

			//Define the buttons to go to the different frames
			JButton btnRockPaperScissors = new JButton("Rock Paper Scissors");
			JButton btnGuessNumber = new JButton("Guess Number");
			JButton btnExit = new JButton("Exit Program");

			//Set the layout to null so the components can be placed to my choosing
			panel.setLayout(null);

			//Set the location for all components

			btnRockPaperScissors.setBounds(10, 410, 215, 30);
			btnGuessNumber.setBounds(235, 410, 215, 30);
			btnExit.setBounds(460, 410, 215, 30);

			//Recieve the click of the buttons and dispatch them each to their respective actions
			btnRockPaperScissors.addActionListener(e -> {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				setCurrentPanel(rockPaperScissors.getPanel());
			});

			btnGuessNumber.addActionListener(e -> {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				setCurrentPanel(guessNumber.getPanel());
			});

			//Exit the program with a button because it's fun.
			btnExit.addActionListener(e -> {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				System.exit(0);
			});

			//Add all components to the panel
			panel.add(btnRockPaperScissors);
			panel.add(btnGuessNumber);
			panel.add(btnExit);

			//Refresh the panel, this is more for the returning to the panel from other frames, without this the panel will be blank upon returning.
			revalidate();
			repaint();


		});

		return panel;
	}

	//Set the current viewing panel for the program
	public void setCurrentPanel(JPanel panel) {
		if (currentPanel == panel)
			return;

		currentPanel = panel;
		frame.setContentPane(panel);
		frame.revalidate();
		frame.repaint();

	}
}
