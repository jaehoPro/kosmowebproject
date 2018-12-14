package com.kosmo.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyPanelClass extends JPanel {

	/**
	 * Create the panel.
	 */
	public MyPanelClass() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		
		JTextArea textArea = new JTextArea();
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(100,220));
		add(scrollPane, BorderLayout.CENTER);
		

	}

}
