package com.kosmo.ch15;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class WriteThread implements Runnable {
	Socket sk;
	String nickName;
	public WriteThread(Socket ss, String nn) {
		this.sk = ss;
		this.nickName = nn;
	}
	@Override
	public void run() {
		PrintStream out = null;
		try {
			OutputStream os = sk.getOutputStream();
			out = new PrintStream(os);
			
			if(nickName != null) {
				out.println(nickName); //닉네임전송
			}
			
			Scanner sc = new Scanner(System.in);
			while(true) {
				String msg = sc.nextLine();
				out.println(nickName+":"+msg);
				
				//String[] arr = msg.split(":");
				if(msg.equals("exit")) break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("클라이언트 퇴장....");
			try {
				out.close();
				sk.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
