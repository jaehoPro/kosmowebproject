package kosmo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Ch11Collection {

	public static void main(String[] args) {
		
				
		int[] numarr = {1,2,3};
		Ch02Var chvar = new Ch02Var();
		
		ArrayList list = new ArrayList();//대문자로 시작 타 클래스
		//Object[] arr = new Object[24];
		//Object aaa = new Object;
				
		
		
		list.add("aa");
		list.add("bb");
		list.add(11);
		list.add(numarr);
		list.add(chvar);
		
		for(int i=0; i<list.size(); i++)
		{
			System.out.println("-----------"+list.get(i));
			
		}
		
		int[] arr = (int[])list.get(3);
		System.out.println(arr.length);
		
		
		Ch02Var a = (Ch02Var)list.get(4);
		System.out.println(a.point);
		//Ch02Var rrr = (Ch02Var)arr[4]
		
		String b = (String)list.get(0);
		System.out.println(b);
		
		int ccc = (int)list.get(2);
		System.out.println(ccc);
		
		////////////////////////////////
		
		HashSet set = new HashSet();// distinct와 같다
		
		set.add("1");
		set.add("3");
		set.add("2");
		set.add("2");
		
		System.out.println("set값전체 출력"+set);
		
		Iterator it = set.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		////////////////////////////////////////////
		HashMap map = new HashMap();	//키값은 중복되면 안된다.
		
		//맵과 리스트를 연결해서 많이 사용함.
		
		//The method put(Object, Object)
		map.put("name", "lkh");
		map.put("age",20);
		map.put("arr", numarr);
		map.put("cls", chvar);
		
		String mres1 = (String)map.get("name");
		int mres2 =(int)map.get("age");
		System.out.println("mres1값은"+mres1);
		
		for(int i=0; i<map.size(); i++)
		{
			System.out.println(map.size());
		}
		//배열		arr[0] = "aa";
		//			syso(arr[0]);
		//리스트 		list.add("aa")
		//			list.get("i")
		//셋			set.add("aa")
		//			iterator.next()
		//맵			map.put("key","aa")
		//			map.get("k")
		ArrayList<HashMap<String, Object>> mlist = new ArrayList<HashMap<String, Object>>();
		
		
		for(int i=0; i<2; i++)
		{
			HashMap<String,Object> map1 = new HashMap<String,Object>();
			map1.put("name", "lee"+i);
			map1.put("age", i+10);
			mlist.add(map1);
		
		}
		
		System.out.println("총회원수"+mlist.size());
		
		
		
		//HashMap hm = new HashMap();
		
		for(int i=0; i<mlist.size(); i++)
		{
//			hm = (HashMap)mlist.get(i);
			
//			System.out.println(i+1+"번 회원의 이름:"+hm.get("name")+",나이 :"+hm.get("age"));
			System.out.println(i+1+"번 회원의 이름:"+mlist.get(i).get("name")+",나이 :"+mlist.get(i).get("age"));
//			System.out.println(mlist.get(i));
			
		}
					
			
		

	}

}
