package oop20230503;

class WebProgram {   // 외부 클래스
	String title = "Java Programming";
	class Language {		// 내부 클래스
		String basic = " Java, Html, JavaScipt";
		void disp() {
			System.out.println("기초수업" + basic);
		}
	}
	class Smart{
	String basic = "Object - C";
	void disp() {
		System.out.println("기초수업: " + basic); 
	}	
	}
 // WebProgram class end ( 외부 클래스)
void print() {
	Language lang = new Language();
	lang.disp();
	Smart sm = new Smart();
	sm.disp();
}


public class InterClassEX {

	public static void main(String[] args) {
		// inner class : 내부 클래스 
		// - 클래스 안의 클래스가 있는 경우
		// - 외부에서 접근할 필요가 없는 클래스 
		// - GUI 어플리케이션(AWT, Swing)
		// 이벤트(ex. 마우스 클릭, 드래그, 키보드 입력 등) 처리에 많이 사용
		// (예) 자바스크립트 --> jQuery, Ajax
		
		WebProgram web = new WebProgram();
		web.print();
		
// 		에러. 내부클래스를 접근하는 경우,
// 		외부클래스를 통해 단계적으로 접근해야한다.
//		Language lang = new Language(); // 에러 
//		Smart smart = new Smart(); // 에러
		
		WebProgram.Language lan = new WebProgram().new Language();
		lan.disp();
	}

}}
