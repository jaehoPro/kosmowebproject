package vocabularyList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import kosmo.test.Ch99DBManager;
import kosmo.test.EmpVO;

public class JDBC {

	
	//------------------------------------단어장 리스트 조회(단어장 목록 노출에 사용)
	public ArrayList<VO> bookList() {
		DBManager db = new DBManager(); 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<VO> list=new ArrayList<VO>();

		conn=db.dbconn();


		try {
			//String sql="";
			String sql="select n.book_num as book_num, n.book_name as book_name, count(v.voca_num) as voca_count\r\n" + 
					"from notebook n, voca v\r\n" + 
					"where n.book_num=v.book_num(+)\r\n" + 
					"group by n.book_name, n.book_num order by book_num asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				VO vo = new VO();
				vo.setBook_num(rs.getInt("book_num"));
				vo.setBook_name(rs.getString("book_name"));
				vo.setVoca_count(rs.getInt("voca_count"));

				list.add(vo);
		

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}



		return list;

	}
	
	//------------------------------------단어장 추가
	public int bookAdd(String book_name)
	{
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		
		conn = db.dbconn();
		
				
		
		String sql = "insert into notebook (BOOK_NUM,BOOK_NAME) values (book_num.nextval,?)";
		
		
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book_name);
			
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			db.dbClose(pstmt, conn);
		}
		
		
		return res;
	}
	//--------------------------------------단어장 삭제
	public int bookDelete(int book_num, int getVoca_count) {
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res =0;
		
		conn = db.dbconn();
		
		try {
			String sql;
			if(getVoca_count>0)			//단어장에 단어가 있으면 단어를 먼저 삭제하는 구문
			{
				sql = "delete from voca where book_num=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, book_num);
				
				res = pstmt.executeUpdate();
			}
			
			//단어장을 삭제하는 구문
			sql = "delete from notebook where book_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book_num);
			
			res = pstmt.executeUpdate();
			
			System.out.println(book_num+"번 단어장 삭제하였습니다");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
		return res;
	}

	

	//--------------------------------------단어목록 버튼 클릭시 조회하는 단어 목록(단어관리 메뉴에서 사용)
	public ArrayList<Vector> vocaList(int book_num) {

		DBManager db = new DBManager(); 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Vector> list=new ArrayList<Vector>();

		conn=db.dbconn();


		try {
			
			//String sql="select * from voca where book_num = "+book_num;
			
			
			String sql="select voca_num, voca_spell, voca_means, trunc((sysdate-voca_date),0)as voca_date, voca_memory, book_num"
					+ " from voca where book_num = "+book_num+" order by voca_date asc";
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{


				Vector<Object> vector = new Vector<Object>();
				vector.addElement(rs.getInt("voca_num"));
				vector.addElement(rs.getString("voca_spell"));
				vector.addElement(rs.getString("voca_means"));
				
				if(rs.getString("voca_date").equals("0"))
				{
					vector.addElement("1일이내 등록");
				}
				else
				{
					vector.addElement(rs.getString("voca_date")+"일 경과");
				}
				if(rs.getInt("voca_memory") == 0)
				{
					vector.addElement("X");
				}
				else
				{
					vector.addElement("O");
				}
				


				list.add(vector);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}



		return list;

	}
	//--------------------------------------학습 버튼 클릭시 선택된 단어장의 단어 모두 조회(단어장 번호로 조회)(랜덤 공부)
	public ArrayList vocaStudyList(int book_num) {

		DBManager db = new DBManager(); 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList list=new ArrayList();

		conn=db.dbconn();


		try {
			String sql="select * from voca where book_num = "+book_num;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				VO vo = new VO();
				vo.setVoca_num(rs.getInt("voca_num"));
				vo.setVoca_spell(rs.getString("voca_spell"));
				vo.setVoca_means(rs.getString("voca_means"));
				vo.setVoca_date(rs.getString("voca_date"));
				vo.setVoca_memory(rs.getInt("voca_memory"));
				vo.setBook_num(rs.getInt("book_num"));
				
				list.add(vo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		
		return list;
		
	}
	//--------------------------------------학습 버튼 클릭시 선택된 단어장의 다시 공부해야하는 단어 모두 조회(단어장 번호와 voca_memory 칼럼으로 조회)
	public ArrayList vocaStudyAgainList(int book_num) {

		DBManager db = new DBManager(); 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList list=new ArrayList();

		conn=db.dbconn();


		try {
			String sql="select * from voca where book_num = "+book_num+" and voca_memory = 0";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				VO vo = new VO();
				vo.setVoca_num(rs.getInt("voca_num"));
				vo.setVoca_spell(rs.getString("voca_spell"));
				vo.setVoca_means(rs.getString("voca_means"));
				vo.setVoca_date(rs.getString("voca_date"));
				vo.setVoca_memory(rs.getInt("voca_memory"));
				vo.setBook_num(rs.getInt("book_num"));
				
				list.add(vo);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		
		return list;
		
	}
	//--------------------------------------외우거나 못외웠을때 정보 업데이트(랜덤단어공부,외우지 못한단어 메뉴시 사용)
	public int vocaMemoryUpdate(int voca_num, int voca_memory) {
		DBManager db = new DBManager(); 
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res=0; 	
		
		conn = db.dbconn();
		
		try {
			String sql= "update voca set voca_memory = ? where voca_num = ?";
			
//			if(Voca_memory==0)			//외움 버튼을 클릭하면 voca_memory 1로 변환
//			{
//				sql= "update voca set voca_memory = 1 where voca_num = ?";				
//			}
//			else 
//			{
//				sql= "update voca set voca_memory = 0 where voca_num = ?";				
//			}
				
			
			pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1, voca_memory);		//바인딩
			pstmt.setInt(2, voca_num);
			
			res = pstmt.executeUpdate();//sql 실행 및 결과 반환	
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
		return res;
	}
	
	
	//--------------------------------------단어와 단어장 번호로 단어 검색
	public ArrayList<Vector> vocaWordSearch(int book_num, String voca_spell) {

		DBManager db = new DBManager(); 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Vector> list=new ArrayList<Vector>();

		conn=db.dbconn();


		try {
			
			String sql="select * from voca where book_num=? and voca_spell=?";
				
						
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, book_num);
			pstmt.setString(2, voca_spell);
			
			rs = pstmt.executeQuery();
			
			
			
			while(rs.next())
			{
				
				Vector<Object> vector = new Vector<Object>();
				vector.addElement(rs.getInt("voca_num"));
				vector.addElement(rs.getString("voca_spell"));
				vector.addElement(rs.getString("voca_means"));
				vector.addElement(rs.getString("voca_date"));
				vector.addElement(rs.getInt("voca_memory"));
				vector.addElement(rs.getInt("book_num"));


				list.add(vector);
	
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		
		return list;
		
	}
	
	public ArrayList<Vector> vocaWordSearch(String input, int getSelectedIndex) {
		//getSelectedIndex 0:단어명
//							1: 뜻
//							2: 단어+뜻
		DBManager db = new DBManager(); 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<Vector> list=new ArrayList<Vector>();

		conn=db.dbconn();


		try {
			
			String sql;
			if(getSelectedIndex==0)		//단어명으로 검색
			{
				sql="select v.voca_spell,v.voca_means,v.voca_date,v.voca_memory, n.book_name \r\n" + 
						"from notebook n, voca v\r\n" + 
						"where n.book_num=v.book_num and v.voca_spell LIKE '%"+input+"%' order by book_name asc";
			}
			else if(getSelectedIndex==1)	//뜻으로 검색
			{
				sql="select v.voca_spell,v.voca_means,v.voca_date,v.voca_memory, n.book_name \r\n" + 
						"from notebook n, voca v\r\n" + 
						"where n.book_num=v.book_num and v.voca_means LIKE '%"+input+"%' order by book_name asc";
			}
			else							//단어 + 뜻
			{
				sql="select v.voca_spell,v.voca_means,v.voca_date,v.voca_memory, n.book_name \r\n" + 
						"from notebook n, voca v\r\n" + 
						"where n.book_num=v.book_num and (v.voca_spell LIKE '%"+input+"%' or voca_means LIKE '%"+input+"%') order by book_name asc";
			}
			
			
			//String sql="select * from voca where voca_means LIKE '%"+input+"%' or voca_spell LIKE '%"+input+"%'";
						
			pstmt = conn.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			
			
			
			while(rs.next())
			{
				
				Vector<Object> vector = new Vector<Object>();
				
				
				
				
				vector.addElement(rs.getString("voca_spell"));
				vector.addElement(rs.getString("voca_means"));
				vector.addElement(rs.getString("voca_date"));
				//vector.addElement(rs.getInt("voca_memory"));
				
				if(rs.getInt("voca_memory") == 0)
				{
					vector.addElement("X");
				}
				else
				{
					vector.addElement("O");
				}
				vector.addElement(rs.getString("book_name"));


				list.add(vector);
	
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		
		
		return list;
		
	}
	
	
	//--------------------------------------단어 입력
	public int vocaAdd(VO vo)
	{
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		
		conn = db.dbconn();
		
				
		
		String sql = "insert into voca (VOCA_NUM,VOCA_SPELL,VOCA_MEANS,VOCA_DATE,VOCA_MEMORY,BOOK_NUM) values"
				+ " (voca_num.nextval,?,?,sysdate,0,?)";
		
		
				
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getVoca_spell());
			pstmt.setString(2, vo.getVoca_means());
			pstmt.setInt(3, vo.getBook_num());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			db.dbClose(pstmt, conn);
		}
		
		
		return res;
	}
	//--------------------------------------단어 삭제
	public int vocaDelete(int voca_num) {
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res =0;
		
		conn = db.dbconn();
		
		try {
			String sql = "delete from voca where voca_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, voca_num);
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
		return res;
	}
	
	

}
