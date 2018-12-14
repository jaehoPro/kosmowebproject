package kosmo.test;

import java.util.ArrayList;
import java.util.HashMap;

public class MethodCallTest {
//javac MethodCallTest.java 자바파일을 컴파일을 거치면 클래스 파일을 만들게 된다 
//      MethodCallTest.class
//java MethodCallTest
//오버로딩 : over loading 하나의 클래스 내에서 N개의 메서드 이름이 같고 매개변수의 타입이 다른것	


//	public static void print(String args)
//	{
//		System.out.println("dddd"+args);
//	}
//	
	public static void main(String[] args)
	{
		
		
//		MethodCallTest.print("3333");
		
		
		
		
//		int sum=0;
//		for(int i=0; i<args.length; i++)
//		{
//			sum += Integer.parseInt(args[i]);
//						
//		}
//		System.out.println(sum);
// 호출하는 방법
//		1.static static
//		2.클래스이름.메서드명
//		3.메서드명(내꺼)
		MethodCommon mc = new MethodCommon();
		System.out.println(mc.add(5, 4.4));
		
		
		int[] abc = {0,1};
		
		System.out.println(mc.getItem(abc));
		
		
		
		
		//맵과 리스트를 연결해서 많이 사용함.
		//The method put(Object, Object)
//-------------------------------------------------------------
		HashMap map = new HashMap();	//키값은 중복되면 안된다.
		map.put("key_name", "testtest");
		System.out.println("-----------getItembyMap");
		System.out.println(mc.getItembyMap(map));
		//배열		arr[0] = "aa";
		//			syso(arr[0]);
		//리스트 		list.add("aa")
		//			list.get("i")
		//셋			set.add("aa")
		//			iterator.next()
		//맵			map.put("key","aa")
		//			map.get("k")
//-------------------------------------------------------------
		System.out.println("-----------convertArrayToList");
		String[] test111 = {"aaa","bbb"};
		
		ArrayList list111 = new ArrayList();
		list111 = mc.convertArrayToList(test111);
		
		System.out.println("컨버팅 된 리스트의 길이는:"+list111.size());
		for(int i=0; i<list111.size(); i++)
		{
			System.out.println(list111.get(i));
		}
		System.out.println(list111);

//-------------------------------------------------------------
		System.out.println("-----------arraynext");
		int test2result;
		int[] arraytest2= {4,5,6,7,8};
		test2result=mc.arraynext(arraytest2, 4);
		System.out.println("다음 배열의 값은 :"+test2result);
//-------------------------------------------------------------
		
		System.out.println("-----------getpoint,getnation");
		int getint=mc.getpoint();
		String getstring=mc.getnation();
		
		System.out.println(getint);
		System.out.println(getstring);
//-------------------------------------------------------------
		System.out.println("-----------setpoint,setnation");		
		mc.setpoint(990);
		mc.setnation("jp");
		
		getint=mc.getpoint();
		getstring=mc.getnation();
		System.out.println(getint);
		System.out.println(getstring);
		
		String loginfo;
		loginfo=mc.login("abc", "def");
		System.out.println(loginfo);
		
//-------------------------------------------------------------		
		System.out.println("-----------getValueByMap");	
		String keyval;
		keyval=mc.getValueByMap("key_id");
		System.out.println(keyval);
		
		MethodCommon mc2 = new MethodCommon(2, "abc");
		keyval=mc2.getValueByMap("key_id");
		System.out.println(keyval);
	
		ArrayList listtest = new ArrayList();
		for(int i=0; i<6; i++)
		{
			listtest.add(i);
		}
		
		for(int i=0; i<listtest.size(); i++)
		{
			System.out.println(listtest.get(i));
		}
		int oddsum=0;
		oddsum=mc.oddAdd(listtest);
		System.out.println("훌수의 합은"+oddsum);
		


		String getage=mc.getAge("901130-1234567");
		System.out.println(getage);
		
		
	}
	
	

}
