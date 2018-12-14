package com.kosmo.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class MyApplicationTest {

	private JFrame frame;
	private JTextField msgField;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {		//자동 쓰레드
			public void run() {
				try {
					MyApplicationTest window = new MyApplicationTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MyApplicationTest() {
		initialize();		//초기화
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		msgField = new JTextField();
		panel.add(msgField);
		msgField.setColumns(10);
		
		
		
		JTextArea chatlogarea = new JTextArea();
		frame.getContentPane().add(chatlogarea, BorderLayout.NORTH);
		
		
		JScrollPane scrollPane = new JScrollPane(chatlogarea);
		scrollPane.setPreferredSize(new Dimension(100,220));
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("전송");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("대화"+msgField.getText());	
				//chatlog.setText(msgField.getText());
				chatlogarea.append(msgField.getText()+"\n");
				msgField.setText("");
				
			}
		});
		panel.add(btnNewButton);
		
		
		

		
	}

}
