package override;

import java.util.*;
public class Text {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		
		Controller controller = new Controller();
		
		while(true) {
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 종료");
			System.out.println("------");
			System.out.println("번호(1~3)입력 : ");
			num = sc.nextInt();
			
			switch(num) {
			case 1: controller.input();
				break;
			case 2: controller.output();  // 출력
				break;
			case 3: System.out.println("프로그램 종료");
				System.exit(0);
			}		
			System.out.println();
		}	
		
	} // main end

}
