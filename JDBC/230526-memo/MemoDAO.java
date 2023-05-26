package memo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import memo.util.DBConn;
import memo.vo.MemoVO;

public class MemoDAO {
	private String query;	   // 쿼리문 저장 필드
	private PreparedStatement psmt;
	private ResultSet rs;
	
	public List<MemoVO> select(){   // 메모 리스트 
		List<MemoVO>mvoList = new ArrayList<MemoVO>();
		
		MemoVO mvo = null;
		
		try {
			query = "SELECT * FROM t_memo";
			psmt = DBConn.getConnection().prepareStatement(query);  // 바인딩이 없으니 이것만 사용
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {   //. 여러 줄이니까 while 
			mvo = new MemoVO();   //  MemberVO 객체를 생성하여 
			mvo.setMid(rs.getString("mid"));						//  해당 레코드 값을 저장
			mvo.setMemo(rs.getString("memo"));
			mvo.setMno(rs.getInt("mno"));
			mvo.setRegdate(rs.getDate("regdate"));	
		
			mvoList.add(mvo);	// list 객체에 추가
			}
		}catch (SQLException e) {
  			e.printStackTrace();
  		}finally { 
  		 DBConn.close(rs, psmt); // 사용한 코드가 rs와 psmt다. 이 두개를 닫기
  		}	
		return mvoList;
		
		
	}
	
	public List<MemoVO> select(String mid) {   // 메모 하나만
		List<MemoVO>mvoList = new ArrayList<MemoVO>();
		MemoVO mvo = null;
		try {
		query = "SELECT * FROM t_memo WHERE MNO=?";    //쿼리문 아이디 조회하는
		psmt = DBConn.getConnection().prepareStatement(query);// 실행할 prepared
		
		psmt.setString(1,mid); // 물음표 바인딩   // 여기서 넘어온 mid
		
		rs = psmt.executeQuery();  // 실행한다.  executeQuery 는 resultSet 으로 온다. 그래서 int로 받을 수 없다. 결과가 있기 때문에 
		
		
		if(rs.next()) {		// 조회된 레코드가 있다면  // == true 기본
			mvo = new MemoVO();   //  MemberVO 객체를 생성하여 
			mvo.setMid(rs.getString("mid"));						//  해당 레코드 값을 저장
			mvo.setMemo(rs.getString("memo"));
			mvo.setMno(rs.getInt("mno"));
			mvo.setRegdate(rs.getDate("regdate"));	
		}
		}catch (SQLException e) {
  			e.printStackTrace();
  		}finally { 
  			DBConn.close(rs, psmt);
  		 
  		}
		return mvoList;
	}
	
	
	public MemoVO select(int mno) {   // 가져올 값이 memo에서는 mno를 가져온다.
		MemoVO mvo = null;
		try {
		query = "SELECT * FROM t_memo WHERE MNO=?";    //쿼리문 아이디 조회하는
		psmt = DBConn.getConnection().prepareStatement(query);// 실행할 prepared
		
		psmt.setInt(1,mno); // 물음표 바인딩   // 여기서 넘어온 mid
		
		rs = psmt.executeQuery();  // 실행한다.  executeQuery 는 resultSet 으로 온다. 그래서 int로 받을 수 없다. 결과가 있기 때문에 
		
		
		if(rs.next()) {		// 조회된 레코드가 있다면  // == true 기본
			mvo = new MemoVO();   //  MemberVO 객체를 생성하여 
			mvo.setMid(rs.getString("mid"));						//  해당 레코드 값을 저장
			mvo.setMemo(rs.getString("memo"));
			mvo.setMno(rs.getInt("mno"));
			mvo.setRegdate(rs.getDate("regdate"));	
		}
		}catch (SQLException e) {
  			e.printStackTrace();
  		}finally { 
  			DBConn.close(rs, psmt);
  		 
  		}
		return mvo;
		
	}
	 // 한줄메모 작성 하기
	public boolean insert(MemoVO mvo) {
		 try {  // 쿼리를 실행하다가 예외가 발생할 수 있으니까 try/ catch문에다가 	// insert 쿼리문
			   query = " INSERT INTO t_memo VALUES (?,?,?,SYSDATE)";
			   
			  // 매개변수로 넘겨받은 데이터를 t_member 테이블에 저장
			   psmt = DBConn.getConnection().prepareStatement(query);
			
			   psmt.setString(1, mvo.getMid());
			   psmt.setString(2, mvo.getMemo());
			   psmt.setInt(3, mvo.getMno());
			  
			   
			   int result = psmt.executeUpdate();
			 
			   if(result ==1) {   // 정상적으로 회원가입 성공 시 true 반환
				  return true; }
		  		} catch (SQLException e) {
		  			e.printStackTrace();
		  		}finally {   
		  		 DBConn.close(psmt);
		  		}
		  		// 그렇지 않으면  false 반환
		  		return false;
	}
	
	// 메모 수정하기
	public boolean update(MemoVO mvo) {
		try {  
			   query = " UPDATE t_memo SET MEMO=? WHERE MNO=?";
			   
			  // 매개변수로 넘겨받은 데이터를 t_member 테이블에 저장
			   
			   psmt = DBConn.getConnection().prepareStatement(query);
			
			   psmt.setString(1, mvo.getMemo());
			   psmt.setInt(3, mvo.getMno());
			  
			  
			   int result = psmt.executeUpdate();
			 
			   if(result ==1) {   // 정상적으로 회원가입 성공 시 true 반환
				  return true; }
		  		} catch (SQLException e) {
		  			e.printStackTrace();
		  		}finally {   
		  		 DBConn.close(psmt);
		  		}
		  		// 그렇지 않으면  false 반환
		  		return false;	  
		
	}
		// 메모 삭제하기
	public boolean delete(int mno) {   // 가져올 값이 memo에서는 mno를 가져온다.
		 try {
			  query = "DELETE FROM t_memo WHERE MID = ? ";
			  
			  psmt = DBConn.getConnection().prepareStatement(query);
			  psmt.setInt(1,mno);
			  
			  
			  	int result = psmt.executeUpdate(query);
			  	
			  	 if(result ==1) {   // 정상적으로 회원가입 성공 시 true 반환
					   }
			  		} catch (SQLException e) {
			  			e.printStackTrace();
			  		}finally {   
			  		 DBConn.close(psmt);
			  		}
			  		// 그렇지 않으면  false 반환
			  		return false ;	   
				  
	}
		
}
