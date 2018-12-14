package kosmo.test;

public class Ch08ThrowsTest {

	public static void main(String[] args) {
		System.out.println(1);
		try {
			myPrint();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(2);
		}
		
		System.out.println(3);

	}
	
	public static void myPrint() throws Exception{
		System.out.println("myprint1");
		int res = 10/0;
		System.out.println("myprint22");
	}

}

