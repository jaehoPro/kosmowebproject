package vocabularyList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


import kosmo.test.Ch99JDBCImpl;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WordList extends JPanel {

	private JTable table;
	private JTextField voca_spell;
	private JTextField voca_means;
	
	int rowIndex=0;
	int columnIndex = 0;
	JScrollPane scrollPane;
	JPanel panel_menu;
	
	JPanel panel;
	
	DefaultTableModel model;
	private JPanel panel_main;

	/**
	 * Create the panel.
	 */
	public WordList(VO selectedVocaVO) {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		setBounds(300, 300, 800, 400);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setPreferredSize(new Dimension(750,330));
		add(panel, BorderLayout.CENTER);
		
		
		String[] columnNames = {"번호",
                "단어",
                "뜻",
                "등록후",
                "암기여부"};
		
		
		model = new DefaultTableModel(null, columnNames);
		
		JDBC jdbc = new JDBC();
		ArrayList<Vector> list = jdbc.vocaList(selectedVocaVO.book_num);
		for(int i=0; i<list.size(); i++)
		{
			model.insertRow(i, list.get(i));
		}
		panel.setLayout(new BorderLayout(0, 0));
        
        
        
        panel_menu = new JPanel();
        panel.add(panel_menu, BorderLayout.SOUTH);
        
        voca_spell = new JTextField();
        panel_menu.add(voca_spell);
        voca_spell.setColumns(10);
        
        voca_means = new JTextField();
        panel_menu.add(voca_means);
        voca_means.setColumns(10);
        
        
        
                  
        
        
        JButton btn_wordAdd = new JButton("단어추가");
        btn_wordAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		panel_main.setVisible(true);
        		int res = 0;

        		panel_main.removeAll();
        		selectedVocaVO.setVoca_spell(voca_spell.getText());		//단어 스펠을 VO 입력
        		selectedVocaVO.setVoca_means(voca_means.getText());		//단어 뜻을 VO 입력
				
				JDBC jdbc = new JDBC();
				
				if(jdbc.vocaAdd(selectedVocaVO)==1)
				{
					JOptionPane.showMessageDialog(null, "등록완료되었습니다.");
					
					
					
					voca_spell.setText("");
					voca_means.setText("");
				}
				else
					return;
				
				ArrayList<Vector> list = jdbc.vocaList(selectedVocaVO.book_num);
				model = new DefaultTableModel(null, columnNames);
				for(int i=0; i<list.size(); i++)
				{
					model.insertRow(i, list.get(i));
				}
			

							
				table.setModel(model);
				
				scrollPane = new JScrollPane(table);
		        scrollPane.setPreferredSize(new Dimension(750,250));
		        panel_main.add(scrollPane);
		        panel_main.revalidate();
				
	
				
				
        	}
        });
        panel_menu.add(btn_wordAdd);
        
        JButton btn_wordDel = new JButton("단어삭제");
        btn_wordDel.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//System.out.println(table.getModel().getValueAt(rowIndex, 0).toString());
        		int del_voca_num;
        		del_voca_num = Integer.parseInt(table.getModel().getValueAt(rowIndex, 0).toString());		//삭제할(선택된) voca번호 
        		
        		JDBC jdbc = new JDBC();
        		panel_main.removeAll();
        		if(jdbc.vocaDelete(del_voca_num)==1)
        		{
        			
        			JOptionPane.showMessageDialog(null, "삭제 되었습니다");
        			model.removeRow(rowIndex);
        			
        		}
        		
	        		        
				table.setModel(model);
				if(model.getRowCount()==0)
				{
					panel_main.setVisible(false);
					JOptionPane.showMessageDialog(null, "단어장에 단어를 모두 삭제 하였습니다.");
					return;
				}
				
				
				scrollPane = new JScrollPane(table);
		        scrollPane.setPreferredSize(new Dimension(750,250));
		        panel_main.add(scrollPane);
		        panel_main.revalidate();

        	
        	}
        });
        panel_menu.add(btn_wordDel);
        
        panel_main = new JPanel();
        panel.add(panel_main, BorderLayout.CENTER);
        

        table = new JTable(model);
        
        
        
        table.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		
                rowIndex=0;
                for (int r : table.getSelectedRows()) {
                	rowIndex = r;
                }
                //-------------------------------------------
                columnIndex = 0;
                for (int c : table.getSelectedColumns()) {
                    columnIndex = c;
                }
                //-------------------------------------------
                String selectedValue = table.getModel().getValueAt(rowIndex, columnIndex).toString();
	        
                //-------------------------------------------

                int csize = table.getModel().getColumnCount();
                String allValue="";
                for(int i=0; i<csize; i++) {
                	allValue += table.getModel().getValueAt(rowIndex, i).toString()+", ";
        		}
                
                
                System.out.println(table.getModel().getValueAt(rowIndex, 0).toString());		//voca_num
                System.out.println(table.getModel().getValueAt(rowIndex, 1).toString());		//voca_spell
                System.out.println(table.getModel().getValueAt(rowIndex, 2).toString());		//voca_means
                System.out.println(table.getModel().getValueAt(rowIndex, 3).toString());		//voca_date
                System.out.println(table.getModel().getValueAt(rowIndex, 4).toString());		//voca_memory
                
//                voca_spell.setText(table.getModel().getValueAt(rowIndex, 1).toString());
//                voca_means.setText(table.getModel().getValueAt(rowIndex, 2).toString());
                
        	}
        });
        //table.setPreferredScrollableViewportSize(new Dimension(700, 300));
        table.setFillsViewportHeight(true);
        
        scrollPane = new JScrollPane(table);
        panel_main.add(scrollPane);
        scrollPane.setPreferredSize(new Dimension(750,250));
        
	}

}
