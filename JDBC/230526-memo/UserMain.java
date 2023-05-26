package memo.main;

import java.util.Scanner;

public class UserMain {
	private Scanner sc;
	private int input;
	private MemoMain memi;
	private MemberMain mbmi;
	
	public UserMain() {
		sc = new Scanner(System.in);
		
	}
	  public static void main(String [] args) {
	UserMain um = new UserMain();
	um.menu();
  }
	
	public void menu() {
		System.out.println("--------------------------------------------");
		System.out.println("           MEMBER MANAGEMENT SYSTEM    " );
		System.out.println("---------------------------------------------");
		System.out.println(" 1. 나의 정보 보기");
		System.out.println(" 2. 한줄 메모 게시판으로 이동");
		System.out.println(" 3. 로그인 페이지로 이동하기");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("   숫자를 선택해주세요 >>>  ");
		input = sc.nextInt();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		switch (input) {
			case 1 : System.out.println("내 정보보기"); break;        // 나의 정보 보기 페이지로 이동하기 
			case 2 : System.out.println("메모 게시판으로 이동합니다.");	
					 memi.menu(); break;//  한줄 메모 게시판으로 이동
			case 3 : System.out.println("로그인 페이지로 이동합니다.");
			         mbmi.login();
		}
		
		
		
		
		
		
	}
	
	
	
	

}
