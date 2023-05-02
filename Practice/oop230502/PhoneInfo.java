package oop20230502;

import java.util.Scanner;
public class PhoneInfo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		
		Controller cont = new Controller();
		
		while(true) {		//  무한반복문
			System.out.println("선택하세요!");
			System.out.println("1. 데이터 입력");
			System.out.println("2. 전체 데이터 조회");
			System.out.println("3. 데이터 검색");
			System.out.println("4. 데이터 삭제");
			System.out.println("5. 프로그램 종료");
			System.out.print("선택 : " );
			num = sc.nextInt();
			
			switch(num) {
			case 1: cont.input();		// 입력
				break;
			case 2: cont.				// 조회
				break;
			case 3: cont.				// 검색
				break;
			case 4: cont. 				// 삭제
				break;
			case 5: System.out.println("프로그램 종료");	// 종료
					System.exit(0);
			}
			System.out.println();
		}

	} // main end

} // class end