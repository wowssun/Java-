package oop20230502;

public class StringTest3 {

	public static void main(String[] args) {
		// (문제) 10명의 친구 문자열 String[]에서 
		//abc 순서로 sorting(정렬)하는 프로그램 - 선택정렬(오름차순)
		String[] friends = {"Jack","John","Aman","Brute","Hank","Canny","Lee"};
		
		for(int i = 0; i < friends.length-1; i++) {
			for(int j = i; j < friends.length; j++) {
				if(friends[i].compareTo(friends[j]) > 1) {   // 일치할 때 0  , 비교하는 대상이 더 크면 음수, 비교하는 값이 더 작으면 양수 ( 불일치)
					String temp;
					temp = friends[i];
					friends[i] = friends[j];
					friends[j] = temp;
				}
			}
		}
		for(String s : friends) {
			System.out.println(s);
		}
		
		
		
		
		
		System.out.println("Jack".length());         // 4 ("문자열" 길이)
		System.out.println(friends.length);          // 10 ( 1차원 배열의 크기)
		for(int i= 0; i < friends.length; i++) {
			System.out.println(friends[i]);
		}
//		for(String i : friends) {
//			System.out.println(i);
//		}
	}

}
