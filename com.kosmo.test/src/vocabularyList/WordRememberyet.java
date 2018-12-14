package vocabularyList;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JSplitPane;

public class WordRememberyet extends JPanel {
	
	ArrayList list=new ArrayList();
	VO vo = new VO();

	int presentWord=0;
	int wordcount = 0;
	public WordRememberyet(VO selectedVocaVO) {
		JDBC jdbc = new JDBC();
		list=jdbc.vocaStudyAgainList(selectedVocaVO.getBook_num());
		
		wordcount = list.size();		//호출된 단어갯수를 wordcount에 저장
				
		
		System.out.println("아직 못외운 단어 호출 완료"+list.size());
		
		if(wordcount>0)
		{
			vo=(VO)list.get(presentWord);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "공부할 단어가 없습니다.");
		}
		
		setLayout(new BorderLayout(0, 0));
		setBounds(300, 300, 600, 400);
		
		
		//텍스트 area 스펠링
		
		
		JPanel panel_button = new JPanel();
		add(panel_button, BorderLayout.SOUTH);
		
		JButton btn_remeber = new JButton("외웠어요");
		panel_button.add(btn_remeber);
		
		JButton btn_rember_no = new JButton("못외웠어요");
		panel_button.add(btn_rember_no);
		
		btn_remeber.setVisible(false);
		btn_rember_no.setVisible(false);
		
		JButton btn_answer = new JButton("정답보기");
		panel_button.add(btn_answer);
		
	
		
		JPanel panel_main = new JPanel();
		add(panel_main, BorderLayout.CENTER);
		panel_main.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_main.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_remain = new JPanel();
		panel.add(panel_remain, BorderLayout.NORTH);
		
		
		JLabel Label_wordcount = new JLabel(wordcount+"개 남았습니다.");
		panel_remain.add(Label_wordcount);
		
		JPanel panel_word = new JPanel();
		panel.add(panel_word, BorderLayout.CENTER);
		
		JSplitPane splitPane = new JSplitPane();
		panel_word.add(splitPane);
		
