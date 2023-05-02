package oop20230502.homework;

public class HospiralRoomManger {

	public static void main(String[] args) {
		Hospital h = new Hospital(3);
		System.out.println("===[sist 병원 입퇴원 관리 시스템]===");
		
		new HospitalController(h).manageRooms();

	/*	HospitalController hc = new HospitalController(h);
		hc.manageRooms();    
	*/
		// 위 코드와 동일 하다.
		
		
		
	}

}
