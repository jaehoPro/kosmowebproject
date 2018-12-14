package kosmo.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ch14ObjectStreamTest {

	public static void main(String[] args) {
		String source ="C:\\jp\\workspace_java\\com.kosmo.test\\src\\kosmo\\test\\aaa.txt";
		String dest ="C:\\jp\\workspace_java\\com.kosmo.test\\src\\kosmo\\test\\bbbb.txt";
		
//		File sfile = new File(source);
//		File dfile = new
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		ObjectInputStream ois = null;
		ObjectOutputStream oos = null;
		
		try {
			
			fis = new FileInputStream(source);
			fos = new FileOutputStream(source);
			
			ois = new ObjectInputStream(fis);
			oos = new ObjectOutputStream(fos);
			
			//라이트 한 순서대로 리드
			
			
			
			
				
			
		
			} catch (FileNotFoundException e) {
			e.printStackTrace();
			}
			catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
