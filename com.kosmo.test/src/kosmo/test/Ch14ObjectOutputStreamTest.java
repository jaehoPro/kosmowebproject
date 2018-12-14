package kosmo.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ch14ObjectOutputStreamTest {

	public static void main(String[] args) {
		String source = "C:\\jp\\workspace_java\\java_prj\\src\\com\\kosmo\\test\\object.txt";
		FileOutputStream fos = null;
		ObjectOutputStream oos  = null;
		try {
			fos = new FileOutputStream(source);
			oos  = new ObjectOutputStream(fos);
			
//			ArrayList<String> list = new ArrayList<String>();
//			list.add("aaa");
//			list.add("bbb");
//			list.add("ccc");
			
			Ch99JDBCTest t = new Ch99JDBCTest();
			ArrayList<EmpVO> list = t.empList();

			Membervo vo = new Membervo();
			vo.setMid("lee");
			vo.setMpw("9999");
			
			//여기서부터 직렬화
			oos.writeObject(list);
			oos.writeObject(vo);
			
		
			System.out.println("====write done====");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		

	}

}
