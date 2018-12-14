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
import java.util.Random;


public class WordStudyAll extends JPanel {
	
	ArrayList list=new ArrayList();
	VO vo = new VO();
	
	int[] randomNumArray;
	
	int wordcount;
	int book_num;
	private int presentWord=0;
	
	JLabel Label_wordcount;
	JTextArea voca_spell;
	JTextArea voca_means;
	
	JButton btn_remeber;
	JButton btn_rember_no;
	JButton btn_answer;
	public WordStudyAll(VO selectedVocaVO) {
		book_num=selectedVocaVO.getBook_num();
		
		JDBC jdbc = new JDBC();
		list=jdbc.vocaStudyList(selectedVocaVO.getBook_num());			//리스트에 단어전부 저장
				//vocaStudyList(selectedVocaVO.getBook_num());
		
		wordcount = list.size();
		
		System.out.println(list.size()+"개 단어 호출 완료");
		
		if(wordcount>0)
		{
			//텍스트 area 스펠링
			randomNumArray=randomNumber(list.size());	//리스트 사이즈 만큼 랜덤 숫자를 배열에 저장
			
			for(int i=0; i<randomNumArray.length; i++)
			{
				System.out.println(randomNumArray[i]);
			}
			
			vo=(VO)list.get(randomNumArray[presentWord]);				//randomNumArray[0]리스트를 VO에  다시저장
		}
		else
		{
			JOptionPane.showMessageDialog(null, "단어장에 등록된 단어가 없습니다.");
			return ;
		}
		
		
		setLayout(new BorderLayout(0, 0));
		setBounds(300, 300, 600, 400);
		
		
		
		
		
		
		JPanel panel_button = new JPanel();
		add(panel_button, BorderLayout.SOUTH);
		
		btn_remeber = new JButton("외웠어요");
		panel_button.add(btn_remeber);
		
		btn_rember_no = new JButton("못외웠어요");
		panel_button.add(btn_rember_no);
		
		btn_remeber.setVisible(false);
		btn_rember_no.setVisible(false);
		
		btn_answer = new JButton("정답보기");
		panel_button.add(btn_answer);
		
		JPanel panel_up = new JPanel();
		add(panel_up, BorderLayout.NORTH);
		
		Label_wordcount = new JLabel(wordcount+"개 남았습니다.");
		panel_up.add(Label_wordcount);
	
	
		
		JPanel panel_content = new JPanel();
		add(panel_content, BorderLayout.CENTER);
		panel_content.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_content.add(panel, BorderLayout.NORTH);
		
		JSplitPane splitPane = new JSplitPane();
		panel.add(splitPane);
		
		JLabel lblNewLabel = new JLabel("단 어");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 50));
		splitPane.setLeftComponent(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("뜻");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 50));
		splitPane.setRightComponent(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_content.add(panel_1, BorderLayout.CENTER);
		
		voca_spell = new JTextArea();
		panel_1.add(voca_spell);
		voca_spell.setFont(new Font("Monospaced", Font.PLAIN, 50));
		voca_spell.setText(vo.getVoca_spell());
		
		
		//텍스트 area 뜻
		voca_means = new JTextArea();
		panel_1.add(voca_means);
		voca_means.setFont(new Font("Monospaced", Font.PLAIN, 50));
		voca_means.setText(vo.getVoca_means());
		
		voca_means.setVisible(false);
		btn_answer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voca_means.setVisible(true);
				btn_answer.setVisible(false);
				btn_remeber.setVisible(true);
				btn_rember_no.setVisible(true);
			}
		});
		

		
		btn_remeber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voca_means.setVisible(false);
				
				jdbc.vocaMemoryUpdate(vo.getVoca_num(), 1);			// 외웠으니깐 voca_memory를 1로 바꿔준다

				afterBtnClick();
				
		
			}
		});
		
		
		btn_rember_no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voca_means.setVisible(false);
				
				jdbc.vocaMemoryUpdate(vo.getVoca_num(), 0);			// 못 외웠으니깐 voca_memory를 0으로 바꿔준다
				

				afterBtnClick();
				
				
			}

			
		});
		

	}
	
	
	public void afterBtnClick()				//외웠어요 or 못외웠어요 클릭시 공통으로 실행되는 부분
	{
		presentWord++;
		wordcount--;
		
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
			
            result = JOptionPane.showConfirmDialog(null,"단어를 전부 공부하였습니다. 처음부터 다시 공부 하겠습니까?");
            
            
					            
        		// (result 리턴값)
        		// JOptionPane.YES_OPTION, JOptionPane.NO_OPTION,
        		// JOptionPane.CANCEL_OPTION 등
    		if(result == JOptionPane.YES_OPTION)//      0
    		{	
    		
       			presentWord=0;
    			JDBC jdbc = new JDBC();
    			list=jdbc.vocaStudyList(book_num);
    			wordcount = list.size();
    			Label_wordcount.setText(wordcount+"개 남았습니다.");
    			System.out.println("단어 호출 완료"+list.size());
    			randomNumArray=randomNumber(list.size());	//리스트 사이즈 만큼 랜덤 숫자를 배열에 저장
    			
    			if(wordcount>0)
    			{
    				vo=(VO)list.get(randomNumArray[presentWord]);
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
    		btn_answer.setVisible(true);
    		btn_remeber.setVisible(false);
    		btn_rember_no.setVisible(false);
			return;
		}
		vo=(VO)list.get(randomNumArray[presentWord]);		//다음 단어를 VO에 다시 저장
		
		voca_spell.setText(vo.getVoca_spell());
		voca_means.setText(vo.getVoca_means());
		
		btn_answer.setVisible(true);
		btn_remeber.setVisible(false);
		btn_rember_no.setVisible(false);
	}
	
	public int[] randomNumber(int number)		//랜덤 숫자 만들어 내는 함수
	{
		int[] randomNumArray = new int[number];
		Random rand = new Random();
		
		for(int i=0; i<number; i++)
		{
			randomNumArray[i]=rand.nextInt(number);			//랜덤 숫자를 pickNum에 저장
			
			for(int j=0; j<i; j++)
			{	
				if(randomNumArray[i]==randomNumArray[j])
				{
					randomNumArray[i]=rand.nextInt(number);	//뽑은 숫자가 배열안에 있는 숫자와 중복 되면 다시 뽑음
					j=-1;							//중복 된경우 처음부터 다시 확인
				}
				
			}
		}
				
		return randomNumArray;
	}

}
