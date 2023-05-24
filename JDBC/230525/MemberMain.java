package member.main;

import java.lang.ProcessHandle.Info;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import member.dao.MemberDAO;
import member.jdbc.DBConn;
import member.vo.MemberVO;


public class MemberMain {
	 private Scanner sc;				// 멤버 필드로 선언 여기에서 바로 초기화해도 된다.
	 private int input;
	 private MemberDAO mdao;			// 많은 곳에 쓸 것이니까 , 생성자에서 초기화
	 private static Connection con;
	 
	 
	public MemberMain() {
		sc = new Scanner(System.in);		// 멤버 필드 초기화
		mdao = new MemberDAO();   // 여기서 초기화 함.
		
	}
	public static void main(String[] args) {
			
			MemberMain mbmain = new MemberMain ();
			mbmain.menu();
			
	//		new MemberMain().menu();   객체생성에서 메인에서 호출만 하는거라면 이렇게 한줄로 사용 할 수도 있다.
					
			
	}
		public void menu() {
			// 메뉴안에다 쓰면 메서드마다 (필요할때마다) 객체생성해서 해야한다. 계속 쓸거라면 
		System.out.println("--------------------------------------------");
		System.out.println("           MEMBER MANAGEMENT SYSTEM    " );
		System.out.println("---------------------------------------------");
		System.out.println(" 1. 회원 가입");
		System.out.println(" 2. 회원 목록");
		System.out.println(" 3. 회원 조회");
		System.out.println(" 4. 종료");
		System.out.print(" 숫자선택 >> ");
		input = sc.nextInt();
		
		switch(input) {
			case 1 : join(); break;	
			case 2 : list(); break;
			case 3 : info(); break;		
			case 4 : System.out.println("프로그램을 종료합니다.");
					 sc.close();
					 DBConn.close();
					 System.exit(0);  // 정상종료
			default : System.out.println(" 다시 선택해주세요.( 1 ~ 4를 선택 ) ");
					  System.out.println( ); // 줄바꿈
				      menu();
		}
		
	}

	public void join() {			// 회원 가입
		// 회원 가입에 필요한 정보를 입력받아서
		// 객체에 저장한 후 DAO 클래스의 메서드로 전달
		System.out.println("--------------------------------------------");
		System.out.println("           MEMBER JOIN    " );
		System.out.println("---------------------------------------------");
		
        System.out.print("아이디를 입력하세요 > ");
        String mid = sc.next();    // 변수 생성 후 입력받기 
        System.out.print("이름을 입력하세요 > ");
        String mname = sc.next();
    
      MemberVO mbvo = new MemberVO();
      
      mbvo.setMid(mid);
      mbvo.setMname(mname);
      System.out.print("나이를 입력하세요 > ");
      mbvo.setMage(sc.nextInt());
      System.out.print("전화번호를 입력하세요 > ");
      mbvo.setMphone(sc.next());
      

      // 회원가입이 성공하면 " 회원가입이 완료되었습니다. 출력
       // 그렇지 않으면 " 회원가입에 실패했습니다." 출력한후
      // 메인 메뉴 표시
      // if (result == true) 변수 설정하고 이런식으로 써도 된다. 그냥 result 라고 써도 된다. 기본이 true
      //      boolean result = mdao.insert(mbvo); 변수생성 후에 result에  mdao에 보낸 값을 담는다.
     if(mdao.insert(mbvo)) {
    	 System.out.println("회원가입이 완료되었습니다.");
    	 
      } else {
    	  System.out.println("회원가입이 실패했습니다.");
    	 
      }
		menu();
		
	}   
	
