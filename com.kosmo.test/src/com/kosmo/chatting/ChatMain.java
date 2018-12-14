package com.kosmo.chatting;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatMain extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private CardLayout cardLayout;
	

	//private JPanel cardPanel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatMain frame = new ChatMain();
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
	public ChatMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		
		cardLayout = new CardLayout(0,0);
		contentPane.setLayout(cardLayout);
		
		JPanel Chat_main = new JPanel();
		contentPane.add(Chat_main, "name_A");
		
		JPanel Chat_room = new JPanel();
		contentPane.add(Chat_room, "name_B");
		
		
	
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton Enter = new JButton("Enter");
		Enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(contentPane, "name_B");
			}
		});
		GroupLayout gl_Chat_main = new GroupLayout(Chat_main);
		gl_Chat_main.setHorizontalGroup(
			gl_Chat_main.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Chat_main.createSequentialGroup()
					.addGap(114)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Enter, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(101))
		);
		gl_Chat_main.setVerticalGroup(
			gl_Chat_main.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Chat_main.createSequentialGroup()
					.addGap(172)
					.addGroup(gl_Chat_main.createParallelGroup(Alignment.BASELINE)
						.addComponent(Enter)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(188, Short.MAX_VALUE))
		);
		Chat_main.setLayout(gl_Chat_main);
		
	
		
		JPanel panel_2 = new JPanel();
		
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		panel_2.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		
		JPanel panel_3 = new JPanel();
		GroupLayout gl_Chat_room = new GroupLayout(Chat_room);
		gl_Chat_room.setHorizontalGroup(
			gl_Chat_room.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Chat_room.createSequentialGroup()
					.addGroup(gl_Chat_room.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Chat_room.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 399, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 524, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_Chat_room.setVerticalGroup(
			gl_Chat_room.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Chat_room.createSequentialGroup()
					.addGroup(gl_Chat_room.createParallelGroup(Alignment.LEADING)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		JTextArea textArea_1 = new JTextArea();
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 345, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		Chat_room.setLayout(gl_Chat_room);
		

	}
}
