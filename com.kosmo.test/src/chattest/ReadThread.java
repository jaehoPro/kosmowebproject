package chattest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;



public class ReadThread implements Runnable {
	Socket sk;
	public ReadThread(Socket ss) {
		this.sk = ss;
		
	}
	
	@Override
	public void run() {
		BufferedReader br = null;		//보조스트림
		InputStream is;					//주스트림
		
		try {
			is = sk.getInputStream();		//받을 준비
			InputStreamReader isr = new InputStreamReader(is);// 2바이트로 바꾸는 보조 버퍼
			br = new BufferedReader(isr);		
			String line = "";
			while((line = br.readLine())!=null)
			{
				System.out.println(line);
				//output?
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		} finally {
			System.out.println("클라이언트 퇴장");
			try {
				br.close();
				sk.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}

}