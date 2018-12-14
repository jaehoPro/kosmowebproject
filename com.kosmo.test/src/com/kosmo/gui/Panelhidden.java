package com.kosmo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class Panelhidden extends JFrame {

	private JPanel contentPane;
	JPanel panelA; 
	JPanel panelB; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panelhidden frame = new Panelhidden();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Panelhidden() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		panelB = new JPanel();
		panelB.setBackground(Color.YELLOW);
		panelB.setForeground(Color.ORANGE);
		contentPane.add(panelB, BorderLayout.EAST);
		
		panelA = new JPanel();
		panelA.setBackground(Color.RED);
		panelA.setForeground(Color.RED);
		contentPane.add(panelA, BorderLayout.WEST);
		
		panelA.setVisible(false);
		panelB.setVisible(false);
		
		JButton btnNewButton = new JButton("AAA button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelA.setVisible(true);
				panelB.setVisible(false);
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BBB button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelA.setVisible(false);
				panelB.setVisible(true);
			}
		});
		panel.add(btnNewButton_1);
		
	}

}
