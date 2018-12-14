package com.kosmo.gui.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GoogleMapIOTest {
	
	
	public String createMapJpg(String streetname) {
		
		String jpgPath ="c:\\down\\map.jpg";
		
		File f = new File(jpgPath);
		FileOutputStream fos = null;
		InputStream is=null;
		String urlStr ="https://maps.googleapis.com/maps/api/staticmap?center="+streetname+"&zoom=16&size=800x600&maptype=roadmap";
//				+ "\r\n" + 
//				"&markers=color:blue%7Clabel:S%7C40.702147,-74.015794&markers=color:green%7Clabel:G%7C40.711614,-74.012318\r\n" + 
//				"&markers=color:red%7Clabel:C%7C40.718217,-73.998284\r\n" + 
//				"&key=AIzaSyAw1qHRul54OoL_HllagQmgb0EOvYcGigk";
						
		URL url;
		
		try {
			fos = new FileOutputStream(f);
			url = new URL(urlStr);
			URLConnection conn = url.openConnection();
			is = conn.getInputStream();
			
			int data = 0;
			
			while((data=is.read())!=-1) {
				fos.write(data);			//fos에 저장
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
//		InputStream is = url.openStream();
		
		
		System.out.println("done");
		
		return jpgPath;
	}
}
