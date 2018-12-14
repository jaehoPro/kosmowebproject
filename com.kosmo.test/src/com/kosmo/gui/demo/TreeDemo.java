package com.kosmo.gui.demo;


import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.UIManager;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

import java.net.URL;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class TreeDemo extends JPanel
implements TreeSelectionListener {
   private JEditorPane htmlPane;
   private JTree tree;
   //private static boolean playWithLineStyle = false;
   //private static String lineStyle = "Horizontal";
   //private static boolean useSystemLookAndFeel = false;

   JFrame frame;
   private JTextField textField;
   
   private int newNodeSuffix = 1;
   protected DefaultMutableTreeNode rootNode;
   protected DefaultTreeModel treeModel;
   private Toolkit toolkit = Toolkit.getDefaultToolkit();
   DefaultMutableTreeNode top;
   

   public static void main(String[] args) {
      //Schedule a job for the event dispatch thread:
      //creating and showing this application's GUI.
      javax.swing.SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            TreeDemo window = new TreeDemo();
            window.frame.pack();
            window.frame.setVisible(true);

         }
      });
   }




   public TreeDemo() {

      frame = new JFrame(); ////////////
      frame.setBounds(100, 100, 450, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      //Create the nodes.  
      //--------------------------------- 중요함
      top = new DefaultMutableTreeNode("KOSMO회사");
      createNodes(top);
      treeModel = new DefaultTreeModel(top);
      tree = new JTree(top);
      //---------------------------------- 노드생성


      //Create a tree that allows one selection at a time.

      tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

      //Listen for when the selection changes.
      tree.addTreeSelectionListener(this);

      //      if (playWithLineStyle) {
      //         tree.putClientProperty("JTree.lineStyle", "Horizontal");
      //      }

      //Create the scroll pane and add the tree to it. 
      JScrollPane topScroll = new JScrollPane(tree);

      //Create the HTML viewing pane.
      htmlPane = new JEditorPane();
      htmlPane.setEditable(false);
      /// initHelp(); 
      JScrollPane buttomScroll = new JScrollPane(htmlPane);
      buttomScroll.setPreferredSize(new Dimension(100,50));



      //Add the scroll panes to a split pane.
      JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
      splitPane.setTopComponent(topScroll);
      splitPane.setBottomComponent(buttomScroll);

      Dimension minimumSize = new Dimension(100, 50);
      buttomScroll.setMinimumSize(minimumSize);
      topScroll.setMinimumSize(minimumSize);
      splitPane.setDividerLocation(100); 
      splitPane.setPreferredSize(new Dimension(500, 300));

      //Add the split pane to this panel.
      frame.getContentPane().add(splitPane);
      
      JPanel panel = new JPanel();
      frame.getContentPane().add(panel, BorderLayout.NORTH);
      
      JButton add = new JButton("추가");
      add.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String name = textField.getText();
      		
      		DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("New-ID");
      		
//      		BookInfoVo vo = new BookInfoVo();
//      		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(vo.);
      		
      		DefaultMutableTreeNode parentNode = null;
            TreePath selectionPath = tree.getSelectionPath();
     
            if (selectionPath == null) {
                parentNode = top;
            } else {
                parentNode = (DefaultMutableTreeNode)
                             (selectionPath.getLastPathComponent());
            }
            
            if (parentNode == null) {
                parentNode = top;
            } else {
                parentNode = (DefaultMutableTreeNode)
                             (selectionPath.getLastPathComponent());
            }
      		
      		treeModel.insertNodeInto(newNode, parentNode, 
      				parentNode.getChildCount());
      		//addObject("New Node " + newNodeSuffix++);
      		//createNodes(name);
      		
//      		leafnode = new DefaultMutableTreeNode(new BookInfoVO
//      	            ("kim",
//      	                  "222"));
//      	      topsub1.add(leafnode);
      	}
      });
      
      textField = new JTextField();
      panel.add(textField);
      textField.setColumns(10);
      panel.add(add);
      
      JButton remove = new JButton("삭제");
      remove.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)
      	            tree.getLastSelectedPathComponent();
      		
      		treeModel.removeNodeFromParent(currentNode);
      	}
      });
      panel.add(remove);

   }


   //-------------------------------------------------- 
   @Override
   public void valueChanged(TreeSelectionEvent e) {
      DefaultMutableTreeNode node = (DefaultMutableTreeNode)
            tree.getLastSelectedPathComponent();

      if (node == null) return;


      //if (node.isLeaf()) {
      //BookInfoVO vo = (BookInfoVO)node.getUserObject();
      //htmlPane.setText(vo.getId()+","+vo.getPw());
      //} else {
      htmlPane.setText("선택 노드값:" + node.toString());

      //   }
   }

   //-------------------------------------------------------

   private class BookInfoVO {
      public String id;
      public String pw; // 책에대한 상세정보

      public BookInfoVO(String aaa, String bbb) {
         this.id = aaa;
         this.pw = bbb;
      }

      public String getId() {
         return id;
      }

      public void setId(String id) {
         this.id = id;
      }

      public String getPw() {
         return pw;
      }

      public void setPw(String pw) {
         this.pw = pw;
      }

      public String toString() {
         return this.id;
      }
   }

   //    private void initHelp() {
   //        String s = "TreeDemoHelp.html";
   //        helpURL = getClass().getResource(s);
   //        if (helpURL == null) {
   //            System.err.println("Couldn't open help file: " + s);
   //        } else if (DEBUG) {
   //            System.out.println("Help URL is " + helpURL);
   //        }
   // 
   //        displayURL(helpURL);
   //    }
   // 
   //   private void displayURL(URL url) {
   //      try {
   //         if (url != null) {
   //            htmlPane.setPage(url);
   //         } else { //null url
   //            htmlPane.setText("File Not Found");
   //            if (DEBUG) {
   //               System.out.println("Attempted to display a null URL.");
   //            }
   //         }
   //      } catch (IOException e) {
   //         System.err.println("Attempted to read a bad URL: " + url);
   //      }
   //   }

   private void createNodes(DefaultMutableTreeNode top) {
      DefaultMutableTreeNode category = null;
      DefaultMutableTreeNode leafnode = null;

      DefaultMutableTreeNode topsub1 = new DefaultMutableTreeNode("영업부");
      top.add(topsub1);

      //original Tutorial

      leafnode = new DefaultMutableTreeNode(new BookInfoVO
            ("park",
                  "000"));
      topsub1.add(leafnode);

      //Tutorial Continued
      leafnode = new DefaultMutableTreeNode(new BookInfoVO
            ("java",
                  "111"));
      topsub1.add(leafnode);

      //JFC Swing Tutorial
      leafnode = new DefaultMutableTreeNode(new BookInfoVO
            ("kim",
                  "222"));
      topsub1.add(leafnode);



      //----------------------------------------------------------------------------
      //2번째 카테고리 붙임

      DefaultMutableTreeNode topsub2 = new DefaultMutableTreeNode("개발부");
      top.add(topsub2);


      //VM
      leafnode = new DefaultMutableTreeNode(new BookInfoVO
            ("lee","111"));
      topsub2.add(leafnode);
      //----------------------------------------------------------------------
      

   }
   public DefaultMutableTreeNode addObject(Object child) {
       DefaultMutableTreeNode parentNode = null;
       TreePath parentPath = tree.getSelectionPath();

       if (parentPath == null) {
           parentNode = rootNode;
       } else {
           parentNode = (DefaultMutableTreeNode)
                        (parentPath.getLastPathComponent());
       }

       return addObject(parentNode, child, true);
   }

   public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
                                           Object child) {
       return addObject(parent, child, false);
   }

   public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
                                           Object child, 
                                           boolean shouldBeVisible) {
       DefaultMutableTreeNode childNode = 
               new DefaultMutableTreeNode(child);

       if (parent == null) {
           parent = rootNode;
       }
    
   //It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
       treeModel.insertNodeInto(childNode, parent, 
                                parent.getChildCount());

       //Make sure the user can see the lovely new node.
       if (shouldBeVisible) {
           tree.scrollPathToVisible(new TreePath(childNode.getPath()));
       }
       return childNode;
   }
}