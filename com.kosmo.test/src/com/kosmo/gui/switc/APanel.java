package com.kosmo.gui.switc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class APanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public APanel(FrameSwitchTest var) {
		setBackground(Color.BLUE);
		setLayout(new BorderLayout(0, 0));
			

		JButton btnNewButton = new JButton(var.textField.getText());
		add(btnNewButton, BorderLayout.WEST);

	}

	public APanel() {
		setBackground(Color.BLUE);
		setLayout(new BorderLayout(0, 0));
			
//		String aa = var.textField.getText();
		JButton btnNewButton = new JButton("APanel");
		add(btnNewButton, BorderLayout.WEST);

	}
}
