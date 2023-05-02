package oop20230502.homework;

import java.util.*;
public class HospitalController {

	private Hospital hospital;			// 병원 객체
	private int new_id = 1001; 			// 신규 환자 등록 번호, 1001 : 첫 환자의 등록번호
	
	public HospitalController(Hospital h) {
		hospital = h;
	}
	
	// 입원실 관리 서비스 ( 무한 루프)
	public void manageRooms() {
		while(true) {
			Scanner sc = new Scanner(System.in);
			double temperature;
			int bp_high, bp_low ;
			Patient p;   // 환자 받기. 비어있는 참조변수, 객체를 참고하고 있지 않은 참조변수 p 
			
			System.out.print("(+) 입원, (-) 퇴원 => ");
			
			String input = sc.next();
			if(input.equals("+")) {			//  if(input.equals("+" == true)
				if(hospital.roomAvailable()) {  // if(hospital.roomAvailable() == true)
					System.out.println("--입원환자(" + new_id + ")정보 등록--");
					System.out.print("입원환자 체온? ");
					temperature = sc.nextDouble();
					System.out.print("인원환자 혈압(상)? ");
					bp_high = sc.nextInt();
					System.out.print("인원환자 혈압(하)? ");
					bp_low = sc.nextInt();
					
					// 환자입원: 환자객체 생성 후, 병실등록 처리
					p = new Patient(new_id++,temperature,bp_high,bp_low);
					hospital.admit(p);
				}
				else{
					System.out.println("병실이 없습니다.");
				}
				
			}
			else if(input.equals("-")){
				System.out.println("퇴원환자 번호?");
				int id =sc.nextInt();
				if(hospital.discharge(hospital.findPatient(id))) {  // (==true) 생략
					System.out.println(id + " 환자 퇴원 합니다.");
				}
				else {
					System.out.println(id + " 환자를 찾을 수 없습니다.");
				}
				
			}
			else {
				System.out.println("병원 병실 관리 프로그램이 종료합니다.");
				break;
			}
			
			
			sc.close();
			
		}
	}
	
}
