package oop20230503;

class Test1{
	void view() throws Exception {
		int a = 3/0;
	}
	void disp() {
		Integer in = null;
		int a = in.intValue();
	}

}
public class ExceptionEx3 {

	public static void main(String[] args) {
		Test test = new Test();
		try {
			System.out.println("Open");
			test.view();
		}catch (Exception e){
			System.out.println(e);			
		} finally {
			System.out.println("End");
		}

	}

}
