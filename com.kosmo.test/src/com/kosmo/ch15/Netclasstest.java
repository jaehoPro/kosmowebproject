package com.kosmo.ch15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class Netclasstest {

	public static void main(String[] args) {
//		InetAddress net;
//		try {
//			net = InetAddress.getLocalHost();
//			String addr = net.getHostAddress();
//			String host = net.getHostName();
//			System.out.println(addr + "\t" + host);
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
		
		try {
			URL url = new URL("http://www.google.com");
			
//			InputStream is = url.openStream();
			
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = "";
			while( (line=br.readLine()) != null ) {
				System.out.println(line);
			}
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		

	}

}
