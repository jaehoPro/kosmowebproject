package kosmo.test;

import java.util.ArrayList;

public class Ch99JDBCCall {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ch99JDBCTest t = new Ch99JDBCTest();
		
		Ch99JDBCImpl impl = new Ch99JDBCImpl();
		
		
//		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
//		list = t.empList();
		
		
		
		//ArrayList<EmpVO> list = t.empList("ENAME", "KING");	//선언과 동시에 값을 할당
		
		ArrayList<EmpVO> list = t.empList();
		
		System.out.println(list.size());
		
		for(int i=0; i<list.size(); i++)
		{
			//리스트 		list.add("aa")
			//			list.get("i")
			
			//EmpVO evo = list.get(i);
			System.out.println(list.get(i).getEname()+"\t"+list.get(i).getEmpno()+"\t"+list.get(i).getJob());
			
		}
		
//		for(EmpVO evo : list)
//		{
//			System.out.println(evo.getEname());
//		}
		//입력
//		int insRes = impl.empInsert(8002, "km");
//		System.out.println(insRes+"건 입력 완료");
		
		//수정
//		int uptres= impl.empUpdate(8001, 100);
//		System.out.println(uptres+"건 수정");
		
		//삭제
//		int delres = impl.empDelete(7777);
//		System.out.println(delres+"건 삭제");
//----------------------------------------------------------------		
		//입력 Vo
		//empno,ename,job,mgr,hiredate,sal,comm,deptno
//		EmpVO votest = new EmpVO();
//		votest.setEmpno(7777);
//		votest.setEname("test");
//		votest.setJob("manager");
//		votest.setSal(400);
//		votest.setComm(5000);
//		
//		int vores = impl.empInsertvo(votest);
//		System.out.println(vores+"건 입력 완료");
		
		ArrayList<EmpVO> list2 = impl.empSelect();
		for(int i=0; i<list2.size(); i++)
		{
			//리스트 		list.add("aa")
			//			list.get("i")
			
			//EmpVO evo = list.get(i);
			System.out.println(list2.get(i).getEmpno()+"\t"+list2.get(i).getEname()+"\t"+list2.get(i).getEmpno()+"\t"+list2.get(i).getJob());
			
		}
		
		
		
	}
	
	
	

}
