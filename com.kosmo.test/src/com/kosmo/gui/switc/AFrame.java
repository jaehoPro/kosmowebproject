package com.kosmo.gui.switc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class AFrame extends JFrame {
	private JPanel contentPane;
	JTextField applTextField;
	String applTextStr;
	AFrame aa;
	CFrame cc;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					AFrame frame = new AFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public AFrame() {
		aa = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		applTextField = new JTextField();
		applTextField.setText("applicationValue : 60");
		applTextField.setColumns(10);
		contentPane.add(applTextField, BorderLayout.SOUTH);
		
		JButton btnAframe = new JButton("AFrame");
		btnAframe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//setVisible(false);
				applTextStr = applTextField.getText();
			
				BFrame bframe = new BFrame(aa);  //AFrame 주소
				bframe.setVisible(true);
			}
		});
		contentPane.add(btnAframe, BorderLayout.WEST);
	}

}
