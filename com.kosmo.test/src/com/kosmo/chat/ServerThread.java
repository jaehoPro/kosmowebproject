package com.kosmo.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ServerThread implements Runnable {
	Socket sk;
	HashMap map;
	public ServerThread(Socket ss, HashMap mm) {
		this.sk = ss;
		this.map = mm;
	}
	
	@Override
	public void run() {
		InputStream is = null;
		BufferedReader br = null;
		PrintStream out = null;
		String nickName = "";
		try {
			is = sk.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			nickName = br.readLine();
			map.put(nickName, sk);
			System.out.println("총 인원:" + map.size());
			
			HashSet set = new HashSet();
			set = (HashSet)map.keySet();
			
			sendMsgToAll("RIGHT:::"+nickName + "입장");	//채팅
			
			StringBuffer buffer = new StringBuffer();
			Iterator it = set.iterator();
			while(it.hasNext())
			{
				buffer.append(it.next()+"@");
			}
			sendMsgToAll("LEFT:::"+buffer.toString());	//닉네임 목록
			
			String msg = "";		
			while( (msg = br.readLine()) != null) {
				sendMsgToAll(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
				sendMsgToAll(nickName + "퇴장");
				map.remove(nickName);
				br.close();
				sk.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void sendMsgToAll(String msg) {
		try {
			Iterator it = map.keySet().iterator();
			while(it.hasNext()) {
				Socket usersk = (Socket)map.get(it.next());
				
				
				OutputStream uos = usersk.getOutputStream();
				new PrintStream(uos).println(msg);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
