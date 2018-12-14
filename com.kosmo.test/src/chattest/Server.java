package chattest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	
	public static void main(String[] args) {
		Socket sk = null;		
		
		try {
			ServerSocket ss = new ServerSocket(7777);
			System.out.println("서버실행");
			while(true) {
				System.out.println("대기중");
				sk=ss.accept();
				System.out.println("클라이언트 접속");
				
				ReadThread read = new ReadThread(sk);
				
				Thread t = new Thread(read);
				
				t.start();
				
			}
			
			
		} catch (IOException e) {
			System.out.println("갑작스런 퇴장");
		}
			
	
		
	}

}
