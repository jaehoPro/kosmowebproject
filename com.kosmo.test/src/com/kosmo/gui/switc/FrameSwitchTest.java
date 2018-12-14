package com.kosmo.gui.switc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class FrameSwitchTest extends JFrame {

	private JPanel basicPanel;
	JTextField textField;
	
	JPanel apanel;
	JPanel bpanel;
	boolean toggle = false;	
	private JButton btnOpenbutton;
	private JButton btnSendbutton;
	
	FrameSwitchTest add;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameSwitchTest frame = new FrameSwitchTest();
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
	public FrameSwitchTest() {
		add=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		
		basicPanel = new JPanel();
		basicPanel.setBackground(Color.YELLOW);
		basicPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		basicPanel.setLayout(new BorderLayout(0, 0));
		setContentPane(basicPanel);
		
		
		apanel = new APanel();
		apanel.setPreferredSize(new Dimension(450,100));
		basicPanel.add(apanel, BorderLayout.CENTER);
		
		
		bpanel = new BPanel();
		bpanel.setPreferredSize(new Dimension(450,100));
		basicPanel.add(bpanel, BorderLayout.SOUTH);
		
		JPanel northpanel = new JPanel();
		basicPanel.add(northpanel, BorderLayout.NORTH);
		northpanel.setLayout(new BorderLayout(0, 0));
		
		textField = new JTextField();
		
		northpanel.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("basic>north>button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				apanel.setVisible(toggle);
				if(toggle == false)
				{
					toggle = true;
				}
				else
				{
					toggle = false;
				}
			}
		});
		northpanel.add(btnNewButton, BorderLayout.EAST);
		
		btnOpenbutton = new JButton("openButton");
		btnOpenbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				AFrame aframe = new AFrame();
//				apanel.setVisible(true);
				
				ApplicationSwitchTest appl = new ApplicationSwitchTest();
				appl.aframe.setVisible(true);
			}
		});
		northpanel.add(btnOpenbutton, BorderLayout.WEST);
		
		btnSendbutton = new JButton("sendButton");
		btnSendbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//APanel apanel= new APanel(add);
				apanel.setVisible(false);
				apanel = new APanel(add);
				apanel.setPreferredSize(new Dimension(450,100));
				basicPanel.add(apanel, BorderLayout.CENTER);
			}
		});
		northpanel.add(btnSendbutton, BorderLayout.SOUTH);
	}

}
