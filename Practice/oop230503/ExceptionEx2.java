package oop20230503;

class Test{
	void view() {
		try {
			int a = 3/0;
		}catch(Exception e) { System.out.println(e);}
	}
	void disp() {
		try {
			Integer in = null;
			int a = in.intValue();
		}catch(Exception e) {System.out.println(e);}
	}
}

public class ExceptionEx2 {

	public static void main(String[] args) {
		// throws문
		// 메소드와 함께 사용
		 Test test = new Test();
		 test.view();
		 test.disp();
	}

}
