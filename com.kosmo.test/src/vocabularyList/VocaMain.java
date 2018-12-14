package vocabularyList;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;

import com.kosmo.gui.switc.BFrame;

import kosmo.test.Ch99JDBCImpl;

public class VocaMain extends JPanel
                      implements ListSelectionListener {
    private JList list;
    private DefaultListModel listModel;
    
    private static final String hireString = "Hire";
    private static final String fireString = "Fire";
    private JButton del_btn;
    private JTextField vocaNameinput;
    private JFrame frame;
    private JButton open_btn;
    VocaMain addr;
    
    VO selectedVocaVO;
    
    ArrayList<VO> booklist;			//단어장 목록이 저장(NOTEBOOK TABLE)
    JScrollPane listScrollPane;
    
//
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VocaMain window = new VocaMain();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
   
 
    public VocaMain() {
    	frame = new JFrame();
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("단어장 목록");			
        
//############### 아래 코드들을 frame.getContentPane()로 대신한다
//        //Create and set up the content pane.
//        JComponent newContentPane = new ListDemo();
//        newContentPane.setOpaque(true); //content panes must be opaque
//        frame.setContentPane(newContentPane);
		
		
		JDBC db = new JDBC();
		
		booklist = db.bookList(); //단어장 목록을 불러옴
		
 
        listModel = new DefaultListModel();
        
        for(int i=0; i<booklist.size(); i++)
		{
			listModel.add(i, booklist.get(i).getBook_name()+"  ("+booklist.get(i).getVoca_count()+")");
			
			if(i==0)
			{
				selectedVocaVO = booklist.get(i);
			}
		}
        
        
 
        //Create the list and put it in a scroll pane.
        list = new JList(listModel);
        
        
        
        list.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		     		

        		selectedVocaVO = booklist.get(list.getSelectedIndex());
        		System.out.println(selectedVocaVO.getBook_num());
        		System.out.println(selectedVocaVO.getBook_name());
//        		
        	}
        });
        
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
        listScrollPane = new JScrollPane(list);

//############### frame에 add하는 방법이 다르다         
//                             add(listScrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(listScrollPane, BorderLayout.CENTER);
       
        
        //------------------------------------------------------------------------
        JButton add_btn = new JButton("추가");
        HireListener hireListener = new HireListener(add_btn);
        add_btn.setActionCommand(hireString);
        add_btn.addActionListener(hireListener);
        add_btn.setEnabled(false);
        
 
        del_btn = new JButton("삭제");
        del_btn.setActionCommand(fireString);
        del_btn.addActionListener(new FireListener());
 
        vocaNameinput = new JTextField(8);
        vocaNameinput.addActionListener(hireListener);
        vocaNameinput.getDocument().addDocumentListener(hireListener);
        String name = listModel.getElementAt(
                              list.getSelectedIndex()).toString();
 
        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,
                                           BoxLayout.LINE_AXIS));
        buttonPane.add(del_btn);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(vocaNameinput);
        buttonPane.add(add_btn);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

//############### frame에 add하는 방법이 다르다
//                             add(buttonPane, BorderLayout.PAGE_END);
        frame.getContentPane().add(buttonPane, BorderLayout.PAGE_END);
        
        
        
        open_btn = new JButton("열기");
        open_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		selectedVocaVO = booklist.get(list.getSelectedIndex());
        		VocaMenu window = new VocaMenu(selectedVocaVO);
        		
				  // 주소전달 해야함
				
        	}
        });
        buttonPane.add(open_btn);
        
        
