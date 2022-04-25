package com.kh.overload.test;

public class Test {
	
	/*
	 * 생성자
	 * 
	 * [접근제한자] 클래스명(..) {객체 생성 순간,실행하고픈 내용}
	 * 
	 * 객체를 생성하려면 생성자를 호출해야한다.
	 */
	
	//기본 생성자
	public Test() {
		System.out.println("객체생성자");
		this.name = "심원용";
		hi();
		System.out.println("종료");
	}
	
	//생성자 오버로딩
	public Test(String s) {
		System.out.println("오버로딩된 생성자 호출");
		System.out.println(s);
		System.out.println("종료");
	}
		
	//data
	public String name;
	
	// 오버로딩
	public void hi() {
		System.out.println("hi");
	}
	
	public void hi(String str) {
		System.out.println("hi" + name);
	}
	
}
