package override;

import java.util.Scanner;
public class Controller {
		//  선언
	Scanner sc = new Scanner(System.in);
	
	PersonVO[] list = new PersonVO[5];		// 객체 배열
	int listCnt = 0;
	
		//  입력
	void input() {
		if(listCnt < 5) {
			// 객체 배열 입력
			list[listCnt] = new PersonVO();
			System.out.println("이름");
			list[listCnt].setName(sc.next());
			System.out.println("나이 : ");
			list[listCnt].setAge(sc.nextInt());
			System.out.println("전화번호 : ");
			list[listCnt].setTel(sc.next());

			listCnt++;
		}
		else {
			System.out.println("인원을 5명 까지 입니다.");
		}
	}
		// 처리/연산
		// 출력
	void output() {
		for(int i = 0; i < listCnt; i ++) {
			System.out.println(list[i].toString());
		}
	}
}
