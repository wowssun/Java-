package member.main;

import java.util.List;
import java.util.Scanner;

import member.dao.MemberDAO2;
import member.jdbc.DBConn;
import member.vo.MemberVO;


public class MemberMain2 {
	 private Scanner sc;				// 멤버 필드로 선언 여기에서 바로 초기화해도 된다.
	 private int input;
	 private MemberDAO2 mdao2;			// 많은 곳에 쓸 것이니까 , 생성자에서 초기화
	
	 
	 
	public MemberMain2() {
		sc = new Scanner(System.in);		// 멤버 필드 초기화
		mdao2 = new MemberDAO2();   // 여기서 초기화 함.
		
	}
	public static void main(String[] args) {
			
			MemberMain2 mbmain = new MemberMain2 ();
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
					 DBConn.close();		// connection close. 시스템이 끝나면 끝나지만 명시적으로 하기 위해
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
     if(mdao2.insert(mbvo)) {
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
		
		List<MemberVO> mvoList = mdao2.select(); 
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
		
		MemberVO mvo = mdao2.select(mid);  //2. 입력받은 매개변수를 select 로 저장한다.// 리턴값을 받는다. mvo로 받아왔다.
		 
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
			case 1: modify(mvo); break;   //  호출을 할때 매개변수 확인하기, 호출한 메서드와 같은 ㅎㅇ태다.
			case 2: remove(mid); break;
			case 3: menu();
			default : System.out.println(" >> 1 ~ 3을 선택해주세요.");
			System.out.println();
			info();   // 회원정보 메뉴 표시
		}
	}else {
		System.out.println("해당 아이디가 존재하지 않습니다.");
		System.out.println("메뉴로 이동합니다.");
		menu();
	}
			
	}
		// 회원 수정										// 회원정보를 조회한 memberVo를 가져오는것이다.(select에서 이미 처리한)
	public void modify(MemberVO mvo) {		// select에서 받은 memberVO를 받아온다. 받아온 데이터로 수정처리를 하려고
		System.out.println("--------------------------------------------");
		System.out.println("           MEMBER UPDATE    " );
		System.out.println("---------------------------------------------");
	
		 	System.out.print("나이를 수정하세요 > ");  // 나이를 입력받는다.
		 	mvo.setMage(sc.nextInt());    // 변수 생성 후 입력받기 
	        System.out.print("전화번호를 수정하세요 > "); // 전화번호 입력받는다.
	        mvo.setMphone(sc.next());					 // 입력받은 값을 바로 membervo에 저장까지 완료
	       
	        boolean result = mdao2.update(mvo);       // 반환되는 값을 받아서
		     if(result) {		// dao에 넘긴다.
		    	 System.out.println("회원정보 수정이 완료되었습니다..");      // 출력한다.
		    	 
		      } else {
		    	  System.out.println("회원정보 수정에 실패했습니다.");
		      }
				info();   // 입력받고 출력한 뒤에는 업무방향에 따라서 어디로 어떻게 이동할지 생각한다.
					
		}
	public void remove(String mid) {   // 삭제만 할거니까 매개변수로 아이디를 받아온다. 삭제를 위한 매개변수
		System.out.println("--------------------------------------------");
		System.out.println("           MEMBER DELETE    " );
		System.out.println("---------------------------------------------");
		
		System.out.print("회원 정보를 삭제하시겠습니까? Y | N");  // 의사확인
		String answer = sc.next();
		
		  if(answer.equalsIgnoreCase("Y")) {  // equalsIgnoreCase는 대소문자 구분없이 사용할 수 있다.
			 
			  if(mdao2.delete(mid)){	
			  		System.out.println("삭제가 완료되었습니다."); 									// 반환되는 값을 받아서  // dao에 넘긴다.
			        System.out.println("메인으로 이동합니다.");
			        
			 	}else {
				 System.out.println("삭제에 실패했습니다.");
			 	}
	  		}else if(answer.equalsIgnoreCase("N")) {
	    	  	System.out.println("삭제가 취소되었습니다.");
	  		}else {
    	        System.out.println("Y나 N을 선택해주세요.");
       }		  
				menu();
	
		   }   // remove end  	    
		
		    
		} // class end
	
