package com.kosmo.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class Cardlayouttest extends JFrame {

	private JPanel contentPane;
	private CardLayout cardLayout;
	private JPanel cardPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cardlayouttest frame = new Cardlayouttest();
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
	public Cardlayouttest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		//큰프레임
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPane.add(buttonPanel, BorderLayout.NORTH);
		
		
		JButton buttonA = new JButton("buttonA");
		buttonA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardPanel.setVisible(true);
				cardLayout.show(cardPanel, "name_A");
			}
		});
		buttonPanel.add(buttonA);
		
		JButton buttonB = new JButton("buttonB");
		buttonB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardPanel.setVisible(true);
				cardLayout.show(cardPanel, "name_B");
			}
		});
		buttonPanel.add(buttonB);
		
		
		cardPanel = new JPanel();
		cardLayout = new CardLayout(0,0);
		cardPanel.setLayout(cardLayout);
		

		
				
		contentPane.add(cardPanel, BorderLayout.CENTER);
		
		cardPanel.setVisible(false);
		
		
		JPanel panelA = new JPanel();
		panelA.setBackground(Color.RED);
		cardPanel.add(panelA, "name_A");
		
		JPanel panelB = new JPanel();
		panelB.setBackground(Color.BLUE);
		cardPanel.add(panelB, "name_B");
		GroupLayout gl_panelB = new GroupLayout(panelB);
		gl_panelB.setHorizontalGroup(
			gl_panelB.createParallelGroup(Alignment.LEADING)
				.addGap(0, 424, Short.MAX_VALUE)
		);
		gl_panelB.setVerticalGroup(
			gl_panelB.createParallelGroup(Alignment.LEADING)
				.addGap(0, 218, Short.MAX_VALUE)
		);
		panelB.setLayout(gl_panelB);
		
//		JPanel panelB = new MyPanelClass();
//		panelB.setBackground(Color.BLUE);
//		cardPanel.add(panelB, "name_B");
	}

}
