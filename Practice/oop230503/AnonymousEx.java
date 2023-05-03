package oop20230503;

interface IMessage {
	public void msgPrint();
}
class Message implements 	IMessage {

	@Override
	public void msgPrint() {
		System.out.println("Message 클래스");
	}
	
}
public class AnonymousEx {

	public static void main(String[] args) {
		// 익명 클래스(anonymous class)
		// 필요한 곳에 일시적으로 사용하고 싶은 경우
		// 이벤트
		
		// 1) 
		Message mess = new Message();
		mess.msgPrint();
		
		// 2) 다형성
		IMessage msg =  new Message();  // 부모클래스, 자식클래스
		
		// 3) 익명
		// 인터페이스와 추상클래스는 객체 생성 불가능하지만,
		// 추상메소드를 오버라이드하면,
		// 일시적으로 new 사용가능하다. (익명클래스)
		IMessage message = new IMessage() {
			
			@Override
			public void msgPrint() {
				System.out.println("Anonymous 익명(내부, 임시)클래스");
				
			}
		};
			message.msgPrint();
	}

}
