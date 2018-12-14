package kosmo.test;

public class Ch02LocalVar {

	int num;
	public static void main(String[] args) {
		int num=121;
		Ch02LocalVar v = new Ch02LocalVar();
		v.myprint();
		
		


	}
	public void myprint() {
		int num = 999;
		System.out.println(num);		//같은 메서드에 있는 변수 999
		System.out.println(this.num);	//바로 위에 있는 변수0
		//static 안에서 this를 못쓴다.this는 주소를 뜻함.
	}

}
