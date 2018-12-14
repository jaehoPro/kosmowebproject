package kosmo.test;


//클래스 안에는 변수, 메서드 들이 올 수 있다.
public class Ch02Var {
	//static변수
	
	//전역변수-전역변수는 초기화 하지 않으면 기본값으로 초기화된다. 문자: 널, 숫자: 0
	static int point;  // static 변수 = 클래스 변수
	int point2;			// 인스턴스 변수   인스턴스 : 메모리에 올라가서 주소를 갖는 것, 
                        //            인스턴스화 : 주소를 만든다(명령어:new)
	
	//일반변수는 new해서 메모리에 올려놓고 사용
	
	public static void main(String[] args) {
		
		System.out.println(point);
		
		
		Ch02Var v = new Ch02Var();
		System.out.println(v.point2);
		
		
		int b; //변수선언
		//지역변수는 반드시 초기화(최초로 값을 넣는것) 초기화를 하지 않으면 에러
		int a = 4;  // 선언과 동시에 초기화
		
		System.out.println(a);
		
		
		a = 7; //값을 재할당
		
			//암기!!!
			// 기본(primitive)타입 : 8개
			// 참조(reference)타입 : 주소값 4byte
		
		boolean bool = false;
		char c = 'c';
		byte bt =127; // 2^7 -1
		
		short s = 32767;
		int i = 25000;
		long l = 5200000;
		
		float f = 3.0f;  //리터럴
		double d = 5.0d; 
		double dnum = 4.0;//d는 생략가능
		
		String aa = "hello";
		System.out.println(aa);
		// 상수 : final이 붙은 변수 , 상수는 대문자를 허용 ;상수는 대문자로 작성권고
		
		
		//메서드 안에서는 Static 선언 사용불가	
		final int NOT_EDIT_NUM = 500;
		System.out.println(NOT_EDIT_NUM);
		
		String str1 = null;
		String str2 = "";
		String str3 = " ";
		
		int h = 100;
		int z = 50;
		System.out.println(str3+h+z);
		
		//int보다 작은 크기의 타입들을 더하면 결과는 int
		char calph = 'A';
		System.out.println(calph);
		System.out.println(calph+1);
		System.out.println((char)(calph+1)); // 캐스팅:형변환(바꾸고 싶은 타입)
		
		char ic = '\u0000';
		System.out.println(ic);
		
		//클래스 변수는 클래스 이름으로 써도 된다.
		// 글자체가 기울어 진것 =static변수
		
		// 기본타입 8개중 boolean을 제외한 나머지는 캐스팅 가능
		// 참조 타입 <--> 기본타입 캐스팅 불가
		// 참조 타입 <--> 기본타입 Wrapper클래스 사용
		int pint = Integer.parseInt("115");
		//int pint = 115;
		
		System.out.println(pint);
		
		
		Boolean bw;
		//Boolean.parseBoolean("true")
		Character cw;
		
		Byte btw;
		Short sw;
		Short.parseShort("14");
		
		Integer it;
		Long lw;
		Float fw;
		Double dw;
		Double dp = Double.parseDouble("3.4");
		
		//레퍼런스 타입은 그냥 캐스팅 할수 없다 레퍼런스타입을 기본타입하고 바꿀때는 함수 사용
		System.out.println('J'+"ava");//string은 뭘 더해도 string
		//모든 예약어는 소문자로 시작 예약어는 사용하면 안됨.
		//변수는 숫자로 시작하면 안된다.
		//참조형 변수 4바이트 int float
		byte aaa= 10;
		byte bbb= 20;
		byte ccc = (byte)(aaa+bbb);  //byte는 127까지 담을수 있다
		
		double drivres = 10f/8;         //꼭제출
		double pi = 3.14d;
		char chara = ' ';
		System.out.println("----------"+ccc);
		System.out.println("----------"+pi);
		
		int n1 = 100000;
		int n2 = 200000;
		long nres = n1 * n2;
		System.out.println(nres);
		
		int tot = 80;
		String totres = (tot>90)?"크다":"작다";
				//decode(tot,90,'같다','다르다')
		
		
		System.out.println(totres);
		
		int score = 80;
		char cres = (score>90)?'A':(score>80)?'B':'c';
		System.out.println(cres);
		
		System.out.println(drivres);
		
		
		String[] teststring = new String[2];
		
		teststring[0]= "abcda";
		System.out.println(teststring[0]);
		
		
	}


	
}
