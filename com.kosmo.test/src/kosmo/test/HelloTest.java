package kosmo.test;
//폴더(디렉토리)
// 18/07/26 18:20:00 아~~~일본어!!!!!!

/**
 * 이건 내가 <b>첫날<b> 만든 자바파일이다.<p>
 * 어쩌구 저쩌구
 * 어쩌구 저쩌구
 * 어쩌구 저쩌구
 * 어쩌구 저쩌구
 * @author jang.j.h
 *
 */
public class HelloTest {
//접근제어자
	static int allnum = 1000; // static은 바로 메모리에 적재됨.
	
	/**
	 * 
	 * @param xcdxc는 그냥 주는거.......
	 * 
	 */
	public static void main(String[] args) {           //static이 포함되면 메인메모리에 올라감
		//                  매개변수, 인자, 파라미터, (타입+변수)
		/*  ___0___ main(__1__ __2__)
		  0:리턴타입 int String void (리턴이 없다= 줄값이 없다)
		  
		  1:타입
		  2:파라미터명=변수(사용자 리네임)
	  */
		
		System.out.println("Hello");
		System.out.println(allnum);
		allnum = allnum-100;
		
	
		int res = add(2,3);
		System.out.println(res);
		// allnum, main, add 까지 메모리에 올라가있는 상태
		HelloTest aaa = new HelloTest();   // 		메모리에 올라감, 메모리에 직접 올리는 방법
		
		System.out.println(aaa);
		System.out.println(aaa.allnum);
		
		int res22 = aaa.add(55, 10);
		System.out.println(res22);;
		
		
	}
	//접근제어자 리턴타입 메서드명(파라미터 타입, 파라미터명)
	/**
	 * 해당함수의 두수를 받아~~~~~~~
	 * 해당함수의 두수를 받아~~~~~~~
	 * @param a는 숫자다
	 * @param b는 숫자다
	 * @return 두 수의 합을 준다
	 */
	public static int add(int a, int b)
	{
		return a + b;
		
	}
	/*메모리에 올리는 방법
	1. static
	2. new
	--------------------------*/
	
	
}
