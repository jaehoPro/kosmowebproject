package kosmo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//C:\jp\jdk1.8.0_171\jre\lib\ext
//이클립스 jre설정확인 : windows > preference > java > installed jre    <- 라이브러리 설치 확인
//프로젝트 트리 우클릭 > properties > java build path > lib 탭 > 
public class Ch99JDBCTest {
	// ODBC : Windows에서 사용되는 DB연결
	//		: MSSql, ACCESS
	//jdbc(java database connectivity)
	//		: Oracle, Mysql, SQLite, MariaDB
	// Driver
	// jar(java archive)클래스파일들을 압축해놓은것 == zip파일
	// API(메서드 기능의 묶음)
//	public static void main(String[] args) {
	public ArrayList<EmpVO> empList(String inputvalue, Object inputvalue2) {
		
		Ch99DBManager db = new Ch99DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		try {
			//DriverManager 기본생성자가 private이라서 new 명령어를 사용 할 수 없다.
			
			conn = db.dbconn();
			
			String sql= "select * from emp where "+inputvalue+"=?";
						//"select * from emp where empno =?";
			
			pstmt= conn.prepareStatement(sql);
			pstmt.setObject(1, inputvalue2);		//바인딩
			
			rs = pstmt.executeQuery();		//쿼리 실행 
			
						
			while(rs.next())
			{
				EmpVO evo = new EmpVO();
				evo.setEmpno(rs.getInt("empno"));
				evo.setEname(rs.getString("ename"));
				evo.setJob(rs.getString("job"));
				list.add(evo);
				
//				int no = rs.getInt("empno");
//				String name = rs.getString("ename");
//				System.out.println(no+"\t"+name);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}
	
	public ArrayList<EmpVO> empList() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");		// oracledriver 안에 전부 static으로 되어 있기 때문에 new 할 필요 없다.
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Ch99DBManager db = new Ch99DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		
		try {
			//DriverManager 기본생성자가 private이라서 new 명령어를 사용 할 수 없다.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "kosmo", "0000");	//drivermanager 생성자가 private
			if (conn != null)
				System.out.println("conn successs");
			else
				System.out.println("conn failed");
			
			String sql= "select * from emp";
			
			pstmt= conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();		//쿼리 실행 
			
						
			while(rs.next())
			{
				EmpVO evo = new EmpVO();
				evo.setEmpno(rs.getInt("empno"));
				evo.setEname(rs.getString("ename"));
				evo.setJob(rs.getString("job"));
				list.add(evo);
				
//				int no = rs.getInt("empno");
//				String name = rs.getString("ename");
//				System.out.println(no+"\t"+name);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return list;
	}

}
