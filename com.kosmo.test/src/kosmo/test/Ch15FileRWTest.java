package kosmo.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ch15FileRWTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String source ="C:\\jp\\workspace_java\\com.kosmo.test\\src\\kosmo\\test\\aaa.txt";
		String dest = "C:\\jp\\workspace_java\\com.kosmo.test\\src\\kosmo\\test\\bbbb.txt";
		//Reader r = new Reader();  //abstarct class new xxx
				FileReader fr = null;
				FileWriter fw = null;
				
				
				BufferedReader bis = null;
				BufferedWriter bos = null;
				//char[] carr = {'j','a','v','a'};
				//CharArrayReader car = 
				
				try {
					int res = 0;
					fr = new FileReader(source);
					fw = new FileWriter(dest);
														
					bis = new BufferedReader(fr);	//다형성
					bos = new BufferedWriter(fw);
					
					String line = null;
					
					
					while((line=bis.readLine()) != null) {
						System.out.println(line);
						bos.write(line);
					}
					
//					while((res=bis.read()) != -1) {
//						System.out.println((char)res);
//						bos.write(res);
//					}
					bos.flush();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						fr.close();
						fw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				System.out.println("===done===");
				
				

			}

		}
