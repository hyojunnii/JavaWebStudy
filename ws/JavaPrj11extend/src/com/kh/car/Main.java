package com.kh.car;

public class Main {

	public static void main(String[] args) {

		System.out.println("===== 상속 =====");

		// 다형성 polymorphism : 부모클래스가 자식클래스 받아주는거
		
		//Ex) Car 타입의 변수에다 자식 타입의 객체 넣는거
		Car rc = new RedCar("빨강",100,3000);
		
		//정적 바인딩: 실행되기 전 (부모클래스)
		//동적 바인딩 : 자식클래스 (실제 런타임)
		
		rc.startCar();
//		System.out.println(rc.getColor());
//		System.out.println(rc.getSpeed());
//		System.out.println(rc.getPrice());
		
		
		Car rc2 = new GreenCar("녹색", 200, 4000);
		rc2.startCar();
		
		Car rc3 = new WhatCar("검정", 300, 9900);
		rc3.startCar();
		
		// 객체 비교 (instanceof)
		// A instanceof B : A가 B 타입이 맞는지 확인하여 boolean 타입의 데이터를 리턴
//		if(rc instanceof Car) {
//			System.out.println("맞음");
//		} else {
//			System.out.println("아님");
//		}
		
		// 추상화 (abstract)
		
		
	}
	
	//1. 상속 : 부모클래스의 data, method 받아옴
	//부모 객체가 존재해야 자식객체도 존재할 수 있음
	//사용법 : extends
	//* 모든 클래스의 제일 위의 부모는 Object 클래스이다. *
	
	//2. 오버라이드
	//정의 : 부모클래스의 메소드 재정의 (바디부분 재정의)
	//작성법 : 오버라이드 하려는 메소드 위에다가 @Override라고 적기
	
	//3. 다형성
	//부모클래스 타입으로 자식 클래스 타입의 객체를 받을 수 있다.
	
	//4. 바인딩
	//정적바인딩
	//동적바인딩

	//5. super
	//super는 부모를 가리키는 키워드
	//this는 자기자신
	
	//6. getter/setter
	//private 필드 (전역변수 == 인스턴스변수 == 객체변수 == 멤버변수 == 클래스변수)
	//접근제한자가 private인 애들을 편법으로 사용하기 위해서 만드는 메소드
	
	
}
