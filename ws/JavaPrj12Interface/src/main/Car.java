package main;

public interface Car {
	
	/*
	 * 인터페이스
	 * 
	 * 모든 메소드는 추상메소드이다.
	 * 모든 메소드는 public abstract이다.
	 * public abstract는 생략이 가능하다.
	 * 인터페이스는 다중 상속이 가능하기 때문에 사용
	 */
	
	// 모든 자동차가 공통적으로 가져야 할 메소드 (추상메소드)
	
	/*public abstract*/ String startCar();
	
	void go();
	
	int stop();
	
}
