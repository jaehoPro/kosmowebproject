package kosmo.test;

import com.kosmo.other.Ch07Parent;
import com.kosmo.other.Ch07other;

public class Ch07Child extends Ch07Parent{

	public static void main(String[] args) {
		//System.out.println(num);
		Ch07other o = new Ch07other();
		
		System.out.println(o.othernum);
		
		Ch07Child2 c2 = new Ch07Child2();
		System.out.println(c2.add());
		System.out.println(Ch07Child2.add());
	}
	public void childFunc()
	{
		System.out.println("childFunc");
	}

}
