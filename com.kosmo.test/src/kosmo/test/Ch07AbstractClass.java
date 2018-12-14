package kosmo.test;
//추상클래스 : 추상메서드(바디가 없는 메서드)를 가질 수도 있다.
//인스턴스(주소)를 생성할 수 없고 상속에 의해서만 메서드/변수 사용 가능
//자식클래스는 반드시 추상메서드를 구현해야한다.
//자식클래스가 추상클래스 이면 추상메서드를 구현하지 않아도 된다.
 //(둘다 추상메서드 이기 때문에 강제성이 없음)
public abstract class Ch07AbstractClass {
	
	//추상 메서드 : 바디가 없는 메서드
	public abstract void absFunc();
	
	public abstract void logWrite();
	
	public abstract void sms();
	
	
	public boolean ipinCheck(String pinNo)
	{
		//500
		return true;
	}
//	public static void main(String[] args)
//	{
//		
//	}

}
