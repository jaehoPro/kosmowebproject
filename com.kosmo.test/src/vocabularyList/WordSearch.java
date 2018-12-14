package vocabularyList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

public class WordSearch extends JPanel {
	private JTextField voca_spell;
	private JTable table;
	
	//ArrayList<Vector> list;
	JPanel panel_result;
	JScrollPane scrollPane;
	private JComboBox comboBox;
	private JPanel panel_bottom;
	private JLabel Label_searchRes;


	/**
	 * Create the panel.
	 */
	public WordSearch(VO selectedVocaVO) {
		setLayout(new BorderLayout(0, 0));
		setBounds(300, 300, 800, 350);
		
		JPanel panel_search = new JPanel();
		add(panel_search, BorderLayout.NORTH);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"단어명", "뜻", "단어명,뜻 하나라도 포함"}));
		comboBox.setSelectedIndex(0);
		panel_search.add(comboBox);
		
		voca_spell = new JTextField();
		panel_search.add(voca_spell);
		voca_spell.setColumns(10);
		
		JButton btnNewButton = new JButton("검색");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_result.removeAll();
				String[] columnNames = {"단어",
		                "뜻",
		                "등록날짜",
		                "암기여부",
		                "단어장이름"};
				
				
				DefaultTableModel model = new DefaultTableModel(null, columnNames);
				
				JDBC jdbc = new JDBC();
				//ArrayList<Vector> list = jdbc.vocaWordSearch(selectedVocaVO.getBook_num(), voca_spell.getText());
				
				
				
				ArrayList<Vector> list = jdbc.vocaWordSearch(voca_spell.getText(), comboBox.getSelectedIndex());
				for(int i=0; i<list.size(); i++)
				{
					model.insertRow(i, list.get(i));
				}
				
				
				
				
				table = new JTable(model);
				
				
				scrollPane = new JScrollPane(table);
		        scrollPane.setPreferredSize(new Dimension(750,250));
				panel_result.add(scrollPane);
				panel_result.revalidate();
								
				
				if(list.size()==0)
				{
					Label_searchRes.setText("검색된 결과가 없습니다.");
				}
				else
				{
					Label_searchRes.setText(list.size()+"개 검색 완료");
				}
				
				System.out.println(selectedVocaVO.getBook_num()+""+voca_spell.getText());
			}
		});
		panel_search.add(btnNewButton);
		
		panel_result = new JPanel();
		
		
		add(panel_result, BorderLayout.CENTER);
		
		scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(750,250));
		panel_result.add(scrollPane);//여기담기
		
		panel_bottom = new JPanel();
		add(panel_bottom, BorderLayout.SOUTH);
		
		Label_searchRes = new JLabel(" ");
		panel_bottom.add(Label_searchRes);
		
		
		//-----------------------------------------------------
		
		
		
		
		


	}

}
