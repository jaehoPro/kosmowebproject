package com.kosmo.gui.demo;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import kosmo.test.Ch99JDBCImpl;
import kosmo.test.EmpVO;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.FlowLayout;

public class TableSelectionDemo extends JPanel 
                                implements ActionListener { 
    private JTable table;
    private JCheckBox rowCheck;
    private JCheckBox columnCheck;
    private JCheckBox cellCheck;
    private ButtonGroup buttonGroup;
    private JTextArea outputTextArea;
    JFrame frame;
    private JTextField empno;
    private JTextField ename;
    private JTextField job;
    private JTextField deptno;
    private JButton add;
    private JButton Delete;
    private JButton Edit;
    
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	TableSelectionDemo window = new TableSelectionDemo();
                //window.frame.pack();
                window.frame.setVisible(true);
            }
        });
    }
    
    public TableSelectionDemo() {
       
    	 //Disable boldface controls.
        UIManager.put("swing.boldMetal", Boolean.FALSE); 

        //Create and set up the window.
        frame = new JFrame("TableSelectionDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 700, 600);
      
        //___.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        frame.getContentPane().setLayout(new BoxLayout
        		(frame.getContentPane(), BoxLayout.Y_AXIS));
        

        
        String[] columnNames = {"EMPNO",
                "ENAME",
                "JOB",
                "DEPTNO"};
//		Object[][] data = {  
//			{new Integer(7733),"SMITH","CLERK",new Integer(10)},
//			{new Integer(7788),"ALERN","MANAGER",new Integer(20)},
//			{new Integer(7799),"KING","PRESIDENT",new Integer(30)},
//		};
//        Vector<Object> vt = new Vector<Object>();
//        vt.addElement("");
//        vt.addElement("");
//        vt.addElement("");
//        vt.addElement("");'
//model.insertRow(i, list.get(i));
        
		DefaultTableModel model = new DefaultTableModel(null, columnNames);
		
		Ch99JDBCImpl impl = new Ch99JDBCImpl();
		ArrayList<Vector> list = impl.empListForSwing();
		for(int i=0; i<list.size(); i++)
		{
			model.insertRow(i, list.get(i));
		}
		
		//model.insertRow(0, vt);
		
        //table = new JTable(new MyTableModel());
		table = new JTable(model);
		table.addMouseListener(new TableListener());
//		table.addMouseListener(new MouseAdapter() {
//			@Override  addMouseListener
//			public void mouseClicked(MouseEvent e) {
//				
//			}
//		});
        table.setPreferredScrollableViewportSize(new Dimension(700, 70));
        table.setFillsViewportHeight(true);
        
//        table.getSelectionModel().addListSelectionListener(new TableListener());
//        table.getColumnModel().getSelectionModel().addListSelectionListener(new TableListener());
        frame.getContentPane().add(new JScrollPane(table));//여기담기

        //---라디오버튼------------------------------
        frame.getContentPane().add(new JLabel("Selection Mode"));//여기담기
        buttonGroup = new ButtonGroup();
        //addRadio("Multiple Interval Selection").setSelected(true);
        //addRadio("Single Selection");
        //addRadio("Single Interval Selection");
        
        JRadioButton b1 = new JRadioButton("Single Selection");
        b1.setSelected(true);
        b1.addActionListener(this);
        buttonGroup.add(b1);
        frame.getContentPane().add(b1);	
        
        JRadioButton b2 = new JRadioButton("Single Interval Selection");
        b2.addActionListener(this);
        buttonGroup.add(b2);
        frame.getContentPane().add(b2);	
        
        JRadioButton b3 = new JRadioButton("Multiple Interval Selection");
        b3.addActionListener(this);
        buttonGroup.add(b3);
        frame.getContentPane().add(b3);	
        
        
        //------체크박스---------------------------
        frame.getContentPane().add(new JLabel("Selection Options"));	//여기담기
        rowCheck = addCheckBox("Row Selection");
        rowCheck.setSelected(true);
        columnCheck = addCheckBox("Column Selection");
        cellCheck = addCheckBox("Cell Selection");
        cellCheck.setEnabled(false);

        outputTextArea = new JTextArea(5, 40);
        outputTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputTextArea);
        frame.getContentPane().add(scrollPane);		//여기담기
        
        JPanel panel = new JPanel();
        scrollPane.setColumnHeaderView(panel);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        empno = new JTextField();
        panel.add(empno);
        empno.setColumns(10);
        
        ename = new JTextField();
        panel.add(ename);
        ename.setColumns(10);
        
        job = new JTextField();
        panel.add(job);
        job.setColumns(10);
        
        deptno = new JTextField();
        panel.add(deptno);
        deptno.setColumns(10);
        
        add = new JButton("Add");
        add.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        		DefaultTableModel model = (DefaultTableModel)table.getModel();
        		
        		if(empno.getText().equals(""))
        		{
        			JOptionPane.showMessageDialog(null, "EMPNO는 필수 입력");
        			empno.grabFocus();
        			return;
        		}
        		