	public void list() {			// 회원 목록
		System.out.println("--------------------------------------------");
		System.out.println("           MEMBER LIST   " );
		System.out.println("---------------------------------------------");
		
		List<MemberVO> mvoList = mdao.select(); 
		// dao에 매개변수가 없는 셀렉트 메서드 호출
		// 반환되는 값을 저장한뒤
		//화면에 표시
	
		if(mvoList.size() > 0) {   // 등록된 게시물이 있다면 화면에 표시
			// for문 이용
//			for(int i = 0 ; i < mvoList.size(); i++) {
//				MemberVO mvo = mvoList.get(i);
//				System.out.println( mvo.getMid()+"|"+ mvo.getMname()+ "|"+mvo.getMage()+ "|"+ mvo.getMphone()+ "|"+ mvo.getMdate());
//	}
			System.out.println(" 아이디 | 이름 | 나이 | 전화번호 | 가입일자");
			for(MemberVO list : mvoList) {
				System.out.println( list.getMid()+"|"+  list.getMname()+"|"+ list.getMage()+"|"+  list.getMphone()+"|"+  list.getMdate());
			}
			
		}else {
				System.out.println("등록된 회원이 없습니다.");
				System.out.println("메뉴로 이동합니다.");
			}
				menu();
	}// list end
	
	public void info() {	// 회원 조회
		System.out.println("--------------------------------------------");
		System.out.println("           MEMBER MANAGEMENT SYSTEM    " );
		System.out.println("---------------------------------------------");
		System.out.print("조회할 아이디를 입력하세요 > ");
		String mid = sc.next();
		
//		mdao.select(mid); // 1. 아이디를 입력받는다.
		
		MemberVO mvo = mdao.select(mid);  //2. 입력받은 매개변수를 select 로 저장한다.// 리턴값을 받는다.
		 
		//4. 화면에 출력한다.
		if(mvo !=null) {
		System.out.println("   회원아이디 :" + mvo.getMid());
		System.out.println("   회원이름 : " + mvo.getMname());
		System.out.println("   회원나이 :  " + mvo.getMage());
		System.out.println("   전화번호 : "+ mvo.getMphone());
		System.out.println("   가입일자 : " + mvo.getMdate());
		System.out.println("------------------------------------------------");
		System.out.println("   1. 회원수정   2. 회원 삭제  3. 메인메뉴");

		System.out.print("실행할 메뉴의 번호를 입력해주세요 > ");
		int num = sc.nextInt();
		
		switch(num) {
			case 1: modify(); break;
			case 2: remove(); break;
			case 3: menu();
		}
	}else {
		System.out.println("해당 아이디가 존재하지 않습니다.");
		System.out.println("메뉴로 이동합니다.");
		menu();
	}
			
	}
	public void modify() {			// 회원 수정
		System.out.println("--------------------------------------------");
		System.out.println("           MEMBER UPDATE    " );
		System.out.println("---------------------------------------------");
		
		
		  MemberVO mbvo = mdao.select(sc.next());
		 	System.out.print("나이를 수정하세요 > ");
		 	mbvo.setMage(sc.nextInt());    // 변수 생성 후 입력받기 
	        System.out.print("전화번호를 수정하세요 > ");
	        mbvo.setMphone(sc.next());
	   	       
      // 회원가입이 성공하면 " 회원가입이 완료되었습니다. 출력
       // 그렇지 않으면 " 회원가입에 실패했습니다." 출력한후
      // 메인 메뉴 표시
      // if (result == true) 변수 설정하고 이런식으로 써도 된다. 그냥 result 라고 써도 된다. 기본이 true
      //      boolean result = mdao.insert(mbvo); 변수생성 후에 result에  mdao에 보낸 값을 담는다.
     if(mdao.update(mbvo)) {
    	 System.out.println("수정이 완료되었습니다..");
    	 
      } else {
    	  System.out.println("수정 실패");
    	 
      }
		menu();
				
	}
	public void remove() {// 회원 삭제
		System.out.println("--------------------------------------------");
		System.out.println("           MEMBER DELETE    " );
		System.out.println("---------------------------------------------");
		
		  MemberVO mbvo = mdao.select(sc.next());
		
		  if(mdao.delete(mbvo)) {
		    	 System.out.println("삭제가 완료되었습니다..");
		    	 
		      } else {
		    	  System.out.println("삭제 실패");
		    	 
		      }
				menu();
		
		
		
	}
	
	
	
}
