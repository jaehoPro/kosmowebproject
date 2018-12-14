package vocabularyList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kosmo.test.Ch99DBManager;
import vocabularyList.vo.CheckableItemVO;

public class DicInsertDAO {
	
	
	public int dicInsert(CheckableItemVO itemVO) {
		Ch99DBManager db = new Ch99DBManager();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int res=0; 
		conn = db.dbconn();
		
		System.out.println(itemVO.getStr());  //입력될 단어
		
//		String sql= "insert into emp (empno,ename)values (?,?)";
//		//"select * from emp where empno =?";
//
//		try {
//			pstmt= conn.prepareStatement(sql);
//			pstmt.setInt(1, prmEmpno);		//바인딩
//			pstmt.setString(2, prmEname);
//			res = pstmt.executeUpdate();	
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			db.dbClose(rs, pstmt, conn);
//		}
		
		
		return res;
	}

}
