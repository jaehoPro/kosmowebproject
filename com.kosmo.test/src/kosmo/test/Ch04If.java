package kosmo.test;

public class Ch04If {

	public static void main(String[] args) {
		// empno=7733 and 
		int empno = 7733;
		int sal =2000;
		if(empno==7733 && sal>2000)
		{
			System.out.println("조건을 만족합니다");
		}else
		{
			System.out.println("false");
		}
		
		int deptno = 11;
		
		if(deptno == 10)
		{
			System.out.println("10번부서");
		}
		else if(deptno == 20)
		{
			System.out.println("20번부서");
		}
		else if(deptno == 30)
		{
			System.out.println("30번부서");
		}
		else
		{
			System.out.println("해당없음");
		}
		
		
		switch(deptno)
		{
			case 10:case 11:
				System.out.println("11");
		//		break;
			case 20:
				System.out.println("20");
				break;
			default:
				System.out.println("해당없음");
		}
		for(int i=1; i<1000; i++)
		{
			System.out.print(i+" ");
			if(i%10 == 6)
			{
				System.out.print("\n");
				i += 4;
			}
		}
	}
	
}
