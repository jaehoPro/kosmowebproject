package com.kosmo.ch15;


import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import javax.lang.model.element.Element;

import org.jsoup.Connection;


public class JsoupTest {
	public static void main(String[] args) {
		
		String source = "C:\\jp\\workspace_java\\com.kosmo.test\\src\\com\\kosmo\\ch15\\web1.txt";
		
		FileWriter fw = null;
		BufferedWriter bos = null;
		
	
		
	
		
		Connection.Response response;
		try {
			
			fw = new FileWriter(source);
			bos = new BufferedWriter(fw);
			
			response = Jsoup.connect("http://www.ytn.co.kr/photo/photo_list_1406.html")
					.method(Connection.Method.GET)
					.execute();
					

			
			
//			System.out.println(response.statusCode());
//			System.out.println(response.statusMessage());
			
			Document doc = response.parse();	//이것저것 꺼내볼 수 있다
			bos.write(doc.html());
			bos.flush();
			
			Elements elms = doc.select("div#ytn_list_v2014 dl.photo_list");
			
	
			
//			elms.select(query)
			for(org.jsoup.nodes.Element elm : elms)
			{
				Elements title1 = elm.select("dt a");
				System.out.println(title1);
				
				Elements content = elm.select("dd.text a");
				System.out.println(content.text());
				
				Elements date = elm.select("dd.date");
				System.out.println(date.text());
				
				System.out.println("------------------------------------------");
				
				
			}
			System.out.println(elms.size());
			
			
			
			
			//System.out.println(google3.html());
			
			//println 자동으로 버퍼장착 및 버퍼플러시
//			FileOutputStream fos = new FileOutputStream(f);
//			PrintStream out = new PrintStream(fos);
//			out.println();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	
	
		
	}
	
}


//
//Connection.Response response;
//try {
//	response = Jsoup.connect("http://www.google.com")
//			.method(Connection.Method.GET)
//			.execute();
//	
////	System.out.println(response.statusCode());
////	System.out.println(response.statusMessage());
//	
//	Document google3 = response.parse();
//	System.out.println(google3.html());
//}catch(IOException e) {
//	e.printStackTrace();
//}
