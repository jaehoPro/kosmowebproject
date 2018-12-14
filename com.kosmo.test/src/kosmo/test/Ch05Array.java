package kosmo.test;

import java.util.ArrayList;

import org.omg.Messaging.SyncScopeHelper;

public class Ch05Array {
	
	public static void main(String[] args)
	{
		//타입 [] 변수 = new 타입[];
		//java name 최대 38글자
		//번째 : 인덱스
		
		int[] numArr = new int[5];
		//System.out.println(numArr[4]);
		
		
		int[] numArr2 = new int[] {10,20,30};	//배열을 생성과 동시에 초기화
		int[] numArr3 = {10,20,30};
		
		
		int[] numArr5 = new int[5];//
		numArr5[0] = 10;
		numArr5[1] = 20;
		numArr5[2] = 30;
		
		HelloTest[] h = new HelloTest[3]; 
		
		Ch02Var[] carr= new Ch02Var[3];
		
		Ch02Var c1 = new Ch02Var();
		Ch02Var c2 = new Ch02Var();
		Ch02Var c3 = new Ch02Var();
		//문법주의() <---빼고
		//Ch02var[] carr= new Ch02var()[3];         시험
		
//		System.out.println(c1.point);  //전역변수
//		c1.point = 5000;
//		
//		System.out.println(c2.point);
//		
//		String[] strarry = new String[]{"aa", "bb"};
//		
//		
//		System.out.println(strarry[0]+strarry[1]);		
//		
//		
//		char[] chararry = new char[] {'a','b','c','d'};
//		
//		System.out.println(chararry[1]);
		
		int[] dan = new int[] {1,2,3,4,5};
		
				
		for(int i=0; i<3; i++)
		{
			System.out.println(dan[i+2]);
		}
		
		int[] stu = {100,80,90,91};
		int sum = 0;
		
		for(int i=0; i<stu.length; i++)
		{
			sum +=stu[i];
			
		}
		System.out.println("총합은 "+sum+"입니다");
		System.out.println("평균은"+(double)sum/stu.length+"입니다");
			
		
		String aaa = "ABCDE";
		
		for(int i=0; i<aaa.length();i++)
			System.out.println(aaa.charAt(i));
		
		char[] eqstrs = aaa.toCharArray();
		System.out.println(eqstrs);	//char은 주소를 반환하는 것이 아니고 값을 반환
		
		//astr2[0] ={"abcdc"}  배열값을 넣을 수는 없다
	
		int[][] stuscore = new int [][] {{100,90,80,1,2},
										{88,87,86,1,2},
										{44,47,49,1,2}};
										
										
		int[][] result = new int[stuscore.length+1][stuscore[0].length+1];
		int cols=0;
		int colssum=0;
		int lows=0;
		int lowssum=0;
										
		for (int i=0; i<stuscore.length; i++)//3
		{
			for(int j=0; j< stuscore[0].length; j++)//5
			{
				result[i][j]= stuscore[i][j];
				cols +=stuscore[i][j];
			}
			result[i][stuscore[0].length]=cols;
			colssum = colssum + cols;
			cols =0;
		}
		result[stuscore.length][stuscore[0].length]=colssum;
		
		for (int i=0; i<stuscore[0].length; i++)//5
		{
			for(int j=0; j< stuscore.length; j++)//3
			{
				lows = lows + stuscore[j][i];
			}
		
			result[stuscore.length][i]=lows;
			lows = 0;
		}
		
		for(int i=0; i<result.length; i++)
		{
			for(int j=0; j<result[i].length; j++)
			{
				System.out.print(result[i][j]+"\t");
			}
			System.out.print("\n");
		}
		
		

		
		
		
		
//		int sum2=0, percount=0;
//		 
//		for (int i=0; i < stuscore.length; i++)
//		{
//			for (int j=0; j<stuscore[i].length; j++)
//			{
//				sum2 += stuscore[i][j];
//			
//			}
//			System.out.println(i+1+"번째 학생 평균값은 :"+(double)sum2/stuscore[i].length );
//			
//			sum2 = 0;
//				
//		}
//		for (int i=0; i < stuscore[0].length; i++)
//		{
//			for (int j=0; j<stuscore.length; j++)
//			{
//				percount += stuscore[j][i];
//			}
//			System.out.println(i+1+"각회차별 평균 값은 :"+(double)percount/stuscore.length);
//			percount = 0;
//				
//		} 
//		
//		int[] answer = {1,4,4,3,1,4,4,2,1,3,2};
//	
//		for (int i=0; i<answer.length; i++)
//		{	
//			System.out.print(answer[i]+":");
//			for(int j=0; j<answer[i]; j++)
//			{
//				System.out.print("*");			
//			}
//			System.out.print("\n");
//		}
				
				
		String[] astr2 = new String[1];
		String[] oarr = new String[]{"ABC"};
//		astr2[0] = {"ABC"};

//--------------------------------------------
//		String[] astr = new String[] {"ABCDE"};
		String[] astr = {"ABCDE"};
		for(int i=0; i<astr.length; i++) {
			System.out.println(astr[i]);
		}
		
		String strs = "ABCDE";
		for(int i=0; i<strs.length(); i++) {
			char c = strs.charAt(i);
			System.out.println(c);
		}
		int [][] aabbb = new int[3][];
		
		aabbb[0] = new int[3];
		aabbb[0][0] = 5;
		aabbb[0][5] = 6;
		
		System.out.println(aabbb);
		
		for(int i=0; i<aabbb[0].length; i++)
		{
			System.out.println(aabbb[0][i]);
			
		}
		

		
		
		
		
	}//main 함수

}
