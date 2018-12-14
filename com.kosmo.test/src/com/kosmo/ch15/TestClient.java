package com.kosmo.ch15;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TestClient {

	public static void main(String[] args) {
		Socket sk = null;
		PrintStream out = null;
		try {
			sk = new Socket("127.0.0.1", 7777);
			System.out.println("[client] 서버연결성공");
			
			Scanner sc = new Scanner(System.in);
			System.out.print("닉네임:");
			String nickName = sc.nextLine();
			
			
			
			WriteThread write = new WriteThread(sk, nickName);
			Thread wt = new Thread(write);
			wt.start();
			
			ReadThread read = new ReadThread(sk);
			Thread rt = new Thread(read);
			rt.start();
			
			System.out.println("===[client] done===");
		} catch (UnknownHostException e) {
			//e.printStackTrace();
			
		} catch (IOException e) {
			//e.printStackTrace();
		} 

	}

}
