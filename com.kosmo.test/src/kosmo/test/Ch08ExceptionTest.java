package kosmo.test;
//예외처리란 : 코드를 끝까지 수행하기 위해서 발생된 예외를 처리해 주는 것 
//try{} xxxx
//try{} catch{}
//try{} catch{}finally{}
//try{}        finally{} : 문법적으로 이상 없으나 의미없음

public class Ch08ExceptionTest {

	public static void main(String[] args) {
		int[] arr = new int[2];
		
		try
		{
			int res ;
		}
//catch{} exception 은 작은타입 --> 큰타입으로 적어라
		catch(Exception aa)
		{
			System.out.println("산술적 예외 발생 잡았다");
		}


		
		System.out.println("1");
		//하나의 메서드에서 try{}catch{} 여러번 사용가능
		try 
		{
			System.out.println(arr[2]);
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("catch:잡았다");
//			System.out.println(e.getMessage());
//			System.out.println(e.getCause());
//			System.out.println(e.getClass());
			
//			e.printStackTrace();
		}
		finally//예외발생 여부와 관계 없이 해당블럭은 실행
		{
			System.out.println("무조건실행");
		}
		
		System.out.println("2");
		System.out.println("3");

	}
	

}
