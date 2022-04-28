package com.kh.math;

public class MathTest {

	public void test() {
		//abs : 절대값
		int num = -10;
		int result = Math.abs(num);
		System.out.println(result);
	}
	
	public void test2() {
		//ceil : 올림
		double d = 1.23;
		double result = Math.ceil(d);
		System.out.println(result);
		
		//floor : 내림
		double result2 = Math.floor(d);
		System.out.println(result2);
		
		//round : 반올림
		double result3 = Math.round(d);
		System.out.println(result3);
	}
	
	public void test3() {
		//random : 0이상 ~ 1미만 사이의 double
		double r = Math.random();
		System.out.println(r);
	}
	
}//class
