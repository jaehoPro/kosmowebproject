package com.kosmo.gui.demo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import com.kosmo.gui.switc.BFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GoogleMapFrame extends JFrame {

	private JPanel contentPane;
	private JTextField searchTextField;
	
	JPanel centerPane;
	JLabel mapLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GoogleMapFrame frame = new GoogleMapFrame();
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
	public GoogleMapFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		GoogleMapIOTest mapTest = new GoogleMapIOTest();
		String jpgpath = mapTest.createMapJpg("가산동");
		
		ImageIcon icon =new ImageIcon(jpgpath);
//		ImageIcon icon = new ImageIcon(getClass().getResource("c:\\down\\map.jpg"));
		ImageIcon resizeicon = new ImageIcon(icon.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH));
		
		
		centerPane = new JPanel();
		contentPane.add(centerPane, BorderLayout.CENTER);
		mapLabel = new JLabel(resizeicon);
		centerPane.add(mapLabel);
		
		JPanel northpanel = new JPanel();
		contentPane.add(northpanel, BorderLayout.NORTH);
		
		searchTextField = new JTextField();
		northpanel.add(searchTextField);
		searchTextField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GoogleMapIOTest mapTest = new GoogleMapIOTest();
				
				if(searchTextField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "검색어 입력 필수");
					return ;
				}
				
				mapTest.createMapJpg("독산동");
				
				centerPane = new JPanel();
				mapLabel = new JLabel(resizeicon);
			

				
				
				
//				
				
				
				
				
			}
		});
		northpanel.add(btnNewButton);
		

	}

}
