package oop20230502;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;
public class Controller {

	Scanner sc = new Scanner(System.in);
	
	EachPerson[] list = new EachPerson[100];
	int listCnt = 0;
	
	void input() {							//  데이터 입력
		if(listCnt < 100) {
			list[listCnt] = new EachPerson();
			System.out.println("이름 : ");
		    list[listCnt].setName(sc.next());
		    System.out.println("전화번호 : ");
		    list[listCnt].setPhonenum(sc.next());
		    System.out.println("생년월일(YY-MM-DD) : ");
		    list[listCnt].setBirth(sc.next());
		    
		    listCnt++;
		}
		else {
			System.out.println("인원은 100명까지 입니다.");
		}
	}
	void check() {								// 전체 데이터 조회
		for(listCnt = 0; listCnt < list.length; listCnt++ ) {
			System.out.println(list[listCnt]);
		}
	}
	
	void search() {								// 데이터 검색
		if(
			
		}
	}
	void delete() {								// 데이터 삭제
		//return null?? patient class 참고하기
	}
	void output() {
		for(int i =0; i <listCnt; i ++) {
			System.out.println(list[i].toString());
		}
	}
	

}