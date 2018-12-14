package com.kosmo.gui.demo;
import javax.swing.*;
import java.util.*; // java.util.Vector;
public class JListTest extends JFrame{
	String[] str={"HTML", "XML", "C", "C++", "자바", "오라클", "COM"};
	Vector vec;
	JList list ; 

	public JListTest(){     

		vec  = new Vector( );  
		list = new JList( );  

		//벡터에 배열에 있는 요소(element)를 추가
		for(int i = 0 ; i < str.length ; i++){   
			vec.addElement(str[i]);
		}

		//JList 컴포넌트에 직접 Item을 추가 할 수 없기 때문에
		// 벡터 객체에 Item을 담아서 추가함.
		
		
		list.setListData(vec);  
		add(new JLabel("리스트 박스 연습"), "North");
		//리스트에 Item이 많을 경우 자동으로 스크롤바가 나타나도록 하려면 
		// JScrollPane클래스의 생성자에 JList의 객체 변수를 넣어 JScrollPane객체를 
		// 생성하여 프레임에 부착함.
		add(new JScrollPane(list), "Center");

		list.setSelectedIndex(4); //index 4번인 자바가  선택되어서 출력됨. 

		setSize(300, 150);  
		setVisible(true); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	} // 생성자 end
	public static void main(String [] args){
		JListTest jf = new JListTest();
	}
}