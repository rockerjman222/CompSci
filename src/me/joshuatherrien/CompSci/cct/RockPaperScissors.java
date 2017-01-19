package me.joshuatherrien.CompSci.cct;

import javax.swing.*;

/**
 * Name: Joshua
 * Course Code: ICS3U
 * Teacher: Mr. Janveau
 * Date: 1/12/2017
 * Description:
 */
public class RockPaperScissors extends Frame {

	public JPanel getPanel() {
		Frame frame = new Frame();

		JPanel panel = new JPanel();

		JLabel label = new JLabel("This is a test");
		JButton btnReturn = new JButton("Return to Main Frame");

		panel.setLayout(null);

		btnReturn.setBounds(235, 410, 215, 30);


		btnReturn.addActionListener(e -> {
			removeAll();
			revalidate();
			repaint();
			setCurrentPanel(Frame.menu.getPanel());
		});

		panel.add(btnReturn);

		return panel;
	}
}
