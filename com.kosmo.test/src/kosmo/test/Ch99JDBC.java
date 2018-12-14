package kosmo.test;

import java.util.ArrayList;

public interface Ch99JDBC {
	//Create
	//Read
	//update
	//delete
	public ArrayList<EmpVO> empList(String inputvalue, Object inputvalue2);
	public ArrayList<EmpVO> empList();
	
	public int empInsert(int prmEmpno, String prmEname);
	public int empUpdate(int prmEmpno, int sal);
	public int empDelete(int prmEmpno);
	

}
 