package com.kosmo.gui.switc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;

public class BFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					BFrame frame = new BFrame();
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
	//AFrame a = new AFrame();
	//a.add()
	public BFrame(AFrame aframeNewAddr) { //String applStr) {
		//Frame 크기 설정
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(120, 120, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('F');
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		
//		mntmOpen.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				if(e.getKeyCode()==KeyEvent.VK_O)
//				{
//					System.out.println("오픈아이템 클릭...............");
//				}
//			}
//		});
		mntmOpen.setIcon(new ImageIcon(BFrame.class.getResource("/com/kosmo/gui/switc/icon/open.png")));
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		
		
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		
		mntmSave.setIcon(new ImageIcon(BFrame.class.getResource("/com/kosmo/gui/switc/icon/save.png")));
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
//		mntmSave.addActionListener(new ActionListener()){
//			public void actionPerformed(ActionEvent e) {
//				
//			}
//		};
//		mntmSave.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				System.out.println("Save");
//			}
//		});
		mnFile.add(mntmSave);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.setIcon(new ImageIcon(BFrame.class.getResource("/com/kosmo/gui/switc/icon/close.png")));
		mntmClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.ALT_MASK));
		mnFile.add(mntmClose);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setMnemonic('E');
		menuBar.add(mnEdit);

		//JPanel 설정
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.RED);

		
		JButton btnNewButton = new JButton("BFrame"+aframeNewAddr.applTextField.getText());
		contentPane.add(btnNewButton, BorderLayout.WEST);
		
		//Frame에 JPanel 올리기
		setContentPane(contentPane);
	}

}
