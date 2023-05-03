package oop20230503;

public class ExceptionEx1 {
		// 교재 = 414 page
		// Exception 예외 처리
		// - cf) 예외는 오류(error)가 아니다.
		// - 프로그램 "실행"시 발생하는 오류
	
	public static void main(String[] args) {  
		// 1) 예외처리를 하지 않는 경우
//		System.out.println(3/0);    // 에러. ArithmeticException
//		System.out.println("END");
//		
//		int x = 3;
//		int y = 0;
//		if(y==0)
//			System.out.println("0으로 나눌 수 없습니다.");
//		else
//			System.out.println(x/y);
//		
		// 2) 예외처리를 하는 경우
//		try{   // 예외가 예상되는 코드를 작성
//		System.out.println(1);
//		System.out.println(5/1);
//		System.out.println(3/0);
//		System.out.println(5);
//		} catch(ArithmeticException e) {
//			// 예외가 발생되면 실행되는 코드
//			System.out.println(e);
//			System.out.println("0으로 나눌 수 없습니다.");
//		}
//		
//		System.out.println("END");

		// 3)
		try {
			System.out.println("=====");		// 에러이지만 컴파일에서는 오류가 안난다.
			System.out.println(5/0);
			int[] su = new int[3];
			su[100] = 100;
			System.out.println("=====");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
				// 예외 상관없이 실행해야 하는 코드
			System.out.println("END");
		}
		// 4) 
		
		try {
		System.out.println(1);
		System.out.println(5/1);
		int []su = new int[3];
		su[100] = 100;
		Integer num = null;
		System.out.println(3/num);
		} catch (ArithmeticException e )	{
			System.out.println(e);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (NullPointerException e) {
			System.out.println(e);
		} finally {
			System.out.println("End");
		}
		

	}

}
