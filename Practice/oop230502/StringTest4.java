package oop20230502;

import java.util.StringTokenizer;
// Ctrl + Shift + o : 패키지추가
public class StringTest4 {

	public static void main(String[] args) {
		String txt = "홍길동/김철수/이영희";			// 불변
		
		StringTokenizer st = new StringTokenizer(txt, "/");
		int countTokens = st.countTokens();
		System.out.println(countTokens);   // 3개
		
		for(int i = 0 ; i < countTokens; i++) {
			String token = st.nextToken();			// (가변) 하나씩 읽고나서, heap memory에서 제거
			System.out.println(token);
		}
//		System.out.println(st.nextToken());
//		st에는 아무 요소도 남아 있지 않음.
	
		
		// hasMore & nextToken : 대중적인 방식 표현
		System.out.println(txt);		
		st = new StringTokenizer(txt,"/");
		while(st.hasMoreElements()) {   // hasMoreElements() : 요소가 있는
			String token = st.nextToken();
			System.out.println(token);
						
		}
		
		
		
		
	}
}
