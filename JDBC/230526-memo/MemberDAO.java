package memo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import memo.util.DBConn;
import memo.vo.MemberVO;

public class MemberDAO {
	private String query;
	private PreparedStatement psmt;
	private ResultSet rs;

	 public boolean insert(MemberVO mvo)  { 
		  try {  // 쿼리를 실행하다가 예외가 발생할 수 있으니까 try/ catch문에다가 	// insert 쿼리문
			   query = " INSERT INTO t_member VALUES (?,?,?,?,SYSDATE)";
			   
			  // 매개변수로 넘겨받은 데이터를 t_member 테이블에 저장
			   psmt = DBConn.getConnection().prepareStatement(query);
			
			   psmt.setString(1, mvo.getMid());
			   psmt.setString(2, mvo.getMname());
			   psmt.setInt(3, mvo.getMage());
			   psmt.setString(4, mvo.getMphone());
			   
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
		  
	  } // insert end  
	
	public boolean login(String mid, String mphone) {
		
		try {
			query = "SELECT COUNT (*) FROM T_MEMBER WHERE MID = ? AND MPHONE=?";// 로그인 하는 쿼리 작성
			psmt = DBConn.getConnection().prepareStatement(query);
			
			psmt.setString(1,mid);
			psmt.setString(2,mphone);
				
			rs = psmt.executeQuery();  // 매개변수로 넘겨받은 유효한 사용자인지 확인
			
			if(rs.next()) {  // 조회된 레코드가 있다면
					if(rs.getInt(1)==1) { // COUNT로 사용했으니 1이 넘겨오면 사용자가 있다. -> 로그인 가능
						return true;	  // COUNT 로 0 이 넘어오면 사용자 존재 안함 -> 로그인 불가 메시지
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally { 
		 DBConn.close(rs, psmt); // 사용한 코드가 rs와 psmt다. 이 두개를 닫기
		}	
			return false;		
	} // login end
	
	
	
	
	
} // class end
