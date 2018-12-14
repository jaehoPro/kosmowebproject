package kosmo.test;

class MyThread implements Runnable{
	//public MyThread() {super();}
	
	String tname;
	
	public MyThread(String aa) {
		this.tname = aa;
	}
//	public void run() {
//		try {
//				for(int i=0; i<10; i++)
//			{
//				Thread.sleep(500);
//				System.out.println("일하는 중..."+this.tname);
//			}
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//	}

	@Override
	public void run() {
		try {
				for(int i=0; i<100; i++)
			{
				Thread.sleep(10);
				System.out.println("일하는 중..."+this.tname);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}


}

public class Ch12ThreadTest {

	public static void main(String[] args) {
//		MyThread th = new MyThread("man1");
//		th.start();
//		
//		MyThread th2 = new MyThread("man2");
//		th2.start();
		
//		Runnable man1 = new MyThread("man11");		//다형성 parent = new child
//		Thread t = new Thread(man1);
//		t.start();
		
		Thread t = new Thread(new MyThread("man11"));
		t.setPriority(Thread.MIN_PRIORITY);
		t.start();	//콜백 메서드 자동으로 메서드 호출(준비되면 호출)
		
		
		Thread t2 = new Thread(new MyThread("man22"));
		t2.setPriority(Thread.MAX_PRIORITY);
		t2.start();
		
		
	}

}
