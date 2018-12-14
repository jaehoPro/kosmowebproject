package com.kosmo.gui.switc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplicationSwitchTest {

	//private JFrame frame;		//윈도우만들면 기본으로 주는것 jframe
	AFrame aframe;
	BFrame bframe;		//extends Jframe

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationSwitchTest window = new ApplicationSwitchTest();
					//window.frame.setVisible(true);
						//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationSwitchTest() {
//		frame = new JFrame();
//		frame.setBounds(100, 100, 450, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		aframe = new AFrame();
		
//		JButton btnNewButton = new JButton("BFrame실행");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//frame.setVisible(false);
//				aframe.setVisible(false);
//				
//				bframe = new BFrame();
//				bframe.setVisible(true);
//			}
//		});
		//frame.getContentPane().add(btnNewButton, BorderLayout.WEST);
		aframe.setVisible(true);
	}


}
