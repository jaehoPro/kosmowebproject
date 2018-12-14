package kosmo.test;

import java.io.File;

public class Ch14FileTest {
	static int linetab = 0;
	static int level = 0;

	public static void main(String[] args) {
//		String source ="C:\\jp\\workspace_java\\com.kosmo.test\\src\\kosmo\\test\\aaa.txt";
//		
//		File f = new File(source);	//파일 객체가 만들어짐
//		
//		System.out.println(f.getPath());
//		System.out.println(f.getAbsolutePath());//절대경로
//		System.out.println(f.getName());		//파일이름
//		System.out.println(f.getParent());
//		System.out.println(f.isFile());			//파일인지 여부
//		System.out.println(f.isDirectory());	//디렉토리인지 여부
//		System.out.println("done");
		
		String path = "C:\\jp\\workspace_java\\com.kosmo.test\\src\\";
		String childpath;
		File f = new File(path);
		File[] farr = f.listFiles();
		int count = 0;
		
		
		for(int i=0; i<farr.length; i++)
		{
			
			if(farr[i].isDirectory())
			{
				System.out.println("<DIR>"+farr[i].getName());
				childpath = Childfolder(farr[i].getName(),farr[i].getAbsolutePath());
				
				Childfile(childpath);
			
			}
			else
			{
				System.out.println(farr[i].getName()+"\t\t"+farr[i].length());
			}
			linetab = 0;
		}
		
		
		
		
		//System.out.println(f.getName());
	}
	public static String Childfolder(String filename, String path)		//다음 주소 반환
	{
		String childpath = null;
		childpath = path;
		return childpath;
	}
	public static void Childfile(String path)			//childfile 출력
	{
		File f = new File(path);
		File[] farr = f.listFiles();
		String childpath;
		for(int i=0; i<farr.length; i++)
		{
			if(farr[i].isDirectory())
			{
				linetab++;
				for(int j=0; j<linetab; j++)
				{
					System.out.print("\t");
					
				}
				
				System.out.println("<DIR>"+farr[i].getName());
				childpath = Childfolder(farr[i].getName(),farr[i].getAbsolutePath());
				
				Childfile(childpath);
			}
			else
			{
				for(int j=0; j<linetab; j++)
				{
					System.out.print("\t");
					
				}
				System.out.println(
						farr[i].getName()+"\t\t"+farr[i].length());
				
			}
			if(i==(farr.length-1))
			{
				linetab--;
			}
			
			
		}
		
	}

}
