package com.kh.car;

public class RedCar extends Car {
	
	//super : 부모클래스 생성자를 호출
	public RedCar(String color, int speed, int price) {
		super(color, speed, price);
		// super(color,speed); 는 오류
	}

//		this(); //가능
	
	//홍차 고유메소드
	public void sayRed() {
		System.out.println("홍홍홍");
	}
	
	
	//오버라이딩 == 부모 클래스의 메소드를 재정의하는 것
	//@Override == 어노테이션 : 사람에게 알려주고, 컴퓨터에게 에러판단 해달라고
	@Override
	public void startCar() {
		System.out.println("홍차 시동 걸었음");
	}
	
	@Override
	public void stop() {
		System.out.println("홍차 브레이크");
	}
	
	@Override
	public void go() {
		System.out.println("홍차 악셀");
	}
}
