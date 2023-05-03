package oop20230503;

interface Animal {
	// 추상메서드만 존재
	abstract void kind(); 			// 추상메서드
    void breathe();		// 추상메서드, 메서드 앞의 abstract 생략 가능
}
class Elephant implements Animal{

	@Override
	public void kind() {
		System.out.println("포유류");
		
	}

	@Override
	public void breathe() {
		  System.out.println("허파로 호흡 중..");
		
	}
	
}

public class InterfaceEx1 {

	public static void main(String[] args) {
		// 인터페이스 
		// = 추상 메서드"만" 존재하는 클래스
		// - 추상클래스와 비슷, 추상 클래스보다 추상화 정도가 높다.
		// - (일반) 필드와 (일반) 메서드 갖지 못함
		// - 인터페이스는 반드시(하위)클래스에서 추상 메서드를 오버라이딩 해야만 한다.

//		Animal ani = new Animal();  // 에러. interface로는 new로 객체 생성 불가능 
		// 인터페이스도 다형성 가능하다.
		Animal ani = new Elephant();
		ani.kind();
		ani.breathe();
	}

}
