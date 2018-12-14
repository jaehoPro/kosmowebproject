package kosmo.test;

import java.util.ArrayList;

public class Ch11PropertyTest {
//  <> 무엇을 담을지 미리 알려주는것 
	public static void main(String[] args) {
		ArrayList<Membervo> list = new ArrayList<Membervo>();
			
		Membervo mvo = new Membervo();
		mvo.setMseq(1);
		mvo.setMid("lee");
		mvo.setMpw("111");
		mvo.setMname("이씨");
		mvo.setMgubun("u");		
		list.add(mvo);
		
		Membervo mvo2 = new Membervo();
		mvo2.setMseq(2);
		mvo2.setMid("lee2");
		mvo2.setMpw("1112");
		mvo2.setMname("이씨2");
		mvo2.setMgubun("u");
		list.add(mvo2);
		
		
		
		for(int i=0; i<list.size(); i++)
		{
			//Membervo vo = (Membervo)list.get(i);
			
//			System.out.println(vo.getMseq()+"\t");
//			System.out.println(vo.getMid()+"\t");
//			System.out.println(vo.getMpw()+"\t");
//			System.out.println(vo.getMgubun()+"\t");
			System.out.println(list.get(i).getMseq()+"\t");
			System.out.println(list.get(i).getMid()+"\t");
			System.out.println(list.get(i).getMpw()+"\t");
			System.out.println(list.get(i).getMgubun()+"\t");
			
		}
		
		

	}

}