//        		Vector vt = new Vector();
//        		vt.addElement(empno.getText());
//        		vt.addElement(ename.getText());
//        		vt.addElement(job.getText());
//        		vt.addElement(deptno.getText());
//        		model.addRow(vt);
        		
        		
        		
        		Object[] obj = {empno.getText(),ename.getText(),job.getText(),deptno.getText()};
        		model.addRow(obj);
        		
        		
        		
        		
        		//================DB에서 입력=====================
        		EmpVO vo = new EmpVO();
        		vo.setEmpno(Integer.parseInt(empno.getText()));
        		vo.setEname(ename.getText());
        		vo.setJob(job.getText());
        		vo.setDeptno(Integer.parseInt(deptno.getText()));
        		
        		
           		
        		
        		Ch99JDBCImpl impl = new Ch99JDBCImpl();
        		impl.empInsertvoForSwing(vo);
        		
        		
        		        		
        		outputTextArea.append(ename.getText()+"님의 데이터 1건 입력\n");
        		empno.setText("");
        		ename.setText("");
        		job.setText("");
        		deptno.setText("");
        		

        	}
        });
        panel.add(add);
        
        Delete = new JButton("Delete");
        Delete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		DefaultTableModel model = (DefaultTableModel)table.getModel();
        		int rowIndex = table.getSelectedRow();
        		if(rowIndex <0)
        		{
        			return;
        		}
        		int result = 0;
        		result = JOptionPane.showConfirmDialog(null, "정말 삭제하겠습니까?");
        		// (result 리턴값)
        		// JOptionPane.YES_OPTION, JOptionPane.NO_OPTION,
        		// JOptionPane.CANCEL_OPTION 등
        		if(result == JOptionPane.YES_OPTION)//      0
        		{
        			outputTextArea.append(rowIndex+"번 데이터삭제\n");
        			model.removeRow(rowIndex);
        			//=======================db삭제
        			Ch99JDBCImpl impl = new Ch99JDBCImpl();
        			impl.empDeleteForSwing(Integer.parseInt(empno.getText()));
        			
        			//Integer.parseInt(model.getValueAt(rowIndex, 0).toString());
        		}
        		else		// 1, 2
        		{
        			outputTextArea.append("데이터삭제를 취소 했습니다.\n");
        			return ;
        		}
        		
        		
        		
        		

        		
        		
        	}
        });
        panel.add(Delete);
        
        Edit = new JButton("Edit");
        Edit.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		int rowIndex = table.getSelectedRow();
        		if(rowIndex <0)
        		{
        			return;
        		}
        		
        		table.getModel().setValueAt(empno.getText(), rowIndex, 0);
        		table.getModel().setValueAt(ename.getText(), rowIndex, 1);
        		table.getModel().setValueAt(job.getText(), rowIndex, 2);
        		table.getModel().setValueAt(deptno.getText(), rowIndex, 3);
        		
        		empno.setText("");
        		ename.setText("");
        		job.setText("");
        		deptno.setText("");
        	}
        });
        panel.add(Edit);
    }

    private JCheckBox addCheckBox(String text) {
        JCheckBox checkBox = new JCheckBox(text);	
        checkBox.addActionListener(this);
        frame.getContentPane().add(checkBox);		//여기담기
        return checkBox;
    }

