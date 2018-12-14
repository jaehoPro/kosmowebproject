package vocabularyList;


/**
 * Created by Trandent on 2017. 1. 25..
 */
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

import vocabularyList.vo.DicVO;
import vocabularyList.vo.PhraseVO;
import vocabularyList.vo.TucVO;

import javax.net.ssl.*;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

public class DicCraw {
	
	
	public ArrayList<String> getDicList(int languageIndex, String searchStr) {
		ArrayList<String> dicList = new ArrayList<String>();
		String domain;
		if(languageIndex==0)
		{
			//일본어
			domain = "https://glosbe.com/gapi/translate?from=kor&dest=jpn&format=json&pretty=true&phrase="+searchStr;
		}
		else if(languageIndex==1)
		{
			//영어
			domain = "https://glosbe.com/gapi/translate?from=kor&dest=eng&format=json&pretty=true&phrase="+searchStr;
		}
		else
		{
			return dicList;
		}
		
		TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
			public X509Certificate[] getAcceptedIssuers(){return new X509Certificate[0];}
			public void checkClientTrusted(X509Certificate[] certs, String authType){}
			public void checkServerTrusted(X509Certificate[] certs, String authType){}
		}};

		try {
			SSLContext sc = SSLContext.getInstance("TLS");
			sc.init(null, trustAllCerts, new SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (NoSuchAlgorithmException | KeyManagementException e1) {
			e1.printStackTrace();
		}
		

		Document doc = null;
		try{
			doc = Jsoup.connect(domain).ignoreContentType(true).get();
			Elements bodyTag = doc.select("body");
			String bodyTagStr = bodyTag.text();
			
			System.out.println(bodyTagStr);
			Gson gson = new Gson();
			
			
			DicVO dicVO = gson.fromJson(bodyTagStr, DicVO.class);
			ArrayList<TucVO> list = dicVO.getTuc();
			for(TucVO tucVO : list) {
				PhraseVO pvo = tucVO.getPhrase();
				System.out.println(pvo.getText());
				dicList.add(pvo.getText());
			}
		}catch(Exception e){
			e.printStackTrace();
		}    
		
		return dicList;
		
	}
}		
			
			
//--------------------------------------------------------------
//			DicVO
//			private String result; //ok
//			private String ArrayList<TucVO> tuc;
//			
//			TucVO
//			private PhraseVO phrase; 
//			private String meaningId; 
//			private String[] authors;
//			
//			PhraseVO 
//			private String text;
//			private String language;
			
//			{ 
//			"result" : "ok", 
//			"tuc" : [ 
//			           { 
//				        	"phrase" : { "text" : "林檎","language" : "ja" }, 
//				           	"meaningId" : -8565753822032758624, 
//				           	"authors" : [ 9 ] 
//			           }, 
//			           { 
//			        	   "phrase" : { "text" : "りんご","language" : "ja" },
//			        	   "meaningId" : 7488809595941412967,
//			        	   "authors" : [ 2692 ] 
//			           }, 
//			           { 
//			        	   	"phrase" : { "text" : "リンゴ", "language" : "ja" }, 
//			        	   	"meanings" : [ 
//			        	   	               { "language" : "ko", "text" : "사과나무의 열매" }, 
//			        	   	               { "language" : "ja", "text" : "バラ科リンゴ属の落葉高木樹、またはその果実" } 
//			        	   	             ], 
//			        	   	"meaningId" : 219828612450976707, 
//			        	   	"authors" : [ 86 ]
//			        	 },
//			           	{ "phrase" : { "text" : "謝罪", "language" : "ja" }, 
//			        		 "meaningId" : -8027716007378933798, 
//			        		 "authors" : [ 2701 ] 
//			        	}, { "phrase" : { "text" : "りんご 林檎", "language" : "ja" }, "meaningId" : 1310966368381055249, "authors" : [ 83086 ] }, { "phrase" : { "text" : "クワドリウィウム", "language" : "ja" }, "meaningId" : -5905694521569029579, "authors" : [ 122622 ] }, { "phrase" : { "text" : "侘び", "language" : "ja" }, "meaningId" : 4754995938642335389, "authors" : [ 83058 ] }, { "phrase" : { "text" : "苹果", "language" : "ja" }, "meaningId" : 5761103726801176416, "authors" : [ 83058 ] }, { "phrase" : { "text" : "詫び", "language" : "ja" }, "meaningId" : 1403596505264685453, "authors" : [ 83058 ] 
//			        			
//			        	} 
//			        	
//			          ], 
//			 "phrase" : "사과", 
//			 "from" : "ko", 
//			 "dest" : "ja", 
//			 "authors" : { "83058" : { "U" : "", "id" : 83058, "N" : "Dbnary: Wiktionary as Linguistic Linked Open Data", "url" : "https://glosbe.com/source/83058" },
//				"2692" : { "U" : "http://dumps.wikimedia.org/iswiktionary/latest/iswiktionary-latest-pages-articles.xml.bz2", "id" : 2692, "N" : "Wikiordabok", "url" : "https://glosbe.com/source/2692" }, 
//				"86" : { "U" : "", "id" : 86, "N" : "wiki", "url" : "https://glosbe.com/source/86" },
//				"9" : { "U" : "http://fr.wiktionary.org", "id" : 9, "N" : "fr.wiktionary.org", "url" : "https://glosbe.com/source/9" }, 
//				"2701" : { "U" : "http://dumps.wikimedia.org/kuwiktionary/latest/kuwiktionary-latest-pages-articles.xml.bz2", "id" : 2701, "N" : "Wikiferheng", "url" : "https://glosbe.com/source/2701" }, 
//				"83086" : { "U" : "", "id" : 83086, "N" : "Dbnary: Wiktionary as Linguistic Linked Open Data", "url" : "https://glosbe.com/source/83086" }, 
//				"122622" : { "U" : "https://www.wikidata.org/", "id" : 122622, "N" : "wikidata", "url" : "https://glosbe.com/source/122622" } 
//				} 
//		} //end of {
//--------------------------------------------------------------			
			
			