//############### 여기에 넣거나 main()에 넣는다      
//        frame.pack();
//        frame.setVisible(true);
        
    }
 
    //버튼 이벤트들 ------------------------------------------
    class FireListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {			
            //This method can be called only if
            //there's a valid selection
            //so go ahead and remove whatever's selected.
        	
            
        	int index = list.getSelectedIndex();
            int result = 0;
            
            if(selectedVocaVO.getVoca_count()==0)		// 단어장이 비었으면
            {
            	result = JOptionPane.showConfirmDialog(null,selectedVocaVO.getBook_name()+"단어장을 정말 삭제하겠습니까?");
            }
            else										//단어장에 단어가 들어있으면
            {
            	result = JOptionPane.showConfirmDialog(null,selectedVocaVO.getBook_name()+"단어장의 단어("+selectedVocaVO.getVoca_count()+"개) 까지 모두 삭제하시겠습니까?");
            }
        		// (result 리턴값)
        		// JOptionPane.YES_OPTION, JOptionPane.NO_OPTION,
        		// JOptionPane.CANCEL_OPTION 등
    		if(result == JOptionPane.YES_OPTION)//      0
    		{
    			
    			//=======================db삭제
    			JDBC jdbc = new JDBC();
                listModel.remove(index);			//삭제하는 구문
                jdbc.bookDelete(selectedVocaVO.getBook_num(),selectedVocaVO.getVoca_count());
    			
    			//Integer.parseInt(model.getValueAt(rowIndex, 0).toString());
    		}
    		else		// 1, 2
    		{
    			//outputTextArea.append("데이터삭제를 취소 했습니다.\n");
    			return ;
    		}
            
    		
    		listReload();			// 단어장 목록을 다시 불러 오는 메서드

        }
    }
    
    //This listener is shared by the text field and the hire button.
    class HireListener implements ActionListener, DocumentListener {
        private boolean alreadyEnabled = false;
        private JButton button;
 
        public HireListener(JButton button) {
            this.button = button;
        }
 
        //Required by ActionListener.
        public void actionPerformed(ActionEvent e) {
        	
        	JDBC jdbc = new JDBC();
            String name = vocaNameinput.getText();
 
            //이름이 공백이거나 이미 존재하면 
            if (name.equals("") || alreadyInList(name)) {
                Toolkit.getDefaultToolkit().beep();
                vocaNameinput.requestFocusInWindow();
                vocaNameinput.selectAll();
                return;
            }
 
            int index = list.getSelectedIndex(); //get selected index
            if (index == -1) { //no selection, so insert at beginning
                index = 0;
            } else {           //add after the selected item
                index++;
            }
            
            
            if(jdbc.bookAdd(name)==1)
            {
            
            	JOptionPane.showMessageDialog(null, "단어장을 추가하였습니다.");
	            //listModel.insertElementAt(vocaNameinput.getText(), index);		//리스트에 삽입하는 구문
	            //If we just wanted to add to the end, we'd do this:
	            //listModel.addElement(employeeName.getText());
	 
	            //Reset the text field.
            	
            	
	            vocaNameinput.requestFocusInWindow();
	            vocaNameinput.setText("");
	 
//	            //Select the new item and make it visible.
//	            list.setSelectedIndex(index);
//	            list.ensureIndexIsVisible(index);
	          
	           
	            
	            listReload();			// 단어장 목록을 다시 불러 오는 메서드
	            
	            
	            
            }
            
        }
 
        
        //This method tests for string equality. You could certainly
        //get more sophisticated about the algorithm.  For example,
        //you might want to ignore white space and capitalization.
        protected boolean alreadyInList(String name) {
            return listModel.contains(name);
        }
 
        //Required by DocumentListener.
        public void insertUpdate(DocumentEvent e) {
            enableButton();
        }
 
        //Required by DocumentListener.
        public void removeUpdate(DocumentEvent e) {
            handleEmptyTextField(e);
        }
 
        //Required by DocumentListener.
        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyTextField(e)) {
                enableButton();
            }
        }
 
        private void enableButton() {
            if (!alreadyEnabled) {
                button.setEnabled(true);
            }
        }
 
        private boolean handleEmptyTextField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                button.setEnabled(false);
                alreadyEnabled = false;
                return true;
            }
            return false;
        }
    }

    //리스트 선택 이벤트 ------------------------------------------
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
 
            if (list.getSelectedIndex() == -1) {
            //No selection, disable fire button.
                del_btn.setEnabled(false);
 
            } else {
            //Selection, enable the fire button.
                del_btn.setEnabled(true);
            }
        }
    }
    
    public void listReload()
    {
    	JDBC jdbc = new JDBC();
    	booklist = jdbc.bookList();				//단어장 목록 불러오기
        
        
        listModel = (DefaultListModel)list.getModel();
        listModel.removeAllElements();
        
        
        for(int i=0; i<booklist.size(); i++)
		{
        	listModel.add(i, booklist.get(i).getBook_name()+"  ("+booklist.get(i).getVoca_count()+")");
			
			System.out.println(booklist.get(i).getBook_num()+"  "+booklist.get(i).getBook_name());
		}
        
        list.setModel(listModel);
        
        list.revalidate();
    }
    
   
}