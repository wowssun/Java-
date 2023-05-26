package memo.main;

import java.util.Scanner;

import memo.vo.MemoVO;

public class MemoMain {
	private Scanner sc;
	private int input;
	private MemoVO mevo;
	
	public MemoMain() {
		sc = new Scanner(System.in);
		mevo = new MemoVO ();
	
	}
	public static void main(String[] args) {
		new MemoMain().menu();
	  // 여기에 메뉴 불러오기
	
	
		}  // main end
	
	public void menu() {
		System.out.println("-----------------------------");
		System.out.println("        MEMO SYSTEM          ");
		System.out.println("-----------------------------");
		System.out.println("1. 한 줄 메모 작성하기");
		System.out.println("2. 전체 목록 보기");
		System.out.println("3. 내 메모 목록 보기");
		System.out.println("4. 회원 메뉴 페이지로 가기");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("   숫자를 선택해주세요 >>>  ");
		input = sc.nextInt();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		switch(input) {
		case 1 : write(); break;
//		case 2 : list(); break;
//		case 3 : list(); break;
		case 4 : System.out.println("회원 메뉴로 이동합니다.");
		         new UserMain().menu();	break;
				
		default : System.out.println("다시 선택해주세요. 1 ~ 4");
				  System.out.println();
				  menu();
		}
		         		
		
	} // menu end


 public void write() {
	System.out.println("-----------------------------");
	System.out.println("            MEMO             ");
	System.out.println("-----------------------------");
	System.out.println("        메모를 작성하세요        ");
	System.out.print(">>> ");
	String input = sc.next();
	
	mevo.setMemo(input);
	
	System.out.println("메모를 작성하시겠습니까? ( Y | N )");
	input = sc.next();
	
	
	if (input.equalsIgnoreCase("y")) {
		System.out.println("메모 작성이 완료되었습니다.");
		// 메모 작성하고 메뉴로 넘어가기
	}else if(input.equalsIgnoreCase("n")) {
		System.out.println("메모 작성을 취소하셨습니다.");
		System.out.println("메모 시스템으로 돌아갑니다.");
	}
	menu();
	
} // write end
//
//// 전체 목록 가져오기
//public void list() {
//	
//	
//}  // list end
//
//// 내 목록 가져오기
//public void list() {
//	
//	
//}  // list end
//
//
//public modify(MemoVO mvo) {} // modify end
//
//
//public modify(int mno, String memo) {} // modify end
//
//
//public remove(int mno) {}  // remove end
//
//	

		
//	1. 한 줄 메모 작성 insert   ( t_member에서 회원가입
//	2. 메모 목록 select list → 한줄메모 전체 게시판  (selectall)           ( t_member에서 회원목록
//	3. 로그인 한 후에 → 내 메모목록을  아이디를 가져오고 목록을 보낸다.  리턴타입 list → 내 메모 보기(상세보기) ↓ 번호를 선택하면 한개만 상세보기         ( t_member에서 회원 조회, 가져오는건 String?
//	    - 수정
//	    - 삭제
//	    - 메뉴
//	4. 종료

	
		
} // class end


