package com.kosmo.gui.demo;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import com.kosmo.gui.switc.BFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class IconTest {

	private JFrame frame;
	JLabel imgLabel;
	private JPanel panel;
	private JButton saveButton;
	BufferedImage buffer;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IconTest window = new IconTest();
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
	public IconTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		//C:/jp/workspace_java/java_prj/bin/com/kosmo/gui/demo/aaa.jpg
		//getClass()  === IconTest.class
		System.out.println(getClass().getResource("/com/kosmo/gui/demo/img/aaa.png").toString());
				
		ImageIcon defaultIcon = new ImageIcon(IconTest.class.getResource("/com/kosmo/gui/demo/img/aaa.png"));
		imgLabel = new JLabel(defaultIcon);
		frame.getContentPane().add(imgLabel, BorderLayout.CENTER);
		
		panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton uploadButton = new JButton("이미지업로드");
		panel.add(uploadButton);
		
		saveButton = new JButton("이미지저장");
		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		panel.add(saveButton);
		uploadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//---------------------------------------------------------
//				String filename = "C:/jp/workspace_java/java_prj/bin/com/kosmo/gui/demo/aaa.jpg";
//				String filename = "C:\\jp/workspace_java\\java_prj\\bin\\com\\kosmo\\gui\\demo\\aaa.jpg";
				String filename= getClass().getResource("/com/kosmo/gui/demo/img/aaa.png").toString();
				
				
				JFileChooser chooser = new JFileChooser();
//				 * <li>JFileChooser.CANCEL_OPTION
//			     * <li>JFileChooser.APPROVE_OPTION
//			     * <li>JFileChooser.ERROR_OPTION 
			    int res = chooser.showOpenDialog(null);
				if(res == JFileChooser.APPROVE_OPTION) {
					try {
						String path = chooser.getSelectedFile().getPath();
						File f = new File(path);  //"C:/jp/aaa.png");
						buffer = ImageIO.read(f);
						ImageIcon imageIcon = new ImageIcon(buffer);
						imgLabel.setIcon(imageIcon);
						
						File outputfile = new File("C:/jp/saved.png");
					    ImageIO.write(buffer, "png", outputfile);
					    
					} catch (IOException exx) {
						JOptionPane.showMessageDialog(null, "에러났어요");
					}
				} else {
					JOptionPane.showMessageDialog(null, "파일선택 필수");
					return;
				}
			    
			    
				
			}
		});
		//ImageIcon resizeicon = new ImageIcon(icon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));		
		

		
		
		
		
		
	}

}
