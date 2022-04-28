package main;

// interface 상속은 implements
// 클래스, 인터페이스 끼리의 상속은 extends
public class RedCar implements Car {

	// 인터페이스를 상속받는 경우, 무조건 모든 메소드를 오버라이딩 해야함
	// 인터페이스는 메소드 오버라이딩을 강제화 하기 위해서 사용함
	
	@Override
	public String startCar() {
		return "홍차 시동 걸었음";
	}

	@Override
	public void go() {
		System.out.println("홍차, 석유로 감");
	}

	@Override
	public int stop() {
		return 100;
	}
	
	
}
