package com.kh.car;

// 추상 클래스 (객체화 되지 않는)
 //abstract 키워드, 0개 이상의 추상메소드, 객체화 불가능

public abstract class Car {
	
	//생성자
	public Car(String color, int speed, int price) {
		this.color = color;
		this.price = price;
		this.speed = speed;
	}
	
	//data
	//차량색상 최대속도 가격
	private String color = "부모색상";
	private int speed = -1;
	private int price = -1;
	
	//method
	//시동걸기 브레이크 악셀
	
	// 추상 메소드
	 //추상 메소드가 있으면 무조건 추상 클래스가 되어야함
	 //abstract 키워드, 메소드 바디가 없음
	 //추상메소드로 바꿨을 때 자식에 메소드 작성안할시 오류
	 
	public abstract void startCar();
	
	public abstract void stop();
	
	public abstract void go();
	
	public String getColor() {
		System.out.println("Car Class getter called...");
		return this.color;
	}
	
	public int getSpeed() {
		System.out.println("Car Class getter called...");
		return this.speed;
	}
	
	public int getPrice() {
		System.out.println("Car Class getter called...");
		return this.price;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setSpeed(int speed) {
		this.speed  = speed;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
