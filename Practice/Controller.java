package pr230501;

import java.util.Scanner;
public class Controller {

	Scanner sc = new Scanner(System.in);
	
	EachPerson[] list = new EachPerson[100];
	int listCnt = 0;
	
	void input() {
		if(listCnt < 100) {
			list[listCnt] = new EachPerson();
			
		}
	}
	
	

}
