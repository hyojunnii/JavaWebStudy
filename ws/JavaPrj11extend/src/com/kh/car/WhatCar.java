package com.kh.car;

public class WhatCar extends Car{

	public WhatCar(String color, int speed, int price) {
		super(color, speed, price);
	}
	
	public void SayWhat() {
		System.out.println("¹¹");
	}
	
	@Override
	public void startCar() {
		System.out.println("¿ÓÂ÷ ½Ãµ¿ °É¾úÀ½");
	}
	
	@Override
	public void stop() {
		System.out.println("¿ÓÂ÷ ºê·¹ÀÌÅ©");
	}
	
	@Override
	public void go() {
		System.out.println("¿ÓÂ÷ ¾Ç¼¿");
	}

}
