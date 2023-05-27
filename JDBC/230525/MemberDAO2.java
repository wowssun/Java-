package member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import member.jdbc.DBConn;
import member.vo.MemberVO;

public class MemberDAO2 {
	private String query;	   // 쿼리문 저장 필드
	private PreparedStatement psmt;
	private ResultSet rs;
	
	// 회원목록 - 매개변수 : x,접근제한 : x, 반환타입 : MemberVO를 저장한 list / 기능 = t_member 테이블의 전체 데이터를 조회하여 list에 저장한 후 반환
	public List<MemberVO> select() {
		List<MemberVO>mvoList = new ArrayList<MemberVO>();
	
		MemberVO mvo = null;
		
		try {
			query = "SELECT * FROM t_member";
			psmt = DBConn.getConnection().prepareStatement(query);  // 바인딩이 없으니 이것만 사용
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {   //. 여러 줄이니까 while 
			mvo = new MemberVO();   //  MemberVO 객체를 생성하여 
			mvo.setMid(rs.getString("mid"));						//  해당 레코드 값을 저장
			mvo.setMname(rs.getString("mname"));
			mvo.setMage(rs.getInt("mage"));
			mvo.setMphone(rs.getString("mphone"));
			mvo.setMdate(rs.getDate("reg_date"));	
		
			mvoList.add(mvo);	// list 객체에 추가
			}
		}catch (SQLException e) {
  			e.printStackTrace();
  		}finally { 
  		 DBConn.close(rs, psmt); // 사용한 코드가 rs와 psmt다. 이 두개를 닫기
  		}	
		return mvoList;
}
	
												// 해당레코드 모두 가지고 있는 memberVO
	// 회원조회 - 매개변수로 String 타입의 mid를 넘겨받아 해당레코드를 객체에 저장하여 반환하는 select() 메서드 ( 접근제한 x)
	public MemberVO select(String mid) {   // mid를 받아온다. 메인에서 select(mid로 값을 받아옴)
		MemberVO mvo = null;
		try {
		query = "SELECT * FROM t_member WHERE MID=?";    //쿼리문 아이디 조회하는
		psmt = DBConn.getConnection().prepareStatement(query);// 실행할 prepared
		
		psmt.setString(1,mid); // 물음표 바인딩   // 여기서 넘어온 mid
		
		rs = psmt.executeQuery();  // 실행한다.  executeQuery 는 resultSet 으로 온다. 그래서 int로 받을 수 없다. 결과가 있기 때문에 
		
		
		if(rs.next()) {		// 조회된 레코드가 있다면  // == true 기본
			mvo = new MemberVO();   //  MemberVO 객체를 생성하여 
			mvo.setMid(rs.getString("mid"));						//  해당 레코드 값을 저장
			mvo.setMname(rs.getString("mname"));
			mvo.setMage(rs.getInt("mage"));
			mvo.setMphone(rs.getString("mphone"));
			mvo.setMdate(rs.getDate("reg_date"));	
		}
		}catch (SQLException e) {
  			e.printStackTrace();
  		}finally { 
  			DBConn.close(rs, psmt);
  		 
  		}
		return mvo;
	}
	
	
	// 회원가입
   // 멤버 vo를 받는다. 거기에 저장이 되어있기 때문에, 멤버 vo가 입력받은것을 저장하는 곳
	
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
	  public boolean update(MemberVO mvo) {  // insert 했던것처럼 membervo로 받아온 데이터를 테이블에 적용 그리고 리턴으로 보낸다.
		  	  // 매개변수로 넘겨받은 데이터를 t_member 테이블에 저장
		  try {  
			   query = " UPDATE t_member SET MAGE=?, MPHONE=? WHERE MID=?";
			   
			   psmt = DBConn.getConnection().prepareStatement(query);
			
			   psmt.setInt(1, mvo.getMage());   // 쿼리 ? 개수만큼 값을 입력
			   psmt.setString(2, mvo.getMphone());
			   psmt.setString(3,mvo.getMid());
			  
			   int result = psmt.executeUpdate();
			 
			   if(result ==1) {   // 정상적으로 회원수정 성공 시 true 반환
				  return true; }
		  		} catch (SQLException e) {
		  			e.printStackTrace();
		  		}finally {   
		  		 DBConn.close(psmt);
		  		}
		  		// 그렇지 않으면  false 반환
		  		return false;	  
			  
		  } // update end
	  
	  public boolean delete(String mid) { 
		  try {
		  query = "DELETE t_member WHERE MID = ? ";
		  
		  psmt = DBConn.getConnection().prepareStatement(query);
		  psmt.setString(1,mid);
		  
		  	int result = psmt.executeUpdate();
		  	
		  	 if(result ==1) {  
		  		 return true;        // 정상적으로 회원가입 성공 시 true 반환
				   }
		  		} catch (SQLException e) {
		  			e.printStackTrace();
		  		}finally {   
		  		 DBConn.close(psmt);
		  		}
		  		// 그렇지 않으면  false 반환
		  		return false ;	   
			  
		
			  
		  } // delete end
	  
} // class end
