package memo.main;

import java.util.Scanner;

import memo.dao.MemberDAO;
import memo.util.DBConn;
import memo.vo.MemberVO;


public class MemberMain {
	private Scanner sc;
	private int input;
	private MemberDAO mdao;
	public static String id;
	private AdminMain am;

	public MemberMain() {
		sc = new Scanner(System.in);
		mdao = new MemberDAO();
		am = new AdminMain();
	}
	
	public static void main(String[] args) {
		
		MemberMain mbmain = new MemberMain ();
		mbmain.menu();			
		
}
	public void menu() {
		System.out.println("--------------------------------------------");
		System.out.println("           MEMBER MANAGEMENT SYSTEM    " );
		System.out.println("---------------------------------------------");
		System.out.println(" 1. 로그인");
		System.out.println(" 2. 회원가입");
		System.out.println(" 3. 종료");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("   숫자를 선택해주세요 >>>  ");
		input = sc.nextInt();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		switch(input) {
		case 1 : login(); break;
		case 2 : join(); break;
		case 3 :  System.out.println("프로그램을 종료합니다.");
				  sc.close();
				  DBConn.close();		// connection close. 시스템이 끝나면 끝나지만 명시적으로 하기 위해
		 		  System.exit(0);  // 정상종료
		default : System.out.println(" 다시 선택해주세요.( 1 ~ 3을 선택해주세요) ");
		  System.out.println( ); // 줄바꿈
	      menu(); 
		}
	} // menu end
	
		public void join() {			// 회원 가입
			// 회원 가입에 필요한 정보를 입력받아서
			// 객체에 저장한 후 DAO 클래스의 메서드로 전달
			System.out.println("--------------------------------------------");
			System.out.println("           MEMBER JOIN    " );
			System.out.println("---------------------------------------------");
			
			MemberVO mbvo = new MemberVO();
	        System.out.print("아이디를 입력하세요 > ");
	        mbvo.setMid(sc.next()); // 변수 생성 후 입력받기 
	        System.out.print("이름을 입력하세요 > ");
	        mbvo.setMname(sc.next());
	        System.out.print("나이를 입력하세요 > ");
	        mbvo.setMage(sc.nextInt());
	        System.out.print("전화번호를 입력하세요 > ");
	        mbvo.setMphone(sc.next());
	        
	     
	     if(mdao.insert(mbvo)) {
	    	 System.out.println("회원가입이 완료되었습니다.");
	    	 
	      } else {
	    	  System.out.println("회원가입이 실패했습니다.");
	    	 
	      }
			menu();
			
	} // join end
		public void login() {			// 회원 가입
			// 회원 가입에 필요한 정보를 입력받아서
			// 객체에 저장한 후 DAO 클래스의 메서드로 전달
			System.out.println("--------------------------------------------");
			System.out.println("           MEMBER LOGIN    " );
			System.out.println("---------------------------------------------");
			
			MemberVO mbvo = new MemberVO();
	        System.out.print("아이디를 입력하세요 > ");
	        String mid = sc.next(); // 변수 생성 후 입력받기 
	        
	        System.out.print("전화번호를 입력하세요 > ");
	        String mphone = sc.next();
	        
	        mbvo.setMid(mid);
	        mbvo.setMphone(mphone);	
	        
	       if(mdao.login(mid, mphone)){  // 사용자에게 입력받은 아이디와 비밀번호가 일치하면
	    	   	System.out.println("로그인에 성공했습니다."); // 로그인 성공 메시지를 출력한다.
	    	   		if(mid.equalsIgnoreCase("admin") & mphone.equals("1111")) {	//관리자 계정이면 관리자 메뉴로 간다.
	    	   			System.out.println("관리자 계정");// 관리자 계정으로 이동한다.
	    	   			id = mid;
	    	   			am.menu();
	    	   		}else {
	    	   			System.out.println("회원 메뉴로 이동");// 회원 메뉴로 이동한다.
	    	   			id = mid;
	    	   			new UserMain().menu();
	    	   		}
	    	   		
	    	   		 // 단, 입력받은 아이디는 필드로 선언된 공유 변수 id에 저장
	    	   		
	    	 } else {   //아이디와 번호가 일치하지 않으면
	    		   System.out.println("로그인에 실패했습니다.");
	    		   System.out.println("로그인 창으로 이동합니다."); // 로그인 실패 메시지를 출력한다.
	    		   login(); // 로그인 화면을 다시 표시
	    	 }
	        	
		}
		
	
	
	
} // class end
