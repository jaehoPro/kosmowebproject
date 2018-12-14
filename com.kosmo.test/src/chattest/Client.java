package chattest;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		PrintStream out = null;
		
		try {
			Socket sk = new Socket("127.0.0.1",7777);
			System.out.println("서버연결 성공");
			OutputStream os = sk.getOutputStream();		//자료를 보내주기 위한 준비
			out = new PrintStream(os);
			
			Scanner sc = new Scanner(System.in);
			Scanner sc2 = new Scanner(System.in);
			
			System.out.println("닉네임을 입력하세요");
			String nickname = sc2.nextLine();
			
			System.out.println("채팅을 시작합니다");
			
			while(true)
			{
				
				String msg = sc.nextLine();
				out.println(nickname+":"+msg);		//닉네임 +메세지 전송
				
				
				if(msg.equals("exit")) break;
			}
			System.out.println("client done");
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
