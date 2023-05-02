package oop20230502;

import java.lang.*;

class School extends Object {
	String name = "학교";
	String address = "주소";
	public School( ) {}
	public School(String name, String address) {
		this.name = name;
		this.address = address;
	}
	public void disp() {
		System.out.println(this.name);
		System.out.println(this.address);
	}
} // School class end

class MiddleSchool extends School{
	public MiddleSchool() {}
	public MiddleSchool(String name, String address) {
//		super.name = name;
//		super.address = name;
		super(name,address);  // 부모의 매개변수를 갖는 자동 호출
	}
	@Override
	public void disp() {   // 헤더는 같아야 한다.
		System.out.println("===MiddleSchool disp()===");
		System.out.println(this.name);
		System.out.println(this.address);
	}
	
	
	
} // MiddleSchool class end

class HighSchool extends School{
	int friend;
	public HighSchool( ) {}
	public HighSchool(String name, String address) {
		super(name, address);
	}
}


public class PolyTest1 {

	public static void main(String[] args) {
		MiddleSchool ms1= new MiddleSchool();				//자식 객체 생성 후, 자식 클래스의 기본 생성자 자동 호출
		ms1.disp();
		MiddleSchool ms2 = new MiddleSchool("행복중학교", "서울시"); //자식 객체 생성 후, 자식 클래스의 매개변수 생성자(부모 -> 자식) 자동호출
		ms2.disp();
		HighSchool hs1 = new HighSchool("사랑고등학교", "경기도");
		hs1.disp();
		
		//1) 업캐스팅 ( 형변환)		
		// 자식 객체(인스턴스)를 부모 클래스 참조변수에 대입할 수 있다.
		// 부모클래스   참조변수         자식객체 (인스턴스)
		School sch1 = new MiddleSchool("믿음중학교", "제주도");
		sch1.disp();		// 동적 바인딩(Dynamic Binding) : 오버라이딩된 자식메소드 호출
		
		
		
		// 2) 다운캐스팅 (강제 형변환) : 업캐스팅된 객체를 다시 원래대로 되돌릴 때
		// 부모 클래스를 자식 클래스에 대입할 수 있다.
		//  	(단, 자식형으로 강제 형변환 해야만 한다.)
		School sch2 = new MiddleSchool("부모중학교", "강원도");
		MiddleSchool ms3;
//		MiddleSchool ms3 = sch2;		// 에러
		ms3  =(MiddleSchool)sch2;
		ms3.disp();
		
		
		
	}

}
