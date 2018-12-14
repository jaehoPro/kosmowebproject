package vocabularyList;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import vocabularyList.vo.CheckableItemVO;
import javax.swing.JTextField;


public class CheckBoxJList extends JFrame {
	DicInsertDAO dicInsertDAO = new DicInsertDAO();
	private JTextField searchTextField;
	JList jList;
	DefaultListModel model; 
	CheckableItemVO[] vo;
	//-----------------------------------------------------------------
	public static void main(String args[]) {
		CheckBoxJList frame = new CheckBoxJList();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {System.exit(0);}
		});
		frame.setSize(300, 200);
		frame.setVisible(true);
	}

	//-----------------------------------------------------------------
	public CheckBoxJList() {
		
		
		model = new DefaultListModel();
		jList = new JList(model);

		vo = new CheckableItemVO[model.size()];
		System.out.println(model.size());
		jList.setCellRenderer(new CheckListRenderer());
		jList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jList.setBorder(new EmptyBorder(0,4,0,0));
		jList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int index = jList.locationToIndex(e.getPoint());
				
				vo[index].setStr(jList.getModel().getElementAt(index).toString());
				//CheckableItemVO itemVO = (CheckableItemVO)jList.getModel().getElementAt(index);
				vo[index].setSelected(!vo[index].isSelected());
				
				Rectangle rect = jList.getCellBounds(index, index);
				jList.repaint(rect);
			}
		});
		JScrollPane sp = new JScrollPane(jList);

		final JTextArea textArea = new JTextArea(3,10);
		JScrollPane textPanel = new JScrollPane(textArea);
		JButton printButton = new JButton("dic insert");
		printButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model = (DefaultListModel)jList.getModel();
				int n = model.getSize();
				for (int i=0;i<n;i++) {
					CheckableItemVO itemVO = (CheckableItemVO)model.getElementAt(i);
					if (itemVO.isSelected()) {
						dicInsertDAO.dicInsert(itemVO);
						//textArea.append(itemVO.toString());
						//textArea.append(System.getProperty("line.separator"));
						
						
					}
				}
			}
		});
		JButton clearButton = new JButton("clear");
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
			}
		});
		JPanel panel = new JPanel(new GridLayout(2,1));
		panel.add(printButton);
		panel.add(clearButton);

		getContentPane().add(sp,    BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		sp.setColumnHeaderView(panel_1);
		
		searchTextField = new JTextField();
		panel_1.add(searchTextField);
		searchTextField.setColumns(10);
		
		JButton searchButton = new JButton("search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//크롤링된 단어 사전 가져오기 ------------------------------------------
				DicCraw dic = new DicCraw();
				ArrayList<String> dicList = dic.getDicList(searchTextField.getText());  
				Object[] strarr = (Object[])dicList.toArray();
				//크롤링된 단어 사전 가져오기 -----------------------------------------
				
				vo = new CheckableItemVO[strarr.length];
				model = (DefaultListModel)jList.getModel();
				model.removeAllElements();
				CheckableItemVO[] items = new CheckableItemVO[strarr.length];
				for (int i=0;i<strarr.length;i++) {
					items[i] = new CheckableItemVO(strarr[i].toString());
					model.addElement(strarr[i].toString());
				}
			}
		});
		panel_1.add(searchButton);
		getContentPane().add(panel, BorderLayout.EAST);
		getContentPane().add(textPanel, BorderLayout.SOUTH);
	}

//	private CheckableItemVO[] createData() {
//		//크롤링된 단어 사전 가져오기 ----------------------------------
//		DicCraw dic = new DicCraw();
//		ArrayList<String> dicList = dic.getDicList("사과");  
//		Object[] strarr = (Object[])dicList.toArray();
//		//크롤링된 단어 사전 가져오기 ----------------------------------
//		
//		CheckableItemVO[] items = new CheckableItemVO[strarr.length];
//		for (int i=0;i<strarr.length;i++) {
//			items[i] = new CheckableItemVO(strarr[i].toString());
//		}
//		return items;
//	}
	//-----------------------------------------------------------------
	

	class CheckListRenderer extends JCheckBox implements ListCellRenderer {

		public CheckListRenderer() {
			setBackground(UIManager.getColor("List.textBackground"));
			setForeground(UIManager.getColor("List.textForeground"));
		}

		public Component getListCellRendererComponent(JList list, Object value,
				int index, boolean isSelected, boolean hasFocus) {
			setEnabled(list.isEnabled());
			setSelected(isSelected());
			setFont(list.getFont());
			setText(value.toString());
			return this;
		}
	}


}