package kosmo.test;

import java.io.IOException;

public class Ch9lang {
	
	static int num = 10; //변수가 기울어져 있으면  static
	//클래스 변수 이름으로도 쓸수 있다.

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sss = "hellobye";
		sss.length();
		sss.charAt(2);
		
		System.out.println(sss.substring(1, 4));
		System.out.println(sss.concat("dear"));
		System.out.println(sss.indexOf("l"));
		System.out.println(sss.lastIndexOf("l"));
		System.out.println(sss.replace("l", "**"));
		
		String[] aa = sss.split("o");
		System.out.println(aa[1]);
		System.out.println(sss.toUpperCase());
		System.out.println(sss.trim()); //앞뒤 공백제거
		
		
		Ch9lang lang = new Ch9lang();
		String str1 = "abc";
		String str2 = "abc";
		//표현은 같은 표현이지만 메모리를 관리하는 방법이 다르다
		String str3 = new String("abc");
		String str4 = new String("abc");
		//3번과 4번은 주소가 다르다
		
		if(str1.equals(str4))
		//if(str1 == str2)	//주소비교
		{
			System.out.println("같다");
		}
		else
			System.out.println("다르다");
		
		System.out.println(str3);
		
		
		int a = 10;
		String astr = a+"";
		System.out.println(astr+10);
		
		String cname = new Ch9lang().getClass().toString();
		System.out.println(cname);
		
		StringBuffer sb = new StringBuffer("abc");
		//내부적으로 버퍼영역을 만듬:메모리 누수가 없다
		sb.append("d");
		System.out.println(sb);
		
		for(int i=0; i<10; i++)
		{
			sb.append(i);
		}
		
		String res = sb.toString();
		
		try {
			int aaa = System.in.read();
			System.out.println(aaa);
		} catch (IOException e) {
			System.out.println("에러가났어요");
			e.printStackTrace();
		}
		
	}

}
