package oop20230502.homework;

public class Hospital {

	private Patient[] rooms;			// 클래스 참조형 배열
	private int occupied;
	
	public Hospital(int n) {		// 병원 객체 생성 초기화 메소드,n : 병원이 보유한 입원실의 개수
		rooms = new Patient[n];
		occupied = 0;
	}
	public Patient[]getRommsInfo(){
		return rooms;
	}
	public boolean roomAvailable() {
		if(occupied < rooms.length) {
			return true;
		}
	return false;
	}
	public Patient findPatient(int id) {
	for(int i = 0; i < rooms.length; i++) {
		if(rooms[i] !=null && rooms[i].getPatientId()== id) {
			return rooms[i];
		}
	}
	return null;
	}
	
	public boolean admit(Patient P) {
		if(roomAvailable()) {
			for(int i = 0; i < rooms.length; i++) {
				if(rooms[i] ==null) {
					rooms[i] = P;
					occupied++;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean discharge(Patient p) {
		for(int i = 0; i < rooms.length; i++) {
			if(rooms[i] == p&& rooms[i] != null) {
				rooms[i] = null;
				occupied--;
				return true;
			}
		}
		return false;
	}
	
	
}
