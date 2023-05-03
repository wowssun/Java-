package oop20230503;

abstract class Parent {   			// (대부분) 추상 클래스는 부모역할만 한다. (부모) 클래스
	String name = "부모";
	abstract void disp();			// 추상 메소드
	void line() {}					// 일반 메소드
}
// 자식클래스 			(추상)부모클래스
class Son extends Parent{
	// 추상 부모 클래스를 상속받은 자식 클래스는
	// 반드시 꼭 ! 추상 부모 메서드를 오버라이드해야만 한다.
	@Override
	void disp() {
		System.out.println("아들입니다.");
	}
}
	class Daughter extends 	Parent{
		@Override
		void disp() {
			System.out.println("딸입니다.");
		}
	}



public class AbstractEx {

	public static void main(String[] args) {
		// 추상클래스 : 주로 부모 역할
		// - 추상메소드가 1개 이상 있으면 추상클래스가 된다.
		// 추상 메서드 : 메서드의 body {} 가 없다. --> 메서드 header;
		// 추상클래스 : 추상메서드(1개 반드시)	+ (일반) 메서드s
		// 인터페이스 : 추상메서드만으로 구성되어 있음.
		
	//에러, 추상클래스는 new ( 객체, 인스턴스 ) 불가능하다.	
	//Parent papa = new Parent();
	Son son = new Son();
	son.disp();
	
	Daughter daughter = new Daughter();
	daughter.disp();
	// 다형성, 업캐스팅, 동적바인딩
	Parent p1 = new Son();
	p1.disp();
	
	Parent p2 = new Daughter();
	p2.disp();
	
		
		
		
		
		
		
		
		
	} // main end

} // class end
