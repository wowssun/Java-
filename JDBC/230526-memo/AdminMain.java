package memo.main;


import java.util.Scanner;

import memo.util.DBConn;
public class AdminMain {
	private Scanner sc;
	private int input;
	
	
	
	public AdminMain() {
		sc = new Scanner(System.in);
	}
	
	public static void main(String []args) {
		AdminMain admin = new AdminMain();
		admin.menu();
	}
		
	

	
	
	public void menu() {
		System.out.println("-----------------------------");
		System.out.println("   ADMIN MANAGEMENT SYSTEM   ");
		System.out.println("-----------------------------");
		System.out.println("1. 회원 목록 확인하기");
		System.out.println("2. 회원 정보 조회하기");
		System.out.println("3. 로그인 페이지로 이동하기");
		System.out.println("4. 프로그램 종료");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("   숫자를 선택해주세요 >>>  ");
		input = sc.nextInt();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		switch(input) {
		case 1 : check(); break;
		case 2 : info(); break;
		case 3 : System.out.println("로그인 페이지로 이동합니다.");
		         new MemberMain().login();  break;
		case 4 : System.out.println("프로그램을 종료합니다.."); 
				  sc.close();
				  DBConn.close();		// connection close. 시스템이 끝나면 끝나지만 명시적으로 하기 위해
				  System.exit(0);  // 정상종료 
		default : System.out.println("다시 선택해주세요. 1 ~ 4");
				  System.out.println();
		}
		         menu();		
			         
	} // menu end
	
	
	public void check() {
		
	}
	
	public void info() {
		
	}

}  // class end
