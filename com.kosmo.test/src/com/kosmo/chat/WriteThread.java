package com.kosmo.chat;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class WriteThread implements Runnable {
	Socket sk;
	String nickName;
	OutputStream os;
	PrintStream out;
	public WriteThread(Socket ss) {
		this.sk = ss;
		//this.nickName = nn;
		try {
			os = sk.getOutputStream();
			out = new PrintStream(os);
		} catch (IOException e) {
			//e.printStackTrace();
		}
		
	}
	@Override
	public void run() {
	
		Scanner nicksc = new Scanner(System.in);
		System.out.print("닉네임:");
		String nickName = nicksc.nextLine();
		out.println(nickName); //닉네임전송
		
		
		Scanner msgsc = new Scanner(System.in);
		while(true) {
			String msg = msgsc.nextLine();
			out.println(nickName+":"+msg);
			if(msg.equals("exit")) break;
		}
		try {
			sk.close();
		} catch (IOException e) {
			//e.printStackTrace();
		}
		
	}

}