//    private JRadioButton addRadio(String text) {
//        JRadioButton b = new JRadioButton(text);
//        b.addActionListener(this);
//        buttonGroup.add(b);
//        frame.getContentPane().add(b);	//여기담기
//        return b;
//    }

    
    
    
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        //Cell selection is disabled in Multiple Interval Selection
        //mode. The enabled state of cellCheck is a convenient flag
        //for this status.
        if ("Row Selection" == command) {
            table.setRowSelectionAllowed(rowCheck.isSelected());
            //In MIS mode, column selection allowed must be the
            //opposite of row selection allowed.
            if (!cellCheck.isEnabled()) {
                table.setColumnSelectionAllowed(!rowCheck.isSelected());
            }
        } else if ("Column Selection" == command) {
            table.setColumnSelectionAllowed(columnCheck.isSelected());
            //In MIS mode, row selection allowed must be the
            //opposite of column selection allowed.
            if (!cellCheck.isEnabled()) {
                table.setRowSelectionAllowed(!columnCheck.isSelected());
            }
        } else if ("Cell Selection" == command) {
            table.setCellSelectionEnabled(cellCheck.isSelected());
        } else if ("Multiple Interval Selection" == command) { 
            table.setSelectionMode(
                    ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
            //If cell selection is on, turn it off.
            if (cellCheck.isSelected()) {
                cellCheck.setSelected(false);
                table.setCellSelectionEnabled(false);
            }
            //And don't let it be turned back on.
            cellCheck.setEnabled(false);
        } else if ("Single Interval Selection" == command) {
            table.setSelectionMode(
                    ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            //Cell selection is ok in this mode.
            cellCheck.setEnabled(true);
        } else if ("Single Selection" == command) {
            table.setSelectionMode(
                    ListSelectionModel.SINGLE_SELECTION);
            //Cell selection is ok in this mode.
            cellCheck.setEnabled(true);
        }

        //Update checkboxes to reflect selection mode side effects.
        rowCheck.setSelected(table.getRowSelectionAllowed());
        columnCheck.setSelected(table.getColumnSelectionAllowed());
        if (cellCheck.isEnabled()) {
            cellCheck.setSelected(table.getCellSelectionEnabled());
        }
    }

//    private void outputSelection() {
//        outputTextArea.append(String.format("Lead: %d, %d. ",
//                    table.getSelectionModel().getLeadSelectionIndex(),
//                    table.getColumnModel().getSelectionModel().getLeadSelectionIndex()));
//        outputTextArea.append("Rows:");
//        for (int c : table.getSelectedRows()) {
//            outputTextArea.append(String.format(" %d", c));
//        }
//        outputTextArea.append(". Columns:");
//        for (int c : table.getSelectedColumns()) {
//            outputTextArea.append(String.format(" %d", c));
//        }
//        outputTextArea.append(".\n");
//    }

    private class TableListener implements MouseListener {
//	public void mouseClicked(MouseEvent e) {
    
    //implements ListSelectionListener {
        //public void valueChanged(ListSelectionEvent event) {
    	public void mouseClicked(MouseEvent event) {
//            if (event.getValueIsAdjusting()) {
//                return;
//            }
            outputTextArea.append(String.format("X,Y: %d, %d \t",
                    table.getSelectionModel().getLeadSelectionIndex(),
                    table.getColumnModel().getSelectionModel().getLeadSelectionIndex()));
	        //-------------------------------------------
            outputTextArea.append("Rows:");
	        int rowIndex=0;
	        for (int r : table.getSelectedRows()) {
	        	rowIndex = r;
	            outputTextArea.append(String.format(" %d \t", r));
	        }
	        //-------------------------------------------
	        outputTextArea.append("Col:");
	        int columnIndex = 0;
	        for (int c : table.getSelectedColumns()) {
	            outputTextArea.append(String.format(" %d \t", c));
	            columnIndex = c;
	        }
	        //-------------------------------------------
	        String selectedValue = table.getModel().getValueAt(rowIndex, columnIndex).toString();
	        outputTextArea.append(selectedValue + "\t");
	        
	        //-------------------------------------------

	        int csize = table.getModel().getColumnCount();
	        String allValue="";
	        for(int i=0; i<csize; i++) {
	        	allValue += table.getModel().getValueAt(rowIndex, i).toString()+", ";
    		}
	        
	        outputTextArea.append(allValue);
	        outputTextArea.append(".\n");
	        
	        
	        empno.setText(table.getModel().getValueAt(rowIndex, 0).toString());
	        
        	ename.setText(table.getModel().getValueAt(rowIndex, 1).toString());
           	job.setText(table.getModel().getValueAt(rowIndex, 2).toString());
          	deptno.setText(table.getModel().getValueAt(rowIndex, 3).toString());
	        
	        
	        
	      
	        
        }

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
    }

//    private class ColumnListener implements ListSelectionListener {
//        public void valueChanged(ListSelectionEvent event) {
//            if (event.getValueIsAdjusting()) {
//                return;
//            }
//            outputTextArea.append("COLUMN SELECTION EVENT. ");
//            outputSelection();
//        }
//    }

//    class MyTableModel extends AbstractTableModel {
//    	 String[] columnNames = {"EMPNO",
//                 "ENAME",
//                 "JOB",
//                 "DEPTNO"};
//		Object[][] data = {  
//			{new Integer(7733),"SMITH","CLERK",new Integer(10)},
//			{new Integer(7788),"ALERN","MANAGER",new Integer(20)},
//			{new Integer(7799),"KING","PRESIDENT",new Integer(30)},
//		};
//
//        public int getColumnCount() {
//            return columnNames.length;
//        }
//
//        public int getRowCount() {
//            return data.length;
//        }
//
//        public String getColumnName(int col) {
//            return columnNames[col];
//        }
//
//        public Object getValueAt(int row, int col) {
//            return data[row][col];
//        }
//
//        /*
//         * JTable uses this method to determine the default renderer/
//         * editor for each cell.  If we didn't implement this method,
//         * then the last column would contain text ("true"/"false"),
//         * rather than a check box.
//         */
//        public Class getColumnClass(int c) {
//            return getValueAt(0, c).getClass();
//        }
//
//        /*
//         * Don't need to implement this method unless your table's
//         * editable.
//         */
//        public boolean isCellEditable(int row, int col) {
//            //Note that the data/cell address is constant,
//            //no matter where the cell appears onscreen.
//            if (col < 2) {
//                return false;
//            } else {
//                return true;
//            }
//        }
//
//        /*
//         * Don't need to implement this method unless your table's
//         * data can change.
//         */
//        public void setValueAt(Object value, int row, int col) {
//            data[row][col] = value;
//            fireTableCellUpdated(row, col);
//        }
//
//    }

   

    
}