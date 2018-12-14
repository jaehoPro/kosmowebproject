package kosmo.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;

public class Ch15PrintStreamTest {

	public static void main(String[] args) {
		byte[] barr = {65,66,67,68};
		
		ByteArrayInputStream bais = new ByteArrayInputStream(barr);
		
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		
		int res =0;
		
		PrintStream ps = new PrintStream(baos);
		ps.println(10);
		
		
		
		try {
			InputStreamReader isr = new InputStreamReader(System.in);		//바이트코드로 받음
			System.out.println(isr.read());
			//6 1byte  숫자
			//54 2byte ascii코드값
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//scan 은 1바이트만 읽는다
		
		Scanner s = new Scanner(
				
				System.in);
		String scStr = s.nextLine();
		System.out.println(scStr);

	}

}
