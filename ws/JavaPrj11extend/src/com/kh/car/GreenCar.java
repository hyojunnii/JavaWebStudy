package com.kh.car;

public class GreenCar extends Car{

	public GreenCar(String color, int speed, int price) {
		super(color, speed, price);
	}
	
	public void sayGreen() {
		System.out.println("³ì³ì³ì");
	}
	
	@Override
	public void startCar() {
		System.out.println("³ìÂ÷ ½Ãµ¿ °É¾úÀ½");
	}
	
	@Override
	public void stop() {
		System.out.println("³ìÂ÷ ºê·¹ÀÌÅ©");
	}
	
	@Override
	public void go() {
		System.out.println("³ìÂ÷ ¾Ç¼¿");
	}
}
