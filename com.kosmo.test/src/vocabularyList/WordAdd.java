package vocabularyList;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class WordAdd extends JPanel {
	private DefaultListModel listModel;
	JPanel panel_wordsearch_content;
	private JList searchlist;
	JScrollPane listScrollPane;
	JTextArea voca_means;
	JTextArea voca_spell;
	JComboBox comboBox;
	/**
	 * Create the panel.
	 */
	ArrayList<VO> list=new ArrayList<VO>();
	private JTextField wordsearch_textField;
	
	
	
	public WordAdd(VO addVoca) {
		setLayout(new BorderLayout(0, 0));
		setBounds(300, 300, 800, 400);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		JPanel panel_wordinput = new JPanel();
		panel.add(panel_wordinput, BorderLayout.WEST);
		
		JButton btn_add = new JButton("등  록");
		
		voca_means = new JTextArea();
		voca_means.setLineWrap(true);
		voca_means.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
				int keycode = e.getKeyCode();
				if(keycode == e.VK_TAB)
				{
					btn_add.requestFocus();
				}
			}
		});
		voca_means.setFont(new Font("Monospaced", Font.PLAIN, 20));
		
		voca_spell = new JTextArea();
		voca_spell.setLineWrap(true);
		voca_spell.setFont(new Font("Monospaced", Font.PLAIN, 20));
		voca_spell.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//if(e.getKeyCode()==KeyEvent.VK_TAB) {
					
				int keycode = e.getKeyCode();
				if(keycode == e.VK_TAB)
				{
					voca_means.requestFocus();
				}
			}
		});
		
		
		JButton btn_reset = new JButton("초기화");
		btn_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voca_spell.setText("");
				voca_means.setText("");
			}
		});
		
		
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int res = 0;
				
				addVoca.setVoca_spell(voca_spell.getText());		//단어 스펠을 VO 입력
				addVoca.setVoca_means(voca_means.getText());		//단어 뜻을 VO 입력
				
				if(voca_spell.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "단어를 입력해주세요.");
					return;
				}
				else if(voca_means.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "단어의 뜻을 입력해주세요.");
					return;
				}
				
				JDBC jdbc = new JDBC();
				res=jdbc.vocaAdd(addVoca);
				if(res==1)
				{
					JOptionPane.showMessageDialog(null, "등록완료되었습니다.");
					voca_spell.setText("");
					voca_means.setText("");
					voca_spell.requestFocus();
				}
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("단어");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 22));
		
		JLabel lblNewLabel_1 = new JLabel("뜻");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 22));
		GroupLayout gl_panel_wordinput = new GroupLayout(panel_wordinput);
		gl_panel_wordinput.setHorizontalGroup(
			gl_panel_wordinput.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_wordinput.createSequentialGroup()
					.addGroup(gl_panel_wordinput.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_wordinput.createSequentialGroup()
							.addGap(143)
							.addComponent(btn_add))
						.addGroup(gl_panel_wordinput.createSequentialGroup()
							.addContainerGap()
							.addComponent(voca_spell, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_wordinput.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_reset)
						.addComponent(voca_means, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(23, Short.MAX_VALUE))
				.addGroup(gl_panel_wordinput.createSequentialGroup()
					.addGap(98)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(52))
		);
		gl_panel_wordinput.setVerticalGroup(
			gl_panel_wordinput.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_wordinput.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_wordinput.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_wordinput.createParallelGroup(Alignment.BASELINE)
						.addComponent(voca_means, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
						.addComponent(voca_spell, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_wordinput.createParallelGroup(Alignment.BASELINE)
						.addComponent(btn_reset)
						.addComponent(btn_add))
					.addContainerGap(123, Short.MAX_VALUE))
		);
		panel_wordinput.setLayout(gl_panel_wordinput);
		
		JPanel panel_wordsearch = new JPanel();
		panel.add(panel_wordsearch, BorderLayout.EAST);
		panel_wordsearch.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_wordsearch_menu = new JPanel();
		panel_wordsearch.add(panel_wordsearch_menu, BorderLayout.NORTH);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"일본어", "영어"}));
		panel_wordsearch_menu.add(comboBox);
		
		wordsearch_textField = new JTextField();
		panel_wordsearch_menu.add(wordsearch_textField);
		wordsearch_textField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("검색");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				voca_spell.setText("");
				voca_spell.setText(wordsearch_textField.getText());
				DicCraw dic = new DicCraw();
				
				System.out.println(comboBox.getSelectedIndex());
				ArrayList<String> dicList = dic.getDicList(comboBox.getSelectedIndex(),wordsearch_textField.getText());
				if(dicList.size()==0)
				{
					JOptionPane.showMessageDialog(null, "검색된 결과가 없습니다");
					return;
				}
				Object[] listItems = (Object[])dicList.toArray();
				
				makeSearchList(listItems);
				
				panel_wordsearch_content.repaint();

			}
		});
		panel_wordsearch_menu.add(btnNewButton);
		
		panel_wordsearch_content = new JPanel();
		panel_wordsearch.add(panel_wordsearch_content, BorderLayout.CENTER);
		
		
		
		
	}

	public void makeSearchList(Object[] listItems) {
		panel_wordsearch_content.removeAll();
		listModel = new DefaultListModel();
        
        for(int i=0; i<listItems.length; i++)
		{
			listModel.add(i, listItems[i]);
		}
        	
        searchlist = new JList(listModel);
        searchlist.setFont(new Font("Monospaced", Font.PLAIN, 20));

        
        listScrollPane = new JScrollPane(searchlist);
     

        
        panel_wordsearch_content.add(listScrollPane);
		panel_wordsearch_content.revalidate();
		
		searchlist.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		if(voca_means.getText().equals(""))
	        		{
	        			voca_means.setText(searchlist.getSelectedValue().toString());
	        		}
	        		else
	        		{
	        			voca_means.setText(voca_means.getText()+","+searchlist.getSelectedValue().toString());
	        		}
	        		
	        		System.out.println(searchlist.getSelectedValue());
	        		System.out.println(searchlist.getSelectedIndex());
//	        		
	        	}
	        });
	}
}
