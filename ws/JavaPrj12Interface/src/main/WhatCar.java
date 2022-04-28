package main;

public class WhatCar implements Car, ElectronicCar {

	@Override
	public String startCar() {
		return "왓차 시동 걸었음";
	}

	@Override
	public void go() {
		System.out.println("왓차, 전기로 감");
	}

	@Override
	public int stop() {
		return 200;
	}

	@Override
	public void charge() {
		System.out.println("왓차, 충전중");
	}

}
