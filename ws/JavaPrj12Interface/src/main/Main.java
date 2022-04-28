package main;

public class Main {

	public static void main(String[] args) {

		System.out.println("===== 인터페이스 =====");
		
		
		Car c1 = new RedCar();
		Car c2 = new GreenCar();
		Car c3 = new WhatCar();
		
		c1.go();
		c2.go();
		c3.go();
	}

}
