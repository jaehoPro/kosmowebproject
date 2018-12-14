package kosmo.test;

import java.util.Scanner;

public class Ch04Loop {
	public static void main(String[] a)
	{
		//for(_s_,조건,_증감_){...}        횟수가 정해져 있을때
		//while(조건){...}			
		//do{...} while{조건}
		
		for(int dan=2; dan<10;dan++)
		{
			
			System.out.println("--"+dan+"단--");
			//System.out.println("2*"+dan+"="+2*dan);
			
			for(int j=1; j<10; j++)
			{
				System.out.print(dan+"*"+j+"="+dan*j+"\t");
				
			}
			
			System.out.print("\n");
  
			
				
		}
		
		for(int i=1; i<10; i++)
		{
			for(int j=2; j<10; j++)
			{
				System.out.print(j+"*"+i+"="+i*j+"\t");
			}
			System.out.println(" ");
		}
		
		
		
		
		/*for (int i=10; i>0; i--)
		{
			System.out.println(i);
			myprint();
		}
		
		String job = "SALES";
		int num = 3;
		while(job=="SALES")
		{
			System.out.println("true");
			num--;
			if(num==0)
				break;
		}*/
		
		int i, j;
		i= 2;
		j= 1;
		
		while(i<10)
		{
			
			System.out.println("While문 구구단"+i+"단");
			while(j<10)
			{
				System.out.print(i+"*"+j+"="+i*j+"\t");
				j++;
			}
			i++;
			j=1;
			System.out.print("\n\n");
		}
		i= 1; //곱해지는수
		j= 2; //단
		while(i<11)
		{
			if(i==1)
				System.out.print("Whiile문 구구단 시작합니다\n");
									
			while(j<10)
			{
				if(i==1)
					System.out.print(j+"단\t");
				else  
				{
					System.out.print(j+"*"+(i-1)+"="+j*(i-1)+"\t");
				}
				j++;
			}
			i++;
			j=2;
			System.out.print("\n");
		}

		
		
		for(i=0;i<5; i++)
		{
			for(j=0;j<=i;j++)
			{
				System.out.print("*");
				if(i==j)
				{
					System.out.print("\n");
				}
			}
		}
		int number=0;
		Scanner star = new Scanner(System.in);
		
		while(true)
		{
			System.out.print("몇 줄 출력할까요? :");
			number = star.nextInt();
			if(number ==0)
				break;
			number = number + 1;
			
			for(i=1; i<number; i++)
			{
				for(int k=number; k>i; k--)
				{
					System.out.print(" ");
				}
				for(j=0; j<(i*2)-1; j++)
				{
					System.out.print("*");
				}
				System.out.print("\n");
			}
		}
//		int sum=0;
//		int scannum=0;
//		String str = "";
//		
//		do
//		{
//			Scanner gg = new Scanner(System.in);
//			System.out.println("1에서 어떤숫자까지 더할까요?(0을 누르면 종료)");
//			scannum = gg.nextInt();
//			if(scannum==0)
//			{
//				System.out.println("종료합니다");
//				break;
//			}
//			for(i=1; i<=scannum; i++)
//			{
//				if(i==1)
//				{
//					str = str + i;
//				}
//				else
//				{
//					str = str + "+"+i;
//				}
//				sum=sum+i;
//			}
//			System.out.println(str+"="+sum);
//			sum=0;
//			str = "";
//		}while(scannum !=0);
				
		
		
/*		
		int gugudan = 0;
		do
		{
			System.out.println("출력할 구구단을 입력하세요:");
			Scanner s = new Scanner(System.in);
			gugudan=s.nextInt();
			System.out.println(gugudan+"단");
			for (i=1; i<10; i++)
			{
				System.out.println(gugudan+"*"+i+"="+gugudan*i);
			}
		
		}while(gugudan != 0);
		
*/		
		
		
	}// end of main
//	public static void myprint()
//	{
//		System.out.println(1);
//		System.out.println(2);
//		System.out.println(3);
//	}
//	
	
	
}
