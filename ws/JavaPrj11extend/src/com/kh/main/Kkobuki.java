package com.kh.main;

public class Kkobuki {

	public Kkobuki(int level, char type) {
		this.level = level;
		this.type = type;
	}
	
	// 데이터
	private final String name = "꼬부기";
	private int level;
	private char type; // L,W,F
	
	public int getLevel() {
		return this.level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public char getType() {
		return this.type;
	}
	
	public void setType(char type) {
		this.type = type;
	}
	
	// 동작
	public void bodyAttack() {
		System.out.println(name + "몸통박치기 !!!");
	}

	public void waterCanon() {
		System.out.println(name + "물대포 ~~!!");
	}

	public void bubble() {
		System.out.println(name + "거품세례 ~~!!");
	}

}
