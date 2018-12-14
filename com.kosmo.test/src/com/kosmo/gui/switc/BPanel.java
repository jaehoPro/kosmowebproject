package com.kosmo.gui.switc;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;

public class BPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public BPanel() {
		setBackground(Color.RED);
		setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("BPanel");
		add(btnNewButton, BorderLayout.WEST);

	}

}
