package kosmo.test;

import java.util.ArrayList;
import java.util.Scanner;

public class testtest {
	
	public static void main(String[] args) {



		ArrayList abc = new ArrayList();
		
		abc.add("a");
		abc.add("bb");
		abc.add(11);
		abc.remove(1);
		
		Scanner sc = new Scanner(System.in);
		abc.add(sc.nextLine());
	
		
		for(int i=0; i<abc.size(); i++)
		{
			System.out.println("-----------"+abc.get(i));
			
		}
	}
	

}
