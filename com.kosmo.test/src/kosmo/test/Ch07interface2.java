package kosmo.test;

public interface Ch07interface2 {
	//상수만 올수 있다.
	//모든 변수에 public final static 키워드가 붙는다.
	final int NUM = 100;	//상수임을 명확하게 표기 대문자로 표시
	
	//final 붙이나 안붙이나 똑같이 상수
	//모든 메서드는 추상 메서드(바디가 없는)메서드이어야 한다.
	//public void myPrint() {}  // 에러
	//모든메서드에 public abstract키워드가 붙는다.
	public void myPrint();
	public abstract int sendEmail(String email);

}
