import java.lang.String;
public class StringTest1 {

	public static void main(String[] args) {
		// "문자열상수", 불변의 데이터(값)
		
		
		String str1 = new String("하이");
		System.out.println(str1);
		
		String str2 = "Hi";   // 힙 영역에 존재하는 
		System.out.println(str2);
		str2 = "ho";
		System.out.println(str2);
		System.out.println(str2.length());  // 2, 문자갯수  
		// length 뒤에 괄호 없으면 에러. 배열 참조변수와 구분
		
		// null : 널 주소 , '\0' : 널 문자  "문자열"의 마지막은 널 문자 존재
		
		// String 클래스 : 불변
		// StringBuffer 클래스, StringBuilder 클래스 : 가변(mutable)
		
//		StringBuffer str3 = "SIST"; 	// 에러
//		StringBuilder str4 = "SIST";   // 에러 
		
		StringBuffer str5 = new StringBuffer("SIST");
		StringBuilder str6 = new StringBuilder("SIST");
		
		System.out.printf("%s. %s%n", str5,str6);
		System.out.println(str5.length());
		
		str1 = str1 + "java";   // "하이java"
		System.out.println(str1);
		
//		str5 = str5 + "자바"; // 에러 
		
		String str = "Gone With The Wind";
		// 0번째 문자 추출
		System.out.println(str.length());    // 18개 문자
		System.out.println(str.charAt(0));		// 'G'
		
		// 마지막번째 문자 추출
		System.out.println(str.charAt(17));  // 'd'	
		System.out.println(str.length()-1);   // 17
		
		// 문자 'G'의 위치
		System.out.println(str.indexOf('G')); // 0번째 문자
		
		// 문자 'G'의 위치
		System.out.println(str.indexOf("G"));
		
		// 없는 문자열
		System.out.println(str.indexOf('R'));   // -1
		
		// 중복 문자열
		System.out.println(str.indexOf("W"));    // 5번째 ( 맨 처음 위치)
		
		System.out.println(str.isEmpty());  // 문자열이 비어있는지 , 공백인지
		
		System.out.println("=========");
		
		boolean a = false;
		for(int i =0; i < str.length(); i++) {
			if(str.charAt(i)=='R') {
				a = true;
				System.out.println(i);
				break;
			}
		}
		System.out.println(a);
		System.out.println(a ? "있음" : "없음");
		System.out.println("===========");
		
		//메소드명이
		//set..(설정)get..(참조) to..(변환)is..(~이니?)
		System.out.println(str.toLowerCase()); // 소문자로 변환
		System.out.println(str);
		System.out.println(str.toUpperCase());  // 대문자로 변환
		
		str = str.replace('n', 'N');   // old - > new
		System.out.println(str);
		
		// 문자열 추출(자르기)
		System.out.println(str.substring(6));  // 6번째부터 ~ 마지막까지 ( null 문자인거 확인하고) 그 전까지
		System.out.println(str.substring(6,11));   // 6번째부터 10번째 자리
		
		// 마지막 글자(한문자)출력 : 'd'
		System.out.println(str.charAt(str.length()-1));
		System.out.println(str.substring(17,18));
		System.out.println(str.substring(str.length()-1, str.length()));
		
		// 첫글자
		System.out.println(str.charAt(0));
		System.out.println(str.substring(0,1));
		
		// 문자열 분리
		String[] word = str.split(" ");   // 구분문자 -> 어디서 구분할건지
//		word[0] = "Gone";
//		word[1] = "With";
		for(int i = 0; i < word.length; i++) {
			System.out.println(word[i]);
		}
		
		for(String s : word)
			System.out.println(s);
		
		System.out.println(str1.equals(str2));  // false   // 일치 할 때 true
		
		System.out.println(str1.compareTo(str2));  // str1이 주어, // 일치할 때 0  , 비교하는 대상이 더 크면 음수, 비교하는 값이 더 작으면 양수 ( 불일치)
		
	}

}
