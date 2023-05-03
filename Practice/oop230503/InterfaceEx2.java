package oop20230503;

class Unit{
	int currentJP;
	int X;
	int y;
}// class end
interface Movealbe {
	abstract void move(int x, int y);   
}// interface end
interface Attackable{
	void attack(Unit u);		// abstract 생략 가능
} // interface end
interface Fightable extends Movealbe, Attackable{
	// 인터페이스는 다중 상속(extends)이 가능하다.
}// interface end
class Fight extends Unit implements Fightable {    // implements 키워드가 있으면 오버라이드 해야한다.

	@Override
	public void move(int x, int y) {
		
	}

	@Override
	public void attack(Unit u) {
		
	}  
	
}
public class InterfaceEx2 {

	public static void main(String[] args) {
		// 인터페이스와 클래스 간의 상속 및 구현
		// Java에서는 다중상속을 인터페이스간 상속으로 구현한다.
		// # 인터페이스와 다중상속 > 교재 : 381page
		// 인터페이스 : 구현 implements
		// Java는 다중상속 불가능하다.
		// 		  다중구현은 가능하다.

	}

}
