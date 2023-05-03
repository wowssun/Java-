package oop20230503;

class Vehicle {
	public void run() {
		System.out.println("차량이 달립니다.");
	}
}
class Train extends Vehicle{

	@Override
	public void run() {
		System.out.println("기차가 달랍니다.");
	}
}
class Bus extends Vehicle{

	@Override
	public void run() {
		System.out.println("버스가 달립니다.");
	
	}
}
class Driver {
	public void drive(Vehicle vehicle) {    // 부모클래스를 타입으로
		vehicle.run();
	}
}
	


public class PolyTest2 {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		bus.run();
		
		Train train = new Train();
		train.run();
		
		Vehicle v1 = new Train();				//  부모 타입 <-- 자식 타입 : 자동 형변환
		v1.run();
		
		driver.drive(new Train());           // 
		driver.drive(new Bus());
		
		driver.drive(v1);
				;
		

	}

}
