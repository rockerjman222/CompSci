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
		menu = new Frame();
		rockPaperScissors = new RockPaperScissors();
		guessNumber = new GuessNumber();

		frame = new JFrame("Computer Science Final CCT");

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

		SwingUtilities.invokeLater(() -> {
			JButton btnRockPaperScissors = new JButton("Rock Paper Scissors");
			JButton btnGuessNumber = new JButton("Guess Number");
			JButton btnExit = new JButton("Exit Program");

			JLabel intro = new JLabel("This is a test paragraph, this is a test paragraph, this is a test paragraph, this is a test paragraph, this is a test paragraph, this is a test paragraph, this is a test paragraph, this is a test paragraph, this is a test paragraph,", SwingConstants.CENTER);

			panel.setLayout(null);

			btnRockPaperScissors.setBounds(10, 410, 215, 30);
			btnGuessNumber.setBounds(235, 410, 215, 30);
			btnExit.setBounds(460, 410, 215, 30);


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

			btnExit.addActionListener(e -> {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				System.exit(0);
			});

			panel.add(btnRockPaperScissors);
			panel.add(btnGuessNumber);
			panel.add(btnExit);

			panel.add(intro);

			revalidate();
			repaint();


		});

		return panel;
	}

	public void setCurrentPanel(JPanel panel) {
		if (currentPanel == panel)
			return;

		currentPanel = panel;
		frame.setContentPane(panel);
		frame.revalidate();
		frame.repaint();

	}
}
