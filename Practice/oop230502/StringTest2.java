package oop20230502;

import java.util.Calendar;

public class StringTest2 {

	public static void main(String[] args) {
		// (문제) 주민번호를 이용해서 아래와 같이 출력
		// [ 출력결과 ]
		// 생년월일 : 2000년11월 30일
		// 성별 : 남자
		// 나이 : 21
		
//		String jumin = "0011303234567";
		
		String jumin1 = "001130";
		String jumin2 = "3234567";
		String jumin = jumin1 + jumin2;
		
		// 생년월일
		int myYear = Integer.parseInt(jumin.substring(0,2)) ;   // 대입연산자 타입 맞추기 // 오른쪽이 String이니 int로 변환 "00" --> 0
		int myMonth = Integer.parseInt(jumin.substring(2, 4));
		int myDate = Integer.parseInt(jumin.substring(4, 6));
		
		// 성별(코드) --> 성별 문자열
//		int code =3; String gender = "남자";
	    int code = Integer.parseInt(jumin.substring(6, 7));
	    String gender = " ";
	    
	    switch(code) {
	    case 1: case 3: 
	    	gender = "남자"; break;
	    case 2: case 4:
	    	gender = "여자"; break;   	
	    }	
	    
	/*    switch(code%2) {
	    case 0: gender = "여자"; break;
	    case 1: gender = "남자"; break;
	    } */   // 이렇게도 표현 가능
	    
		// 현재년도 --> 나이
	    Calendar now = Calendar.getInstance();    // Calendar로 현재년도 구하기
		int cYear = now.get(Calendar.YEAR);
	    System.out.println(cYear);
	    switch (code) {
		case 1: case 2:					// 2020년 이전 (미만)
			myYear = 1900 + myYear;
			break;
		case 3: case 4:					// 2020년 이후 (이하)
			myYear = 2000 + myYear;
			break;
		}
	    int myAge = cYear - myYear + 1;
	    
	    
		// 출력
		System.out.println("생년월일 : " + myYear + "년" + myMonth + "월" + myDate + "일");
		System.out.println("성별 : " + gender);
		System.out.println("나이 : " + myAge);

	}

}
