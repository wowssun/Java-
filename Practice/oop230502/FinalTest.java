package oop20230502;

class Animal {
	private final int value = 999; // 필드에도 final 붙일 수 있다. 대신 선언과 동시에 초기화해야한다.
	public void one() {}
	public final void two() {			// 상속은 된다. 상속을 받고 마지막 수정사항이다. 기능 수정 안된다. 고유의 기능이다.
	 System.out.println("two");	
	}
	
}
class Elephant extends Animal {
	@Override
	public void one() {
		System.out.println("one() overriding!");
	}
//	public void two() { 					// 부모의 final 메소드는 오버라이드 할  수 없다. ( 상속 o, 재정의 x)
//		System.out.println("two() overriding!");
//	}
}

public class FinalTest {
	public static void main(String[]args) {
		// final 변수/필드 : 변수의 상수화
		//final 메소드 : 더이상(이후에는)override할 수 없다.
		//final 클래스 : 종단클래스, 더이상 자식 클래스를 생성할 수 없다.
		Elephant e = new Elephant();
		e.one();
		
		int a = 3;
		a = 300;
		final int b = 7;  	// b로 선언한 뒤 7로 초기화
//		b = 10;				// 에러 final 변수는 새로운 값을 대입할 수 없다.
//		b++;
		
		final double PI = 3.14;			// final 변수에 대문자.
		
		
	}

}
