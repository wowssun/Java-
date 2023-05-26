package member.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import member.vo.MemberVO;

public class JDBCTest {
	Connection con;
	Statement stmt;
	PreparedStatement psmt;
	String query;
	
	
	String driver = "oracle.jdbc.OracleDriver";
	String url  = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "dEv ";
	String password = "1111";


	public static void main(String[] args) {
//		JDBC : Java DataBase Connectivity
//		자바 어플리케이션과 데이터베이스를 연결하는 라이브러리
//		자바 프로그램에서 DB에 접근하기 위해 사용
		
//		1. DBMS : DataBase Management System 설치
//		2. DBMS에 맞는 JDBC 드라이버 설치
//		3. JDBC API를 이용하여 자바 프로그램 개발
//			1단계 -  sql 관련 패키지 import
//			2단계 - JDBC 드라이버 로드
//			3단계 - Connection 객체 생성
//			4단계 - Statement /PreparedStatement 객체 생성
//			5단계 = 쿼리 실행
//			6단계 - 필요 시 ResultSet 객체 생성 사용
//			7단계 - 모든 객체를 닫고 DB 연결 종료
		
		JDBCTest jd = new JDBCTest();
		jd.insert();
	} // main end
	
	public void insert() {
	
		MemberVO mvo = new MemberVO();
		mvo.setMid("ddd");
		mvo.setMname("kim");
		mvo.setMage(20);
		mvo.setMphone("010-1234-5678");
		
			try {
			Class.forName(driver); // 드라이버로딩
			con = DriverManager.getConnection(url, username, password);
			System.out.println("driver ok");
			
	//		con.setAutoCommit(false);    // auto commit을 하지 않을때 사용 , 기본은 auto commit 이다.
	//	    con.commit();
	//	    con.rollback();
			
//			stmt  = con.createStatement();    객체가 비어있다.
			
			// t_member 테이블에 레코드 하나를 추가하는 쿼리를 작성하여
			// query에 저장
			
			query = " INSERT INTO t_member  "  				              // 만들어진 쿼리로        
				 +  " VALUES (?,?,?,?,SYSDATE)";
			psmt = con.prepareStatement(query);   //  객체를 생성하고 여기서 쿼리를 쓰기 때문에 쿼리가 이 문장보다 위에 올라가야 한다.
			
			psmt.setString(1, mvo.getMid());
			psmt.setString(2, mvo.getMname());
			psmt.setInt(3, mvo.getMage());
			psmt.setString(4, mvo.getMphone());
			
			
			
//			query = " INSERT INTO t_member  "  				                       // 공백 주면 좋다. 따옴표 처음과 끝에
//				 +  " VALUES ('" + mvo.getMid()+"','"+ mvo.getMname()+"'," + mvo.getMage()+",'" +mvo.getMphone()+"','" + "SYSDATE)";
//				
				
//				  + " VALUES('AAA','KIM',20,'010-0000-0000')";
			
//			int result = stmt.executeUpdate(query); // 마지막 쿼리만 실행, 생성, 수정, 삭제 모두 executeUpdate로 실행한다. 그래서 거의 result가 1이다.
			
		int result = psmt.executeUpdate(); // psmt를 쓸 때 쿼리는 가져오지 않는다.
			
	//		if(result ==1) {  // 회원가입은 하나만 들어가니까
	//			System.out.println(" ok");
	//		}else {
	//			System.out.println(" not ok");
	//		}
	//		
			}catch(ClassNotFoundException e) {
			e.printStackTrace();
			}catch(SQLException e) {
			e.printStackTrace();
			}finally {
				try {
				// stmt 및 con 객체가 널이 아닌 경우에만 각각 닫기 처리
					if(psmt != null) psmt.close();
					if(con != null) con.close();
				
					}catch (SQLException e) {
						e.printStackTrace();
						}// catch end
			}//finally end	
	} // insert end
	
	public void update() {
		try {
			Class.forName(driver); // 드라이버로딩
			con = DriverManager.getConnection(url, username, password);
			System.out.println("driver ok");
			
	//		con.setAutoCommit(false);    // auto commit을 하지 않을때 사용 , 기본은 auto commit 이다.
	//	    con.commit();
	//	    con.rollback();
			
			stmt  = con.createStatement();
			
			// t_member 테이블에 레코드 하나를 추가하는 쿼리를 작성하여
			// query에 저장
			
			query = " UPDATE t_member "  				                       // 공백 주면 좋다. 따옴표 처음과 끝에
				   +" SET MNAME = 'LEE'"
				   +" WHERE MID = 'BBB' ";
					
			int result = stmt.executeUpdate(query); // 마지막 쿼리만 실행, 생성, 수정, 삭제 모두 executeUpdate로 실행한다. 그래서 거의 result가 1이다.
			
			
	//		if(result ==1) {  // 회원가입은 하나만 들어가니까
	//			System.out.println(" ok");
	//		}else {
	//			System.out.println(" not ok");
	//		}
	//		
			}catch(ClassNotFoundException e) {
			e.printStackTrace();
			}catch(SQLException e) {
			e.printStackTrace();
			}finally {
				try {
				// stmt 및 con 객체가 널이 아닌 경우에만 각각 닫기 처리
					if(stmt != null) stmt.close();
					if(con != null) con.close();
				
					}catch (SQLException e) {
						e.printStackTrace();
						}// catch end
			}//finally end		
		
	}
	public void delete() {
		try {
			Class.forName(driver); // 드라이버로딩
			con = DriverManager.getConnection(url, username, password);
			System.out.println("driver ok");
			
	//		con.setAutoCommit(false);    // auto commit을 하지 않을때 사용 , 기본은 auto commit 이다.
	//	    con.commit();
	//	    con.rollback();
			
			stmt  = con.createStatement();
			
			// t_member 테이블에 레코드 하나를 추가하는 쿼리를 작성하여
			// query에 저장
			
			query = "DELETE FROM t_member  "  				                       // 공백 주면 좋다. 따옴표 처음과 끝에
			      + "WHERE MID = 'BBB' ";
			
			int result = stmt.executeUpdate(query); // 마지막 쿼리만 실행, 생성, 수정, 삭제 모두 executeUpdate로 실행한다. 그래서 거의 result가 1이다.
			
			
	//		if(result ==1) {  // 회원가입은 하나만 들어가니까
	//			System.out.println(" ok");
	//		}else {
	//			System.out.println(" not ok");
	//		}
	//		
			}catch(ClassNotFoundException e) {
			e.printStackTrace();
			}catch(SQLException e) {
			e.printStackTrace();
			}finally {
				try {
				// stmt 및 con 객체가 널이 아닌 경우에만 각각 닫기 처리
					if(stmt != null) stmt.close();
					if(con != null) con.close();
				
					}catch (SQLException e) {
						e.printStackTrace();
						}// catch end
			}//finally end	
	
	}
	
	
	
}// class end
