package vocabularyList;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VocaMenu {

	private JFrame frame;
	private CardLayout cardLayout;
	JPanel panelContent;
	int wordExist =0;


	public VocaMenu(VO selectedVocaVO) {
		
		JDBC jdbc = new JDBC();
		ArrayList checkWord=new ArrayList();
		checkWord=jdbc.vocaStudyList(selectedVocaVO.getBook_num());
		if(checkWord.size()==0)
		{
			JOptionPane.showMessageDialog(null, "등록된 단어가 없습니다.\n단어를 등록해주세요");
			wordExist = 0; // 단어가 존재 하지 않으면 0
		
		}
		else
		{
			JOptionPane.showMessageDialog(null, checkWord.size()+"개 단어가 호출되었습니다.");
			wordExist = 1; // 단어가 존재 하면  1
		}
		
		
		frame = new JFrame();
		frame.setBounds(300, 300, 550, 400);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panelMenu = new JPanel();
		panel.add(panelMenu, BorderLayout.NORTH);
		
		
		
		
		panelContent = new JPanel();
		panel.add(panelContent, BorderLayout.CENTER);
		cardLayout=new CardLayout(0,0);
		panelContent.setLayout(cardLayout);
		
//		WordStudyAgain study_again = new WordStudyAgain(selectedVocaVO);
//		
//		panelContent.add(study_again, "WordStudyAgain");
//		
//		JButton word_study_again_btn = new JButton("아직못외운단어");
//		word_study_again_btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				frame.setBounds(300, 300, 550, 400);
//				panelContent.setVisible(true);
//				cardLayout.show(panelContent, "WordStudyAgain");
//			}
//		});
//		panelMenu.add(word_study_again_btn);
		
		
		//--------------------------------------------------------
		if(wordExist == 1)
		{
			WordRememberyet study_again = new WordRememberyet(selectedVocaVO);
			panelContent.add(study_again, "WordStudyAgain");		// WordStudyAgain(사용자 지정 이름: 카드이름)
			
			JButton word_study_again_btn = new JButton("외우지못한단어");
			word_study_again_btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setBounds(300, 300, 550, 400);
					////////////////다시 panel로 호출//////////////
					WordRememberyet study_again = new WordRememberyet(selectedVocaVO);
					panelContent.add(study_again, "WordStudyAgain");		// WordStudyAgain(사용자 지정 이름: 카드이름)
					
					panelContent.setVisible(true);
					cardLayout.show(panelContent, "WordStudyAgain");
					frame.setTitle(selectedVocaVO.getBook_name()+"-"+word_study_again_btn.getText());	
				}
			});
			panelMenu.add(word_study_again_btn);
			
			
			//--------------------------------------------------------
			WordStudyAll study = new WordStudyAll(selectedVocaVO);
			panelContent.add(study, "WordStudy");		//study, WordStudy(사용자 지정 이름: 카드이름)
			//panelContent.setVisible(true);
			
			
			JButton word_study_btn = new JButton("랜덤단어공부");
			word_study_btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setBounds(300, 300, 550, 400);
					////////////////다시 panel로 호출//////////////
					WordStudyAll study = new WordStudyAll(selectedVocaVO);
					panelContent.add(study, "WordStudy");		//study, WordStudy(사용자 지정 이름: 카드이름)
					
					panelContent.setVisible(true);
					cardLayout.show(panelContent, "WordStudy");		//
					frame.setTitle(selectedVocaVO.getBook_name()+"-"+word_study_btn.getText());
				}
			});
		
			panelMenu.add(word_study_btn);
			//--------------------------------------------------------
			
//			WordAdd add = new WordAdd(selectedVocaVO);
//			panelContent.add(add, "WordAdd");
//			//panelContent.setVisible(false);
//			
//			JButton word_add_btn = new JButton("단어등록");
//			word_add_btn.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					frame.setBounds(300, 300, 550, 400);
//					panelContent.setVisible(true);
//					cardLayout.show(panelContent, "WordAdd");
//				}
//			});
//			panelMenu.add(word_add_btn);
			
			//--------------------------------------------------------
			WordList list = new WordList(selectedVocaVO);
			panelContent.add(list, "WordList");
			//panelContent.setVisible(false);
			
			
			JButton word_list_btn = new JButton("단어관리");
			word_list_btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setBounds(300, 300, 800, 400);
					////////////////다시 panel로 호출//////////////
					WordList list = new WordList(selectedVocaVO);
					panelContent.add(list, "WordList");
					
					panelContent.setVisible(true);
					cardLayout.show(panelContent, "WordList");
					frame.setTitle(selectedVocaVO.getBook_name()+"-"+word_list_btn.getText());
				}
			});
			panelMenu.add(word_list_btn);
			
			//--------------------------------------------------------
			WordSearch search = new WordSearch(selectedVocaVO);
			panelContent.add(search, "WordSearch");
			//panelContent.setVisible(false);
			
			JButton word_search_btn = new JButton("단어검색");
			word_search_btn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.setBounds(300, 300, 800, 400);
					panelContent.setVisible(true);
					cardLayout.show(panelContent, "WordSearch");
					frame.setTitle(selectedVocaVO.getBook_name()+"-"+word_search_btn.getText());
				}
			});
			panelMenu.add(word_search_btn);
			frame.setTitle(selectedVocaVO.getBook_name()+"-"+word_study_again_btn.getText());			//현재 선택된 단어장
		}
		else if(wordExist == 0)
		{
			WordAdd add = new WordAdd(selectedVocaVO);
			panelContent.add(add, "WordAdd");
			frame.setBounds(300, 300, 850, 400);
			//panelContent.setVisible(false);
			
//			JButton word_add_btn = new JButton("단어등록");
//			word_add_btn.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//					frame.setBounds(300, 300, 550, 400);
//					panelContent.setVisible(true);
//					cardLayout.show(panelContent, "WordAdd");
//				}
//			});
//			panelMenu.add(word_add_btn);
			frame.setTitle(selectedVocaVO.getBook_name()+"단어장 단어등록");			//현재 선택된 단어장
		}
		
	}
	

	

}