		JLabel lblNewLabel = new JLabel("단 어");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 50));
		splitPane.setLeftComponent(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("뜻");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 50));
		splitPane.setRightComponent(lblNewLabel_1);
		
		JPanel panel_study = new JPanel();
		panel_main.add(panel_study, BorderLayout.CENTER);
		
		JTextArea voca_spell = new JTextArea();
		panel_study.add(voca_spell);
		voca_spell.setFont(new Font("Monospaced", Font.PLAIN, 50));
		voca_spell.setText(vo.getVoca_spell());
		
		
		//텍스트 area 뜻
		JTextArea voca_means = new JTextArea();
		panel_study.add(voca_means);
		voca_means.setFont(new Font("Monospaced", Font.PLAIN, 50));
		voca_means.setText(vo.getVoca_means());
		
		voca_means.setVisible(false);
		btn_answer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(list.size()==0)
				{
					JOptionPane.showMessageDialog(null, "공부할 단어가 없습니다. 랜덤단어공부메뉴를 이용하세요");
					return;
				}
				voca_means.setVisible(true);
				btn_answer.setVisible(false);
				btn_remeber.setVisible(true);
				btn_rember_no.setVisible(true);
			}
		});
		

		
		btn_remeber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voca_means.setVisible(false);
				System.out.println("현재 단어번호:"+vo.getVoca_num());
				
								
				
				jdbc.vocaMemoryUpdate(vo.getVoca_num(), 1);			// 외웠으니깐 voca_memory를 1로 바꿔준다
				presentWord++;							// 다음 단어가 호출될때 list의 count를 증가 시키는 변수
				
				if(wordcount > 0)
				{
					wordcount--;							// 다음 단어가 호출될때 전체 단어 카운터를 줄임.
				}
				if(wordcount==0)
				{
					Label_wordcount.setText("학습완료");
					
				}
				else
				{
					Label_wordcount.setText(wordcount+"개 남았습니다.");
				}
				
				if(presentWord>=list.size())
				{
					JOptionPane.showMessageDialog(null, "단어를 전부 공부하였습니다.");
					
					int result = 0;		
					
		            result = JOptionPane.showConfirmDialog(null,"단어를 전부 공부하였습니다. 못외운 단어를 다시 공부 하겠습니까?");
		            
		            
							            
		        		// (result 리턴값)
		        		// JOptionPane.YES_OPTION, JOptionPane.NO_OPTION,
		        		// JOptionPane.CANCEL_OPTION 등
		    		if(result == JOptionPane.YES_OPTION)//      0
		    		{	
		    		
		       			presentWord=0;
		    			JDBC jdbc = new JDBC();
		    			list=jdbc.vocaStudyAgainList(selectedVocaVO.getBook_num());
		    			wordcount = list.size();
		    			if(wordcount==0)
		    			{
		    				JOptionPane.showMessageDialog(null, "단어장의 단어를 이미 다 외웠습니다.");
		    				btn_remeber.setVisible(false);
			    			btn_rember_no.setVisible(false);
			    			return;
		    			}
		    			Label_wordcount.setText(wordcount+"개 남았습니다.");
		    			System.out.println("아직 못외운 단어 호출 완료"+list.size());
		    			
		    			if(wordcount>0)
		    			{
		    				vo=(VO)list.get(presentWord);
		    			}
		    			voca_spell.setText(vo.getVoca_spell());
		    			voca_means.setText(vo.getVoca_means());
		    	
		    		}
		    		else		// 1, 2
		    		{
		    			btn_remeber.setVisible(false);
		    			btn_rember_no.setVisible(false);
		    			return ;
		    		}
					return;
				}
				
				
				
				vo=(VO)list.get(presentWord);		//다음 단어를 VO에 다시 저장
				voca_spell.setText(vo.getVoca_spell());
				voca_means.setText(vo.getVoca_means());
				
				btn_answer.setVisible(true);
				btn_remeber.setVisible(false);
				btn_rember_no.setVisible(false);
			}
		});
		
		
		btn_rember_no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voca_means.setVisible(false);
				
				jdbc.vocaMemoryUpdate(vo.getVoca_num(), 0);			// 못 외웠으니깐 voca_memory를 0으로 바꿔준다
				
				presentWord++;							// 다음 단어가 호출될때 list의 count를 증가 시키는 변수
				
				if(wordcount > 0)
				{
					wordcount--;							// 다음 단어가 호출될때 전체 단어 카운터를 줄임.
				}
				if(wordcount==0)
				{
					Label_wordcount.setText("학습완료");
					
				}
				else
				{
					Label_wordcount.setText(wordcount+"개 남았습니다.");
				}
				
				if(presentWord>=list.size())
				{
					JOptionPane.showMessageDialog(null, "단어를 전부 공부하였습니다.");
					
					int result = 0;		
					
		            result = JOptionPane.showConfirmDialog(null,"단어를 전부 공부하였습니다. 못외운 단어를 다시 공부 하겠습니까?");
		            
		            
							            
		        		// (result 리턴값)
		        		// JOptionPane.YES_OPTION, JOptionPane.NO_OPTION,
		        		// JOptionPane.CANCEL_OPTION 등
		    		if(result == JOptionPane.YES_OPTION)//      0
		    		{	
		    		
		       			presentWord=0;
		    			JDBC jdbc = new JDBC();
		    			list=jdbc.vocaStudyAgainList(selectedVocaVO.getBook_num());
		    			wordcount = list.size();
		    			if(wordcount==0)
		    			{
		    				JOptionPane.showMessageDialog(null, "단어장의 단어를 이미 다 외웠습니다.");
		    				btn_remeber.setVisible(false);
			    			btn_rember_no.setVisible(false);
			    			return;
		    			}
		    			Label_wordcount.setText(wordcount+"개 남았습니다.");
		    			
		    			System.out.println("아직 못외운 단어 호출 완료"+list.size());
		    			
		    			if(wordcount>0)
		    			{
		    				vo=(VO)list.get(presentWord);
		    			}
		    			voca_spell.setText(vo.getVoca_spell());
		    			voca_means.setText(vo.getVoca_means());
		    	
		    		}
		    		else		// 1, 2
		    		{
		    			btn_remeber.setVisible(false);
		    			btn_rember_no.setVisible(false);
		    			return ;
		    		}
					return;
				}

				vo=(VO)list.get(presentWord);		//다음 단어를 VO에 다시 저장
				voca_spell.setText(vo.getVoca_spell());
				voca_means.setText(vo.getVoca_means());
				
				btn_answer.setVisible(true);
				btn_remeber.setVisible(false);
				btn_rember_no.setVisible(false);
			}
		});
		

	}
	

}
