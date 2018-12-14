package kosmo.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Ch14ObjectInputStreamTest {

	public static void main(String[] args) {
		String source = "C:\\jp\\workspace_java\\java_prj\\src\\com\\kosmo\\test222\\object.txt";
		
		FileInputStream fis = null;
		ObjectInputStream ois  = null;
		try {
			fis = new FileInputStream(source);		//경로나 파일을 넣어주면됨
			ois  = new ObjectInputStream(fis);		//
			try {
				ArrayList<String> res = (ArrayList<String>)ois.readObject();
				Membervo res2 = (Membervo)ois.readObject();
				System.out.println(res.size());
				System.out.println(res2.getMpw());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ois != null) ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("=====read done=====");
	}

}
