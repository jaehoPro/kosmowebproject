package kosmo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class MethodCommon {
	
	int point = 50000;
	String nation ="korea";
	
	HashMap map = new HashMap();
	
	//public MethodCommon(){}	<-자동으로 이구문을 컴파일 해줌
	
	//생성자 : 클래스 이름과 동일한 메서드
	//		: 리턴이 없다..void xxxx 2단구성
	//		: 컴파일러는 해당클래스 컴파일시 생성자가 단 한개도 없을경우 기본 생성자를 만들어준다
	// 초기에 메모리에 올라가는 초기값을 지정하기 위해 생성자를 사용
	
	//생성자(함수) =constructor :메모리에 올려놓는 함수
	//생성자가 하는일 :초기화 변수 초기값을 설정
	
	public MethodCommon()//기본생성자
	{
		map.put("key_id", "lee");
		map.put("key_pw", "123");
		map.put("key_name", "이씨");
	}
	public MethodCommon(int pt, String nn)//매개변수가 있는 생성자
	{
		map.put("key_id", "hong");
		map.put("key_pw", "1234");
		map.put("key_name", "홍씨");
	}


//접근제어자public	
	public double add(double a, double b)
	{
		return a+b;
	}
//int[]배열을 입력 받아 3번째 값을 리턴하는
	
	public int getItem(int[] a)
	{
		if(a.length >=3)
			return a[2];
		else
			return 0;
	}
	//hashmap을 파라미터로 받아
	//키값이 key_name인 값을 리턴
	///getitembymap메서드 생성
	public String getItembyMap(HashMap abc)
	{
		String name=(String)abc.get("key_name");
				
		return name; 
	}
	//문자열 배열을 파라미터로 받아
	//ArrayList로 변환해서 그 Arraylist리턴
	//메서드명 : convertArrayToList
	public ArrayList convertArrayToList(String[] a)
	{
		ArrayList list = new ArrayList();
		for(int i=0; i<a.length; i++)
		{
			list.add(a[i]);
		}
		return list;
	}
	//배열의 인덱스를 파라미터로 받아 그인덱스의 다음 데이터를 리턴하는 
	//NEXT메서드
	public int arraynext(int[] a, int b)
	{
		int imsi=0;
		if(b<a.length-1)
			imsi= a[b+1];
		else
			imsi = -1;
		
		return imsi;
		
	}
	// 전역변수값 리턴
	public int getpoint()
	{
		return this.point;	//static 안에서는 this를 사용하지 못한다 언제new될지 모르기 때문에
	}
	public String getnation()
	{
		return this.nation;
	}
	//입력받은 파라미터 값을 전역변수에 넣는, set변수명 메서드 생성
	public void setpoint(int a)
	{
		this.point = a;
	}
	public void setnation(String abc)
	{
		this.nation = abc;
	}
	//private 해당클래스 안에서만 사용 =캡슐화             이유: 외부로 부터 보호하기 위해
	
	//아이디. 비밀번호를 입력받아,  이름을 리턴하는(하드코딩), login메서드 생성
	public String login(String a, String b)
	{
		String id="abc";
		String password="def";
		String name=null;
		if(a==id && b==password)
		{
			name = "홍길동";
		}
		else
		{
			name = "검색된회원이 없습니다";
		}
	
		return name;
	}
	//맵의 키값을 파라미터로 받아 그값을 리턴하는 getValueBymap 메서드 생성
	
	public String getValueByMap(String a)
	{
		String imsi;
		imsi =(String)this.map.get(a);
		
				
		return imsi;
	}
//	파라미터 : ArrayList
//	리턴 :  홀수합
//	메서드 : oddAdd
	public int oddAdd(ArrayList abc)
	{
		int sum=0;
		for(int i=0; i<abc.size(); i++)
		{
			if(((int)abc.get(i))%2==1)
			{
				sum+=(int)abc.get(i);
			}
		}
		return sum;
	}
	public String getAge(String jumin)
	{
		String gender = "";
		int year=0;

		String[] arr = jumin.split("-");
		
		year=Integer.valueOf(arr[0].substring(0, 2));
		gender=Integer.toString(118-year);
		if((int)arr[1].charAt(0)==1)
		{
			gender+="살 남자";
		}
		else
			gender+="살 여자";
		return gender;
	}
	
	
}
