package kosmo.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Ch15IOTest {

	//	public static void main(String[] args) {
	//		//InputStream is = new InputStream();
	//		FileOutputStream fos = null;
	//		String name ="C:\\jp\\workspace_java\\com.kosmo.test\\src\\kosmo\\test\\aaa.txt";
	//		try {
	//			Fil
	//			
	//			eInputStream fis = new FileInputStream(name);
	//			int res = fis.read();
	//			
	//		} catch (FileNotFoundException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//			name = "c:\\default.txt";
	//		} catch (IOException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//
	//	}
	//
	//}
	public static void main(String[] args) {
		//InputStream is = new InputStream();
		String source ="C:\\jp\\workspace_java\\com.kosmo.test\\src\\kosmo\\test\\aaa.txt";
		String dest ="C:\\jp\\workspace_java\\com.kosmo.test\\src\\kosmo\\test\\bbbb.txt";
		
		File sfile = new File(source);
		File dfile = new File(dest);
		
		if(sfile.isDirectory() || dfile.isDirectory())	//
				System.exit(0);
		
		//String name = "aaa.txt";
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		DataInputStream dis = null;
		DataOutputStream dos = null;

		try { 
			fis = new FileInputStream(source);
			fos = new FileOutputStream(dest, true);
			
//			bis = new BufferedInputStream(fis);	//다형성
//			bos = new BufferedOutputStream(fos);
			
			dis = new DataInputStream(fis);
			dos = new DataOutputStream(fos);
			
			int num = 0;
			while(dis.available()>0) {
				num=dis.readInt();
				System.out.println(num+" ");
			}
			
			/*while(true) {
				int res = fis.read();
				System.out.println((char)res);
				if(res == -1)
					break;
			}*/
			int res = 0;
//			while((res = fis.read()) != -1 ) {
//				System.out.println((char)res);
//			}
			
			while((res = fis.read()) != -1 ) {
				System.out.println((char)res);
				
				fos.write((char)res);
				
			}

//			byte[] b = {65,66,67,68};
//			int num = 65;
//			String dest ="C:\\jp\\workspace_java\\com.kosmo.test\\src\\kosmo\\test\\aaa.txt";
//			fos = new FileOutputStream(dest);
//			fos.write(num);

		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				fis.close();
				//fos.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		System.out.println("--done--");
	}

}
