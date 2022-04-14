package com.kh.main;

public class Run {

	public static void main(String[] args) {

	// 제어문 - 조건문, 반복문

	// 조건문 (if, switch)
		
		// if
		int num = 0;
		if (num > 0) {
			System.out.println("양수입니다.");
		} else if (num == 0) {
			System.out.println("Zero");
		} else {
			System.out.println("음수입니다.");
		}
		
		// switch (switch, case, default, break)
		int x = 3;
		switch (x) { 
		case 1 : System.out.println("일"); break;
		case 2 : System.out.println("이"); break;
		case 3 : System.out.println("삼"); break;
		default : System.out.println("범위에 없음");
		}

	}

}
